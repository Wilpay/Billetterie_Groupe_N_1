/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.vueMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Willy
 */
public class CtrlMenu implements WindowListener, ActionListener{

    private vueMenu vue = new vueMenu(); // LA VUE
    private CtrlPrincipal ctrlPrincipal;
    
     public CtrlMenu (CtrlPrincipal ctrlPrincipal){

        this.ctrlPrincipal = ctrlPrincipal;
        this.vue.addWindowListener(this);
        this.vue.getAfficherRep().addActionListener(this);
        this.ctrlPrincipal = ctrlPrincipal;
        
      
    }
     
      // ACCESSEURS et MUTATEURS
    public vueMenu getVue() {
        return vue;
    }

    public void setVue(vueMenu vue) {
        this.vue = vue;
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
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.vue.getAfficherRep())){
            ctrlPrincipal.showRepresentation();
            ctrlPrincipal.hideMenu();
        }    }
    
}
