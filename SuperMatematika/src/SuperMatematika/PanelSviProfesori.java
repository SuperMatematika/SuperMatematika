/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melida
 */
public class PanelSviProfesori extends javax.swing.JPanel {

    /**
     * Creates new form PanelSviProfesori
     */
    
    public PanelSviProfesori() {
        initComponents();
        popuniTabelu();
    }
   public void popuniTabelu()
   {
       
       String upit="Select Users.username,Users.ime,Users.prezime,Users.godina_rodjenja,Users.pol,Nastavnik.fakultet from Users,Nastavnik where Users.username=Nastavnik.username";
         try {
            ResultSet rezultat = DBController.require().submitQuery(upit);
            while(rezultat.next()) {
                Object[] row = { rezultat.getString("Username"), rezultat.getString("Ime"), rezultat.getString("Prezime"),rezultat.getString("Godina_rodjenja"),rezultat.getString("Pol"),rezultat.getString("fakultet")}
                        ;
                ((DefaultTableModel) jTable1.getModel()).insertRow(0, row);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(OcenePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void izbrisiIzTabele() throws SQLException
   {
       
           
      
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnIzbrisi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnPrikazi = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        pnlMainContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Ime", "Prezime", "Godina rodjenja", "Pol", "Fakultet"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        pnlMainContent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 460));

        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzbrisiClick(evt);
            }
        });
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });
        pnlMainContent.add(btnIzbrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 140, 30));

        btnDodaj.setText("Dodaj ");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });
        pnlMainContent.add(btnDodaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 140, 30));

        btnPrikazi.setText("Prikazi");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });
        pnlMainContent.add(btnPrikazi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 140, 30));

        jButton3.setText("Izmeni");
        pnlMainContent.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
      
       
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnIzbrisiClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzbrisiClick
        try {
            // TODO add your handling code here:
            izbrisiIzTabele();
        } catch (SQLException ex) {
            Logger.getLogger(PanelSviProfesori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzbrisiClick

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        // TODO add your handling code here:
        PanelSviProfesori newPnl = new PanelSviProfesori();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnPrikaziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        // TODO add your handling code here:
         PanelDodajProfesora newPnl = new PanelDodajProfesora();
        this.pnlMainContent.removeAll();
        this.pnlMainContent.revalidate();
        this.pnlMainContent.setLayout(new BorderLayout());
        this.pnlMainContent.add(newPnl);
    }//GEN-LAST:event_btnDodajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlMainContent;
    // End of variables declaration//GEN-END:variables

    private Object DBController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
