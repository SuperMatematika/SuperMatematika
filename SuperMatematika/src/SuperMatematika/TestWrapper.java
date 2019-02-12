/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

/**
 *
 * @author 1
 */
public class TestWrapper {

    private String nastavnik;
    private int id_predmeta;
    private int razred;
    private int tromesecje;
    private int redni_broj_testa;
    private int[] zadaci;

    public TestWrapper() {
    }

    public void setNastavnik(String nastavnik) {
        this.nastavnik = nastavnik;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public void setId_predmeta(int id_predmeta) {
        this.id_predmeta = id_predmeta;
    }

    public int getId_predmeta() {
        return id_predmeta;
    }

    public void setTromesecje(int odeljenje) {
        this.tromesecje = odeljenje;
    }

    public void setRedni_broj_testa(int redni_broj_testa) {
        this.redni_broj_testa = redni_broj_testa;
    }

    public void setZadaci(int[] zadaci) {
        this.zadaci = zadaci;
    }

    public String getNastavnik() {
        return nastavnik;
    }

    public int getRazred() {
        return razred;
    }

    public int getTromesecje() {
        return tromesecje;
    }

    public int getRedni_broj_testa() {
        return redni_broj_testa;
    }

    public int[] getZadaci() {
        return zadaci;
    }

    public TestWrapper(String nastavnik, int id_predmeta, int razred, int odeljenje, int redni_broj_testa, int[] zadaci) {
        this.nastavnik = nastavnik;
        this.id_predmeta = id_predmeta;
        this.razred = razred;
        this.tromesecje = odeljenje;
        this.redni_broj_testa = redni_broj_testa;
        this.zadaci = zadaci;
    }
}
