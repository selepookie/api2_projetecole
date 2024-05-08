package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;
/**
 * classe métier de gestion d'une salle de cours
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Salle {
    /**
     * compteur qui auto incrémente l'identifiant
     */
    protected static int i=1;
    /**
     * identifiant unique de la salle
     */
    protected int id_salle;
    /**
     * sigle de la classe
     */
    protected String sigle;
    /**
     * capacité de la salle
     */
    protected int capacite;
    /**
     * liste des cours ayant lieu dans cette salle
     */
    protected List<Cours> cours = new ArrayList<>();
    /**
     * constructeur par défaut
     */
    public Salle(){}
    /**
     * constructeur paramétré
     * @param sigle sigle
     * @param capacite capacité de la salle
     * @param id_salle identifiant unique de la salle auto-incrémenté par i
     */
    public Salle(String sigle, int capacite, int id_salle) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.id_salle=i++;
    }
    /**
     * getter sigle
     * @return sigle actuel de la salle
     */
    public String getSigle() {
        return sigle;
    }
    /**
     * setter sigle
     * @param sigle nouveau sigle de la salle
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }
    /**
     * getter capacite
     * @return capacité actuelle de la salle
     */
    public int getCapacite() {
        return capacite;
    }
    /**
     * setter capacite
     * @param capacite nouvelle capacité de la salle
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    /**
     * getter cours
     * @return liste des cours ayant lieu dans cette salle
     */
    public List<Cours> getCours() {
        return cours;
    }
    /**
     * setter cours
     * @param cours nouvelle liste de cours
     */
    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }
    /**
     * getter id_salle
     * @return identifiant unique de la salle
     */
    public int getId_salle() {
        return id_salle;
    }
    /**
     * setter id_salle
     * @param id_salle nouvel identifiant unique de la salle
     */
    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public List<Cours> coursSalleDefaut(){
        List<Cours> listecours = new ArrayList<>();
        int i=0;
        for(Cours cours : cours){
            if(cours.getSalle().equals(this)){
                listecours.add(cours);
            }
            i++;
        }
        return listecours;
    }
}
