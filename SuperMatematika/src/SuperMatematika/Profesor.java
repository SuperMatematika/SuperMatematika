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
    private String Fakultet;
    public Profesor(String userType, String username, String Ime, String prezime, Date datumRodjenja, String pol,String Fakultet) {
        super(userType, username, Ime, prezime, datumRodjenja, pol);
        this.Fakultet=Fakultet;
    }

    
    public Profesor(Korisnik tr) {
        super(tr.getUserType(),tr.getUsername(),tr.getIme(),tr.getPrezime(),tr.getDatumRodjenja(),tr.getPol());
    }

    public Profesor(String username, String ime, String prezime,Date datumRodjenja, String pol, String fakultet) {
       super(username,ime,prezime,datumRodjenja,pol);
       this.Fakultet=fakultet;
    }

    

   
    String getFakultet() {
       return Fakultet;
    }

    Object getString(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
