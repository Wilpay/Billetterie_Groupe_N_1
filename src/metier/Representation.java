/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Willy
 */
public class Representation {
    
    private int idRep;
    private String dateRep;
    private Lieu lieu;
    private Groupe groupe;
    private String heureDebut;
    private String heureFin;
    private int nbPlace;

    public Representation(int idRep, String dateRep, Lieu lieu, Groupe groupe, String heureDebut, String heureFin, int nbPlace) {
        this.idRep = idRep;
        this.dateRep = dateRep;
        this.lieu = lieu;
        this.groupe = groupe;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nbPlace = nbPlace;
    }


    @Override
    public String toString() {
        return "Representation{" + "idRep=" + idRep + ", dateRep=" + dateRep + ", lieu=" + lieu + ", groupe=" + groupe + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + ", nbPlace=" + nbPlace +'}';
    }
    
    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }
}
