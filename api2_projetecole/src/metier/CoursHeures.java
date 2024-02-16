package metier;

public class CoursHeures {
    protected Cours cours;
    protected int NbreHeures;

    public CoursHeures(){}

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public int getNbreHeures() {
        return NbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        NbreHeures = nbreHeures;
    }

    public CoursHeures(Cours cours, int nbreHeures) {
        this.cours = cours;
        NbreHeures = nbreHeures;
    }
}
