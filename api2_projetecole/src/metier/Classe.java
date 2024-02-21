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
     * liste de chaque enseignant et de ses heures avec cette classe
     */
    protected List<ListeEnseignantsHeures> listeEnsHrs = new ArrayList<>();

    /**
     * liste de chaque salle où la classe a cours avec les heures durant
     * lesquelles la salle est occupée par la classe
     */
    protected List<SalleHeures> listeSalleHeures = new ArrayList<>();
    /**
     * liste de chaque cours qu'a la classe et ses heures attribuées
     */
    protected List<CoursHeures> listeCoursHeures = new ArrayList<>();

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
     * getter ListeEnseignantsHeures
     * @return la liste complète des enseignants + heures qu'ils ont avec cette classe
     */
    public List<ListeEnseignantsHeures> getListeEnsHrs() {
        return listeEnsHrs;
    }

    /**
     * setter ListeEnseignantsHeures
     * @param listeEnsHrs nouvelle liste enseignants et heures
     */
    public void setListeEnsHrs(List<ListeEnseignantsHeures> listeEnsHrs) {
        this.listeEnsHrs = listeEnsHrs;
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
                ", listeEnsHrs=" + listeEnsHrs +
                ", listeSalleHeures=" + listeSalleHeures +
                ", listeCoursHeures=" + listeCoursHeures +
                '}';
    }

    // methodes


    /**
     * calcul du nombre total des heures de la classe
     */
    public void nbreHeuresTot(){
        int total_heures=0;
        for(Infos infos : infos){
            total_heures+=infos.getNbreHeures();
        }
        System.out.println("Total des heures de la classe "+sigle+" : "+total_heures);
    }

    /**
     * affichage d'une liste qui comprend chaque enseignant et ses heures avec la classe
     */
    public void listeEnseignantsEtHeures(){
        for(Infos infos : infos){
            
            listeEnsHrs.add(new ListeEnseignantsHeures(infos.getEnseignant(), infos.getNbreHeures()));
        }
        for(int i=0;i<listeEnsHrs.size();i++){
            System.out.println(listeEnsHrs.get(i));
        }
    }

    /**
     * affichage d'une liste qui comprend chaque salle et ses heures avec la classe
     */
    public void listeSalleetHeures(){
        for(Infos infos : infos){
            listeSalleHeures.add(new SalleHeures(infos.getSalle(), infos.getNbreHeures()));
        }
        for(int i=0;i<listeSalleHeures.size();i++){
            System.out.println(listeSalleHeures.get(i));
        }
    }

    /**
     * affichage d'une liste qui comprend chaque cours et ses heures avec la classe
     */
    public void listeCoursetHeures(){
        for(Infos infos : infos){
            listeCoursHeures.add(new CoursHeures(infos.getCours(), infos.getNbreHeures()));
        }
        for(int i=0;i<listeCoursHeures.size();i++){
            System.out.println(listeCoursHeures.get(i));
        }
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
            System.out.println("La salle est ok");
        }
        else{
            ok=false;
            System.out.println("La salle n'est pas ok");
        }

        return ok;
    }

    /**
     * ajout d'un cours pour cette classe
     * @param nbreHeures nombre d'heures accordées à ce cours
     * @param cours cours que l'on veut ajouter
     */
    public void addCours(int nbreHeures, Cours cours){ // heure et cours seulement
        int flag=0;
        for(Infos infos : infos){
            if(infos.getCours().getCode().equals(cours.getCode())) {
                flag = 1;
            }
        }
        if(flag==0){
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
        int i=0;
        for(Infos info : infos){
            i++;
            if(infos.get(i).getCours().equals(cours)){
                infos.remove(cours);
            }
        }
    }

}
