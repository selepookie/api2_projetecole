package pharmacie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {

    private int id;

    private String nss;

    private String nom;

    private String prenom;

    private Date dateNaissance;

    private List<Prescription> liste_prescriptions = new ArrayList<>();

    public Patient(){}

    public Patient(int id, String nss, String nom, String prenom, Date dateNaissance){
        this.id=id;
        this.nss=nss;
        this.nom=nom;
        this.prenom = prenom;
        this.dateNaissance=dateNaissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Prescription> getListe_prescriptions() {
        return liste_prescriptions;
    }

    public void setListe_prescriptions(List<Prescription> liste_prescriptions) {
        this.liste_prescriptions = liste_prescriptions;
    }
}
