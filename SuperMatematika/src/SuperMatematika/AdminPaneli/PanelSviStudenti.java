/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika.AdminPaneli;

import SuperMatematika.UcenikPaneli.PanelOcene;
import SuperMatematika.AdminPaneli.FrameDodajStudenta;
import SuperMatematika.ZajednickeKlase.DBController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melida
 */
public class PanelSviStudenti extends javax.swing.JPanel {

    public PanelSviStudenti() {
        initComponents();
        popuniTabelu();
    }
   public void popuniTabelu()
   {
       String upit = "Select Users.username,Users.ime,Users.prezime,Users.godina_rodjenja,Users.pol,Student.Razred,Student.Odeljenje from Users,Student where Users.username=Student.username";
       try {
           ResultSet rezultat = DBController.require().submitQuery(upit);
           while (rezultat.next()) {
               Object[] row = {rezultat.getString("Username"), rezultat.getString("Ime"), rezultat.getString("Prezime"), rezultat.getString("Godina_rodjenja"), rezultat.getString("Pol"), rezultat.getString("Razred"), rezultat.getString("Odeljenje")};
               ((DefaultTableModel) jTable1.getModel()).insertRow(0, row);
           }
       } catch (SQLException ex) {
           System.out.println(ex);
           Logger.getLogger(PanelOcene.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzbrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Username", "Ime", "Prezime", "Godina rodjenja", "Pol", "Razred", "Odeljenje"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        btnDodaj.setBackground(new java.awt.Color(124, 187, 0));
        btnDodaj.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(255, 255, 255));
        btnDodaj.setText("Dodaj");
        btnDodaj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnDodaj.setFocusPainted(false);
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzbrisi.setBackground(new java.awt.Color(124, 187, 0));
        btnIzbrisi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIzbrisi.setForeground(new java.awt.Color(255, 255, 255));
        btnIzbrisi.setText("Izbrisi");
        btnIzbrisi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnIzbrisi.setFocusPainted(false);
        btnIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setBackground(new java.awt.Color(124, 187, 0));
        btnIzmeni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIzmeni.setForeground(new java.awt.Color(255, 255, 255));
        btnIzmeni.setText("Izmeni");
        btnIzmeni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnIzmeni.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnIzbrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbrisiActionPerformed
        int niz[]=new int[this.jTable1.getSelectedRowCount()];
        niz=this.jTable1.getSelectedRows();
        for(int i=0;i<niz.length;i++){
            try {
                System.out.println("Brise se " + this.jTable1.getModel().getValueAt(niz[i], 0));
                DBController.require().izbrisiUcenika(this.jTable1.getModel().getValueAt(niz[i], 0));
                ((DefaultTableModel)this.jTable1.getModel()).removeRow(niz[i]);
            } catch (SQLException ex) {
                Logger.getLogger(PanelSviProfesori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnIzbrisiActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        FrameDodajStudenta fds= new FrameDodajStudenta();
        fds.setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzbrisi;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
