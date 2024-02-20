package metier;

/**
 * classe métier de gestion d'un cours
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Cours {
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

    protected Salle salle;
    /**
     * constructeur par défaut
     */

    public Cours(){}
    /**
     * constructeur paramétré
     * @param code code du cours
     * @param intitule intitule du cours
     * @param salle salle du cours
     */

    public Cours(String code, String intitule,Salle salle) {
        this.code = code;
        this.intitule = intitule;
        this.salle=salle;
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

    public Salle getSalle() {
        return salle;
    }
    /**
     * setter salle
     * @param salle nouvelle salle du cours
     */

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
