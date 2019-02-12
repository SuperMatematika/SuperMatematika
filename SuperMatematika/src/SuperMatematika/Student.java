package SuperMatematika;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1
 */
public class Student extends Korisnik {

    private int razred;
    private int odeljenje;

    public Student(String userType, String username, String Ime, String prezime, String datumRodjenja, String pol, int razred, int odeljenje) {
        super(userType, username, Ime, prezime, datumRodjenja, pol);
        this.razred = razred;
        this.odeljenje = odeljenje;
    }

    Student(Korisnik tr) {
        super(tr.getUserType(), tr.getUsername(), tr.getIme(), tr.getPrezime(), tr.getDatumRodjenja(), tr.getPol());
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public int getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(int odeljenje) {
        this.odeljenje = odeljenje;
    }

    @Override
    public String toString() {
        return "Student{" + "razred=" + razred + '}';
    }

}
