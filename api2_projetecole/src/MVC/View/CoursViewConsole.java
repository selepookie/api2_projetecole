package MVC.View;

import MVC.Controller.SalleController;
import MVC.Model.DAOSalle;
import metier.Classe;
import metier.Cours;
import metier.Salle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.choixListe;

public class CoursViewConsole extends CoursAbstractView{
    private Scanner sc = new Scanner(System.in);
    SalleController salleController;

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(coursController.getAll());
        do {

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    /*
    private void special(Classe cl) {

        do {
            int ch = choixListe(Arrays.asList("commandes en cours", "factures non payees", "factures en retard", "factures payees", "produits achetés", "menu principal"));
            if(ch==6) return;
            List l =   switch (ch) {
                case 1 ->  clientController.commandes(cl);

                case 2 ->  clientController.factNonPayees(cl);

                case 3 ->   clientController.factRetard(cl);

                case 4 ->   clientController.factPayees(cl);

                case 5  ->   clientController.produits(cl);
                default -> null;
            };
            if(l==null || l.isEmpty()) affMsg("aucun élément trouvée");
            else affList(l);
        } while (true);
    }

*/

    private void modifier() {
        int nl = choixListe(lc) - 1;
        Cours cours = lc.get(nl);
        String code = modifyIfNotBlank("code", cours.getCode());
        String intitule = modifyIfNotBlank("intitule", cours.getIntitule());
        int salleid = parseInt(modifyIfNotBlank("salle", "" + cours.getSalle().getId_salle()));
        // FAIRE ICI
        Salle salle = salleController.search(salleid);
        Cours cl =coursController.update(new Cours(cours.getId_cours(), code, intitule, salle));
        if(cl==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+cl);
    }

    private void rechercher() {
        System.out.println("id cours : ");
        int id_cours = sc.nextInt();
        Cours cl = coursController.search(id_cours);
        if(cl==null) affMsg("recherche infructueuse");
        else {
            affMsg(cl.toString());
        }
    }

    private void retirer() {
        int nl = choixElt(lc)-1;
        Cours cours = lc.get(nl);
        boolean ok = coursController.removeCours(cours);
        if(ok) affMsg("cours effacé");
        else affMsg("cours non effacé");
    }

    private void ajouter() {
        System.out.print("code : ");
        String code = sc.nextLine();
        System.out.print("intitule : ");
        String intitule = sc.nextLine();
        System.out.print("id salle : ");
        int id_salle = parseInt(sc.nextLine());
        Salle salle = salleController.search(id_salle);
        Cours cl = coursController.addCours(new Cours(0, code, intitule, salle));
        if(cl!=null) affMsg("création de :"+cl);
        else affMsg("erreur de création");
    }

    @Override
    public Cours selectionner() {
        update(coursController.getAll());
        int nl = choixListe(lc);
        Cours cl = lc.get(nl - 1);
        return cl;
    }
}

