package DesignPatterns.Observer;

/**
 * classe métier de gestion des enseignants et de leurs heures
 * @author Selena D'Urbano
 * @version 1.0
 */
public class ListeEnseignantsHeures {
    /**
     * enseignant
     */
        private Enseignant enseignant;
    /**
     * nombre d'heures
     */
        private int nbreHeures;
    /**
     * constructeur paramétré
     * @param enseignant enseignant
     * @param nbreHeures nombre d'heures
     */
        public ListeEnseignantsHeures(Enseignant enseignant, int nbreHeures) {
            this.enseignant = enseignant;
            this.nbreHeures = nbreHeures;
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
    /**
     * getter nbreHeures
     * @return nombre d'heures actuelles
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
}
