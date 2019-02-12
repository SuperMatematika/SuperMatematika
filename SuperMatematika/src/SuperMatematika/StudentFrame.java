/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Melida
 */
public class StudentFrame extends javax.swing.JFrame {
    Student trenutniKorisnik;

    public StudentFrame(Korisnik k) throws SQLException {
        initComponents();
        
        this.trenutniKorisnik=new Student(k);
        System.out.println(trenutniKorisnik);
        trenutniKorisnik.setRazred(DBController.require().getRazred(trenutniKorisnik));
        trenutniKorisnik.setOdeljenje(DBController.require().getOdeljenje(trenutniKorisnik));
        
        
        System.out.println(trenutniKorisnik.getIme());
        this.imePrezime.setText(trenutniKorisnik.getIme()+" "+trenutniKorisnik.getPrezime());
        
        mainChoiceView newPnl = new mainChoiceView(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        
        setNav();
        
        
        System.out.println(trenutniKorisnik.getRazred() + " - " + trenutniKorisnik.getOdeljenje());
    }


//    

    public void setNav() {
        //create the root node
        DefaultMutableTreeNode category = new DefaultMutableTreeNode("Navigacija");
        DefaultMutableTreeNode category1 = new DefaultMutableTreeNode("V Razred");
        //create the child nodes
        DefaultMutableTreeNode category1_1 = new DefaultMutableTreeNode("Skupovi");
        DefaultMutableTreeNode category1_2 = new DefaultMutableTreeNode("Deljivost brojeva");
        //add the child nodes to the root node
        category1.add(category1_1);
        category1.add(category1_2);
        category.add(category1);
        DefaultTreeModel defaultTreeModel = new DefaultTreeModel(category);
        

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

        pnlBackground = new javax.swing.JPanel();
        pnlMainContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnProfil = new javax.swing.JButton();
        btnOdjava = new javax.swing.JButton();
        imePrezime = new javax.swing.JLabel();
        btnPodesavanja = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnTest = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnTest3 = new javax.swing.JButton();
        btnPredmeti = new javax.swing.JButton();
        btnOcene = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pnlMainContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 115, 173));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnProfil.setBackground(new java.awt.Color(124, 187, 0));
        btnProfil.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/ProfilIcon.png"))); // NOI18N
        btnProfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnProfil.setFocusPainted(false);
        btnProfil.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });

        btnOdjava.setBackground(new java.awt.Color(0, 115, 173));
        btnOdjava.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnOdjava.setForeground(new java.awt.Color(255, 255, 255));
        btnOdjava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/logout.png"))); // NOI18N
        btnOdjava.setBorder(null);
        btnOdjava.setFocusPainted(false);
        btnOdjava.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOdjava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdjavaActionPerformed(evt);
            }
        });

        imePrezime.setBackground(new java.awt.Color(255, 255, 255));
        imePrezime.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        imePrezime.setForeground(new java.awt.Color(255, 255, 255));
        imePrezime.setText("Ime Prezime");

        btnPodesavanja.setBackground(new java.awt.Color(0, 115, 173));
        btnPodesavanja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/PodesavanjaIcon.png"))); // NOI18N
        btnPodesavanja.setBorder(null);
        btnPodesavanja.setFocusPainted(false);
        btnPodesavanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnPodesavanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPodesavanjaActionPerformed(evt);
            }
        });

        btnTest.setBackground(new java.awt.Color(0, 115, 173));
        btnTest.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnTest.setForeground(new java.awt.Color(255, 255, 255));
        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/Test.png"))); // NOI18N
        btnTest.setText("Krajnji test");
        btnTest.setBorder(null);
        btnTest.setFocusPainted(false);
        btnTest.setIconTextGap(17);
        btnTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnTest3.setBackground(new java.awt.Color(0, 115, 173));
        btnTest3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnTest3.setForeground(new java.awt.Color(255, 255, 255));
        btnTest3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/Test.png"))); // NOI18N
        btnTest3.setText("Probni test");
        btnTest3.setBorder(null);
        btnTest3.setFocusPainted(false);
        btnTest3.setIconTextGap(13);
        btnTest3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnTest3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTest3ActionPerformed(evt);
            }
        });

        btnPredmeti.setBackground(new java.awt.Color(0, 115, 173));
        btnPredmeti.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnPredmeti.setForeground(new java.awt.Color(255, 255, 255));
        btnPredmeti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/book-multiple.png"))); // NOI18N
        btnPredmeti.setText("Predmeti");
        btnPredmeti.setBorder(null);
        btnPredmeti.setFocusPainted(false);
        btnPredmeti.setIconTextGap(17);
        btnPredmeti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnPredmeti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredmetiActionPerformed(evt);
            }
        });

        btnOcene.setBackground(new java.awt.Color(0, 115, 173));
        btnOcene.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnOcene.setForeground(new java.awt.Color(255, 255, 255));
        btnOcene.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/OceneIcon.png"))); // NOI18N
        btnOcene.setText("Ocene");
        btnOcene.setBorder(null);
        btnOcene.setFocusPainted(false);
        btnOcene.setIconTextGap(19);
        btnOcene.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnOcene.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        btnOcene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOceneActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 115, 173));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SlikeDizajn/home-outline.png"))); // NOI18N
        jButton1.setText("Pocetna ");
        jButton1.setBorder(null);
        jButton1.setFocusPainted(false);
        jButton1.setIconTextGap(17);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoverHandler(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HoverLeave(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPredmeti, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnOcene, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnTest3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnPodesavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btnOdjava, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(imePrezime))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imePrezime)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGap(22, 22, 22)
                .addComponent(btnPredmeti)
                .addGap(22, 22, 22)
                .addComponent(btnOcene, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnTest3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPodesavanja)
                            .addComponent(btnOdjava)))))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        UcenikPodaciPanel newPnl = new UcenikPodaciPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        
    }//GEN-LAST:event_btnProfilActionPerformed

    private void HoverHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverHandler
        hoverButton((JButton) evt.getSource());
    }//GEN-LAST:event_HoverHandler

    private void HoverLeave(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoverLeave
        // TODO add your handling code here:
        hoverButtonExit((JButton) evt.getSource());
    }//GEN-LAST:event_HoverLeave

    private void btnOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdjavaActionPerformed
        try {
            MainFrame m = new MainFrame();
            m.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnOdjavaActionPerformed

    private void btnOceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOceneActionPerformed
       
        // TODO add your handling code here:
        OcenePanel newPnl = new OcenePanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
   
    }//GEN-LAST:event_btnOceneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         mainChoiceView main;
        try {
            main = new mainChoiceView(trenutniKorisnik);
            this.pnlMainContent.removeAll();
            this.pnlMainContent.revalidate();
            this.pnlMainContent.setLayout(new BorderLayout());
            this.pnlMainContent.add(main);
            
            
        } catch (Exception ex) {

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPredmetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredmetiActionPerformed
        // TODO add your handling code here:
        UcenikPredmetiPanel newPnl= new UcenikPredmetiPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        
    }//GEN-LAST:event_btnPredmetiActionPerformed

    private void btnPodesavanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPodesavanjaActionPerformed
        // TODO add your handling code here:
        UcenikNalogPanel newPnl= new UcenikNalogPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        
    }//GEN-LAST:event_btnPodesavanjaActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        // TODO add your handling code here:
        pnlOdabirTesta newPnl=new pnlOdabirTesta(trenutniKorisnik);
         this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
      
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnTest3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTest3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTest3ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new StudentFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOcene;
    private javax.swing.JButton btnOdjava;
    private javax.swing.JButton btnPodesavanja;
    private javax.swing.JButton btnPredmeti;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnTest3;
    private javax.swing.JLabel imePrezime;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlMainContent;
    // End of variables declaration//GEN-END:variables
}
