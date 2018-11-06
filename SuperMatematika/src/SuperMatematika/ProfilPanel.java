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
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Melida
 * @author Samed
 */
public class ProfilPanel extends javax.swing.JPanel {
    
    Student trenutniKorisnik;
    
    // Ovaj panel ce se koristiti za prikazivanje profila ucenika i profesora, zbog toga je atribut "trenutniKorsnik" tipa
    // korsinik jer obe ove klase nasledjuju tu klasu
    public ProfilPanel(Student tk) {
        trenutniKorisnik=tk;
        initComponents();
        UcenikPodaciPanel newPnl = new UcenikPodaciPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        
    }
    
  
     public void hoverButton(JButton b) {
        b.setBackground(Color.decode("#666666"));
        b.setForeground(Color.decode("#E0E0E0"));
    }
     public void hoverButtonExit(JButton b)
     {
         b.setBackground(Color.decode("#E0E0E0"));
        b.setForeground(Color.decode("#666666"));
     }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlavni = new javax.swing.JPanel();
        pnlUserInfo = new javax.swing.JPanel();
        btnUcenikPodaci = new javax.swing.JButton();
        btnMojiPredmeti = new javax.swing.JButton();
        btnNalog = new javax.swing.JButton();
        pnlMainContent = new javax.swing.JPanel();

        pnlGlavni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUserInfo.setBackground(new java.awt.Color(224, 224, 224));
        pnlUserInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlUserInfo.setLayout(new java.awt.GridLayout(14, 0));

        btnUcenikPodaci.setBackground(new java.awt.Color(224, 224, 224));
        btnUcenikPodaci.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnUcenikPodaci.setForeground(new java.awt.Color(102, 102, 102));
        btnUcenikPodaci.setText("PODACI O UCENIKU");
        btnUcenikPodaci.setBorder(null);
        btnUcenikPodaci.setFocusPainted(false);
        btnUcenikPodaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClicked(evt);
            }
        });
        btnUcenikPodaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUcenikPodaciActionPerformed(evt);
            }
        });
        pnlUserInfo.add(btnUcenikPodaci);

        btnMojiPredmeti.setBackground(new java.awt.Color(224, 224, 224));
        btnMojiPredmeti.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnMojiPredmeti.setForeground(new java.awt.Color(102, 102, 102));
        btnMojiPredmeti.setText("MOJI PREDMETI");
        btnMojiPredmeti.setBorder(null);
        btnMojiPredmeti.setFocusPainted(false);
        btnMojiPredmeti.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMojiPredmeti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClicked(evt);
            }
        });
        btnMojiPredmeti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMojiPredmetiActionPerformed(evt);
            }
        });
        pnlUserInfo.add(btnMojiPredmeti);

        btnNalog.setBackground(new java.awt.Color(224, 224, 224));
        btnNalog.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnNalog.setForeground(new java.awt.Color(102, 102, 102));
        btnNalog.setText("NALOG");
        btnNalog.setBorder(null);
        btnNalog.setFocusPainted(false);
        btnNalog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNalogActionPerformed(evt);
            }
        });
        pnlUserInfo.add(btnNalog);

        pnlGlavni.add(pnlUserInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 650));

        pnlMainContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlGlavni.add(pnlMainContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 620, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlavni, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlavni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUcenikPodaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUcenikPodaciActionPerformed
        // TODO add your handling code here:
        UcenikPodaciPanel newPnl = new UcenikPodaciPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
        this.btnUcenikPodaci.setBackground(Color.decode("666666"));
        this.btnUcenikPodaci.setForeground(Color.decode("#E0E0E0"));
        this.btnMojiPredmeti.setBackground(Color.decode("#E0E0E0"));
        this.btnMojiPredmeti.setForeground(Color.decode("666666"));
        
        this.btnNalog.setBackground(Color.decode("#E0E0E0"));
        this.btnNalog.setForeground(Color.decode("666666"));
        
    }//GEN-LAST:event_btnUcenikPodaciActionPerformed

    private void btnClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btnClicked

    private void btnMojiPredmetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMojiPredmetiActionPerformed
        // TODO add your handling code here:
        UcenikPredmetiPanel newPn1= new UcenikPredmetiPanel(trenutniKorisnik);
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPn1);
        this.btnMojiPredmeti.setBackground(Color.decode("666666"));
        this.btnMojiPredmeti.setForeground(Color.decode("#E0E0E0"));
         this.btnNalog.setBackground(Color.decode("#E0E0E0"));
        this.btnNalog.setForeground(Color.decode("666666"));
        this.btnUcenikPodaci.setBackground(Color.decode("#E0E0E0"));
        this.btnUcenikPodaci.setForeground(Color.decode("666666"));
       
    }//GEN-LAST:event_btnMojiPredmetiActionPerformed

    private void btnNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNalogActionPerformed
        // TODO add your handling code here:
          this.btnMojiPredmeti.setForeground(Color.decode("666666"));
        this.btnMojiPredmeti.setBackground(Color.decode("#E0E0E0"));
         this.btnNalog.setForeground(Color.decode("#E0E0E0"));
        this.btnNalog.setBackground(Color.decode("666666"));
        this.btnUcenikPodaci.setBackground(Color.decode("#E0E0E0"));
        this.btnUcenikPodaci.setForeground(Color.decode("666666"));
    }//GEN-LAST:event_btnNalogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMojiPredmeti;
    private javax.swing.JButton btnNalog;
    private javax.swing.JButton btnUcenikPodaci;
    private javax.swing.JPanel pnlGlavni;
    private javax.swing.JPanel pnlMainContent;
    private javax.swing.JPanel pnlUserInfo;
    // End of variables declaration//GEN-END:variables
}
