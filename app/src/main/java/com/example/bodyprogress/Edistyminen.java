package com.example.bodyprogress;


public class Edistyminen {
    private String pvm;
    private int ika;
    private float paino;
    private float pituus;
    private String bmi;
    private String lisatietoja;
    private String hauis;
    private String vyotaro;


    public Edistyminen(String pvm, int ika, float paino, float pituus, String bmi, String lisatietoja, String hauis, String vyotaro) {
        this.pvm = pvm;
        this.ika = ika;
        this.paino = paino;
        this.pituus = pituus;
        this.bmi = bmi;
        this.lisatietoja = lisatietoja;
        this.hauis = hauis;
        this.vyotaro = vyotaro;

    }
    public String getPvm(){
        return this.pvm;
    }
    public int getIka(){
        return this.ika;
    }
    public float getPaino(){
        return this.paino;
    }
    public float getPituus(){
        return this.pituus;
    }
    public String getBmi(){
        return this.bmi;
    }
    public String getLisatietoja(){
        return this.lisatietoja;
    }
    public String getHauis(){ return this.hauis;}
    public String getVyotaro(){ return this.vyotaro; }

    @Override
    public String toString() {
        return this.pvm;
    }
}
