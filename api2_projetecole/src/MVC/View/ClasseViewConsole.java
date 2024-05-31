package MVC.View;

import metier.*;
import metier.ListeEnseignantsHeures;

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

    private void special(Classe cl) {

        do {

            int ch = choixListe(Arrays.asList("nombre d'heures totales", "liste enseignants et heures", "liste salles et heures", "liste cours et heures","fin"));
            switch (ch) {
                case 1:
                    nbreHeuresTot(cl);
                    break;
                case 2:
                    listeEnsHeures(cl);
                    break;
                case 3:
                    listeSalleHeures(cl);
                    break;
                case 4:
                    listeCoursHeures(cl);
                    break;
                case 5 : return;
            }
        } while (true);
    }

    public void nbreHeuresTot(Classe cl) {
        int nb = classeController.nbreHeuresTot(cl);
        if (nb == 0) System.out.println("pas d'heure pour cette classe");
        else System.out.println(nb);
    }

    public void listeEnsHeures(Classe cl) {
        List<ListeEnseignantsHeures> leh = classeController.listeEnsHeures(cl);
        if (leh.isEmpty()) {
            System.out.println("liste nulle");
        } else {
            System.out.println(leh);
        }
    }

    public void listeSalleHeures(Classe cl) {
        List<SalleHeures> sh = classeController.listeSalleHeures(cl);
        if (sh.isEmpty()) System.out.println("liste nulle");
        else affList(sh);
    }

    public void listeCoursHeures(Classe cl) {
        List<CoursHeures> ch = classeController.listeCoursHeures(cl);
        if (ch.isEmpty()) System.out.println("liste nulle");
        else affList(ch);
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
        int nl = choixListe(lc) - 1;
        Classe classe = lc.get(nl);
        String sigle = modifyIfNotBlank("sigle", classe.getSigle());
        int annee = parseInt(modifyIfNotBlank("année", "" + classe.getAnnee()));
        String specialite = modifyIfNotBlank("specialité ", classe.getSpecialite());
        int nbreEleves = parseInt(modifyIfNotBlank("nombre d'eleves ", "" + classe.getNbreEleves()));
        Classe cl = classeController.update(new Classe(classe.getId_classe(), sigle, annee, specialite, nbreEleves));
        if (cl == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : " + cl);
    }

    private void rechercher() {
        System.out.println("id_classe : ");
        int id_classe = sc.nextInt();
        Classe cl = classeController.search(id_classe);
        if (cl == null) affMsg("recherche infructueuse");
        else {
            affMsg(cl.toString());
            special(cl);
        }
    }

    private void retirer() {
        int nl = choixElt(lc) - 1;
        Classe classe = lc.get(nl);
        boolean ok = classeController.removeClasse(classe);
        if (ok) affMsg("classe effacée");
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
        if (cl != null) affMsg("création de :" + cl);
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
