package metier;

public class Infos {
    protected int id_infos;
    protected int nbreHeures;

    protected Cours cours;
    protected Salle salle;
    protected Enseignant enseignant;

    public Infos(){}

    public Infos(int id_infos, int nbreHeures, Cours cours, Salle salle, Enseignant enseignant) {
        this.id_infos = id_infos;
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.salle = salle;
        this.enseignant = enseignant;
    }

    public Infos(Cours cours, int nbreHeures){
        this.cours=cours;
        this.nbreHeures=nbreHeures;
    }

    public Infos(Cours cours, Enseignant enseignant){
        this.cours = cours;
        this.enseignant = enseignant;
    }

    public Infos(Cours cours, Salle salle){
        this.cours=cours;
        this.salle=salle;
    }

    public Infos(Cours cours){
        this.cours=cours;
    }

    public int getId_infos() {
        return id_infos;
    }

    public void setId_infos(int id_infos) {
        this.id_infos = id_infos;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }
}
