package MVC.View;

import MVC.Controller.CoursController;
import MVC.Observer.Observer;
import metier.Cours;

import java.util.List;

public abstract class CoursAbstractView implements Observer {
    protected CoursController coursController;
    protected List<Cours> lc;
    protected SalleAbstractView sv;
    public void setController(CoursController coursController){
        this.coursController = coursController;
    }

    public abstract void affMsg(String msg);
    public abstract Cours selectionner();

    public abstract void menu();
    public abstract void affList(List lc);

    @Override
    public void update(List lc) {
        this.lc = lc;
    }

    public void setSalleView(SalleAbstractView sv){ this.sv=sv; }
}
