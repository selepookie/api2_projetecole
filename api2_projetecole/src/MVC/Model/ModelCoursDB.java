package MVC.Model;

import metier.Cours;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelCoursDB extends DAOCours{
    protected Connection dbConnect;

    public ModelCoursDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Cours addCours(Cours cours) {
        String query1 = "insert into API_COURS(code, intitule, salle) values(?,?,?,?,?,?,?)";
        String query2 = "select id_cours from API_cours where code= ? and intitule =? and salle =?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,cours.getCode());
            pstm1.setString(2,cours.getIntitule());
            pstm1.setInt(3,cours.getSalle().getId_salle());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1,cours.getCode());
                pstm2.setString(2,cours.getIntitule());
                pstm2.setString(3,cours.getSalle().getId_salle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int id_cours= rs.getInt(1);
                    cours.setId_cours(id_cours);
                    notifyObservers();
                    return cours;
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
    public boolean removeCours(Cours cours) {
        String query = "delete from API_COURS where id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,cours.getId_cours());
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
    public Cours updateCours(Cours cours) {
        String query = "update API_COURS set code =?,intitule=?,salle=? where id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,cours.getCode());
            pstm.setString(2,cours.getIntitule());
            pstm.setInt(3,cours.getSalle().getId_salle());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readCours(cours.getId_cours());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Cours readCours(int id_cours) {
        String query = "select * from API_COURS where id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_cours);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String code = rs.getString(2);
                String intitule = rs.getString(3);
                int id_salle = rs.getInt(4);
                Cours cl = new Cours(id_cours, code, intitule, id_salle);
                return  cl;

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
    public List<Cours> getCours() {
        List<Cours> lc = new ArrayList<>();
        String query="select * from API_COURS";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_cours = rs.getInt(1);
                String code = rs.getString(2);
                String intitule = rs.getString(3);
                int id_salle = rs.getInt(4);
                Cours cl = new Cours(id_cours,code, intitule, id_salle);
                lc.add(cl);
            }
            return lc;
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }
    @Override
    public List<ComFact>  factPayees(Cours Cours) {
        String query = "select * from APICOMFACT where idCours = ? AND  DATEPAYEMENT IS NOT NULL order by IDCOMMANDE ";
        return rechercheCommandes(Cours,query);
    }
    @Override
    public List<ComFact> factRetard(Cours Cours) {
        String query = "select * from APICOMFACT where idCours = ?  AND  DATEPAYEMENT IS NULL AND DATEFACTURATION + 30 < SYSDATE order by IDCOMMANDE";
        return rechercheCommandes(Cours,query);
    }

    @Override
    public List<ComFact> factNonPayees(Cours Cours) {
        String query = "select * from APICOMFACT where idCours = ? AND DATEFACTURATION IS NOT NULL AND DATEPAYEMENT IS NULL order by IDCOMMANDE ";
        return rechercheCommandes(Cours,query);
    }


    @Override
    public List<ComFact> commandes(Cours Cours) {

        String query = "select * from APICOMFACT where idCours = ? order by IDCOMMANDE";
        return rechercheCommandes(Cours,query);
    }
    private List<ComFact> rechercheCommandes(Cours Cours,String query){
        List<ComFact>lcf = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,Cours.getIdCours());
            ResultSet rs = pstm.executeQuery();
            boolean trouve= false;
            while(rs.next()){
                trouve=true;
                int nc = rs.getInt(1);
                Integer nf = rs.getInt(2);//permet d'éviter une erreur si n° de facture nul
                LocalDate dateCom = rs.getDate(3)==null? null: rs.getDate(3).toLocalDate();
                LocalDate dateFact = rs.getDate(4)==null? null: rs.getDate(3).toLocalDate();
                LocalDate datePay= rs.getDate(5)==null? null: rs.getDate(3).toLocalDate();
                BigDecimal montant = rs.getBigDecimal(6);
                char etat = rs.getString(7).charAt(0);
                ComFact cf = new ComFact(nc,nf,dateCom,etat,montant,Cours) ;
                cf.setDateFacturation(dateFact);
                cf.setDatePayement(datePay);
                lcf.add(cf);
            }

        } catch (SQLException e) {
            //System.out.println("erreur sql :"+e);

            return null;
        }
        return lcf;
    }
    @Override
    public List<Produit> produits(Cours Cours) {
        List<Produit> lpr = new ArrayList<>();
        String query="select * from prodcli where idCours = ? order by numprod";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,Cours.getIdCours());
            ResultSet rs = pstm.executeQuery();
            boolean trouve= false;
            while(rs.next()){
                trouve=true;
                int idprod = rs.getInt(2);
                String numprod = rs.getString(3);
                String descr = rs.getString(4);
                Produit pr = new Produit(idprod,numprod,descr,new BigDecimal(0),0,0);
                lpr.add(pr);
            }
            if(!trouve) System.out.println("aucune commande trouvée");
        } catch (SQLException e) {

            return null;
        }
        return lpr;
    }

    @Override
    public List getNotification() {
        return getCourss();
    }

}
