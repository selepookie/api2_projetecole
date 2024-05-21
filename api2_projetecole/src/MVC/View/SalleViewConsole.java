package MVC.View;

import metier.Salle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.choixListe;

public class SalleViewConsole extends SalleAbstractView{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(salleController.getAll());
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



    private void modifier() {
        int nl = choixElt(lc) - 1;
        Salle salle = lc.get(nl);
        String sigle = modifyIfNotBlank("sigle", salle.getSigle());
        int capacite = parseInt(modifyIfNotBlank("capacite", "" + salle.getCapacite()));
        Salle sl =salleController.updateSalle(new Salle(salle.getId_salle(), sigle, capacite));
        if(sl==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+sl);
    }

    private void rechercher() {
        System.out.println("id salle : ");
        int id_salle = sc.nextInt();
        Salle sl = salleController.search(id_salle);
        if(sl==null) affMsg("recherche infructueuse");
        else {
            affMsg(sl.toString());
            // special(cl);
        }
    }

    private void retirer() {
        int nl = choixElt(lc)-1;
        Salle salle = lc.get(nl);
        boolean ok = salleController.removeSalle(salle);
        if(ok) affMsg("salle effacée");
        else affMsg("salle non effacée");
    }

    private void ajouter() {
        System.out.print("sigle : ");
        String sigle = sc.nextLine();
        System.out.print("capacite: ");
        int capacite = sc.nextInt();
        Salle sl = salleController.addSalle(new Salle(0, sigle, capacite));
        if(sl!=null) affMsg("création de :"+sl);
        else affMsg("erreur de création");
    }

    @Override
    public Salle selectionner() {
        update(salleController.getAll());
        int nl = choixListe(lc);
        Salle salle = lc.get(nl - 1);
        return salle;
    }
}
