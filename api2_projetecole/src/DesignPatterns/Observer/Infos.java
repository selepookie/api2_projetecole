package DesignPatterns.Observer;

public class Infos {
    /**
     * classe métier de gestion des infos relatives aux cours
     * @author Selena D'Urbano
     * @version 1.0
     */
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i=1;
    /**
     * id des informations
     */
    protected int id_infos;
    /**
     * nombre d'heures
     */
    protected int nbreHeures;
    /**
     * cours
     */
    protected Cours cours;
    /**
     * salle
     */
    protected Salle salle;
    /**
     * enseignant
     */
    protected Enseignant enseignant;
    /**
     * constructeur par défaut
     */
    public Infos(){}
    /**
     * constructeur paramétré
     * @param id_infos id des informations
     * @param cours cours
     * @param salle enseignant
     * @param enseignant enseignant
     */
    public Infos(int id_infos, int nbreHeures, Cours cours, Salle salle, Enseignant enseignant) {
        this.id_infos = i++;
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.salle = salle;
        this.enseignant = enseignant;
    }
    /**
     * constructeur paramétré
     * @param cours cours
     * @param nbreHeures nombre d'heures
     */
    public Infos(Cours cours, int nbreHeures){
        this.cours=cours;
        this.nbreHeures=nbreHeures;
    }
    /**
     * constructeur paramétré
     * @param cours cours
     * @param enseignant enseignant
     */
    public Infos(Cours cours, Enseignant enseignant){
        this.cours = cours;
        this.enseignant = enseignant;
    }
    /**
     * constructeur paramétré
     * @param cours cours
     * @param salle salle
     */
    public Infos(Cours cours, Salle salle){
        this.cours=cours;
        this.salle=salle;
    }
    /**
     * constructeur paramétré
     * @param cours cours
     */
    public Infos(Cours cours){
        this.cours=cours;
    }

    /**
     * getter id_infos
     * @return id des informations
     */
    public int getId_infos() {
        return id_infos;
    }
    /**
     * setter id_infos
     * @param id_infos nouvel id des informations
     */
    public void setId_infos(int id_infos) {
        this.id_infos = id_infos;
    }
    /**
     * getter nbreHeures
     * @return nombre d'heures actuels
     */
    public int getNbreHeures() {
        return nbreHeures;
    }
    /**
     * setter nbreHeures
     * @param nbreHeures nouveau nombre d'heures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }
    /**
     * getter cours
     * @return cours actuel
     */
    public Cours getCours() {
        return cours;
    }
    /**
     * setter cours
     * @param cours nouveau cours
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }
    /**
     * getter salle
     * @return salle actuelle
     */
    public Salle getSalle() {
        return salle;
    }
    /**
     * setter salle
     * @param salle nouvelle salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    /**
     * getter enseignant
     * @return enseignant actuel
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }
    /**
     * setter enseignant
     * @param enseignant nouvel enseignant
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
