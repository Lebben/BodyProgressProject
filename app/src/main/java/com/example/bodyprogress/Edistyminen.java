package com.example.bodyprogress;

/**Luokka sisältää Edistymisen lisäämiseen tarvittavat tiedot, näitä tietoja käytetään moneen eri tarkoitukseen
 * kuten profiilin päivitykseen jossa viimeisimmän edistymisen tiedot siirtyy profiili osioon ja tallentaessa
 * shared preferenceihin olio listan avulla joka sisältää Edistyminen olioita.
 * @author Tatu Pulkkinen
 * @version 5.5.2020
 */

public class Edistyminen {
    private String pvm;
    private int ika;
    private float paino;
    private float pituus;
    private String bmi;
    private String lisatietoja;
    private String hauis;
    private String vyotaro;

    /**
     *
     * @param pvm, on päivämäärä String muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param ika, on henkilön ikä int muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param paino, on henkilön paino float muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param pituus, on henkilön pituus float muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param bmi, on henkilön painoindeksi String muodossa. Tämä saadaan käyttäjän painon ja pituuden avulla.
     * @param lisatietoja, on henkilön lisäämät lisätiedot String muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param hauis, on henkilön hauiksen ympäryysmitta String muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     * @param vyotaro, on henkilön vyötärönmitta String muodossa. Käyttäjä asettaa itse tämän ja se noudetaan tallentaessa.
     */

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

    public int getIka() {
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

    public String getHauis(){
        return this.hauis;
    }
    public String getVyotaro(){
        return this.vyotaro;
    }

    @Override
    public String toString() {
        return this.pvm;
    }
}
