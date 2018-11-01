/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.Color;
import java.awt.LayoutManager;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author 1
 */
public class MainFrame extends javax.swing.JFrame {

    
        String currPath=new File("").getAbsolutePath();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
    public MainFrame() throws SQLException {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String msAccDB = currPath+"/Supermatematika.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 

            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL); 

        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPozadina = new javax.swing.JPanel();
        pnlLogin = new javax.swing.JPanel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblWrongUser = new javax.swing.JLabel();
        pnlPrijaviteSe = new javax.swing.JPanel();
        lblPrijaviteSe = new javax.swing.JLabel();
        lblDangerIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(780, 520));

        pnlPozadina.setBackground(new java.awt.Color(51, 51, 51));
        pnlPozadina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(204, 204, 204));
        txtUser.setText("Username");
        txtUser.setToolTipText("");
        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, null, null, java.awt.Color.lightGray));
        txtUser.setPreferredSize(new java.awt.Dimension(64, 23));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        pnlLogin.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 183, 240, 30));

        btnLogin.setBackground(new java.awt.Color(185, 20, 60));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOG IN");
        btnLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, null, null, java.awt.Color.black));
        btnLogin.setFocusPainted(false);
        btnLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
        });
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HoverOnReleased(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 80, 30));

        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setText("password");
        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, null, null, java.awt.Color.lightGray));
        txtPass.setPreferredSize(new java.awt.Dimension(64, 20));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });
        pnlLogin.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 240, 30));

        lblWrongUser.setForeground(new java.awt.Color(255, 0, 0));
        pnlLogin.add(lblWrongUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 180, 20));

        pnlPrijaviteSe.setBackground(new java.awt.Color(185, 20, 60));
        pnlPrijaviteSe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlPrijaviteSe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrijaviteSe.setBackground(new java.awt.Color(255, 255, 255));
        lblPrijaviteSe.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lblPrijaviteSe.setForeground(new java.awt.Color(255, 255, 255));
        lblPrijaviteSe.setText("PRIJAVITE SE");
        pnlPrijaviteSe.add(lblPrijaviteSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        pnlLogin.add(pnlPrijaviteSe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 90));
        pnlLogin.add(lblDangerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 40, 20));

        pnlPozadina.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 330, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPozadina, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPozadina, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        txtUser.setText("");
        txtUser.setForeground(Color.black);
        
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        handleLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
           txtUser.setText("");
        txtUser.setForeground(Color.black);
    }//GEN-LAST:event_txtUserFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
          txtPass.setText("");
        txtPass.setForeground(Color.black);
    }//GEN-LAST:event_txtPassFocusGained

    private void HoverOnReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverOnReleased
        this.btnLogin.setBackground(Color.decode("#B9143C"));
        this.btnLogin.setForeground(Color.white);
    }//GEN-LAST:event_HoverOnReleased

    private void HoverHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverHandler
        this.btnLogin.setBackground(Color.white);
        this.btnLogin.setForeground(Color.decode("#B9143C"));
    }//GEN-LAST:event_HoverHandler

    private void HoverExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverExited
       this.btnLogin.setBackground(Color.decode("#B9143C"));
       this.btnLogin.setForeground(Color.white);
    }//GEN-LAST:event_HoverExited
                      
    
   
    public void handleLogin(){
          try {

            // Step 2.B: Creating JDBC Statement 
            statement = (Statement) connection.createStatement();  
          
            resultSet = statement.executeQuery("SELECT usertype,username FROM Users where username='"+txtUser.getText()+"' and password='"+txtPass.getText()+"';");
            
            // Step 2.C: Executing SQL & retrieve data into ResultSet
             try{
                 int i=0;
                 while(resultSet.next()){
                     i++;   
                     //    this.jPanel1.setVisible(false);
                     System.out.println(resultSet.getString(1));
                     if(resultSet.getString(1).equals("admin")){
                         System.out.println("admin");
                     }else if(resultSet.getString(1).equals("student")){
                         System.out.println("student");
                         StudentFrame newMain=new StudentFrame(resultSet.getString("username"));
                         newMain.setVisible(true);
                         this.dispose();
                     }else if(resultSet.getString(1).equals("profesor")){  
                         System.out.println("Profesor");
                     }
                 }
                 if(i==0){
                     this.lblWrongUser.setText("Wrong user or pass!");
                     this.lblDangerIcon.setIcon(new ImageIcon(new File("").getAbsolutePath()+"\\src\\SlikeDizajn\\DangerIcon.png"));
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

                   // connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblDangerIcon;
    private javax.swing.JLabel lblPrijaviteSe;
    private javax.swing.JLabel lblWrongUser;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlPozadina;
    private javax.swing.JPanel pnlPrijaviteSe;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
