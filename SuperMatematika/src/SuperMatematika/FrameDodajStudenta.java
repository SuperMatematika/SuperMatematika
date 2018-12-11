/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Melida
 */
public class FrameDodajStudenta extends javax.swing.JFrame {

    /**
     * Creates new form FrameDodajStudenta
     */
    public FrameDodajStudenta() {
        initComponents();
    }
    public void DodajStudenta() throws SQLException
            
    {
        int r=Integer.parseInt(this.txtRazred.getText());
        int o=Integer.parseInt(this.txtOdeljenje.getText());
        String username=txtUsername.getText();
        
       try{
           if(!txtUsername.getText().equals("") && !txtPassword.getText().equals("") && !txtUsertype.getText().equals("") && !txtIme.getText().equals("") && !txtPrezime.getText().equals("") && !txtDatumRodj.getText().equals("") && !txtPol.getText().equals("") && !txtRazred.getText().equals("") && !txtOdeljenje.getText().equals(""))
         { 
             DBController.require().DodajKorisnika(this.txtUsername.getText(),this.txtPassword.getText(),this.txtUsertype.getText(), this.txtIme.getText(), this.txtPrezime.getText(), this.txtDatumRodj.getText(), this.txtPol.getText());
              DBController.require().DodajStudenta(this.txtUsername.getText(), r, o);
         }
         else
         {
        JOptionPane.showMessageDialog(null, "Niste popunili sva polja");
             }
    }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"Greska");
       }
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtUsertype = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtDatumRodj = new javax.swing.JTextField();
        txtPol = new javax.swing.JTextField();
        txtRazred = new javax.swing.JTextField();
        txtOdeljenje = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(10, 0, 5, 8));

        txtUsername.setForeground(new java.awt.Color(153, 153, 153));
        txtUsername.setText("username");
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername);

        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("lozinka");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(txtPassword);

        txtUsertype.setForeground(new java.awt.Color(153, 153, 153));
        txtUsertype.setText("student");
        txtUsertype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsertypeMouseClicked(evt);
            }
        });
        jPanel1.add(txtUsertype);

        txtIme.setForeground(new java.awt.Color(153, 153, 153));
        txtIme.setText("ime");
        txtIme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtImeMouseClicked(evt);
            }
        });
        jPanel1.add(txtIme);

        txtPrezime.setForeground(new java.awt.Color(153, 153, 153));
        txtPrezime.setText("prezime");
        txtPrezime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrezimeMouseClicked(evt);
            }
        });
        jPanel1.add(txtPrezime);

        txtDatumRodj.setForeground(new java.awt.Color(153, 153, 153));
        txtDatumRodj.setText("datum rodjenja");
        txtDatumRodj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDatumRodjMouseClicked(evt);
            }
        });
        jPanel1.add(txtDatumRodj);

        txtPol.setForeground(new java.awt.Color(153, 153, 153));
        txtPol.setText("pol");
        txtPol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPolMouseClicked(evt);
            }
        });
        jPanel1.add(txtPol);

        txtRazred.setForeground(new java.awt.Color(153, 153, 153));
        txtRazred.setText("razred");
        txtRazred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRazredMouseClicked(evt);
            }
        });
        jPanel1.add(txtRazred);

        txtOdeljenje.setForeground(new java.awt.Color(153, 153, 153));
        txtOdeljenje.setText("odeljenje");
        txtOdeljenje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtOdeljenjeMouseClicked(evt);
            }
        });
        jPanel1.add(txtOdeljenje);

        btnSacuvaj.setBackground(new java.awt.Color(204, 255, 153));
        btnSacuvaj.setForeground(new java.awt.Color(255, 255, 255));
        btnSacuvaj.setText("SACUVAJ");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            DodajStudenta();
            
        } catch (SQLException ex) {
            Logger.getLogger(FrameDodajStudenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        // TODO add your handling code here:
        this.txtUsername.setText("");
        this.txtUsername.setForeground(Color.black);
    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        // TODO add your handling code here:
        this.txtPassword.setText("");
        this.txtPassword.setForeground(Color.black);
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtUsertypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsertypeMouseClicked
        // TODO add your handling code here:
        this.txtUsertype.setText("");
        this.txtUsertype.setForeground(Color.black);
    }//GEN-LAST:event_txtUsertypeMouseClicked

    private void txtImeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtImeMouseClicked
        // TODO add your handling code here:
        this.txtIme.setText("");
        this.txtIme.setForeground(Color.black);
    }//GEN-LAST:event_txtImeMouseClicked

    private void txtPrezimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrezimeMouseClicked
        // TODO add your handling code here:
        this.txtPrezime.setText("");
        this.txtPrezime.setForeground(Color.black);
    }//GEN-LAST:event_txtPrezimeMouseClicked

    private void txtDatumRodjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDatumRodjMouseClicked
        // TODO add your handling code here:
        this.txtDatumRodj.setText("");
        this.txtDatumRodj.setForeground(Color.black);
    }//GEN-LAST:event_txtDatumRodjMouseClicked

    private void txtPolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPolMouseClicked
        // TODO add your handling code here:
        this.txtPol.setText("");
        this.txtPol.setForeground(Color.black);
    }//GEN-LAST:event_txtPolMouseClicked

    private void txtRazredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRazredMouseClicked
        // TODO add your handling code here:
        this.txtRazred.setText("");
        this.txtPol.setForeground(Color.black);
    }//GEN-LAST:event_txtRazredMouseClicked

    private void txtOdeljenjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOdeljenjeMouseClicked
        // TODO add your handling code here:
        this.txtOdeljenje.setText("");
        this.txtOdeljenje.setForeground(Color.black);
    }//GEN-LAST:event_txtOdeljenjeMouseClicked

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
            java.util.logging.Logger.getLogger(FrameDodajStudenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDodajStudenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDodajStudenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDodajStudenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDodajStudenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDatumRodj;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOdeljenje;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPol;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtRazred;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsertype;
    // End of variables declaration//GEN-END:variables
}
