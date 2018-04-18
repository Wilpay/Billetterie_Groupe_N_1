/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RepresentationDao;
import View.vueReservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metier.Representation;

/**
 *
 * @author Willy
 */
public class CtrlReservation implements WindowListener, MouseListener, ActionListener{

    
    vueReservation vue = new vueReservation();
    Representation representation;
    private CtrlPrincipal ctrlPrinc;

    
    public CtrlReservation(int id, CtrlPrincipal ctrlPrinc) {
        this.ctrlPrinc = ctrlPrinc;
        representation = RepresentationDao.selectOne(id);
        vue.getjGroupe().setText(representation.getGroupe().getNomGroup());
        vue.getjLieu().setText(representation.getLieu().getNomLieu());
        vue.getjDate().setText(representation.getDateRep().toString());
        vue.getJheureDebut().setText(representation.getHeureDebut().toString());
        vue.getjHeureFin().setText(representation.getHeureFin().toString());
        vue.getjNbplace().setText(Integer.toString(representation.getLieu().getCapaciteAccueil()));
        vue.getjPlaceDispo().setText(Integer.toString(representation.getNbPlace()));

        vue.getjNbAchat().removeAllItems();
        for (int i = 1; i <= representation.getNbPlace(); i++) {
            vue.getjNbAchat().addItem(Integer.toString(i));
        }
        vue.getjButtonCommander().addActionListener(this);
        vue.getjButton1().addActionListener(this);
    }

    public vueReservation getVue() {
        return vue;
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vue.getjButtonCommander()) {
            int nbplace = representation.getNbPlace() - Integer.parseInt(vue.getjNbAchat().getSelectedItem().toString());
            try {
                RepresentationDao.vendreRepresentation(representation.getIdRep(), nbplace);
            } catch (SQLException ex) {
                Logger.getLogger(CtrlReservation.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(vue,
                    "Achat réussie. \nIl reste plus que " + nbplace + " place(s).",
                    "Reservation",
                    JOptionPane.PLAIN_MESSAGE);
            ctrlPrinc.showRepresentation();
            vue.setVisible(false);
        }
        if (ae.getSource() == vue.getjButton1()) {
            ctrlPrinc.showMenu();
            vue.setVisible(false);
        }    }
    
}
