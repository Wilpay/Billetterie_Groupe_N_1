/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UtilisateurDao;
import View.vueMembre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import metier.Utilisateur;

/**
 *
 * @author Willy
 */
public class CtrlPanelMembre implements ActionListener, WindowListener, MouseListener {
    
    private vueMembre vue = new vueMembre(); // LA VUE
    private CtrlPrincipal ctrlPrinc;
    Utilisateur utilisateur;
    
    public CtrlPanelMembre(CtrlPrincipal ctrlPrinc) {
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);       
        this.vue=vue;
        this.vue.addWindowListener((WindowListener) this);
        this.ctrlPrinc = ctrlPrinc; 
        this.vue.getjReservation().addActionListener(this);
        this.vue.getjMenu().addActionListener(this);
    }

    // ACCESSEURS et MUTATEURS
    public vueMembre getVue() {
        return vue;
    }

    public void setVue(vueMembre vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vue.getjMenu()){
            ctrlPrinc.hideMembre();
            ctrlPrinc.showMenu();
        }else if(ae.getSource() == vue.getjReservation()){
            ctrlPrinc.showRepresentation();
            ctrlPrinc.hideMembre();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
