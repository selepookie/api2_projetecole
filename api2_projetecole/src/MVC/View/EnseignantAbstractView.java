package MVC.View;
import MVC.Controller.EnseignantController;
import MVC.Observer.Observer;
import metier.Enseignant;

import java.util.List;

public abstract class EnseignantAbstractView  implements Observer {
    protected EnseignantController enseignantController;
    protected List<Enseignant> lc;
    public void setController(EnseignantController enseignantController){
        this.enseignantController = enseignantController;
    }

    public abstract void affMsg(String msg);
    public abstract Enseignant selectionner();

    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }

}