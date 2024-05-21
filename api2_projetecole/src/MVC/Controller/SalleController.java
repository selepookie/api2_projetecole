package MVC.Controller;


import MVC.Model.DAOSalle;
import MVC.View.SalleAbstractView;
import metier.Salle;

import java.util.List;

public class SalleController {
    private DAOSalle model;
    private SalleAbstractView view;

    public SalleController(DAOSalle model, SalleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Salle> getAll(){
        return model.getSalles();
    }
    public Salle addSalle(Salle salle) {
        return  model.addSalle(salle);
    }

    public boolean removeSalle(Salle salle) {
        return model.removeSalle(salle);
    }

    public Salle updateSalle(Salle salle) {
        return model.updateSalle(salle);
    }

    public Salle search(int id_salle) {
        return model.readSalle(id_salle);
    }
}
