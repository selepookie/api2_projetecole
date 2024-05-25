package MVC.Controller;

import MVC.Model.DAOClasse;
import MVC.View.ClasseAbstractView;
import metier.Classe;
import metier.ListeEnseignantsHeures;

import java.util.List;

public class ClasseController {
    private DAOClasse model;
    private ClasseAbstractView view;

    public ClasseController(DAOClasse model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Classe> getAll(){
        return model.getClasses();
    }
    public Classe addClasse(Classe classe) {
        return  model.addClasse(classe);
    }

    public boolean removeClasse(Classe cl) {
        return model.removeClasse(cl);
    }

    public Classe update(Classe classe) {
        return model.updateClasse(classe);

    }

    public Classe search(int idClasse) {
        return  model.readClasse(idClasse);
    }
    public int nbreHeuresTot(Classe classe){ return model.nbreHeuresTot(classe);}

    public List<ListeEnseignantsHeures> listeEnsHeures(Classe classe) { return model.listeEnsHeures(classe);}

}
