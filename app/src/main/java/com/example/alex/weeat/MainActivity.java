package com.example.alex.weeat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    public static Button add;
    public static Button sup;
    public static Button mod;
    public static Button eval;
    public static ImageButton param;
    public static SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor c1; // utilisé par les boutons suivant et précédent

        bd = openOrCreateDatabase("TP3", Context.MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS Restaurants(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nom VARCHAR, Adresse VARCHAR, qualiteBouffe INTEGER, qualiteService INTEGER, prixMoyen REAL, Cote INTEGER );");


        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.ajouter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdd();
            }
        });


        sup = (Button) findViewById(R.id.supp);
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSup();
            }
        });


        mod = (Button) findViewById(R.id.modif);
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMod();
            }
        });

        eval = (Button) findViewById(R.id.eval);
        eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEval();
            }
        });

        param = (ImageButton) findViewById(R.id.param);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openParam();
            }
        });


    }



    public void openAdd()
    {
        Intent myIntent = new Intent(MainActivity.this, AddResto.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void openSup()
    {
        Intent myIntent = new Intent(MainActivity.this, DeleteResto.class);
        MainActivity.this.startActivity(myIntent);
    }



    public void openMod()
    {
        Intent myIntent = new Intent(MainActivity.this, Modify_restaurant.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void openEval()
    {
        Intent myIntent = new Intent(MainActivity.this, ReadSelonEtoiles.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void openParam()
    {
        Cursor c = bd.rawQuery("SELECT * FROM Restaurants", null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                // Do something Here with value
                ShowToast(c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4)+" "+c.getString(5)+" "+c.getString(6));
            } while(c.moveToNext());
        }
        c.close();
    }

    public void ShowToast(CharSequence text)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //    Cursor c = bd.rawQuery("SELECT * FROM Restaurants", null);
//        if (c.moveToFirst()){
//        do {
//            // Passing values
//            String column1 = c.getString(0);
//            String column2 = c.getString(1);
//            String column3 = c.getString(2);
//            // Do something Here with value
//            ShowToast(c.getString(0)+c.getString(1)+c.getString(2));
//        } while(c.moveToNext());
//    }
//        c.close();

}
