package com.example.itsukiichiyuu.intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public Button btn =(findViewById(R.id.btnClick));
    Intent monIntent = new Intent(this, Main2Activity.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(monIntent,2);
            }
        });
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//récupère l'intent précédemment envoyé
        Log.v("ActivityResult","OK OK");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==2){
            if(resultCode == RESULT_OK){
                //traitement souhaité
               /* Bitmap bmp = null;
                String filename = getIntent().getStringExtra("EXTRA_IMG");
                try {
                    FileInputStream is = this.openFileInput(filename);
                    bmp = BitmapFactory.decodeStream(is);
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }*/

                EditText nom=(findViewById(R.id.editNom));
                nom.setText(data.getStringExtra("EXTRA_NOM"));

                EditText descriptif=(findViewById(R.id.editDescriptif));
                descriptif.setText(data.getStringExtra("EXTRA_DESCRIPTIF"));

                Log.v("ActivityResult","retour OK");
            }else{
                //traitement souhaité
                Log.v("activityResult","retour KO");
            }
        }
    }
/*
    public void goToActivity2 (View view){
        Intent monIntent = new Intent(this, Main2Activity.class);
        startActivityForResult(monIntent,0);//envoi l'intent dans l'autre page, vide
    }
*/
}
