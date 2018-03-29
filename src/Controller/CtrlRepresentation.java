/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RepresentationDao;
import View.vueRepresentation;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import metier.Representation;

/**
 *
 * @author Willy
 */
public class CtrlRepresentation implements WindowListener, MouseListener{

    private vueRepresentation vue = new vueRepresentation(); // LA VUE
    private List<Representation> lesRepresentations = null;
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) {
       this.ctrlPrincipal = ctrlPrincipal;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        this.vue.getjButtonMenuPrincipal().addMouseListener(this);
        this.vue.getjTableRepresentation().addMouseListener(this);
        // préparer l'état initial de la vue
        afficherLesRepresentations();

    }
    
    private final void afficherLesRepresentations() {
        try {
            lesRepresentations = RepresentationDao.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des Representations");
        }
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"DATE", "GROUPE", "LIEU", "DEBUT", "FIN", "PLACE"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);

        String[] ligneDonnees = new String[6];

        for (Representation uneRepresentation : lesRepresentations) {
            ligneDonnees[0] = uneRepresentation.getDateRep().toString();
            ligneDonnees[1] = uneRepresentation.getGroupe().getNomGroup();
            ligneDonnees[2] = uneRepresentation.getLieu().getNomLieu();
            ligneDonnees[3] = uneRepresentation.getHeureDebut().toString();
            ligneDonnees[4] = uneRepresentation.getHeureFin().toString();
            ligneDonnees[5] = uneRepresentation.getNbPlace() + "";
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
    }
     // ACCESSEURS et MUTATEURS
    public vueRepresentation getVue() {
        return vue;
    }

    public void setVue(vueRepresentation vue) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
       
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int row = vue.getjTableRepresentation().getSelectedRow();
        ctrlPrincipal.showReservation(lesRepresentations.get(row).getIdRep());
        ctrlPrincipal.hideRepresentation();
        if (me.getSource() == vue.getjButtonMenuPrincipal()) {
            ctrlPrincipal.showMenu();
            ctrlPrincipal.hideRepresentation();
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
