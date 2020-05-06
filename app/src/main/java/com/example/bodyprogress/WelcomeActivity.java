package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        /**@author Leevi Laaksonen
         *activity toistuu ensimmäisen kerran kun sovellus avataan.
         * Luo profiili nappia painettaessa siirrytään profiilin luomis activityyn.
         *
         */




    }
    public void onButtonCreate (View v){
        Intent intent = new Intent(this, CreateProfiiliActivity.class);
        startActivity(intent);
        finish();
    }
}
