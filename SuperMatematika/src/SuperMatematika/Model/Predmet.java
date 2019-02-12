/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika.Model;

/**
 *
 * @author 1
 */
public class Predmet {

    private int id;
    private String nazivPredmeta;
    private String predavac;
    private int razred;

    public Predmet() {
    }

    public Predmet(int id, String nazivPredmeta, String predavac, int razred) {
        this.id = id;
        this.nazivPredmeta = nazivPredmeta;
        this.predavac = predavac;
        this.razred = razred;
    }

    public int getId() {
        return id;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public String getPredavac() {
        return predavac;
    }

    public int getRazred() {
        return razred;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setPredavac(String predavac) {
        this.predavac = predavac;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

}
