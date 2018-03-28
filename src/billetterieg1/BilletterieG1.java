/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billetterieg1;

import Controller.CtrlPrincipal;
import DAO.Jdbc;
import Properties.Reader;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Willy
 */
public class BilletterieG1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival2", "root", "joliverie");
        //Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "//localhost/", Reader.readString("BDD_name"), Reader.readString("BDD_login"), Reader.readString("BDD_mdp"));
        try {
            Jdbc.getInstance().connecter();
            CtrlPrincipal ctrlPrcp = new CtrlPrincipal();
            ctrlPrcp.showAuthentification();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }
    }
    
}
