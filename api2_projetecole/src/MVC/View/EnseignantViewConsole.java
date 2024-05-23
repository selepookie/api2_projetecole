package MVC.View;

import MVC.Model.DAOSalle;
import metier.Cours;
import metier.Enseignant;
import metier.Salle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.choixListe;

public class EnseignantViewConsole extends EnseignantAbstractView{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(enseignantController.getAll());
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
        Enseignant enseignant = lc.get(nl);
        String matricule = modifyIfNotBlank("matricule", enseignant.getMatricule());
        String nom = modifyIfNotBlank("nom", enseignant.getNom());
        String prenom = modifyIfNotBlank("prenom", enseignant.getPrenom());
        String tel = modifyIfNotBlank("tel", enseignant.getTel());
        int chargeSem = parseInt(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        double salaireMensu = Double.parseDouble(modifyIfNotBlank("chargesem","" + enseignant.getChargeSem()));
        LocalDate date = enseignant.getDateEngag();
        Enseignant ens =enseignantController.update(new Enseignant(enseignant.getId_enseignant(), matricule, nom, prenom, tel, chargeSem, salaireMensu, date));
        if(ens==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+ens);
    }

    private void rechercher() {
        System.out.println("id enseignant : ");
        int id_ens = sc.nextInt();
        Enseignant ens = enseignantController.search(id_ens);
        if(ens==null) affMsg("recherche infructueuse");
        else {
            affMsg(ens.toString());
        }
    }

    private void retirer() {
        int nl = choixElt(lc)-1;
        Enseignant ens = lc.get(nl);
        boolean ok = enseignantController.removeEnseignant(ens);
        if(ok) affMsg("enseignant effacé");
        else affMsg("enseignant non effacé");
    }

    private void ajouter() {
        System.out.print("matricule : ");
        String matricule = sc.nextLine();
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("prenom : ");
        String prenom = sc.nextLine();
        System.out.print("tel : ");
        String tel = sc.nextLine();
        System.out.print("chargesem : ");
        int chargesem = parseInt(sc.nextLine());
        System.out.print("salaire mensu : ");
        double salairemensu = Double.parseDouble(sc.nextLine());
        System.out.print("Date : ");
        String date = sc.nextLine();
        LocalDate datee = LocalDate.parse(date);
        Enseignant ens = enseignantController.addEnseignant(new Enseignant(0, matricule, nom, prenom, tel, chargesem, salairemensu, datee));
        if(ens!=null) affMsg("création de :"+ens);
        else affMsg("erreur de création");
    }

    @Override
    public Enseignant selectionner() {
        update(enseignantController.getAll());
        int nl = choixListe(lc);
        Enseignant ens = lc.get(nl - 1);
        return ens;
    }
}
