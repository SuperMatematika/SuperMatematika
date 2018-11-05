/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.util.Date;

/**
 *
 * @author 1
 */
public class Profesor extends Korisnik{
<<<<<<< HEAD
    
    public Profesor(String userType, String username, String Ime, String prezime, Date datumRodjenja, String pol) {
        super(userType, username, Ime, prezime, datumRodjenja, pol);
    }

=======
    String fakultet;
    public Profesor(String userType, String username, String Ime, String prezime, Date datumRodjenja, String pol, String fakultet) {
        super(userType, username, Ime, prezime, datumRodjenja, pol);
        this.fakultet = fakultet;
    }
>>>>>>> Profil-i-Ocene
    
    public Profesor(Korisnik tr) {
        super(tr.getUserType(),tr.getUsername(),tr.getIme(),tr.getPrezime(),tr.getDatumRodjenja(),tr.getPol());
    }
<<<<<<< HEAD
=======

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }
    
    
>>>>>>> Profil-i-Ocene
    
}
