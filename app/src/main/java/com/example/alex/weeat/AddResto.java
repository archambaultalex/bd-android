package com.example.alex.weeat;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class AddResto extends AppCompatActivity {

    public static Button add;
    public static EditText nom;
    public static EditText address;
    public static EditText prixMoy;
    public static RatingBar bouf;
    public static RatingBar cote;
    public static RatingBar service;
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

        bouf = (RatingBar) findViewById(R.id.QualiteBouffe);
        service = (RatingBar) findViewById(R.id.QualiteService);
        cote = (RatingBar) findViewById(R.id.cote);

        add = (Button) findViewById(R.id.addBut);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomString = nom.getText().toString();
                String addString = address.getText().toString();

                Api api = new Api();
                api.Insert(MainActivity.bd,nomString,addString,Float.toString(bouf.getRating()),Float.toString(service.getRating()),prixMoy.getText().toString(),Float.toString(cote.getRating()));

                Toast.makeText(context,"Restaurant Créé", Toast.LENGTH_SHORT).show();
                finish();
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
