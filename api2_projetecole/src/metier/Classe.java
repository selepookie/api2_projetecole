package metier;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    protected int id_classe;
    protected String sigle;
    protected int annee;
    protected String specialite;
    protected int nbreEleves;
    protected List<Infos> infos;


    public Classe(){}

    public Classe(int id_classe, String sigle, int annee, String specialite, int nbreEleves) {
        this.id_classe = id_classe;
        this.sigle = sigle;
        this.annee = annee;
        this.specialite = specialite;
        this.nbreEleves = nbreEleves;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public List<Infos> getInfos() {
        return infos;
    }

    public void setInfos(List<Infos> infos) {
        this.infos = infos;
    }

    // methodes

    public void nbreHeuresTot(){
        int total_heures=0;
        for(Infos infos : infos){
            total_heures+=infos.getNbreHeures();
        }
        System.out.println("Total des heures de la classe "+sigle+" : "+total_heures);
    }

    // retourner chaque enseignant et ses heures qu'il a avec cette classe
    public void listeEnseignantsEtHeures(){
        int total_heures=0;
        int i=0;
        for(Infos infos : infos){
            for(){

            }
        }
    }

    public void listeSalleetHeures(){

    }

    public void listeCoursetHeures(){

    }

    // est ce qu'une salle peut accueillir une classe ? par rapport a nbeleves et capacité.
    // vrai si elle peut faux si elle peut pas
    public boolean salleCapaciteOK(Salle salle){
        boolean ok=true;

        return ok;
    }

    public void addCours(Infos nbreHeures, Infos cours){ // heure et cours seulement

    }

    // faire les 3 methodes modifCours (une cours,enseignant. une cours,salle. une cours,heures.

    public void suppCours(Infos cours){

    }




}
