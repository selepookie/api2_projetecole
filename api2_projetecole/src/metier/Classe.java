package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * classe métier de gestion d'une classe
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Classe {
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i = 1;

    /**
     * id unique de la classe
     */
    protected int id_classe;
    /**
     * sigle de la classe
     */
    protected String sigle;
    /**
     * année en cours
     */
    protected int annee;
    /**
     * spécialité de la classe
     */
    protected String specialite;
    /**
     * nombre d'élèves
     */
    protected int nbreEleves;
    /**
     * liste d'infos relatives à la classe
     */
    protected List<Infos> infos = new ArrayList<>();

    /**
     * constructeur par défaut
     */
    public Classe(){}

    /**
     * constructeur paramétré
     * @param id_classe id unique de la classe, affilié au i qui s'incrémente a chaque nouvelle classe
     * @param sigle sigle de la classe
     * @param annee année en cours
     * @param specialite specialité de la classe
     * @param nbreEleves nombre d'élèves de la classe/**
     */
    public Classe(int id_classe, String sigle, int annee, String specialite, int nbreEleves) {
        this.id_classe = i++;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter id_classe
     * @return identifiant de la classe
     */
    public int getId_classe() {
        return id_classe;
    }
    /**
     * setter id_classe
     * @param id_classe nouvel identifiant de la classe
     */
    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    /**
     * getter sigle
     * @return sigle actuel de la classe
     */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter sigle
     * @param sigle nouveau sigle
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter annee
     * @return année en cours
     */
    public int getAnnee() {
        return annee;
    }
    /**
     * setter annee
     * @param annee nouvelle année
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * getter specialite
     * @return specialité de la classe
     */
    public String getSpecialite() {
        return specialite;
    }
    /**
     * setter specialite
     * @param specialite nouvelle spécialité de la classe
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    /**
     * getter nbreEleves
     * @return nombre d'élèves de la classe
     *
     */
    public int getNbreEleves() {
        return nbreEleves;
    }
    /**
     * setter nbreEleves
     * @param nbreEleves nouveau nombre d'élèves
     */
    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    /**
     * getter Infos
     * @return les infos de la classe
     */
    public List<Infos> getInfos() {
        return infos;
    }

    /**
     * setter infos
     * @param infos nouvelle liste d'infos
     */
    public void setInfos(List<Infos> infos) {
        this.infos = infos;
    }


    /**
     * affichage de toutes les informations de la classe
     * @return toutes les infos relatives à la classe
     */
    @Override
    public String toString() {
        return "Classe{" +
                "id_classe=" + id_classe +
                ", sigle='" + sigle + '\'' +
                ", annee=" + annee +
                ", specialite='" + specialite + '\'' +
                ", nbreEleves=" + nbreEleves +
                ", infos=" + infos +
                '}';
    }
    // methodes


    /**
     * calcul du nombre total des heures de la classe
     * @return nombre total des heures de la classe
     */
    public int nbreHeuresTot(){
        int total_heures=0;
        for(Infos infos : infos){
            total_heures+=infos.getNbreHeures();
        }
        return total_heures;
    }

    /**
     * liste qui comprend chaque enseignant et ses heures avec la classe
     * @return liste des enseignants et de leurs heures
     */
    public List<ListeEnseignantsHeures> listeEnseignantsEtHeures(){
        List<ListeEnseignantsHeures> listeEnsHrs = new ArrayList<>();
        for(Infos infos : infos){
            listeEnsHrs.add(new ListeEnseignantsHeures(infos.getEnseignant(), infos.getNbreHeures()));
        }
        return listeEnsHrs;
    }

    /**
     * liste qui comprend chaque salle et ses heures avec la classe
     * @return liste des salles et leurs heures avec la classe
     */
    public List<SalleHeures> listeSalleetHeures(){
        List<SalleHeures> listeSalleHeures = new ArrayList<>();
        for(Infos infos : infos){
            listeSalleHeures.add(new SalleHeures(infos.getSalle(), infos.getNbreHeures()));
        }
        return listeSalleHeures;
    }

    /**
     * liste qui comprend chaque cours et ses heures avec la classe
     * @return liste des cours et leurs heures avec la classe
     */
    public List<CoursHeures> listeCoursetHeures(){
        List<CoursHeures> listeCoursHeures = new ArrayList<>();
        for(Infos infos : infos){
            listeCoursHeures.add(new CoursHeures(infos.getCours(), infos.getNbreHeures()));
        }
        return listeCoursHeures;
    }

    /**
     * Vérification si une salle a une capacité assez grande pour pouvoir accueillir la classe
     * @param salle la salle que l'on veut vérifier
     * @return salle ok ou pas
     */
    public boolean salleCapaciteOK(Salle salle){
        boolean ok;
        if(getNbreEleves()>=salle.capacite){
            ok=true;
        }
        else{
            ok=false;
        }

        return ok;
    }

    /**
     * ajout d'un cours pour cette classe
     * @param nbreHeures nombre d'heures accordées à ce cours
     * @param cours cours que l'on veut ajouter
     */
    public void addCours(int nbreHeures, Cours cours){ // heure et cours seulement
        boolean ok=false;
        for(Infos infos : infos){
            if(infos.getCours().getCode().equals(cours.getCode())) {
                ok=true;
            }
        }
        if(!ok){
            infos.add(new Infos(cours,nbreHeures));
            System.out.println("Nouveau cours ajouté");
        }
        else{
            System.out.println("Cours déjà existant");
        }
    }


    /**
     * modification du nombre d'heures d'un cours
     * @param CoursChoisi cours duquel on doit changer le nombre d'heures
     * @param nbreHeures nouveau nombre d'heures
     */
    public void modifCours(Cours CoursChoisi, int nbreHeures){
        for(Infos infos : infos){
            if(infos.getCours().equals(CoursChoisi)){
                infos.setNbreHeures(nbreHeures);
                System.out.println("Modification effectuée");
            }
        }
    }

    /**
     * modification de la salle où est donné un cours
     * @param CoursChoisi cours duquel on doit changer la salle
     * @param salleChoisie nouvelle salle
     */
    public void modifCours(Cours CoursChoisi, Salle salleChoisie){
        for(Infos infos : infos){
            if(infos.getCours().equals(CoursChoisi)){
                infos.setSalle(salleChoisie);
                System.out.println("Modification effectuée");
            }
        }
    }

    /**
     * modification de l'enseignant qui donne un cours
     * @param CoursChoisi cours duquel on doit changer l'enseignant
     * @param EnsChoisi nouvel enseignant
     */
    public void modifCours(Cours CoursChoisi, Enseignant EnsChoisi){
        for(Infos infos : infos){
            if(infos.getCours().equals(CoursChoisi)){
                infos.setEnseignant(EnsChoisi);
                System.out.println("Modification effectuée");
            }
        }
    }

    /**
     * supprime un cours
     * @param cours cours à supprimer
     */
    public void suppCours(Infos cours){
        infos.remove(cours);
    }

}
