package com.example.bodyprogress;

/**
 * Luokka tarkistaa onko editTextistä saadut muuttujat tyhjiä stringejä.
 * @author Leevi Laaksonen
 * @version 5.5.2020
 */
public class Tarkistus {
    private String nimi, ika, paino, pituus, hauis, vyotaro;
    private boolean tulos;

    public Tarkistus (String nimi, String ika, String paino, String pituus, String hauis, String vyotaro) {
        this.nimi = nimi;
        this.ika = ika;
        this.paino = paino;
        this.pituus = pituus;
        this.hauis = hauis;
        this.vyotaro = vyotaro;
    }


    /**
     * Palauttaa booleanin true vain jos mikään string ei ole "tyhjä"
     * @return boolean
     */
    public boolean getTarkistus(){
        if(nimi.isEmpty()) {return false;  }
        if(ika.isEmpty()) {return false;  }
        if(paino.isEmpty()) {return false;  }
        if(pituus.isEmpty()) {return false;  }
        if(hauis.isEmpty()) {return false;  }
        if(vyotaro.isEmpty()) {return false;  }
        else{ return true; }

    }

}
