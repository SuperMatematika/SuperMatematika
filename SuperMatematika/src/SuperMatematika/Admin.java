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
public class Admin extends Korisnik {

    public Admin(String userType, String username, String Ime, String prezime, String datumRodjenja, String pol) {
        super(userType, username, Ime, prezime, datumRodjenja, pol);
    }

    public Admin(Korisnik tr) {
        super(tr.getUserType(),tr.getUsername(),tr.getIme(),tr.getPrezime(),tr.getDatumRodjenja(),tr.getPol());
    }
    
}
