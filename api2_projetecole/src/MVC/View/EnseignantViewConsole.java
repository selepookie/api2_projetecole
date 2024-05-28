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
    public void affListe(List l) {
        affListe(l);
    }

    private void modifier() {
        int nl = choixListe(lc) - 1;
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
        int nl = choixListe(lc)-1;
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
        System.out.print("Date d'engagement: ");
        // j'avais des difficultés à entrer la date donc nolwenn m'a aidé
        System.out.println("Jour : ");
        int jour = Integer.parseInt(sc.nextLine());
        System.out.println("Mois : ");
        int mois = Integer.parseInt(sc.nextLine());
        System.out.println("Annee : ");
        int annee = Integer.parseInt(sc.nextLine());
        LocalDate datee = LocalDate.of(annee, mois, jour);
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
