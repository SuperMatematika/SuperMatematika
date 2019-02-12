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
public class RezultatiTesta {

    private String student;
    private int id_predmeta;

    public RezultatiTesta(String student, String ime_predmeta, int odeljenje, int razred, int redni_broj_testa, int broj_bodova, boolean odgovor1, boolean odgovor2, boolean odgovor3, boolean odgovor4, boolean odgovor5) {
        this.student = student;
        this.odeljenje = odeljenje;
        this.razred = razred;
        this.redni_broj_testa = redni_broj_testa;
        this.odgovor1 = odgovor1;
        this.odgovor2 = odgovor2;
        this.odgovor3 = odgovor3;
        this.odgovor4 = odgovor4;
        this.odgovor5 = odgovor5;
        this.broj_bodova = broj_bodova;
        this.ime_predmeta = ime_predmeta;
    }
    private int odeljenje;
    private int razred;
    private int redni_broj_testa;
    private boolean odgovor1;
    private boolean odgovor2;
    private boolean odgovor3;
    private boolean odgovor4;
    private boolean odgovor5;
    private int broj_bodova;
    private String ime_predmeta;

    public void setIme_predmeta(String ime_predmeta) {
        this.ime_predmeta = ime_predmeta;
    }

    public String getIme_predmeta() {
        return ime_predmeta;
    }

    RezultatiTesta(String string, String aInt, int aInt0, int aInt1, int aInt2, int aInt3) {
        student = string;
        ime_predmeta = aInt;
        odeljenje = aInt0;
        razred = aInt1;
        redni_broj_testa = aInt2;
        broj_bodova = aInt3;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setId_predmeta(int id_predmeta) {
        this.id_predmeta = id_predmeta;
    }

    public void setOdeljenje(int odeljenje) {
        this.odeljenje = odeljenje;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public void setRedni_broj_testa(int redni_broj_testa) {
        this.redni_broj_testa = redni_broj_testa;
    }

    public void setBroj_bodova(int broj_bodova) {
        this.broj_bodova = broj_bodova;
    }

    public String getStudent() {
        return student;
    }

    public int getId_predmeta() {
        return id_predmeta;
    }

    public int getOdeljenje() {
        return odeljenje;
    }

    public int getRazred() {
        return razred;
    }

    public int getRedni_broj_testa() {
        return redni_broj_testa;
    }

    public int getBroj_bodova() {
        return broj_bodova;
    }

    public void setOdgovor1(boolean odgovor1) {
        this.odgovor1 = odgovor1;
    }

    public void setOdgovor2(boolean odgovor2) {
        this.odgovor2 = odgovor2;
    }

    public void setOdgovor3(boolean odgovor3) {
        this.odgovor3 = odgovor3;
    }

    public void setOdgovor4(boolean odgovor4) {
        this.odgovor4 = odgovor4;
    }

    public void setOdgovor5(boolean odgovor5) {
        this.odgovor5 = odgovor5;
    }

    public boolean isOdgovor1() {
        return odgovor1;
    }

    public boolean isOdgovor2() {
        return odgovor2;
    }

    public boolean isOdgovor3() {
        return odgovor3;
    }

    public boolean isOdgovor4() {
        return odgovor4;
    }

    public boolean isOdgovor5() {
        return odgovor5;
    }

    public RezultatiTesta(String student, int id_predmeta, int odeljenje, int razred, int redni_broj_testa, boolean odgovor1, boolean odgovor2, boolean odgovor3, boolean odgovor4, boolean odgovor5, int broj_bodova) {
        this.student = student;
        this.id_predmeta = id_predmeta;
        this.odeljenje = odeljenje;
        this.razred = razred;
        this.redni_broj_testa = redni_broj_testa;
        this.odgovor1 = odgovor1;
        this.odgovor2 = odgovor2;
        this.odgovor3 = odgovor3;
        this.odgovor4 = odgovor4;
        this.odgovor5 = odgovor5;
        this.broj_bodova = broj_bodova;
    }

}
