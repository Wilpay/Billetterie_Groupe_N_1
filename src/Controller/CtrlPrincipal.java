/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Willy
 */
public class CtrlPrincipal implements WindowListener, ActionListener {

    int idrep;
    
    CtrlRepresentation ctrlRepresentation;
    CtrlMenu ctrlMenu;
    CtrlReservation ctrlReservation;
    CtrlAuthentification ctrlConnexion;
    
    public void showRepresentation() {
        ctrlRepresentation = new CtrlRepresentation(this);
        ctrlRepresentation.getVue().setVisible(true);
    }
    
    public void showMenu() {
        ctrlMenu = new CtrlMenu(this);
        ctrlMenu.getVue().setVisible(true);
    }
    public void hideMenu() {
        ctrlMenu.getVue().setVisible(false);
    }
    public void hideRepresentation() {
        ctrlRepresentation.getVue().setVisible(false);
    }
    public void showReservation(int id) {
        ctrlReservation = new CtrlReservation(id, this);
        ctrlReservation.getVue().setVisible(true);
    }
        
        public void showAuthentification() {
        ctrlConnexion = new CtrlAuthentification(this);
        ctrlConnexion.getVue().setVisible(true);
    }

    public void hideAuthentification() {
        ctrlConnexion.getVue().setVisible(false);
    }
    
    
    public void quitterApplication()
    {       
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Representation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
