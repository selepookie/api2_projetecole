package MVC.View;

import metier.Classe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;


public class ClasseViewConsole extends ClasseAbstractView {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(classeController.getAll());
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
        int nl = choixElt(lc) - 1;
        Classe classe = lc.get(nl);
        String sigle = modifyIfNotBlank("sigle", classe.getSigle());
        int annee = parseInt(modifyIfNotBlank("année","" + classe.getAnnee()));
        String specialite = modifyIfNotBlank("specialité ",classe.getSpecialite());
        int nbreEleves = parseInt(modifyIfNotBlank("nombre d'eleves ", "" + classe.getNbreEleves()));
        Classe cl =classeController.update(new Classe(classe.getId_classe(), sigle, annee, specialite, nbreEleves));
        if(cl==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+cl);
    }

    private void rechercher() {
        System.out.println("id_classe : ");
        int id_classe = sc.nextInt();
        Classe cl = classeController.search(id_classe);
        if(cl==null) affMsg("recherche infructueuse");
        else {
            affMsg(cl.toString());
        }
    }

    private void retirer() {
        int nl = choixElt(lc)-1;
        Classe classe = lc.get(nl);
        boolean ok = classeController.removeClasse(classe);
        if(ok) affMsg("classe effacée");
        else affMsg("classe non effacé");
    }

    private void ajouter() {
        System.out.print("sigle : ");
        String sigle = sc.nextLine();
        System.out.print("annee : ");
        int annee = parseInt(sc.nextLine());
        System.out.print("specialite: ");
        String specialite = sc.nextLine();
        System.out.print("nbre eleves : ");
        int nb = parseInt(sc.nextLine());
        Classe cl = classeController.addClasse(new Classe(0, sigle, annee, specialite, nb));
        if(cl!=null) affMsg("création de :"+cl);
        else affMsg("erreur de création");
    }

    @Override
    public Classe selectionner() {
        update(classeController.getAll());
        int nl = choixListe(lc);
        Classe cl = lc.get(nl - 1);
        return cl;
    }
}
