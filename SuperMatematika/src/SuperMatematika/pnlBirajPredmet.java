/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author 1
 */
public class pnlBirajPredmet extends javax.swing.JPanel {

    Student trenutniKorisnik;
    ArrayList<Predmet> listaPredmeta;
    ArrayList<JButton> listaButtona = new ArrayList();
    String prethodnik;
    /**
     * Creates new form pnlBirajPredmet
     */
    public pnlBirajPredmet(Student s,ArrayList<Predmet> predmeti,String prethodno) {
        listaPredmeta=new ArrayList<Predmet>(predmeti);
        trenutniKorisnik=s;
        prethodnik=prethodno;
        initComponents();
        
        createForm();
    }
    
    private void createForm() {
        this.MainPanel.removeAll();
        this.MainPanel.revalidate();
        this.MainPanel.setLayout(new GridLayout(5,4,3,2));
        
        Font f = new Font("Century Gothic", Font.PLAIN, 24);
        listaPredmeta.forEach(elemn->{
            JButton b = new JButton(elemn.getNazivPredmeta());
           
            b.setBorder(BorderFactory.createLineBorder(Color.decode("#999999"), 1, false));
            b.setBackground(Color.white);
            b.setForeground(Color.GRAY);
            b.setFont(f);
            
            b.setFocusPainted(false);
            b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prikaziOblasti(elemn);
                }

            }
            );
            listaButtona.add(b);
            this.MainPanel.add(b);
            this.MainPanel.setVisible(true);
        });
        for (int i = 0; i <= listaPredmeta.size(); i++) {
            
        }

    }

    private void prikaziOblasti(Predmet p){
        try {
            switch(this.prethodnik){
                case "predavanja":
                    pnlPredavanja main=new pnlPredavanja(trenutniKorisnik,p);
                    this.removeAll();
                    this.revalidate();
                    this.setLayout(new BorderLayout());
                    this.add(main);
                    break;
                case "zadaci":
                    pnlZadaci main2=new pnlZadaci(trenutniKorisnik,p);
                    this.removeAll();
                    this.revalidate();
                    this.setLayout(new BorderLayout());
                    this.add(main2);
                    break;
            }
        } catch (Exception ex) {

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

        MainPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    // End of variables declaration//GEN-END:variables
}
