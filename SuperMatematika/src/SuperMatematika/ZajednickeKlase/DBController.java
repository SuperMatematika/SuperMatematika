package SuperMatematika.ZajednickeKlase;

import SuperMatematika.UcenikPaneli.PanelZadatak;
import SuperMatematika.Model.RezultatiTesta;
import SuperMatematika.Model.TestWrapper;
import SuperMatematika.Model.Profesor;
import SuperMatematika.Model.Predmet;
import SuperMatematika.Model.Student;
import SuperMatematika.Model.Zadatak;
import SuperMatematika.Model.Korisnik;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1
 */
public class DBController {

    private static DBController instance = null;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DBController() throws SQLException {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = new File("").getAbsolutePath() + "/Supermatematika.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB;
            connection = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
    }

    public static DBController require() throws SQLException {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public ResultSet submitQuery(String query) {
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception E) {
            System.out.println(E);
        } finally {
            try {
                if (null != connection) {
                    statement.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return resultSet;
    }

    // Vraca razred za datog ucenika
    public int getRazred(Korisnik k) {
        resultSet = submitQuery("SELECT razred FROM Student WHERE username='" + k.getUsername() + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getInt("razred");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    // Vraca odeljnje ucenika
    public int getOdeljenje(Korisnik k) {
        resultSet = submitQuery("SELECT Odeljenje FROM Student WHERE username='" + k.getUsername() + "';");
        try {
            if (resultSet.next()) {
                return resultSet.getInt("odeljenje");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    // Proverava da li je login ispravan
    public Korisnik loginValid(String username, String password) {
        resultSet = submitQuery("SELECT username,usertype,ime,prezime,godina_rodjenja,pol from Users where username='" + username + "' and password='" + password + "';");

        try {
            if (resultSet.next()) {
                return new Korisnik(resultSet.getString("usertype"), resultSet.getString("username"), resultSet.getString("ime"), resultSet.getString("prezime"), resultSet.getString("Godina_rodjenja"), resultSet.getString("pol"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /* public Profesor getProfesore(Profesor p) throws SQLException
    {
        resultSet=submitQuery("Select Users.username,Users.ime,Users.prezime,Users.godina_rodjenja,Users.pol,Nastavnik.fakultet from Users,Nastavnik where Users.username=Nastavnik.username");
            try {
            if(resultSet.next())    
        return new Profesor(resultSet.getString("usertype"),resultSet.getString("username"),resultSet.getString("ime"),resultSet.getString("prezime"),resultSet.getDate("datumRodjenja"),resultSet.getString("pol"),resultSet.getString("fakultet"));
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }
            return null;
     }*/
    public ArrayList<String> getPutanjeOblasti(String oblast, int idPredmeta) {
        ArrayList<String> listaPutanja = new ArrayList();
        resultSet = submitQuery("SELECT Putanja from " + oblast + " where ID_predmeta='" + idPredmeta + "';");
        try {
            while (resultSet.next()) {
                listaPutanja.add(resultSet.getString("Putanja"));
            }
            return listaPutanja;

        } catch (Exception E) {
            E.printStackTrace();
        }

        return null;
    }

    public ArrayList<String> getOblasti(String tabela, int idPredmeta) {
        ArrayList<String> listaLekcija = new ArrayList();
        resultSet = submitQuery("SELECT NaslovLekcije from " + tabela + " where ID_predmeta='" + idPredmeta + "';");
        try {
            while (resultSet.next()) {
                listaLekcija.add(resultSet.getString("NaslovLekcije"));
            }
            return listaLekcija;

        } catch (Exception E) {
            System.out.println(E);
        }

        return null;
    }

    public List<Zadatak> SastaviTest(ArrayList<String> oblasti, int brzadataka) throws GreskaNemaDovoljnoPitanja {
        ArrayList<Zadatak> zadaci = new ArrayList();

        String upit = "SELECT * from Zadatak "
                + "WHERE Oblast = '" + String.join("' OR Oblast = '", oblasti) + "' "
                + "ORDER BY RAND() LIMIT " + brzadataka + ";";

        resultSet = submitQuery(upit);

        try {
            while (resultSet.next()) {
                Zadatak temp = new Zadatak(resultSet.getString("Putanja"),
                        resultSet.getString("TacanOdgovor"),
                        resultSet.getString("PogresanOdgovor1"),
                        resultSet.getString("PogresanOdgovor2"),
                        resultSet.getString("PogresanOdgovor3"));
                zadaci.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (zadaci.size() < 5) {
            throw new GreskaNemaDovoljnoPitanja();
        }

        return zadaci;
    }

    // Funkcija vraca listu od 5 zadataka koji su unapred odrednjeni od strane nastavnika i nalaze se u bazi
    public List<Zadatak> SastaviTest(int razred, int odeljenje, int ID_predmeta, int redniBrojTesta) {
        ArrayList<Zadatak> zadaci = new ArrayList();

        String upit = "SELECT Zadatak.*\n"
                + "FROM Zadatak, Test\n"
                + "WHERE (Zadatak.ID_zadatka = Test.zad1 OR Zadatak.ID_zadatka = Test.zad2 OR Zadatak.ID_zadatka = Test.zad3 OR Zadatak.ID_zadatka = Test.zad4 OR Zadatak.ID_zadatka = Test.zad5) \n"
                + " AND Test.redni_broj_testa = " + redniBrojTesta
                + " AND Test.predmet = " + ID_predmeta
                + " AND Test.razred = " + razred
                + " AND Test.tromesecje = " + odeljenje + ";";
        resultSet = submitQuery(upit);

        try {
            while (resultSet.next()) {
                Zadatak temp = new Zadatak(resultSet.getString("Putanja"),
                        resultSet.getString("TacanOdgovor"),
                        resultSet.getString("PogresanOdgovor1"),
                        resultSet.getString("PogresanOdgovor2"),
                        resultSet.getString("PogresanOdgovor3"));
                zadaci.add(temp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return zadaci;
    }

    public ArrayList<Predmet> getPredmete(int razred) {
        try {
            ArrayList<Predmet> listaPredmeta = new ArrayList();
            statement = (Statement) connection.createStatement();
            // HARDKODOVANO mora da se ispravi, join sa tabelom Predmet, ovo sad radi samo za predmet matematika
            resultSet = statement.executeQuery("SELECT ID_predmeta,naziv,Users.ime,Users.prezime,razred from Predmet,Users where Predmet.username_nastavnika=username and Razred='" + razred + "';");
            statement.close();
            while (resultSet.next()) {
//                listaPutanja.add(resultSet.getString("Putanja"));
                listaPredmeta.add(new Predmet(resultSet.getInt("ID_predmeta"), resultSet.getString("Naziv"), resultSet.getString("Ime") + " " + resultSet.getString("Prezime"), resultSet.getInt("Razred")));
            }
            return listaPredmeta;

        } catch (Exception E) {
            System.out.println(E);
        }

        return null;
    }

    // U tabeli Rezultati_testa upisuje podatke o tom testu, informacije o svakom zadatku
    // tj. da li je tacan ili ne i ukupan broj bodova
    public void submitTest(ArrayList<PanelZadatak> resenjaZadataka, Student trenutniKorisnik, int ID_predmeta, int redniBrojTesta) throws SQLException {
        try {
            String upit = "INSERT INTO Rezultati_testa VALUES ('" + trenutniKorisnik.getUsername() + "', "
                    + ID_predmeta + ", " + trenutniKorisnik.getOdeljenje() + ", "
                    + trenutniKorisnik.getRazred() + ", " + redniBrojTesta + ", "
                    + resenjaZadataka.get(0).odgovorJeTacan() + ", "
                    + resenjaZadataka.get(1).odgovorJeTacan() + ", "
                    + resenjaZadataka.get(2).odgovorJeTacan() + ", "
                    + resenjaZadataka.get(3).odgovorJeTacan() + ", "
                    + resenjaZadataka.get(4).odgovorJeTacan() + ", "
                    + izracunajBrojBodova(resenjaZadataka) + ");";

            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);

            System.out.println(upit);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }
    }

    // Pomocna funkcija koja izracunava broj bodova za dati niz ZadatakPanela
    private int izracunajBrojBodova(ArrayList<PanelZadatak> resenjaZadataka) {
        int brojTacnihOdgovora = 0;
        for (PanelZadatak zp : resenjaZadataka) {
            if (zp.odgovorJeTacan()) {
                brojTacnihOdgovora++;
            }
        }

        return 100 * brojTacnihOdgovora / resenjaZadataka.size();
    }

    // Ovo sam malo drugacije uradio jer zelim da radim sa izuzecima u UcenikNalogPanel posto ima tamo jos nekih izuzetaka
    public void postaviNovuLozinku(String username, String staraLozinka, String novaLozinka) throws SQLException, Exception {
        // Koristim funkciju loginValid da bi proverio da li je stara lozinka ispravna
        Korisnik k = require().loginValid(username, staraLozinka);
        if (k == null) {
            throw new Exception("Neispravna stara lozinka!");
        }

        String upit = "UPDATE Users SET Password = '" + novaLozinka + "' WHERE Username = '" + username + "';";
        statement = (Statement) connection.createStatement();
        statement.executeUpdate(upit);
    }

    public void DodajKorisnika(String username, String password, String usertype, String ime, String prezime, String datum_rodjenja, String pol) throws SQLException {
        try {
            String upit = "Insert into Users(username,password,usertype,ime,prezime,godina_rodjenja,pol) Values('" + username + "','" + password + "','" + usertype + "','" + ime + "','" + prezime + "','" + datum_rodjenja + "','" + pol + "')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dati korisnik vec postoji!");
            e.printStackTrace();
        } finally {
            statement.close();
        }

    }

    public void DodajProfesora(String username, String fakultet) throws SQLException {
        try {
            String upit = "Insert into Nastavnik(username,fakultet) Values('" + username + "','" + fakultet + "')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
        }

    }

    public void DodajStudenta(String username, int Razred, int Odeljenje) throws SQLException {
        try {
            String upit = "Insert into Student(username,razred,odeljenje) Values('" + username + "'," + Razred + "," + Odeljenje + ")";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ProfesorPredaje(String NazivPredmeta, String username, int Razred) throws SQLException {
        int idPredmeta;
        idPredmeta = getIdPredmeta();
        idPredmeta++;
        try {
            statement.close();
            String upit = "Insert into Predmet Values(" + idPredmeta + ",'" + NazivPredmeta + "','" + username + "'," + Razred + ")";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getIdPredmeta() throws SQLException {
        try {
            statement.close();
            System.out.println(connection.isClosed() + " i " + statement.isClosed());
            String upit = "Select max(id_predmeta) as dzm FROM Predmet;";
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(upit);
            System.out.println(resultSet);

            while (resultSet.next()) {
                return resultSet.getInt("dzm");
            }
        } catch (Exception ex) {
            System.out.println("Ne radi" + ex);
        }
        return 0;

    }

    public ArrayList<Predmet> getProfPredmeti(Profesor trenutniKorisnik) throws SQLException {
        ArrayList<Predmet> listaPredmeta = new ArrayList();
        try {
            int i = 0;
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_predmeta,naziv,username_nastavnika,razred from predmet where username_nastavnika='" + trenutniKorisnik.getUsername() + "';");
            while (resultSet.next()) {
                listaPredmeta.add(new Predmet(resultSet.getInt("id_predmeta"), resultSet.getString("naziv"), resultSet.getString("username_nastavnika"), resultSet.getInt("razred")));
            }

        } catch (Exception e) {

        } finally {
            statement.close();
        }
        return listaPredmeta;
    }

    public void kreirajTest(Profesor p, TestWrapper newTest, ArrayList<Integer> izabraniZadaci) throws SQLException {
        try {
            String upit = "insert into Test"
                    + " (nastavnik, predmet, razred, tromesecje, redni_broj_testa, zad1, zad2, zad3, zad4, zad5) "
                    + " values('" + p.getUsername() + "'," + newTest.getId_predmeta() + "," + newTest.getRazred() + "," + newTest.getTromesecje() + "," + newTest.getRedni_broj_testa() + "," + izabraniZadaci.get(0) + "," + izabraniZadaci.get(1) + "," + izabraniZadaci.get(2) + "," + izabraniZadaci.get(3) + "," + izabraniZadaci.get(4) + ");";
            System.out.println(upit);
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);

            JOptionPane.showMessageDialog(null, "Uspesno!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Dati test vec postoji. Kliknite YES ako zelite da ga izmenite, NO ako zelite da ostane isti.", "Test vec postoji", dialogButton);
            if (dialogResult == 0) {
                System.out.println("Yes option");
            } else {
                System.out.println("No Option");
            }
        } finally {
            statement.close();
        }
    }

    public ArrayList<Zadatak> prikaziZadatke(String selectedPredmet, String selectedRazred, ArrayList<String> izabraneOblasti) {
        ArrayList<String> izabObl = new ArrayList();
        ArrayList<Zadatak> iza = new ArrayList();
        System.out.println("Asd");
        izabraneOblasti.forEach(e -> {
            System.out.println("PRE:" + e);
            if (izabraneOblasti.get(izabraneOblasti.size() - 1) != e) {
                izabObl.add("'" + e + "',");
            } else {
                izabObl.add("'" + e + "'");
            }
            System.out.println("POSLE:" + izabObl.get(izabObl.size() - 1));
        });
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT id_zadatka,oblast,putanja from zadatak,predmet where predmet.razred=" + selectedRazred + " and predmet.id_predmeta=zadatak.id_predmeta and predmet.naziv='" + selectedPredmet + "' and zadatak.oblast in (" + prebaci(izabObl) + ");");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id_zadatka"));
                iza.add(new Zadatak(resultSet.getInt("id_zadatka"), resultSet.getString("oblast"), resultSet.getString("putanja")));
            }
            return iza;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    private String prebaci(ArrayList<String> izabObl) {
        String ret = "";
        for (int i = 0; i < izabObl.size(); i++) {
            ret += izabObl.get(i);
        }
        return ret;
    }

    public int getIdPredmeta(String nazivP, int raz) {

        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("select id_predmeta from predmet where naziv='" + nazivP + "' and razred='" + raz + "';");
            while (resultSet.next()) {
                return resultSet.getInt("id_predmeta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<TestWrapper> prikaziTestove(Profesor trenutniKorisnik) throws SQLException {
        ArrayList<TestWrapper> testovi = new ArrayList();

        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT predmet,razred,tromesecje,redni_broj_testa FROM test where nastavnik='" + trenutniKorisnik.getUsername() + "'");
            int i = 0;
            while (resultSet.next()) {
                testovi.add(new TestWrapper());
                testovi.get(i).setId_predmeta(resultSet.getInt("predmet"));
                testovi.get(i).setRazred(resultSet.getInt("razred"));
                testovi.get(i).setTromesecje(resultSet.getInt("tromesecje"));
                testovi.get(i).setRedni_broj_testa(resultSet.getInt("redni_broj_testa"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            statement.close();
        }

        return testovi;
    }

    public ArrayList<RezultatiTesta> statistika(Profesor trenutniKorisnik, TestWrapper newTest) {
        ArrayList<RezultatiTesta> rt = new ArrayList();

        try {
            statement = (Statement) connection.createStatement();
            if (newTest.getTromesecje() != 5 && newTest.getRedni_broj_testa() != 5) {
                resultSet = statement.executeQuery("SELECT predmet.naziv,rezultati_testa.*"
                        + " from rezultati_testa,predmet "
                        + "where predmet.username_nastavnika='" + trenutniKorisnik.getUsername() + "'"
                        + "and rezultati_testa.predmet=predmet.id_predmeta "
                        + "and rezultati_testa.predmet='" + newTest.getId_predmeta() + "' "
                        + "and rezultati_testa.tromesecje='" + newTest.getTromesecje() + "' "
                        + "and rezultati_testa.razred='" + newTest.getRazred() + "' "
                        + "and rezultati_testa.redni_broj_testa='" + newTest.getRedni_broj_testa() + "'");
            } else if (newTest.getTromesecje() == 5 && newTest.getRedni_broj_testa() != 5) {
                resultSet = statement.executeQuery("SELECT predmet.naziv,rezultati_testa.* "
                        + "from rezultati_testa,predmet "
                        + "where predmet.username_nastavnika='" + trenutniKorisnik.getUsername() + "'"
                        + "and rezultati_testa.predmet=predmet.id_predmeta "
                        + "and rezultati_testa.predmet='" + newTest.getId_predmeta() + "' "
                        + "and rezultati_testa.razred='" + newTest.getRazred() + "' "
                        + "and rezultati_testa.redni_broj_testa='" + newTest.getRedni_broj_testa() + "'");
            } else if (newTest.getTromesecje() != 5 && newTest.getRedni_broj_testa() == 5) {
                resultSet = statement.executeQuery("SELECT predmet.naziv,rezultati_testa.*"
                        + " from rezultati_testa,predmet "
                        + "where predmet.username_nastavnika='" + trenutniKorisnik.getUsername() + "'"
                        + "and rezultati_testa.predmet=predmet.id_predmeta "
                        + "and rezultati_testa.predmet='" + newTest.getId_predmeta() + "' "
                        + "and rezultati_testa.tromesecje='" + newTest.getTromesecje() + "' "
                        + "and rezultati_testa.razred='" + newTest.getRazred() + "';");
            } else {
                resultSet = statement.executeQuery("SELECT predmet.naziv,rezultati_testa.* "
                        + "from rezultati_testa,predmet "
                        + "where predmet.username_nastavnika='" + trenutniKorisnik.getUsername() + "'"
                        + "and rezultati_testa.predmet=predmet.id_predmeta "
                        + "and rezultati_testa.predmet='" + newTest.getId_predmeta() + "' "
                        + "and rezultati_testa.razred='" + newTest.getRazred() + "';");
            }
            while (resultSet.next()) {
                System.out.println(resultSet.getString("student"));
                rt.add(new RezultatiTesta(resultSet.getString("student"), resultSet.getString("naziv"), resultSet.getInt("tromesecje"), resultSet.getInt("razred"), resultSet.getInt("redni_broj_testa"), resultSet.getInt("broj_bodova"), resultSet.getBoolean("odgovor1"), resultSet.getBoolean("odgovor2"), resultSet.getBoolean("odgovor3"), resultSet.getBoolean("odgovor4"), resultSet.getBoolean("odgovor5")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return rt;
    }

    public void izbrisiKorisnika(Object valueAt) throws SQLException {
        String user = (String) valueAt;
        try {
            String upit = "delete * from test where nastavnik='" + user + "';delete * from predmet where username_nastavnika='" + user + "';delete * from nastavnik where username='" + user + "' delete * from users where username='" + user + "'"; //'; delete from Users where username='"+user+"'"
            // String upit="delete * from users where username='"+user+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(upit);
            System.out.println("Uspesno izbrisano");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            statement.close();
        }
    }

    public void addToDbFile(int id_predmeta, String oblast, String naslocLekcije, String fileName, String type) throws SQLException {
        System.out.println(new File("").getAbsolutePath() + "\\predavanja");

        try {
            statement = (Statement) connection.createStatement();
            String s = "\\predavanja\\" + fileName;
            statement.executeUpdate("insert into " + type + "(ID_predmeta,oblast,naslovlekcije,putanja) values(" + id_predmeta + ",'" + oblast + "','" + naslocLekcije + "','" + s + "');");
            JOptionPane.showMessageDialog(null, "Uspesno!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            statement.close();
        }

    }

    public class GreskaNemaDovoljnoPitanja extends Exception {

        public GreskaNemaDovoljnoPitanja() {
            super("Nema dovoljno pitanja u bazi!");
        }
    }

    public ArrayList<RezultatiTesta> getRezultati(Profesor trenutniKorisnik) throws SQLException {
        ArrayList<RezultatiTesta> rt = new ArrayList();
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("select rezultati_testa.* from rezultati_testa,nastavnik,predmet where nastavnik.username=predmet.username_nastavnika and nastavnik.username='" + trenutniKorisnik.getUsername() + "' and predmet.id_predmeta=rezultati_testa.predmet");
            while (resultSet.next()) {
                rt.add(new RezultatiTesta(resultSet.getString("student"), resultSet.getInt("predmet"), resultSet.getInt("tromesecje"), resultSet.getInt("razred"), resultSet.getInt("redni_broj_testa"), resultSet.getBoolean("odgovor1"), resultSet.getBoolean("odgovor2"), resultSet.getBoolean("odgovor3"), resultSet.getBoolean("odgovor4"), resultSet.getBoolean("odgovor5"), resultSet.getInt("broj_bodova")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            statement.close();
        }
        return rt;
    }

    //Treba da se poveze sa PanelSviProfesori
    public ArrayList<Profesor> getProfesore(Profesor p) throws SQLException {
        ArrayList<Profesor> sp = new ArrayList();
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("Select Users.username,Users.ime,Users.prezime,Users.godina_rodjenja,Users.pol,Nastavnik.fakultet from Users,Nastavnik where Users.username=Nastavnik.username");
            while (resultSet.next()) {
                sp.add(new Profesor(resultSet.getString("username"), resultSet.getString("ime"), resultSet.getString("prezime"), resultSet.getString("godina_rodjenja"), resultSet.getString("pol"), resultSet.getString("faku1tet")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            statement.close();
        }
        return sp;
    }
}
