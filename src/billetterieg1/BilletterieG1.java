/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billetterieg1;

import Controller.CtrlPrincipal;
import DAO.Jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Willy
 */
public class BilletterieG1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
	InputStream input = null;
        
        try {

		input = new FileInputStream("properties.properties");

		// load a properties file
		prop.load(input);

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        
        Jdbc.creer(prop.getProperty("jdbcDriver"), prop.getProperty("typeBdd"), prop.getProperty("localisation"), prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
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
