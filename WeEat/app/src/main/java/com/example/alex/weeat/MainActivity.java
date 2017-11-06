package com.example.alex.weeat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static Button add;
    public static Button sup;
    public static Button mod;
    public static Button eval;
    public static ImageButton param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }

    public void openSup()
    {

    }

    public void openMod()
    {

    }

    public void openEval()
    {

    }

    public void openParam()
    {

    }


}
