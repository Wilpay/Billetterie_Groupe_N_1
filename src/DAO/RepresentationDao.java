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
import metier.Representation;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import metier.Lieu;
import metier.Groupe;
import DAO.LieuDao;
import DAO.GroupeDao;
import java.sql.Connection;
import java.sql.Statement;
import Properties.Reader;
import java.sql.DriverManager;
/**
 *
 * @author Willy
 */
public class RepresentationDao {
     public static Representation selectOne(String idRepresentation) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("ID");
            String dateRep = rs.getString("DATE_REP");
            String leLieu = rs.getString("ID_LIEU");
            int idlieu = Integer.parseInt(leLieu);
            Lieu lieu = LieuDao.selectOne(idlieu);
            String leGroupe = rs.getString("ID_GROUPE");
            Groupe groupe = GroupeDao.selectOne(leGroupe);
            String heureDebut = rs.getString("HEUREDEBUT");
            String heureFin = rs.getString("HEUREFIN");
            int nbPlace = rs.getInt("NBPLACE");

            uneRepresentation = new Representation(id, dateRep, lieu, groupe, heureDebut, heureFin, nbPlace);
        }
        return uneRepresentation;
    }

    /**
     * Extraction de toutes les representations
     *
     * @return collection de representations
     * @throws SQLException
     */
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String dateRep = rs.getString("DATE_REP");
            String leLieu = rs.getString("ID_LIEU");
            int idlieu = Integer.parseInt(leLieu);
            Lieu lieu = LieuDao.selectOne(idlieu);
            String leGroupe = rs.getString("ID_GROUPE");
            Groupe groupe = GroupeDao.selectOne(leGroupe);
            String heureDebut = rs.getString("HEUREDEBUT");
            String heureFin = rs.getString("HEUREFIN");
            int nbPlace = rs.getInt("NBPLACE");

            uneRepresentation = new Representation(id, dateRep, lieu, groupe, heureDebut, heureFin, nbPlace);
            lesRepresentations.add(uneRepresentation);
        }
        return lesRepresentations;
    }

    public static Representation selectOne(int idRepresentation) {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= " + idRepresentation;
        try {
            pstmt = jdbc.getConnexion().prepareStatement(requete);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String dateRep = rs.getString("DATE_REP");
                String leLieu = rs.getString("ID_LIEU");
                int idlieu = Integer.parseInt(leLieu);
                Lieu lieu = LieuDao.selectOne(idlieu);
                String leGroupe = rs.getString("ID_GROUPE");
                Groupe groupe = GroupeDao.selectOne(leGroupe);
                String heureDebut = rs.getString("HEUREDEBUT");
                String heureFin = rs.getString("HEUREFIN");
                int nbPlace = rs.getInt("NBPLACE");
                uneRepresentation = new Representation(id, dateRep, lieu, groupe, heureDebut, heureFin, nbPlace);
            }
        } catch (Exception e) {
            System.err.println("selectOne error");
        }
        return uneRepresentation;
    }

    /**
     * @param id
     * @param nbDePlace 
     */
    public static void updateNbPlace(int id, int nbDePlace) throws SQLException {
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        
        String requete = ("UPDATE `Representation` SET `nbPlace`= " + nbDePlace + " WHERE `id` = " + id);
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.executeUpdate();
        
    }
}
