package test.modele.metier;

import java.time.LocalDate;
import java.time.LocalTime;
import metier.Groupe;
import metier.Lieu;
import metier.Representation;

public class TestRepresentation {
        public static void main(String[] args) {
        Representation rp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        Lieu lieu = new Lieu(5, "Lieu de test","Adresse de test", 44230);
        Groupe grp = new Groupe("g300", "Groupe de test","Identite de test","Adresse Test",500,"France");
        LocalDate uneDate = LocalDate.of(2017,12,11);
        LocalTime heureD = LocalTime.of(19,0,0,0);
        LocalTime heureF = LocalTime.of(20,0,0,0);
        rp = new Representation(3,"25/07/2018",lieu,grp,"20:00:00", "23:00:00",400);
        System.out.println(rp);
    }
}