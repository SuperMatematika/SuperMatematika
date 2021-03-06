/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika.Model;

import java.awt.image.BufferedImage;
import java.lang.String;

/**
 *
 * @author samed
 *
 * Ova klasa pamti podatke o pojedinacnom zadatku, putanju do slike, tacan
 * odgovor i netacne odgovore
 */
public class Zadatak {

    private int id_zadatka;
    private String oblast;
    private Object slika_zadatka;

    public Zadatak(int aInt, String str1, String string) {
        id_zadatka = aInt;
        oblast = str1;
        slika_zadatka = (Object) string;
    }

    public void setSlika_zadatka(Object slika_zadatka) {
        this.slika_zadatka = slika_zadatka;
    }

    public Object getSlika_zadatka() {
        return slika_zadatka;
    }
    private String putanjaDoZadatka;
    private String tacanOdogovor;
    private String pogresanOdg1;
    private String pogresanOdg2;
    private String pogresanOdg3;

    public Zadatak(String putanjaDoZadatka, String tacanOdogovor, String pogresanOdg1, String pogresanOdg2, String pogresanOdg3) {
        this.putanjaDoZadatka = putanjaDoZadatka;
        this.tacanOdogovor = tacanOdogovor;
        this.pogresanOdg1 = pogresanOdg1;
        this.pogresanOdg2 = pogresanOdg2;
        this.pogresanOdg3 = pogresanOdg3;
    }

    public void setId_zadatka(int id_zadatka) {
        this.id_zadatka = id_zadatka;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public int getId_zadatka() {
        return id_zadatka;
    }

    public String getOblast() {
        return oblast;
    }

    public String getPutanjaDoZadatka() {
        return putanjaDoZadatka;
    }

    public void setPutanjaDoZadatka(String putanjaDoZadatka) {
        this.putanjaDoZadatka = putanjaDoZadatka;
    }

    public String getTacanOdogovor() {
        return tacanOdogovor;
    }

    public void setTacanOdogovor(String tacanOdogovor) {
        this.tacanOdogovor = tacanOdogovor;
    }

    public String getPogresanOdg1() {
        return pogresanOdg1;
    }

    public void setPogresanOdg1(String pogresanOdg1) {
        this.pogresanOdg1 = pogresanOdg1;
    }

    public String getPogresanOdg2() {
        return pogresanOdg2;
    }

    public void setPogresanOdg2(String pogresanOdg2) {
        this.pogresanOdg2 = pogresanOdg2;
    }

    public String getPogresanOdg3() {
        return pogresanOdg3;
    }

    public void setPogresanOdg3(String pogresanOdg3) {
        this.pogresanOdg3 = pogresanOdg3;
    }

    @Override
    public String toString() {
        return "Zadatak{" + "putanjaDoZadatka=" + putanjaDoZadatka + ", tacanOdogovor=" + tacanOdogovor + ", pogresanOdg1=" + pogresanOdg1 + ", pogresanOdg2=" + pogresanOdg2 + ", pogresanOdg3=" + pogresanOdg3 + '}';
    }
}
