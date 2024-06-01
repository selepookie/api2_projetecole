package DesignPatterns.Composite;

import metier.Salle;

/**
 * classe métier de gestion d'un cours
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Cours {
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i=1;
    /**
     * identifiant unique du cours
     */
    protected int id_cours;
    /**
     * code du cours
     */
    protected String code;
    /**
     * intitule du cours
     */
    protected String intitule;
    /**
     * salle du cours
     */
    protected metier.Salle salle;
    /**
     * constructeur par défaut
     */
    public Cours(){}
    /**
     * constructeur paramétré
     * @param code code du cours
     * @param intitule intitule du cours
     * @param salle salle du cours
     * @param id_cours identifiant unique du cours auto-incrémenté par le i
     */
    public Cours(int id_cours, String code, String intitule, metier.Salle salle) {
        this.code = code;
        this.intitule = intitule;
        this.salle=salle;
        this.id_cours=i++;
    }
    public Cours(String code, String intitule, metier.Salle salle){
        this.code = code;
        this.intitule = intitule;
        this.salle = salle;
    }
    /**
     * getter code
     * @return code actuel du cours
     */
    public String getCode() {
        return code;
    }
    /**
     * setter du cours
     * @param code nouveau code du cours
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * getter intitule
     * @return intitule actuel du cours
     */
    public String getIntitule() {
        return intitule;
    }
    /**
     * setter intitule
     * @param intitule nouvel intitule du cours
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    /**
     * getter salle
     * @return salle actuelle
     */
    public metier.Salle getSalle() {
        return salle;
    }
    /**
     * setter salle
     * @param salle nouvelle salle du cours
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    /**
     * getter id_cours
     * @return id actuel du cours
     */
    public int getId_cours() {
        return id_cours;
    }
    /**
     * setter id_cours
     * @param id_cours nouvel id du cours
     */
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "id_cours=" + id_cours +
                ", code='" + code + '\'' +
                ", intitule='" + intitule + '\'' +
                ", salle=" + salle +
                '}';
    }
}
