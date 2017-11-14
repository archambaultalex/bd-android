package com.example.alex.weeat;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Modify_restaurant extends AppCompatActivity {

    public static Spinner spinner;
    public static EditText prixmoy;
    public static RatingBar qbouf;
    public static RatingBar qService;
    public static RatingBar cote;

    public static Button Modifier;
    public static int id;

    public static Context context;
    ArrayList<String> resto = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_restaurant);

        context = getApplicationContext();

        prixmoy = (EditText) findViewById(R.id.PrixMoyen);
        qbouf = (RatingBar) findViewById(R.id.QualiteBouffe);
        qService = (RatingBar) findViewById(R.id.QualiteService);
        cote = (RatingBar) findViewById(R.id.cote);
        Modifier = (Button) findViewById(R.id.modButmodBut);

        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Api api = new Api();
                api.Update(MainActivity.bd,id,cote.getNumStars(),qService.getNumStars(),qbouf.getNumStars(),Integer.parseInt(prixmoy.getText().toString()));
                Toast.makeText(context, "Restaurant modifier", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        Cursor cu = MainActivity.bd.rawQuery("select Nom from Restaurants",null);
        if(cu.getCount() == 0)
        {

        }
        else
        {
            while(cu.moveToNext())
            {
                resto.add(cu.getString(0));
            }
        }

        spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter aa = new ArrayAdapter(this,R.layout.spinner_item, resto);

        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Cursor cu = MainActivity.bd.rawQuery("select * from Restaurants where Nom = '" + spinner.getSelectedItem() +"'" ,null);
                if(cu.getCount() > 0)
                {
                    while(cu.moveToNext())
                    {
                        Modify_restaurant.id = Integer.parseInt(cu.getString(0));
                        qbouf.setRating(Float.parseFloat(cu.getString(3)));
                        qService.setRating(Float.parseFloat(cu.getString(4)));
                        prixmoy.setText(cu.getString(5));
                        cote.setRating(Float.parseFloat(cu.getString(6)));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}
