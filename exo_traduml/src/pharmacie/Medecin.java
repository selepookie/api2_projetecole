package pharmacie;

import java.util.ArrayList;
import java.util.List;

public class Medecin {

    private int id;

    private String matricule;

    private String nom;

    private String prenom;

    private String tel;

    private List<Prescription> liste_prescriptions = new ArrayList<>();

    public Medecin(){}

    public Medecin(int id, String matricule, String nom, String prenom, String tel){
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Prescription> getListe_prescriptions() {
        return liste_prescriptions;
    }

    public void setListe_prescriptions(List<Prescription> liste_prescriptions) {
        this.liste_prescriptions = liste_prescriptions;
    }



}
