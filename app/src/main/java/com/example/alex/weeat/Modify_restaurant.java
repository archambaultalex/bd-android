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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Modify_restaurant extends AppCompatActivity {

    public static Spinner spinner;
    public static EditText prixmoy;
    public static Spinner qbouf;
    public static Spinner qService;
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
        qbouf = (Spinner) findViewById(R.id.QualiteBouffe);
        qService = (Spinner) findViewById(R.id.QualiteService);
        cote = (RatingBar) findViewById(R.id.cote);
        Modifier = (Button) findViewById(R.id.modButmodBut);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cote, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        qbouf.setAdapter(adapter);
        qService.setAdapter(adapter);

        qbouf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.white)); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        qService.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.white)); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!prixmoy.getText().toString().trim().isEmpty()) {
                    Api api = new Api();
                    api.Update(MainActivity.bd, id, cote.getRating(), qService.getSelectedItem().toString(), qbouf.getSelectedItem().toString(), Integer.parseInt(prixmoy.getText().toString()));
                    Toast.makeText(context, "Restaurant modifier", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(context,"Tous les champs doivent etre remplies!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.white)); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Cursor cu = MainActivity.bd.rawQuery("select Nom from Restaurants",null);
        if(cu.getCount() == 0)
        {
            Toast.makeText(context,"Il n'y a pas de resto",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cu.moveToNext())
            {
                resto.add(cu.getString(0));
            }
        }




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
                        for(int i = 0; i < 5; i++)
                        {
                            String temp = qbouf.getItemAtPosition(i).toString();
                            if(qbouf.getItemAtPosition(i).toString().contains(cu.getString(3)))
                            {
                                qbouf.setSelection(i);
                            }

                            if(qService.getItemAtPosition(i).toString().contains(cu.getString(4)))
                            {
                                qService.setSelection(i);
                            }
                        }
                        prixmoy.setText(cu.getString(5));
                        cote.setRating(Integer.parseInt(cu.getString(6)));
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
