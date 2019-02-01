package com.example.itsukiichiyuu.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap IMG = BitmapFactory.decodeResource(getResources(), R.drawable.kingdom_come);
        jeu_video jeu= new jeu_video("test1","test2",IMG);

        Intent monIntent=getIntent();
        monIntent.putExtra("EXTRA_NOM",jeu.getNom());
        monIntent.putExtra("EXTRA_DESCRIPTIF", jeu.getDescriptif());
        monIntent.putExtra("EXTRA_IMG",jeu.getImg());

        Log.v(jeu.getNom(),"envoi_OK");

        setResult(RESULT_OK,monIntent);

        Log.v("ActivityResult","setResult ok");

        finish();
    }

/*
    public void goToActivity1 (View view){
        Intent intent = new Intent (this, MainActivity.class);

        startActivity(intent);
    }
    */
}
