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
import javax.swing.ImageIcon;

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
    
//    public Boolean handleLogin(String username,String password){
//         try {
//            statement = (Statement) connection.createStatement();  
//            resultSet = statement.executeQuery("SELECT usertype,username FROM Users where username='"+username+"' and password='"+password+"';");
//             try{
//                 if(resultSet.first()){
//                     return true;
//                 }
//                 else{
//                     return false;
//                 }
//                 int i=0;
//                 while(resultSet.next()){
//                     i++;   
//                     if(resultSet.getString(1).equals("admin")){
//                         System.out.println("admin");
//                     }else if(resultSet.getString(1).equals("student")){
//                         System.out.println("student");
//                         StudentFrame newMain=new StudentFrame(connection,statement,resultSet,resultSet.getString("username"));
//                         newMain.setVisible(true);
//                         this.dispose();
//                     }else if(resultSet.getString(1).equals("profesor")){  
//                         System.out.println("Profesor");
//                         ProfesorFrame newMain=new ProfesorFrame(connection,statement,resultSet,resultSet.getString("username"));
//                          newMain.setVisible(true);
//                          this.dispose();
//                     }
//                 }
//                 if(i==0){
//                     this.lblWrongUser.setText("Wrong user or pass!");
//                     this.lblDangerIcon.setIcon(new ImageIcon(new File("").getAbsolutePath()+"\\src\\SlikeDizajn\\DangerIcon.png"));
//                 }
//             }       
//             catch(Exception e){
//                 System.out.println(e);
//             }
//            // processing returned data and printing into console
//          
//        }
//        catch(Exception E){
//            System.out.println(E);
//        }
//        finally {
//
//            // Step 3: Closing database connection
//            try {
//                if(null != connection) {
//
//                    // cleanup resources, once after 
//                    statement.close();
//
//                   // connection.close();
//                }
//            }
//            catch (SQLException sqlex) {
//                sqlex.printStackTrace();
//            }
//        }
//    }
    
    
}
