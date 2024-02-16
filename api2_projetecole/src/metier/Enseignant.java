package metier;

import java.util.Date;

public class Enseignant {
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected int chargeSem;
    protected double salaireMensu;
    protected Date dateEngag;

    public Enseignant(){}

    public Enseignant(String matricule, String nom, String prenom, String tel, int chargeSem, double salaireMensu, Date dateEngag) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.chargeSem = chargeSem;
        this.salaireMensu = salaireMensu;
        this.dateEngag = dateEngag;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getChargeSem() {
        return chargeSem;
    }

    public void setChargeSem(int chargeSem) {
        this.chargeSem = chargeSem;
    }

    public double getSalaireMensu() {
        return salaireMensu;
    }

    public void setSalaireMensu(double salaireMensu) {
        this.salaireMensu = salaireMensu;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }
}
