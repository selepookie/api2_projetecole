package DesignPatterns.Composite;

import java.util.HashSet;
import java.util.Set;

public class Section extends Element {
    private String nom;
    private Set<Element> elts = new HashSet<>();

    public Section(int id, String nom) {
        super(id);
        this.nom = nom;
    }

    @Override
    public int nbEleves() {
        int nb = 0;
        for (Element e : elts) {
            nb += e.nbEleves();
        }
        return nb;
    }

    @Override
    public String toString() {
        StringBuilder aff = new StringBuilder(getId() + " " + nom + "\n");
        for (Element e : elts) {
            aff.append(e).append("\n");
        }
        return aff.toString() + "Nombre total d'élèves dans " + nom + " = " + nbEleves() + "\n";
    }

    public Set<Element> getElts() {
        return elts;
    }
}