package MVC;

import MVC.Controller.ClasseController;
import MVC.Model.DAOClasse;
import MVC.Model.ModelClasseDB;
import MVC.View.ClasseAbstractView;
import MVC.View.ClasseViewConsole;

import java.util.Arrays;
import java.util.List;

public class GestionProjet {
    private DAOClasse cl;
    private ClasseController cc;
    private ClasseAbstractView cv;

    public void gestion(){
        cl = new ModelClasseDB();
        cv = new ClasseViewConsole();
        cc = new ClasseController(cl,cv);

        cv.menu();
    }

    public static void main(String[] args) {
        GestionProjet gm = new GestionProjet();
        gm.gestion();
    }
}
