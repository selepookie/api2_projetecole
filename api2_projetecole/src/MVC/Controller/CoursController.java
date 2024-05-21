package MVC.Controller;

import MVC.Model.DAOCours;
import MVC.View.CoursAbstractView;
import metier.Cours;

import java.util.List;

public class CoursController {
    private DAOCours model;
    private CoursAbstractView view;

    public CoursController(DAOCours model, CoursAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Cours> getAll(){
        return model.getCours();
    }
    public Cours addCours(Cours cours) {
        return  model.addCours(cours);
    }

    public boolean removeCours(Cours cours) {
        return model.removeCours(cours);
    }

    public Cours update(Cours cours) {
        return model.updateCours(cours);
    }

    public Cours search(int idCours) {
        return model.readCours(idCours);
    }

}