/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1
 */
public class DBController {
    private static DBController instance=null; 
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private DBController() throws SQLException{
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = new File("").getAbsolutePath()+"/Supermatematika.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
            connection = DriverManager.getConnection(dbURL); 
        }
        catch(ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
    }
    
    public static DBController require() throws SQLException{
        if(instance==null){
            instance=new DBController();
        }
        return instance;
    }
    
    public ResultSet submitQuery(String query){
         try {
            statement = (Statement) connection.createStatement();  
            resultSet = statement.executeQuery(query);
        }
        catch(Exception E){
            System.out.println(E);
        }
        finally {
            try {
                if(null != connection) {
                    statement.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return resultSet;
    }
    public int getRazred(Korisnik k){
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT razred from Student where username='" + k.getUsername() + "';");
            try {
                statement.close();
                while (resultSet.next()) {
                    return resultSet.getInt("razred");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception E) {
            System.out.println(E);
        } 
        return 0;
    }
    
    
    
    public Korisnik loginValid(String username,String password){
         try {
            statement = (Statement) connection.createStatement();  
            resultSet=statement.executeQuery("SELECT username,usertype,ime,prezime,godina_rodjenja,pol from Users where username='"+username+"' and password='"+password+"';");
            statement.close();
            if(resultSet.next()){
                return new Korisnik(resultSet.getString("usertype"),resultSet.getString("username"),resultSet.getString("ime"),resultSet.getString("prezime"),resultSet.getDate("Godina_rodjenja"),resultSet.getString("pol"));
            }
            else{
                return null;
            }
          
        }
        catch(Exception E){
            System.out.println(E);
        }
        finally {
            try {
                if(null != connection)
                    statement.close();
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return null;
    }

    ArrayList<String> getPutanjeOblasti(String oblast,int idPredmeta) {
        try {
            ArrayList<String> listaPutanja=new ArrayList();
            statement = (Statement) connection.createStatement();
            // HARDKODOVANO mora da se ispravi, join sa tabelom Predmet, ovo sad radi samo za predmet matematika
            resultSet = statement.executeQuery("SELECT Putanja from "+oblast+" where ID_predmeta='"+idPredmeta+"';");
            statement.close();
            while (resultSet.next()) {
                listaPutanja.add(resultSet.getString("Putanja"));
//                listaLekcija.add(resultSet.getString("NaslovLekcije"));
            }
            return listaPutanja;

        } catch (Exception E) {
            System.out.println(E);
        } 

        return null;
    }

    ArrayList<String> getOblasti(String tabela,int idPredmeta) {
        try {
            ArrayList<String> listaLekcija=new ArrayList();
            statement = (Statement) connection.createStatement();
            // HARDKODOVANO mora da se ispravi, join sa tabelom Predmet, ovo sad radi samo za predmet matematika
            resultSet = statement.executeQuery("SELECT NaslovLekcije from "+tabela+" where ID_predmeta='"+idPredmeta+"';");
            statement.close();
            while (resultSet.next()) {
//                listaPutanja.add(resultSet.getString("Putanja"));
                listaLekcija.add(resultSet.getString("NaslovLekcije"));
            }
            return listaLekcija;

        } catch (Exception E) {
            System.out.println(E);
        } 

        return null;
    }

    List<Zadatak> SastaviTest(String oblast, int brzadataka) {
        ArrayList<Zadatak> zadaci = new ArrayList();
        
        try {

            // Treba da se popravi, da zavisi od razreda i od predmeta
            statement = (Statement) connection.createStatement();  
            resultSet = statement.executeQuery("SELECT * from Zadatak " 
                                                + "WHERE Oblast = '" + oblast + "'" 
                                                + "ORDER BY RAND() LIMIT " + brzadataka + ";");
            
            // Step 2.C: Executing SQL & retrieve data into ResultSet
             try{
                 while(resultSet.next()){
                     Zadatak temp = new Zadatak(resultSet.getString("Putanja"),
                                                resultSet.getString("TacanOdgovor"),
                                                resultSet.getString("PogresanOdgovor1"),
                                                resultSet.getString("PogresanOdgovor2"),
                                                resultSet.getString("PogresanOdgovor3"));
                    zadaci.add(temp);
                 }
                
             }       
             catch(Exception e){
                 System.out.println(e);
             }
            // processing returned data and printing into console
          
        }
        catch(Exception E){
            System.out.println(E);
        }
        finally {

            // Step 3: Closing database connection
            try {
                if(null != connection) {

                    // cleanup resources, once after 
                    statement.close();

                    //connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        
        return zadaci;
    }
    
    public ArrayList<Predmet> getPredmete(int razred){
         try {
            ArrayList<Predmet> listaPredmeta=new ArrayList();
            statement = (Statement) connection.createStatement();
            // HARDKODOVANO mora da se ispravi, join sa tabelom Predmet, ovo sad radi samo za predmet matematika
            resultSet = statement.executeQuery("SELECT ID_predmeta,naziv,Users.ime,Users.prezime,razred from Predmet,Users where Predmet.username_nastavnika=username and Razred='"+razred+"';");
            statement.close();
            while (resultSet.next()) {
//                listaPutanja.add(resultSet.getString("Putanja"));
                listaPredmeta.add(new Predmet(resultSet.getInt("ID_predmeta"),resultSet.getString("Naziv"),resultSet.getString("Ime")+" "+resultSet.getString("Prezime"),resultSet.getInt("Razred")));
            }
            return listaPredmeta;

        } catch (Exception E) {
            System.out.println(E);
        } 

        return null;
    }

    void submitTest(ArrayList<ZadatakPanel> resenjaZadataka,Student s) throws SQLException {
        try{
            statement=(Statement) connection.createStatement();
            
            statement.executeUpdate("Insert into rezultati values('"+s.getUsername()+"', ");
            
        }catch(Exception e){
            
        }finally{
            statement.close();
        }
    }  
    
    // Ovo sam malo drugacije uradio jer zelim da radim sa izuzecima u UcenikNalogPanel posto ima tamo jos nekih izuzetaka
    void postaviNovuLozinku(String username, String staraLozinka, String novaLozinka) throws SQLException, Exception {
        // Koristim funkciju loginValid da bi proverio da li je stara lozinka ispravna
        Korisnik k = require().loginValid(username,staraLozinka);
        if (k == null) 
            throw new Exception("Neispravna stara lozinka!"); 
        
        // Promena lozinke u bazi podataka
        String upit = "UPDATE Users SET Password = '" + novaLozinka + "' WHERE Username = '" + username + "';";
        statement=(Statement) connection.createStatement();
        statement.executeUpdate(upit);           
    }
}
