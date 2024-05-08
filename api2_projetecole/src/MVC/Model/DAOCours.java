package MVC.Model;

import MVC.Observer.Subject;
import metier.Cours;

import java.util.List;

public abstract class DAOCours extends Subject {
    public abstract Cours addCours(Cours cours);
    public abstract boolean removeCours(Cours cours);
    public abstract Cours updateCours(Cours cours);
    public abstract Cours readCours(int idcours);

    public abstract List<Cours> getCours();
}
