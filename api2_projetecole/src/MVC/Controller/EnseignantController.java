package MVC.Controller;

import MVC.Model.DAOEnseignant;
import MVC.View.EnseignantAbstractView;
import metier.Enseignant;

import java.util.List;


public class EnseignantController {
    private DAOEnseignant model;
    private EnseignantAbstractView view;

    public EnseignantController(DAOEnseignant model, EnseignantAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Enseignant> getAll(){
        return model.getEnseignants();
    }
    public Enseignant addEnseignant(Enseignant ens) {
        return  model.addEnseignant(ens);
    }

    public boolean removeEnseignant(Enseignant ens) {
        return model.removeEnseignant(ens);
    }

    public Enseignant update(Enseignant ens) {
        return model.updateEnseignant(ens);

    }

    public Enseignant search(int id_enseignant) {
        return  model.readEnseignant(id_enseignant);
    }
}
