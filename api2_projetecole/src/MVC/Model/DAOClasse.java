package MVC.Model;

import MVC.Observer.Subject;
import metier.Classe;

import java.util.List;

public abstract class DAOClasse extends Subject {
    public abstract Classe addClasse(Classe classe);
    public abstract boolean removeClasse(Classe classe);
    public abstract Classe updateClasse(Classe classe);
    public abstract Classe readClasse(int idclasse);

    public abstract List<Classe> getClasses();

}
