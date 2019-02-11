/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        btnRezultatiTesta1 = new javax.swing.JButton();
        btnProfesori = new javax.swing.JButton();
        btnUcenici = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        pnlMainContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 710));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 161, 241));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 880, 60));

        ProfesorViewLeft.setBackground(new java.awt.Color(0, 115, 173));
        ProfesorViewLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        ProfesorViewLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRezultatiTesta1.setBackground(new java.awt.Color(0, 115, 173));
        btnRezultatiTesta1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnRezultatiTesta1.setForeground(new java.awt.Color(255, 255, 255));
        btnRezultatiTesta1.setText("Rezultati testa");
        btnRezultatiTesta1.setAlignmentY(0.0F);
        btnRezultatiTesta1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnRezultatiTesta1.setFocusPainted(false);
        btnRezultatiTesta1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRezultatiTesta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRezultatiTesta1MouseClicked(evt);
            }
        });
        btnRezultatiTesta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezultatiTesta1ActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnRezultatiTesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 230, 50));

        btnProfesori.setBackground(new java.awt.Color(0, 115, 173));
        btnProfesori.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnProfesori.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesori.setText("Profesori");
        btnProfesori.setAlignmentY(0.0F);
        btnProfesori.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnProfesori.setFocusPainted(false);
        btnProfesori.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfesori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfesoriMouseClicked(evt);
            }
        });
        btnProfesori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesoriActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnProfesori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 230, 50));

        btnUcenici.setBackground(new java.awt.Color(0, 115, 173));
        btnUcenici.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnUcenici.setForeground(new java.awt.Color(255, 255, 255));
        btnUcenici.setText("Ucenici");
        btnUcenici.setAlignmentY(0.0F);
        btnUcenici.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnUcenici.setFocusPainted(false);
        btnUcenici.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUcenici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUceniciMouseClicked(evt);
            }
        });
        btnUcenici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUceniciActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnUcenici, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 230, 50));

        btnLogOut.setBackground(new java.awt.Color(0, 115, 173));
        btnLogOut.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/logout.png"))); // NOI18N
        btnLogOut.setActionCommand("Odjava");
        btnLogOut.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnLogOut.setFocusPainted(false);
        btnLogOut.setPreferredSize(new java.awt.Dimension(280, 50));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        ProfesorViewLeft.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, 80, -1));

        jPanel1.add(ProfesorViewLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 710));

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        jPanel1.add(pnlMainContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 880, 650));

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
        AdminRezultatiTesta newPnl = new AdminRezultatiTesta();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnRezultatiTesta1MouseClicked

    private void btnRezultatiTesta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezultatiTesta1ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JButton btnProfesori;
    private javax.swing.JButton btnRezultatiTesta1;
    private javax.swing.JButton btnUcenici;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlMainContent;
    // End of variables declaration//GEN-END:variables
}
