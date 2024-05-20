package DesignPatterns.Composite;

import java.util.HashSet;
import java.util.Set;

public class Section extends Element{
    String nom;
    private Set<Element> elts = new HashSet<>();

    public Section(){}

    @Override
    public int nbEleves() {
        int nb=0;
        for(Element e:elts){
            nb+=e.nbEleves();
        }
        return nb;
    }

    public Section(int id, String nom){
        super(id);
        this.nom=nom;
    }

    @Override
    public String toString() {
        StringBuilder aff= new StringBuilder(getId()+" "+nom+"\n");

        for(Element e:elts){
            aff.append(e+"\n");
        }
        return aff+"nombre total d'élèves " +nom +" = "+nbEleves()+"\n";

    }

    public Set<Element> getElts() { return elts; }
}
