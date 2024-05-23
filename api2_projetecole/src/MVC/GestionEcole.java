package MVC;

import MVC.Controller.ClasseController;
import MVC.Controller.CoursController;
import MVC.Controller.EnseignantController;
import MVC.Controller.SalleController;
import MVC.Model.*;
import MVC.View.*;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestionEcole {
    private DAOClasse clm;
    private DAOCours com;
    private DAOEnseignant em;
    private DAOSalle sm;
    private ClasseController cc;
    private CoursController coc;
    private EnseignantController ec;
    private SalleController sc;
    private ClasseAbstractView cv;
    private CoursAbstractView cov;
    private EnseignantAbstractView ev;
    private SalleAbstractView sv;


    public void gestion(){
        //cm = new ClientModelDB();
        clm = new ModelClasseDB();
        com = new ModelCoursDB();
        em=new ModelEnseignantDB();
        sm = new ModelSalleDB();

        cv = new ClasseViewConsole();
        cov = new CoursViewConsole();
        ev = new EnseignantViewConsole();
        sv =  new SalleViewConsole();

        cc = new ClasseController(clm,cv);//création et injection de dépendance
        coc = new CoursController(com,cov);
        ec = new EnseignantController(em,ev);
        sc = new SalleController(sm,sv);

        clm.addObserver(cv);
        com.addObserver(cov);
        em.addObserver(ev);
        sm.addObserver(sv);

        List<String> loptions = Arrays.asList("classe","cours","enseignant","salle","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: cv.menu();
                    break;
                case 2 : cov.menu();
                    break;
                case 3: ev.menu();
                    break;
                case 4: sv.menu();
                    break;
                case 5: System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestionEcole ge = new GestionEcole();
        ge.gestion();
    }
}
