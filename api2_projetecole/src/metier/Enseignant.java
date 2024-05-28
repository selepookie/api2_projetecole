package metier;

import java.time.LocalDate;
import java.util.Date;

/**
 * classe métier de gestion d'un enseignant
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Enseignant {
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i=1;
    /**
     * identifiant unique de l'enseignant
     */
    protected int id_enseignant;
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
    protected LocalDate dateEngag;
    /**
     * constructeur par défaut
     */
    public Enseignant(){}
    /**
     * constructeur paramétré
     * @param id_enseignant identifiant unique de l'enseignant auto incrémenté par iUNIQ
     * @param matricule matricule de l'enseignant
     * @param nom nom de l'enseignant
     * @param prenom prenom de l'enseignant
     * @param tel numéro de téléphone de l'enseignant
     * @param chargeSem charge sem de l'enseignant
     * @param salaireMensu salaire mensuel de l'enseignant
     * @param dateEngag date d'engagement de l'enseignant
     */
    public Enseignant(int id_enseignant,String matricule, String nom, String prenom, String tel, int chargeSem, double salaireMensu, LocalDate dateEngag) {
        this.id_enseignant = id_enseignant;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
    }
    /**
     * getter id_enseignant
     * @return identifiant unique de l'enseignant
     */
    public int getId_enseignant() {
        return id_enseignant;
    }
    /**
     * setter id_enseignant
     * @param id_enseignant nouvel identifiant de l'enseignant
     */
    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
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
    public LocalDate getDateEngag() {
        return dateEngag;
    }

    /**
     * setter dateEngag
     * @param dateEngag définit la date d'engagement
     */
    public void setDateEngag(LocalDate dateEngag) {
        this.dateEngag = dateEngag;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id_enseignant=" + id_enseignant +
                ", matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", chargeSem=" + chargeSem +
                ", salaireMensu=" + salaireMensu +
                ", dateEngag=" + dateEngag +
                '}';
    }
}
