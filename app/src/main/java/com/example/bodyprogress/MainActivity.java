package com.example.bodyprogress;
/**
 * @author Tatu Pulkkinen & Leevi Laaksonen
 */

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tarkistetaan avataanko sovellus ensimmäistä kertaa(jos kyllä niin luodaan profiili)
        Boolean ekaKerta = getSharedPreferences("Prefet", MODE_PRIVATE)
                .getBoolean("ekaKerta", true);

        if(ekaKerta) {

            Intent intent = new Intent (this, WelcomeActivity.class);
            startActivity(intent);
            //Siirtyy profiilin luontiin. Kun profiili luotu niin vaihtuu ekaKerta boolean falseksi
            //Toast.makeText(MainActivity.this, "Luo profiili", Toast.LENGTH_LONG).show();
           // Intent intent = new Intent(this, CreateProfiiliActivity.class);
            //startActivity(intent);
        }





    }
    //Siirtyy edistymisten aktiviteetille
    public void onProgressButtonClick (View v) {
        Intent progressIntent = new Intent(this, EdistyminenActivity.class);
        startActivity(progressIntent);
    }
    //siirtyy profiili aktiviteettiin
    public void onProfileButtonClick (View v){
        Intent profileIntent = new Intent(this, ProfiiliActivity.class);
        startActivity(profileIntent);
    }

}
