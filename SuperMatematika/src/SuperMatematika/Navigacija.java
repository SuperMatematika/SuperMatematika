/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SuperMatematika;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Samed
 */
public class Navigacija {
    
    public static void PromeniPanel(JPanel old, JPanel newPanel) {
        old.removeAll();
	old.revalidate();	
	old.setLayout(new BorderLayout());
	old.add(newPanel);
    }
    
}
