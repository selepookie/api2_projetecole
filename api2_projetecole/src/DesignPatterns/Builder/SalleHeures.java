package DesignPatterns.Builder;

/**
 * classe métier de gestion des salles et de leurs heures
 * @author Selena D'Urbano
 * @version 1.0
 */
public class SalleHeures {
    /**
     * salle
     */
    protected Salle salle;
    /**
     * nombre d'heures de la salle
     */
    protected int nbreHeures;
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
     * getter nbreHeures
     * @return nombre d'heures de la salle
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
     * constructeur paramétré
     * @param salle salle
     * @param nbreHeures nombre d'heures de la salle
     */
    public SalleHeures(Salle salle, int nbreHeures) {
        this.salle = salle;
        this.nbreHeures = nbreHeures;
    }
    /**
     * constructeur par défaut
     */
    public SalleHeures(){}
}
