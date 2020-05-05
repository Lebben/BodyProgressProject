
package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfiiliActivity extends AppCompatActivity {

    String nimi;
    String ika;
    String paino;
    String pituus;
    String bmi;
    String hauis;
    String vyotaro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiili);

        //Lataa profiilin tiedot sharedpreferencestä
        SharedPreferences sharedPreferences=getSharedPreferences("Prefet", MODE_PRIVATE);

        nimi = sharedPreferences.getString("nimi", "");
        ika = sharedPreferences.getString("ika", "");
        paino = sharedPreferences.getString("paino", "");
        pituus = sharedPreferences.getString("pituus", "");
        bmi = sharedPreferences.getString("bmi", "");
        hauis = sharedPreferences.getString("hauis", "");
        vyotaro = sharedPreferences.getString("vyotaro", "");

        //alustetaan ja luodaan textViewit ja asetetaan ladatut arvot niihin.
        TextView nimiTextView = (TextView) findViewById(R.id.textViewProfiilinimi);
        TextView ikaTextView = (TextView) findViewById(R.id.textViewIka);
        TextView painoTextView = (TextView) findViewById(R.id.textViewPaino);
        TextView pituusTextView = (TextView) findViewById(R.id.textViewPituus);
        TextView bmiTextView = (TextView) findViewById(R.id.textViewBmi);
        TextView hauistTextView = (TextView) findViewById(R.id.textViewHauis);
        TextView vyotaroTextView = (TextView) findViewById(R.id.textViewVyotaro);

        nimiTextView.setText(nimi);
        ikaTextView.setText(ika);
        painoTextView.setText(paino);
        pituusTextView.setText(pituus);
        bmiTextView.setText(bmi);
        hauistTextView.setText(hauis);
        vyotaroTextView.setText(vyotaro);




    }


}
