/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Properties.Reader;
import View.vueAuthentification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Willy
 */
public class CtrlAuthentification implements WindowListener, ActionListener {
    
     private vueAuthentification vue = new vueAuthentification(); // LA VUE
    private CtrlPrincipal ctrlPrinc;
    
    public CtrlAuthentification(CtrlPrincipal ctrlPrinc) {
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);       
        this.vue=vue;
        this.vue.addWindowListener((WindowListener) this);
        this.vue.getjConnexion().addActionListener((ActionListener) this);
        this.ctrlPrinc = ctrlPrinc;        
    }

    // ACCESSEURS et MUTATEURS
    public vueAuthentification getVue() {
        return vue;
    }

    public void setVue(vueAuthentification vue) {
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
        if(ae.getSource().equals(this.vue.getjConnexion())){
            try {
                String login = this.vue.getjTextField1().getText();
                String mdp = this.vue.getjPassword().getText();
                
                MessageDigest mdLogin = MessageDigest.getInstance("MD5");
                mdLogin.update(mdp.getBytes());
                byte[] digestLogin = mdLogin.digest();
                StringBuffer sbLogin = new StringBuffer();
                for (byte b : digestLogin) {
                    sbLogin.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest mdMDP = MessageDigest.getInstance("MD5");
                mdMDP.update(mdp.getBytes());
                byte[] digestMDP = mdMDP.digest();
                StringBuffer sbMDP = new StringBuffer();
                for (byte b : digestMDP) {
                    sbMDP.append(String.format("%02x", b & 0xff));
                }
                
                if(Reader.readString("Authentification_login").equals(sbLogin.toString()) && Reader.readString("Authentification_login").equals(sbMDP.toString())){
                    ctrlPrinc.showMenu();
                    ctrlPrinc.hideAuthentification();
                }else {
                    JOptionPane.showMessageDialog(null, "Votre login et/ou MDP est incorrecte");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlAuthentification.class.getName()).log(Level.SEVERE, null, ex);
            }    }
}
}
