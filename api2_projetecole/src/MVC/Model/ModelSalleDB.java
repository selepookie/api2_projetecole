package MVC.Model;

import metier.Salle;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelSalleDB extends DAOSalle{
    protected Connection dbConnect;

    public ModelSalleDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

    }

    @Override
    public Salle addSalle(Salle salle) {
        String query1 = "insert into API_SALLE(sigle,capacite) values(?,?,?,?,?)";
        String query2 = "select id_salle from APIPRODUIT where sigle= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,salle.getSigle());
            pstm1.setInt(2,salle.getCapacite());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1,salle.getSigle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int id_salle= rs.getInt(1);
                    salle.setId_salle(id_salle);
                    notifyObservers();
                    return salle;
                }
                else {

                    System.err.println("record introuvable");
                    return null;
                }
            }
            else return null;

        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean removeSalle(Salle salle) {
        String query = "delete from API_SALLE where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,salle.getId_salle());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }
    }

    @Override
    public Salle updateSalle(Salle salle) {
        String query = "update API_SALLE set sigle =?,capacite=?where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,salle.getSigle());
            pstm.setInt(2,salle.getCapacite());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readSalle(salle.getId_salle());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Salle readSalle(int id_salle) {
        String query = "select * from API_SALLE where id_salle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_salle);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                int capacite = rs.getInt(3);
                Salle sl = new Salle(id_salle,sigle,capacite);
                return sl;

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }


    @Override
    public List<Salle> getSalles() {
        List<Salle> ls = new ArrayList<>();
        String query="select * from API_SALLE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_salle = rs.getInt(1);
                String sigle = rs.getString(2);
                int capacite = rs.getInt(3);
                Salle sl = new Salle(id_salle,sigle,capacite);
                ls.add(sl);
            }
            return ls;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List getNotification() {
        return getSalles();
    }
}
