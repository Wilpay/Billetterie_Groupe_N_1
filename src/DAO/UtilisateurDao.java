/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Utilisateur;
import java.util.List;
/**
 *
 * @author Willy
 */
public class UtilisateurDao {
    
     public static Utilisateur selectOne(int idUtil) throws SQLException {
        Utilisateur unUtilisateur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Utilisateur WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idUtil);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String login = rs.getString("LOGIN");
            String password = rs.getString("PASSWORD");
            String nomUtil = rs.getString("NOM");
            String preUtil = rs.getString("PRENOM");
            
            unUtilisateur = new Utilisateur(id, login, password, nomUtil, preUtil);
        }
        return unUtilisateur;
    }
    
}
