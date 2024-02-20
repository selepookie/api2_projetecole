package metier;

import java.util.Date;

/**
 * classe métier de gestion d'un enseignant
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Enseignant {
    /**
     * matricule de l'enseignant
     */
    protected String matricule;
    /**
     * nom de l'enseignant
     */
    protected String nom;
    /**
     * prénom de l'enseignant
     */
    protected String prenom;
    /**
     * numéro de téléphone de l'enseignant
     */
    protected String tel;
    /**
     * charge sem de l'enseignant
     */
    protected int chargeSem;
    /**
     * salaire mensuel de l'enseignant
     */
    protected double salaireMensu;
    /**
     * date d'engagement de l'enseignant
     */
    protected Date dateEngag;
    /**
     * constructeur par défaut
     */
    public Enseignant(){}
    /**
     * constructeur paramétré
     * @param matricule matricule de l'enseignant
     * @param nom nom de l'enseignant
     * @param prenom prenom de l'enseignant
     * @param tel numéro de téléphone de l'enseignant
     * @param chargeSem charge sem de l'enseignant
     * @param salaireMensu salaire mensuel de l'enseignant
     * @param dateEngag date d'engagement de l'enseignant
     */
    public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, double salaireMensu, Date dateEngag) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
    }
    /**
     * getter matricule
     * @return matricule actuel
     */
    public String getMatricule() {
        return matricule;
    }
    /**
     * setter matricule
     * @param matricule nouveau matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    /**
     * getter nom
     * @return nom actuel de l'enseignant
     */
    public String getNom() {
        return nom;
    }
    /**
     * setter nom
     * @param nom nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * getter prénom
     * @return prénom actuel de l'enseignant
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * setter prenom
     * @param prenom nouveau prénom de l'enseignant
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * getter tel
     * @return telephone actuel de l'enseignant
     */
    public String getTel() {
        return tel;
    }
    /**
     * setter tel
     * @param tel nouveau téléphone de l'enseignant
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * getter chargeSem
     * @return chargesem actuelle
     */
    public int getChargeSem() {
        return chargeSem;
    }
    /**
     * setter chargeSem
     * @param chargeSem nouvelle chargeSem
     */
    public void setChargeSem(int chargeSem) {
        this.chargeSem = chargeSem;
    }
    /**
     * getter salaireMensu
     * @return salaire mensuel actuel
     */
    public double getSalaireMensu() {
        return salaireMensu;
    }
    /**
     * setter salaireMensu
     * @param salaireMensu nouveau salaire mensuel
     */
    public void setSalaireMensu(double salaireMensu) {
        this.salaireMensu = salaireMensu;
    }
    /**
     * getter dateEngag
     * @return date d'engagement
     */
    public Date getDateEngag() {
        return dateEngag;
    }

    /**
     * setter dateEngag
     * @param dateEngag définit la date d'engagement
     */
    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }
}
