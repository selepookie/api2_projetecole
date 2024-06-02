package MVC.Model;

import metier.Cours;
import metier.Salle;
import myconnections.DBConnection;

import javax.swing.plaf.nimbus.State;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelCoursDB extends DAOCours {
    protected Connection dbConnect;
    private DAOSalle daoSalle;

    public ModelCoursDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
        daoSalle = new ModelSalleDB();
    }

    @Override
    public Cours addCours(Cours cours) {
        String query1 = "insert into API_COURS(code, intitule, id_salle) values(?,?,?)";
        String query2 = "select id_cours from API_cours where code= ? and intitule =? and id_salle =?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, cours.getCode());
            pstm1.setString(2, cours.getIntitule());
            pstm1.setInt(3, cours.getSalle().getId_salle());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, cours.getCode());
                pstm2.setString(2, cours.getIntitule());
                pstm2.setInt(3, cours.getSalle().getId_salle());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int id_cours = rs.getInt(1);
                    cours.setId_cours(id_cours);
                    notifyObservers();
                    return cours;
                } else {

                    System.err.println("record introuvable");
                    return null;
                }
            } else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public boolean removeCours(Cours cours) {
        String query = "delete from API_COURS where id_cours = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, cours.getId_cours());
            int n = pstm.executeUpdate();
            notifyObservers();
            if (n != 0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return false;
        }
    }

    @Override
    public Cours updateCours(Cours cours) {
        String query = "update API_COURS set code =?,intitule=?,id_salle=? where id_cours = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, cours.getCode());
            pstm.setString(2, cours.getIntitule());
            pstm.setInt(3, cours.getSalle().getId_salle());
            pstm.setInt(4,cours.getId_cours());
            int n = pstm.executeUpdate();
            notifyObservers();
            if (n != 0) return readCours(cours.getId_cours());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Cours readCours(int id_cours) {
        String query = "SELECT * FROM API_COURS WHERE id_cours = ?";
        String query2 = "SELECT * FROM API_SALLE WHERE id_salle = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id_cours);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String code = rs.getString(2);
                String intitule = rs.getString(3);
                int id_salle = rs.getInt(4);
                String sigle = null;
                int capacite = 0;

                try (PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
                    pstm2.setInt(1, id_salle);
                    ResultSet rs2 = pstm2.executeQuery();
                    if (rs2.next()) {
                        sigle = rs2.getString(2);
                        capacite = rs2.getInt(3);
                    }
                } catch (SQLException e) {
                    System.err.println("erreur sql " + e.getMessage());
                    return null;
                }
                Salle salle = new Salle(id_salle, sigle, capacite);
                Cours cours = new Cours(id_cours, code, intitule, salle);
                return cours;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erreur$ " + e.getMessage());
            return null;
        }
    }

    // Séraphin m'a aidé pour cette méthode (pour récupérer la salle uniquement car j'avais du mal, je m'en suis servie a d'autres endroits)
    @Override
    public List<Cours> getCours() {
        List<Cours> lc = new ArrayList<>();
        String query = "select * from API_COURS";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int id_cours = rs.getInt(1);
                String code = rs.getString("code");
                String intitule = rs.getString("intitule");
                int id_salle = rs.getInt("id_salle");
                Salle salle = daoSalle.readSalle(id_salle);
                Cours cl = new Cours(id_cours, code, intitule, salle);
                lc.add(cl);
            }
            return lc;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }


    @Override
    public List getNotification() {
        return getCours();
    }

}