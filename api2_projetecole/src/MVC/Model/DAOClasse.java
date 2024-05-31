package MVC.Model;

import MVC.Observer.Subject;
import metier.*;


import java.util.List;

public abstract class DAOClasse extends Subject {
    public abstract Classe addClasse(Classe classe);
    public abstract boolean removeClasse(Classe classe);
    public abstract Classe updateClasse(Classe classe);
    public abstract Classe readClasse(int idclasse);

    public abstract List<Classe> getClasses();
    public abstract int nbreHeuresTot(Classe classe);
    public abstract List<ListeEnseignantsHeures> listeEnsHeures(Classe classe);
    public abstract List<SalleHeures> listeSalleHeures(Classe classe);
    public abstract List<CoursHeures> listeCoursHeures(Classe classe);
    public abstract boolean salleCapOK(Salle salle, Classe classe);
}
