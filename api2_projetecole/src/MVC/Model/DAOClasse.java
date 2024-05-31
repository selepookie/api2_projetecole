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
    public abstract boolean salleCapOK(Classe classe);
    public abstract boolean addCours(Classe classe);
    public abstract boolean modifCoursSalle(Classe classe, Cours cours, Salle salle);
    public abstract boolean modifCoursHeures(Classe classe, Cours cours, int nb);
    public abstract boolean modifCoursEns(Classe classe, Cours cours, Enseignant ens);
}
