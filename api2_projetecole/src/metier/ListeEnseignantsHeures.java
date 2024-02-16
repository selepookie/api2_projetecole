package metier;

import java.util.List;

public class ListeEnseignantsHeures {
        private Enseignant enseignant;

        private int nbreHeures;

        public ListeEnseignantsHeures(Enseignant enseignant, int nbreHeures) {
            this.enseignant = enseignant;
            this.nbreHeures = nbreHeures;
        }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }
}
