/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UtilisateurDao;
import Properties.Reader;
import View.vueAuthentification;
import View.vueIdentifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willy
 */
public class CtrlIdentification implements ActionListener, WindowListener {
    
    private vueIdentifier vue = new vueIdentifier(); // LA VUE
    private CtrlPrincipal ctrlPrinc;
    
    
    public CtrlIdentification(CtrlPrincipal ctrlPrinc) {
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);       
        this.vue=vue;
        this.vue.addWindowListener((WindowListener) this);
        this.vue.getjButtonConnexion().addActionListener(this);
        this.ctrlPrinc = ctrlPrinc;        
    }


    // ACCESSEURS et MUTATEURS
    public vueIdentifier getVue() {
        return vue;
    }

    public void setVue(vueIdentifier vue) {
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(this.vue.getjButtonConnexion())){
        
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
}
