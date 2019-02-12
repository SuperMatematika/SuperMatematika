/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1
 */
public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    Admin trenutniKorisnik;
    public AdminFrame() {
        initComponents();
    }
     AdminFrame(Admin admin) {
        trenutniKorisnik=admin;
        initComponents();
        AdminMainChoiceView newPnl = new AdminMainChoiceView();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }
       public void hoverButton(JButton b) {
        b.setBackground(Color.decode("#00A1F1"));
        
    }

    public void hoverButtonExit(JButton b) {
        b.setBackground(Color.decode("#0073AD"));
       
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ProfesorViewLeft = new javax.swing.JPanel();
        btnProfesori = new javax.swing.JButton();
        btnUcenici = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnRezultatiTesta1 = new javax.swing.JButton();
        btnPocetna = new javax.swing.JButton();
        btnProfil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pnlMainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 710));

        jPanel2.setBackground(new java.awt.Color(0, 161, 241));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        ProfesorViewLeft.setBackground(new java.awt.Color(0, 115, 173));
        ProfesorViewLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        ProfesorViewLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfesori.setBackground(new java.awt.Color(0, 115, 173));
        btnProfesori.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnProfesori.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/professor.png"))); // NOI18N
        btnProfesori.setText("Profesori");
        btnProfesori.setAlignmentY(0.0F);
        btnProfesori.setBorder(null);
        btnProfesori.setFocusPainted(false);
        btnProfesori.setIconTextGap(16);
        btnProfesori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfesoriMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnProfesori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesoriActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnProfesori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 240, 50));

        btnUcenici.setBackground(new java.awt.Color(0, 115, 173));
        btnUcenici.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnUcenici.setForeground(new java.awt.Color(255, 255, 255));
        btnUcenici.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/student.png"))); // NOI18N
        btnUcenici.setText("Ucenici");
        btnUcenici.setAlignmentY(0.0F);
        btnUcenici.setBorder(null);
        btnUcenici.setFocusPainted(false);
        btnUcenici.setIconTextGap(17);
        btnUcenici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUceniciMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnUcenici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUceniciActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnUcenici, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 240, 50));

        btnLogOut.setBackground(new java.awt.Color(0, 115, 173));
        btnLogOut.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/logout.png"))); // NOI18N
        btnLogOut.setActionCommand("Odjava");
        btnLogOut.setBorder(null);
        btnLogOut.setFocusPainted(false);
        btnLogOut.setPreferredSize(new java.awt.Dimension(280, 50));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, 60, -1));

        btnRezultatiTesta1.setBackground(new java.awt.Color(0, 115, 173));
        btnRezultatiTesta1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnRezultatiTesta1.setForeground(new java.awt.Color(255, 255, 255));
        btnRezultatiTesta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/Test.png"))); // NOI18N
        btnRezultatiTesta1.setText("Rezultati ");
        btnRezultatiTesta1.setAlignmentY(0.0F);
        btnRezultatiTesta1.setBorder(null);
        btnRezultatiTesta1.setFocusPainted(false);
        btnRezultatiTesta1.setIconTextGap(17);
        btnRezultatiTesta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRezultatiTesta1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnRezultatiTesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezultatiTesta1ActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnRezultatiTesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 240, 50));

        btnPocetna.setBackground(new java.awt.Color(0, 115, 173));
        btnPocetna.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPocetna.setForeground(new java.awt.Color(255, 255, 255));
        btnPocetna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/home-outline.png"))); // NOI18N
        btnPocetna.setText("Pocetna");
        btnPocetna.setBorder(null);
        btnPocetna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnPocetna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocetnaActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnPocetna, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 240, 50));

        btnProfil.setBackground(new java.awt.Color(124, 187, 0));
        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/ProfilIcon.png"))); // NOI18N
        btnProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ProfesorViewLeft.add(btnProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 17, 120, 80));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRATOR");
        ProfesorViewLeft.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/PodesavanjaIcon.png"))); // NOI18N
        ProfesorViewLeft.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 60, 50));
        ProfesorViewLeft.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 280, 10));
        ProfesorViewLeft.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 280, 20));

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ProfesorViewLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProfesorViewLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUceniciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUceniciMouseClicked
        // TODO add your handling code here:
        this.btnUcenici.setBackground(Color.decode("#00A1F1"));
        
    }//GEN-LAST:event_btnUceniciMouseClicked

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        try {
            MainFrame m = new MainFrame();
            m.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnRezultatiTesta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRezultatiTesta1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRezultatiTesta1MouseClicked

    private void btnRezultatiTesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezultatiTesta1ActionPerformed
        // TODO add your handling code here:
        AdminRezultatiTesta newPnl = new AdminRezultatiTesta();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnRezultatiTesta1ActionPerformed

    private void btnProfesoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesoriMouseClicked
        // TODO add your handling code here:
        PanelSviProfesori newPnl = new PanelSviProfesori();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnProfesoriMouseClicked

    private void btnProfesoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesoriActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnProfesoriActionPerformed

    private void btnUceniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUceniciActionPerformed
        // TODO add your handling code here:
        PanelSviStudenti newPnl = new PanelSviStudenti();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnUceniciActionPerformed

    private void btnPocetnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocetnaActionPerformed
        // TODO add your handling code here:
       AdminMainChoiceView newPnl = new AdminMainChoiceView();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnPocetnaActionPerformed

    private void HoverHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverHandler
        // TODO add your handling code here:
         hoverButton((JButton) evt.getSource());
    }//GEN-LAST:event_HoverHandler

    private void HoverLeave(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverLeave
        // TODO add your handling code here:
        hoverButtonExit((JButton) evt.getSource());
    }//GEN-LAST:event_HoverLeave

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProfesorViewLeft;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPocetna;
    private javax.swing.JButton btnProfesori;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnRezultatiTesta1;
    private javax.swing.JButton btnUcenici;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlMainContent;
    // End of variables declaration//GEN-END:variables
}
