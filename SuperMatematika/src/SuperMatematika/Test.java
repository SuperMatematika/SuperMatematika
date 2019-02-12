/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samed
 */
public class Test {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public Test(Connection cnc, Statement st, ResultSet rs) {
        connection = cnc;
        statement = st;
        resultSet = rs;
    }

    // Nemam pojma kako se pravilno pise ovde komentar, pa improvizujem
    // Funkcija nazlazi odredjeni broj zadataka u bazi za dati razred i datu oblast
    // Vraca listu zadataka odgovarajuce duzine
    public List<Zadatak> SastaviTest(String oblast, String razred, int brojZadataka) {
        ArrayList<Zadatak> zadaci = new ArrayList();

        try {

            // Step 2.B: Creating JDBC Statement 
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from PraviTest "
                    + "WHERE Razred = '" + razred + "' AND Oblast = '" + oblast + "'"
                    + "ORDER BY RAND() LIMIT " + brojZadataka + ";");

            // Step 2.C: Executing SQL & retrieve data into ResultSet
            try {
                while (resultSet.next()) {
                    Zadatak temp = new Zadatak(resultSet.getString("Putanja"),
                            resultSet.getString("TacanOdgovor"),
                            resultSet.getString("PogresanOdgovor1"),
                            resultSet.getString("PogresanOdgovor2"),
                            resultSet.getString("PogresanOdgovor3"));
                    zadaci.add(temp);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            // processing returned data and printing into console

        } catch (Exception E) {
            System.out.println(E);
        } finally {

            // Step 3: Closing database connection
            try {
                if (null != connection) {

                    // cleanup resources, once after 
                    statement.close();

                    //connection.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }

        return zadaci;
    }

    // Isto kao i funkcija iznad samo uzima 5 zadataka
    public List<Zadatak> SastaviTest(String oblast, String razred) {
        return SastaviTest(oblast, razred, 5);
    }

}
