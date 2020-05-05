package com.example.bodyprogress;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LisaaEdistyminen extends AppCompatActivity {
    public static final String PVM = "pvm";
    public static final String PAINO = "paino";
    public static final String PITUUS = "pituus";
    public static final String BMIARVO = "bmiarvo";
    public static final String IKA = "ikä";
    public static final String LISATIEDOT = "lisatiedot";
    public static final String HAUIS = "hauis";
    public static final String VYOTARO = "vyotaro";

    private TextView BMI;
    private EditText paino, pituus, pvm, ika, lisatiedot, hauis, vyotaro;
    private BMICalculator bmiCalculator;
    private Tarkistus tarkistus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisaa_edistyminen);

        paino = (EditText) findViewById(R.id.PainoText);
        pituus = (EditText) findViewById(R.id.PituusText);
        BMI = (TextView) findViewById(R.id.BMINumero);
        pvm = (EditText) findViewById(R.id.PaivamaaraText);
        ika = (EditText) findViewById(R.id.IkaText);
        lisatiedot = (EditText) findViewById(R.id.KuvausBox);
        hauis = (EditText) findViewById(R.id.HauisText);
        vyotaro = (EditText) findViewById(R.id.VyotaroText);

    }



    //laskee BMI arvon ja päivittää sen kohdan
    public void onLaskeBMIClick(View v){
        laskeBMI();
    }
    private void laskeBMI(){

        //ottaa käyttäjän asettaman painon ja muutta sen merkkijonoksi.
        String stringPaino = paino.getText().toString();
        String stringPituus = pituus.getText().toString();

        //String to -> float.
        float laskettavaPaino = Float.parseFloat(stringPaino);
        float laskettavaPituus = Float.parseFloat(stringPituus);

        //uusi bmilaskuri olio, annetaan float arvot paino ja pituus.
        bmiCalculator = new BMICalculator(laskettavaPaino, laskettavaPituus);

        //saadaan laskurista BMI arvo ja asetetaan float muutujaan bmiArvo.
        float bmiArvo = bmiCalculator.getBMI();
        //pyöristetään BMI arvo yhteen desimaaliin
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        String bmiS = decimalFormat.format(bmiArvo);

        //laitetaan BMI:n teksiosuuteen pyöristetty arvo joka saatiin laskurista
        BMI.setText(bmiS);

    }
//    //luodaan intent jossa valitaan kuva galleriasta, ja aloitetaan aktiviteetti.
//    private void avaaGalleria(){
//        Intent valitseGalleriasta = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(valitseGalleriasta, PICK_IMAGE);
//    }
//    //asettaa valitun kuvan imageButtonin kohdalle jos kuvan valitseminen onnistui
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //kun käyttäjä on valinnut kuvan onnistuneesti se laitetaan kuvan paikalle.
//        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
//            ImageUri = data.getData();
//            userImage.setImageURI(ImageUri);
//        }
//    }

    //painaessa tallena nappia tallentaa tiedot shared preferenceihin yksitellen. (oli ongelmia saada koko lista)
    public void onTallennaClick(View v){


        if (tarkista()==true) {
            //muutetaan ensin saadut tiedot käyttäjältä sopiviin muotoihin.
            String stringPvm = pvm.getText().toString();
            int intIka = Integer.parseInt(ika.getText().toString());
            float floatPaino = Float.parseFloat(paino.getText().toString());
            float floatPituus = Float.parseFloat(pituus.getText().toString());
            float floatBmi = Float.parseFloat(BMI.getText().toString());
            String stringLisatiedot = lisatiedot.getText().toString();

            String stringIka = ika.getText().toString();
            String stringPaino = paino.getText().toString();
            String stringPituus = pituus.getText().toString();
            String stringHauis = hauis.getText().toString();
            String stringVyotaro = vyotaro.getText().toString();


            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            String stringBmi = decimalFormat.format(floatBmi);

            //tallennetaan tiedot
            SharedPreferences sharedPreferences = getSharedPreferences("Prefet", MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();

            editor.putString("ika", stringIka);
            editor.putString("paino", stringPaino);
            editor.putString("pituus", stringPituus);
            editor.putString("bmi", stringBmi);
            editor.putString("hauis", stringHauis);
            editor.putString("vyotaro", stringVyotaro);
            editor.commit();



            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor2 = prefs.edit();
            editor2.putString(PVM, stringPvm);
            editor2.putInt(IKA, intIka);
            editor2.putFloat(PAINO, floatPaino);
            editor2.putFloat(PITUUS, floatPituus);
            editor2.putString(BMIARVO, stringBmi);
            editor2.putString(LISATIEDOT, stringLisatiedot);
            editor2.putString(HAUIS, stringHauis);
            editor2.putString(VYOTARO, stringVyotaro);
            editor2.apply();

            //lopuksi ilmoitetaan käyttäjälle että tiedot on tallennettu ja päivitä edistymisesi.
            Toast.makeText(LisaaEdistyminen.this, "Tiedot tallennettu!", Toast.LENGTH_LONG).show();
            finish();
        }
        else{
            Toast.makeText(LisaaEdistyminen.this, "Täytä kaikki kentät", Toast.LENGTH_LONG).show();
        }


    }


    //Metodi kutsuu tarkistaja luokasta booleanin(true jos kaikki kentät täytetty)
    public boolean tarkista() {
        paino = (EditText) findViewById(R.id.PainoText);
        pituus = (EditText) findViewById(R.id.PituusText);
        ika = (EditText) findViewById(R.id.IkaText);
        hauis = (EditText) findViewById(R.id.HauisText);
        vyotaro = (EditText) findViewById(R.id.VyotaroText);

        //muutetaan tiedot String muotoon

        String nimi = "on valmiiksi";
        String painoS = paino.getText().toString();
        String pituusS = pituus.getText().toString();
        String ikaS = ika.getText().toString();
        String hauisS = hauis.getText().toString();
        String vyotaroS = vyotaro.getText().toString();

        tarkistus = new Tarkistus(nimi, ikaS, painoS, pituusS, hauisS, vyotaroS);
        boolean tarkistaja = tarkistus.getTarkistus();

        return tarkistaja;
    }


}
