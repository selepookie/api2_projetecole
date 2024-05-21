package MVC.Model;

import MVC.Observer.Subject;
import metier.Salle;

import java.util.List;

public abstract class  DAOSalle extends Subject {
    public abstract Salle addSalle(Salle salle);

    public abstract boolean removeSalle(Salle salle);

    public abstract Salle updateSalle(Salle salle);

    public static Salle readSalle(int id_salle) {
        return null;
    }

    public abstract List<Salle> getSalles();
}