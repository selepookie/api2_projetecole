package MVC.View;

import MVC.Controller.ClasseController;
import MVC.Controller.CoursController;
import MVC.Controller.EnseignantController;
import MVC.Controller.SalleController;
import MVC.Observer.Observer;
import metier.Classe;

import java.util.List;

public abstract class ClasseAbstractView implements Observer {
    protected ClasseController classeController;
    protected List<Classe> lc;
    protected CoursAbstractView cv;
    protected SalleAbstractView sv;
    protected EnseignantAbstractView ev;
    public void setController(ClasseController classeController){
        this.classeController = classeController;
    }



    public abstract void affMsg(String msg);
    public abstract Classe selectionner();

    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
    }

    public void setCoursView(CoursAbstractView cv) { this.cv = cv;}
    public void setEnseignantView(EnseignantAbstractView ev) { this.ev = ev;}
    public void setSalleView(SalleAbstractView sv) { this.sv = sv;}
}