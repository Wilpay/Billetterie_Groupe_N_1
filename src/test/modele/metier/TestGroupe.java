package test.modele.metier;

import metier.Groupe;

/**
 * Test unitaire de la classe Groupe
 */
public class TestGroupe {

    public static void main(String[] args) {
        Groupe grp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp = new Groupe("g300", "Groupe de test","Identite de test","Adresse Test",500,"France");
        System.out.println(grp);
    }
}