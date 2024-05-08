package MVC.View;

import MVC.Controller.ClasseController;
import MVC.Observer.Observer;
import metier.Classe;

import java.util.List;

public abstract class ClasseAbstractView implements Observer {
    protected ClasseController classeController;
    protected List<Classe> lc;
    public void setController(ClasseController classeController){
        this.classeController = classeController;
    }

    public abstract void affMsg(String msg);
    public abstract Class selectionner();

    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}
