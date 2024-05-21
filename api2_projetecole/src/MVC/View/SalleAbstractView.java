package MVC.View;

import MVC.Controller.SalleController;
import MVC.Observer.Observer;
import metier.Salle;

import java.util.List;

public abstract class SalleAbstractView implements Observer {

    protected SalleController salleController;
    protected List<Salle> lc;

    public void  setController(SalleController salleController){
        this.salleController=salleController;
    }

    public abstract void affMsg(String msg);

    public abstract Salle selectionner();

    public abstract void menu();

    public abstract void affList(List l);
    @Override
    public void update(List l) {

    }
}
