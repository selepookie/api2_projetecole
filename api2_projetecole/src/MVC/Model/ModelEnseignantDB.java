package MVC.Model;

import metier.Cours;
import metier.Enseignant;
import metier.Salle;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ModelEnseignantDB extends DAOEnseignant {
    protected Connection dbConnect;

    public ModelEnseignantDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Enseignant addEnseignant(Enseignant enseignant) {
        String query1 = "insert into API_ENSEIGNANT(matricule, nom, prenom,tel,chargeSem, salairemensu,dateengag) values(?,?,?,?,?,?,?)";
        String query2 = "select id_enseignant from API_ENSEIGNANT where matricule= ? and nom =? and prenom =?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,enseignant.getMatricule());
            pstm1.setString(2,enseignant.getNom());
            pstm1.setString(3,enseignant.getPrenom());
            pstm1.setString(4,enseignant.getTel());
            pstm1.setInt(5,enseignant.getChargeSem());
            pstm1.setDouble(6,enseignant.getSalaireMensu());
            // j'ai regardé sur internet pour la date car je galerais un peu !! j'ai trouvé sur le forum stackoverflow
            LocalDate date = enseignant.getDateEngag();
            java.sql.Date datee = java.sql.Date.valueOf(date);
            pstm1.setDate(7, datee);
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1,enseignant.getMatricule());
                pstm2.setString(2,enseignant.getNom());
                pstm2.setString(3,enseignant.getPrenom());
                pstm2.setString(4,enseignant.getTel());
                pstm2.setInt(5,enseignant.getChargeSem());
                pstm2.setDouble(6,enseignant.getSalaireMensu());
                pstm2.setDate(7, datee);
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int id_enseignant= rs.getInt(1);
                    enseignant.setId_enseignant(id_enseignant);
                    notifyObservers();
                    return enseignant;
                }
                else {

                    System.err.println("record introuvable");
                    return null;
                }
            }
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public boolean removeEnseignant(Enseignant enseignant) {
        String query = "delete from API_ENSEIGNANT where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,enseignant.getId_enseignant());
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
    public Enseignant updateEnseignant(Enseignant enseignant) {
        String query = "update API_ENSEIGNANT set matricule =?,nom=?,prenom=?, tel=?, chargeSem=?, salaireMensu = ?, dateEngag= ? where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,enseignant.getMatricule());
            pstm.setString(2,enseignant.getNom());
            pstm.setString(3,enseignant.getPrenom());
            pstm.setString(4,enseignant.getTel());
            pstm.setInt(5,enseignant.getChargeSem());
            pstm.setDouble(6,enseignant.getSalaireMensu());
            LocalDate date = enseignant.getDateEngag();
            java.sql.Date datee = java.sql.Date.valueOf(date);
            pstm.setDate(7, datee);
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readEnseignant(enseignant.getId_enseignant());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Enseignant readEnseignant(int id_enseignant) {
        String query = "select * from API_ENSEIGNANT where id_enseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_enseignant);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                int chargeSem = rs.getInt(6);
                double salairemensu = rs.getDouble(7);
                LocalDate dateengag = rs.getDate(8).toLocalDate();
                Enseignant ens = new Enseignant(id_enseignant, matricule, nom, prenom, tel, chargeSem, salairemensu, dateengag);
                return  ens;

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
    public List<Enseignant> getEnseignants() {
        List<Enseignant> lc = new ArrayList<>();
        String query="select * from API_ENSEIGNANT";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_enseignant = rs.getInt(1);
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                int chargeSem = rs.getInt(6);
                double salairemensu = rs.getDouble(7);
                LocalDate dateengag = rs.getDate(8).toLocalDate();

                Enseignant ens = new Enseignant(id_enseignant, matricule, nom, prenom, tel, chargeSem, salairemensu, dateengag);
                lc.add(ens);
            }
            return lc;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List getNotification() {
        return getEnseignants();
    }
}
