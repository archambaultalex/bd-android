package com.example.alex.weeat;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Alex on 11/13/2017.
 */

public class Api {



    public  void Insert (SQLiteDatabase bd , String nom , String adresse , String qualiteBouffe, String qualiteService, String prixMoyen , String cote)
    {
        try {

            bd.execSQL("INSERT INTO Restaurants VALUES(null,'"+nom+"','"+adresse+"','"+ qualiteBouffe+"','"+qualiteService+"',"+prixMoyen+","+cote+")");

        } catch (SQLiteConstraintException e) {

            Log.e("insert", e.getMessage().toString());
        }


    }

    public  void Delete (SQLiteDatabase bd, int id)
    {
        try {

            bd.execSQL("DELETE FROM Restaurants WHERE Id="+ id );

        } catch (SQLiteConstraintException e) {

            Log.e("Delete", e.getMessage().toString());
        }
    }
    public  void UpdateQualiteBouffe(SQLiteDatabase bd , int id , int qualiteBouffe)
    {

        try {

            bd.execSQL("UPDATE Restaurants SET qualiteBouffe = "+ qualiteBouffe + " WHERE Id = "+ id +";");

        } catch (SQLiteConstraintException e) {

            Log.e("UpdateQualiteBouffe", e.getMessage().toString());
        }
    }
    public  void UpdateQualiteService(SQLiteDatabase bd , int id ,int qualiteService)
    {

        try {

            bd.execSQL("UPDATE Restaurants SET qualiteService = "+ qualiteService + " WHERE Id = "+ id +";");

        } catch (SQLiteConstraintException e) {

            Log.e("UpdateQualiteService", e.getMessage().toString());
        }
    }

    public  void Update(SQLiteDatabase bd , int id, float cote, String qualiteService, String qualiteBouffe,int prixmoy)
    {
        try {

            bd.execSQL("UPDATE Restaurants SET Cote = "+ cote + ", qualiteService = '"+ qualiteService + "', qualiteBouffe = '"+ qualiteBouffe + "', prixMoyen ="+ prixmoy + " WHERE Id = "+ id +";");

        } catch (SQLiteConstraintException e) {

            Log.e("UpdateCote", e.getMessage().toString());
        }
    }
}
