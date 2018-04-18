/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.vueIdentifier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.UtilisateurDao;
import metier.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        vue.getjTextFieldLogin().addActionListener(this);
        vue.getjPassword().addActionListener(this);
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
        if ((ae.getSource().equals(vue.getjButtonConnexion()) || ae.getSource().equals(vue.getjTextFieldLogin())
                || ae.getSource().equals(vue.getjPassword()))) {
            try {
                //if (e.getSource().equals(vue.getjButtonValider())
                //|| e.getSource().equals(vue.getjTextFieldUtil())
                //|| e.getSource().equals(vue.getjTextFieldMdp())) {
                
                String util = vue.getjTextFieldLogin().getText();
                String mdp = vue.getjPassword().getText();
                
                MessageDigest mdUtil = MessageDigest.getInstance("MD5");
                mdUtil.update(util.getBytes());
                byte[] digestUtil = mdUtil.digest();
                StringBuffer sbUtil = new StringBuffer();
                for (byte b : digestUtil) {
                    sbUtil.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest mdMdp = MessageDigest.getInstance("MD5");
                mdMdp.update(mdp.getBytes());
                byte[] digestMdp = mdMdp.digest();
                StringBuffer sbMdp = new StringBuffer();
                for (byte b : digestMdp) {
                    sbMdp.append(String.format("%02x", b & 0xff));
                }
                
                boolean connexion = false;
                try {
                    List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
                    lesUtilisateurs = UtilisateurDao.selectAll();
                    for(Utilisateur unUtilisateur : lesUtilisateurs){
                        if (sbUtil.toString().equals(unUtilisateur.getLogin()) && sbMdp.toString().equals(unUtilisateur.getPassword())) {
                            connexion = true;
                            break;
                        }
                    }
                    if (connexion) {
                        util = vue.getjTextFieldLogin().getText();
                        ctrlPrinc.setConnecter(util);
                        ctrlPrinc.showMembre();
                        ctrlPrinc.hideIdentification();
                    } else {
                        JOptionPane.showMessageDialog(null, "Votre login et/ou MDP est incorrecte");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlIdentification.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlIdentification.class.getName()).log(Level.SEVERE, null, ex);
            }
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
