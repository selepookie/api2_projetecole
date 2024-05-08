package DesignPatterns.Builder;

/**
 * classe métier de gestion des cours et de leurs heures
 * @author Selena D'Urbano
 * @version 1.0
 */
public class CoursHeures {
    /**
     * cours
     */
    protected Cours cours;
    /**
     * nombre d'heures du cours
     */
    protected int NbreHeures;
    /**
     * constructeur par défaut
     */
    public CoursHeures(){}
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
     * getter nbreHeures
     * @return nombre d'heures actuel
     */
    public int getNbreHeures() {
        return NbreHeures;
    }
    /**
     * setter nbreHeures
     * @param nbreHeures
     */
    public void setNbreHeures(int nbreHeures) {
        NbreHeures = nbreHeures;
    }
    /**
     * constructeur paramétré
     * @param nbreHeures nombre d'heures du cours
     * @param cours cours
     */
    public CoursHeures(Cours cours, int nbreHeures) {
        this.cours = cours;
        NbreHeures = nbreHeures;
    }
}
