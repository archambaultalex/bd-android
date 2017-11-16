package com.example.alex.weeat;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddResto extends AppCompatActivity {

    public static Button add;
    public static EditText nom;
    public static EditText address;
    public static EditText prixMoy;
    public static Spinner bouf;
    public static RatingBar cote;
    public static Spinner service;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_resto);

        context = getApplicationContext();
        nom = (EditText) findViewById(R.id.NomResto);
        prixMoy = (EditText) findViewById(R.id.PrixMoyen);
        address = (EditText) findViewById(R.id.AddressResto);

        bouf = (Spinner) findViewById(R.id.QualiteBouffe);
        service = (Spinner) findViewById(R.id.QualiteService);
        cote = (RatingBar) findViewById(R.id.cote);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cote, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        bouf.setAdapter(adapter);
        service.setAdapter(adapter);


        bouf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.white)); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(getResources().getColor(R.color.white)); //Change selected text color
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add = (Button) findViewById(R.id.addBut);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String nomString = nom.getText().toString();
                    String addString = address.getText().toString();
                    String prixString = prixMoy.getText().toString();
                if(!nomString.trim().isEmpty() && !addString.trim().isEmpty() && !prixString.trim().isEmpty()) {

                    Api api = new Api();
                    api.Insert(MainActivity.bd, nomString, addString, bouf.getSelectedItem().toString(), service.getSelectedItem().toString(), prixString, Float.toString(cote.getRating()));

                    Toast.makeText(context, "Restaurant Créé", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    ShowToast("Tout les champs doivent etre remplie");
                }
            }
        });
    }
    public void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
