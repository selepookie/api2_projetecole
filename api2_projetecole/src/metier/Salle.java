package metier;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    protected int id_salle;
    protected String sigle;
    protected int capacite;
    protected List<Cours> cours = new ArrayList<>();

    public Salle(){}

    public Salle(String sigle, int capacite,int id_salle) {
        this.sigle = sigle;
        this.capacite = capacite;
        this.id_salle=id_salle;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }
}
