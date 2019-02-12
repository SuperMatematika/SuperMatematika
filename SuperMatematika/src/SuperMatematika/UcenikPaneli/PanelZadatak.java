/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika.UcenikPaneli;

import SuperMatematika.Model.Zadatak;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author samed
 */
public class PanelZadatak extends JPanel {

    // Tacan odgovor za dati zadatak, moram da ga pamtim jer vrsim shuffle (mesanje) odogovora
    private String tacanOdgovor;

    // Grupa radioButton da bi se osigurala medjusobna iskljucivost
    private ButtonGroup group = new ButtonGroup();
    ;
    
    // Lista radioButton koji predstavljaju date odgovore
    private ArrayList<JRadioButton> buttoni = new ArrayList<JRadioButton>();

    // Konsturktor kao parametar prima jedan zadatak, i za taj zadatak pravi panel sa odogovarajucom slikom i ponudjenim odgovorima
    public PanelZadatak(Zadatak z) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Prvo bi trebalo da dodje slika sa tekstom zadatka
        // a onda sledi buttongroup sa ponudjenim odgovirma
        // ovo sa labelom je samo za test
        ImageIcon myPicture;
//        try {
        //  myPicture = ImageIO.read(new File(new File("").getAbsolutePath() + z.getPutanjaDoZadatka()));
        //  myPicture = ImageIO.read(new File("C:\\Users\\samed\\Documents\\Lightshot\\Screenshot_11.png"));

        // TODO: da pokaze da je pogresan odgovor
        // TODO: da postavim velicinu slike
        JLabel picLabel = new JLabel();
        picLabel.setIcon(new ImageIcon(new File("").getAbsolutePath() + z.getPutanjaDoZadatka()));
        picLabel.setSize(300, 100);
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(picLabel);
//        } catch (IOException ex) {
//            Logger.getLogger(ZadatakPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

        // Pamtim tacan odgovor na dato pitanje
        tacanOdgovor = z.getTacanOdogovor();

        // Lista sa svim odgovorima da bih mogao da uradim shuffle()
        buttoni.add(new JRadioButton(z.getTacanOdogovor()));
        if (z.getPogresanOdg1() != null && !z.getPogresanOdg1().isEmpty()) {
            buttoni.add(new JRadioButton(z.getPogresanOdg1()));
        }

        if (z.getPogresanOdg2() != null && !z.getPogresanOdg2().isEmpty()) {
            buttoni.add(new JRadioButton(z.getPogresanOdg2()));
        }

        if (z.getPogresanOdg3() != null && !z.getPogresanOdg3().isEmpty()) {
            buttoni.add(new JRadioButton(z.getPogresanOdg3()));
        }

        Collections.shuffle(buttoni, new Random());

        // Novi panel koji je horizonalan, jer hocu da radioButtoni budu horizontalno poredjani
        JPanel rbGroup = new JPanel();
        rbGroup.setLayout(new BoxLayout(rbGroup, BoxLayout.X_AXIS));
        for (JRadioButton rb : buttoni) {
            rbGroup.add(rb);
            group.add(rb);
        }
        rbGroup.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(rbGroup);
    }

    // Vraca true ako je selektovani dogovor tacan, inace false
    public boolean odgovorJeTacan() {
        for (JRadioButton rb : buttoni) {
            if (rb.isSelected()) {

                return rb.getText().equals(tacanOdgovor);
            }
        }
        return false;
    }

    // Vraca true ako je selektovan neki radioButton, inace false
    public boolean pritisnutJeNekiRadioButton() {
        for (JRadioButton rb : buttoni) {
            if (rb.isSelected()) {
                return true;
            }
        }
        return false;
    }

}
