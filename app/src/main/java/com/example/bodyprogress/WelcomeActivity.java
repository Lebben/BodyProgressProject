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

    }
    public void onButtonCreate (View v){
        Intent intent = new Intent(this, CreateProfiiliActivity.class);
        startActivity(intent);
        finish();
    }
}
