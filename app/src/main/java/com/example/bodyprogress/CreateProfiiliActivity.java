package com.example.bodyprogress;
/**
 * Luodaan profiili ottamalla editText kentistä arvot, tarkistamalla tarkista() metodilla ovatko
 * edit textit tyhjiä. Jos eivät niin tallennetaan srvot sharedpreferenceen josta profiiliActivity ne
 * ottaa sitten vastaan.
 * @author Leevi Laaksonen
 *
 */
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;



public class CreateProfiiliActivity extends AppCompatActivity {


    String nimi, paino, pituus, ika, bmi, vyotaro, hauis;
    Button button;
    EditText nimiText;
    EditText ikaText;
    EditText painoText;
    EditText pituusText;
    EditText hauisText;
    EditText vyotaroText;

    private Tarkistus tarkistus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profiili);


        button = (Button) findViewById(R.id.ButtonCreateProfile);

        //Luo profiili-nappia painettaessa tarkistaa "tarkista() metodin avulla onko kaikki kentät täytetty (jos ei niin ei anna jatkaa)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarkista();

                if (tarkista()==true) {
                    getSharedPreferences("Prefet", MODE_PRIVATE).edit().putBoolean("ekaKerta", false).commit();
                    luoProfiili();
                }
                else{
                    Toast.makeText(CreateProfiiliActivity.this, "Täytä kaikki kentät", Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    /**
     * @author Leevi Laaksonen
     * Metodilla tallenetaan editText kenttien arvot sharedPreferenceen
     */

    //"luodaan" profiili tallentamalla String muuttujat shared preferenceen josta profiili activity ne lataa.
    public void luoProfiili() {

        //otetaan käyttäjän syöttämät tiedot
        nimiText = (EditText) findViewById(R.id.editTextCProfileName);
        ikaText = (EditText) findViewById(R.id.editTextCAge);
        painoText = (EditText) findViewById(R.id.editTextCWeight);
        pituusText = (EditText) findViewById(R.id.editTextCHeight);
        hauisText = (EditText) findViewById(R.id.editTextCBicep);
        vyotaroText = (EditText) findViewById(R.id.editTextCwaist);

        //muutetaan tiedot String muotoon
        nimi = nimiText.getText().toString();
        paino = painoText.getText().toString();
        pituus = pituusText.getText().toString();
        ika = ikaText.getText().toString();
        hauis = hauisText.getText().toString();
        vyotaro = vyotaroText.getText().toString();

        //lasketaan BMI arvo
        float painoF = Float.parseFloat(paino);
        float pituusF = Float.parseFloat(pituus);
        BMICalculator bmiCalculator = new BMICalculator(painoF, pituusF);
        float bmiArvo = bmiCalculator.getBMI();
        //pyöristetään BMI arvo yhteen desimaaliin
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        bmi = decimalFormat.format(bmiArvo);





        //tallennetaan muuttujat shared preferenceen josta ProfiiliActivity ne lataa.
        SharedPreferences sharedPreferences = getSharedPreferences("Prefet", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nimi", nimi);
        editor.putString("ika", ika);
        editor.putString("paino", paino);
        editor.putString("pituus", pituus);
        editor.putString("bmi", bmi);
        editor.putString("hauis", hauis);
        editor.putString("vyotaro", vyotaro);
        editor.commit();
        Toast.makeText(CreateProfiiliActivity.this, "Profiili luotu!", Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * @author Leevi Laaksonen
     *      *Metodi lähettää Tarkistus luokkaan muuttujat ja saa booleanin takaisin (false jos kaikkia kenttiä ei täytetty)
     *      * palauttaa saman booleanin kuin minkä saa luokasta Tarkistus
     *      * @return tarkistaja
     *
     */
    //Metodi kutsuu tarkistaja luokasta booleanin(true jos kaikki kentät täytetty)
    public boolean tarkista() {
        nimiText = (EditText) findViewById(R.id.editTextCProfileName);
        ikaText = (EditText) findViewById(R.id.editTextCAge);
        painoText = (EditText) findViewById(R.id.editTextCWeight);
        pituusText = (EditText) findViewById(R.id.editTextCHeight);
        hauisText = (EditText) findViewById(R.id.editTextCBicep);
        vyotaroText = (EditText) findViewById(R.id.editTextCwaist);

        //muutetaan tiedot String muotoon
        nimi = nimiText.getText().toString();
        paino = painoText.getText().toString();
        pituus = pituusText.getText().toString();
        ika = ikaText.getText().toString();
        hauis = hauisText.getText().toString();
        vyotaro = vyotaroText.getText().toString();

        //saa Tarkistus luokasta booleanin (true jos kaikki kentät täytetty, false jos ei)
        tarkistus = new Tarkistus(nimi, ika, paino, pituus, hauis, vyotaro);
        boolean tarkistaja = tarkistus.getTarkistus();

        return tarkistaja;
    }

}


