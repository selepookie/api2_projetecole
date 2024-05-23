package MVC.Model;

import MVC.Observer.Subject;
import metier.Salle;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class  DAOSalle extends Subject {
    public abstract Salle addSalle(Salle salle);

    public abstract boolean removeSalle(Salle salle);

    public abstract Salle updateSalle(Salle salle);

    public abstract Salle readSalle(int id_salle);

    public abstract List<Salle> getSalles();
}
