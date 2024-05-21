package MVC.Model;

import MVC.Observer.Subject;
import metier.Classe;
import metier.Enseignant;

import java.util.List;

public abstract class DAOEnseignant extends Subject {
    public abstract Enseignant addEnseignant(Enseignant enseignant);
    public abstract boolean removeEnseignant(Enseignant enseignant);
    public abstract Enseignant updateEnseignant(Enseignant enseignant);
    public abstract Enseignant readEnseignant(int id_enseignant);

    public abstract List<Enseignant> getEnseignants();

}
