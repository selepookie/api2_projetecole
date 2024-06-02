package MVC.Model;

import MVC.Controller.SalleController;
import metier.*;
import myconnections.DBConnection;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.affListe;
import static utilitaires.Utilitaire.choixListe;

public class ModelClasseDB extends DAOClasse {
    protected Connection dbConnect;
    Scanner sc = new Scanner(System.in);
    public DAOSalle daosalle;
    public DAOEnseignant daoens;
    public DAOCours daocours;

    public ModelClasseDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }
        daosalle = new ModelSalleDB();
        daoens = new ModelEnseignantDB();
        daocours = new ModelCoursDB();

    }

    @Override
    public Classe addClasse(Classe classe) {
        String query1 = "insert into API_CLASSE(sigle,annee,specialite,nbreEleves) values(?,?,?,?)";
        String query2 = "select id_classe from API_CLASSE where sigle= ?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, classe.getSigle());
            pstm1.setInt(2, classe.getAnnee());
            pstm1.setString(3, classe.getSpecialite());
            pstm1.setInt(4, classe.getNbreEleves());
            int n = pstm1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if (n == 1) {
                pstm2.setString(1, classe.getSigle());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int id_classe = rs.getInt(1);
                    System.out.println("id_classe = " + id_classe);
                } else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return classe;
    }

    @Override
    public boolean removeClasse(Classe classe) {
        String query = "delete from API_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,classe.getId_classe());
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
    public Classe updateClasse(Classe classe) {
        String query = "update API_CLASSE set sigle =?,annee=?,specialite=?, nbreEleves=? where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,classe.getSigle());
            pstm.setInt(2,classe.getAnnee());
            pstm.setString(3,classe.getSpecialite());
            pstm.setInt(4,classe.getNbreEleves());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return readClasse(classe.getId_classe());
            else return null;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return null;
        }
    }

    @Override
    public Classe readClasse(int id_classe) {
        String query = "select * from API_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_classe);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves = rs.getInt(5);
                Classe cl = new Classe(id_classe, sigle, annee, specialite, nbreEleves);
                return cl;

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
    public List<Classe> getClasses() {
        List<Classe> lcl= new ArrayList<>();
        String query="select * from API_CLASSE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_classe = rs.getInt(1);
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves = rs.getInt(5);
                Classe cl = new Classe(id_classe,sigle,annee,specialite,nbreEleves);
                System.out.println(cl);
                lcl.add(cl);
            }
            return lcl;

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
            return null;
        }
    }

    @Override
    public List getNotification() {
        return getClasses();
    }

    @Override
    public int nbreHeuresTot(Classe classe){
        int nb=0;
        String query = "select nbreHeures from API_INFOS where id_classe = ? ";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)){
            pstm.setInt(1,classe.getId_classe());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                nb += rs.getInt("nbreHeures");
            }
            return nb;
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
        }
        return nb;
    }

    @Override
    public List<ListeEnseignantsHeures> listeEnsHeures(Classe classe){
        List<ListeEnseignantsHeures> leh = new ArrayList<>();
        String query = "select id_enseignant, nbreHeures from API_INFOS where id_classe = ?";
        String query2 = "select * from API_ENSEIGNANT where id_enseignant = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query)){
            pstm1.setInt(1,classe.getId_classe());
            ResultSet rs = pstm1.executeQuery();
            while(rs.next()){
                int id_ens = rs.getInt("id_enseignant");
                int nbh = rs.getInt("nbreheures");
                Enseignant ens = null;
                try(PreparedStatement pstm2 = dbConnect.prepareStatement(query2)){
                    pstm2.setInt(1,id_ens);
                    ResultSet rs2 = pstm2.executeQuery();
                    String matricule=null;
                    String nom=null;
                    String prenom=null;
                    String tel=null;
                    int chargesem=0;
                    double salairemensu=0;
                    LocalDate dateengag = null;
                    if(rs2.next()){
                        matricule = rs2.getString("matricule");
                        nom = rs2.getString("nom");
                        prenom = rs2.getString("prenom");
                        tel = rs2.getString("tel");
                        chargesem = rs2.getInt("chargesem");
                        salairemensu = rs2.getDouble("salairemensu");
                        dateengag = rs2.getDate("dateengag").toLocalDate();
                    }
                    ens = new Enseignant(id_ens, matricule, nom,prenom,tel,chargesem,salairemensu,dateengag);
                }
                catch(SQLException e){
                    System.err.println("erreur sql : "+e);
                    return null;
                }
                ListeEnseignantsHeures list = new ListeEnseignantsHeures(ens,nbh);
                leh.add(list);
;            }
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
            return leh;
        }
        return leh;
    }

    @Override
    public List<SalleHeures> listeSalleHeures(Classe cl){
        List<SalleHeures> sh = new ArrayList<>();
        String query = "select id_salle, nbreHeures from API_INFOS where id_classe = ?";
        String query2 = "select * from API_SALLE where id_salle = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query)){
            pstm1.setInt(1,cl.getId_classe());
            ResultSet rs = pstm1.executeQuery();
            while(rs.next()){
                int id_salle = rs.getInt("id_salle");
                int nbh = rs.getInt("nbreheures");
                Salle salle = null;
                try(PreparedStatement pstm2 = dbConnect.prepareStatement(query2)){
                    pstm2.setInt(1,id_salle);
                    ResultSet rs2 = pstm2.executeQuery();
                    String sigle=null;
                    int capacite = 0;
                    if(rs2.next()){
                        sigle = rs2.getString(2);
                        capacite = rs2.getInt(3);
                    }
                    salle = new Salle(cl.getId_classe(),sigle, capacite);
                }
                catch(SQLException e){
                    System.err.println("erreur sql : "+e);
                    return null;
                }
                SalleHeures shh = new SalleHeures(salle,nbh);
                sh.add(shh);
            }
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
            return sh;
        }
        return sh;
    }

    @Override
    public List<CoursHeures> listeCoursHeures(Classe cl){
        List<CoursHeures> ch = new ArrayList<>();
        String query = "select id_cours, nbreHeures from API_INFOS where id_classe = ?";
        String query2 = "select * from API_COURS where id_salle = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query)){
            pstm1.setInt(1,cl.getId_classe());
            ResultSet rs = pstm1.executeQuery();
            while(rs.next()){
                int id_cours = rs.getInt("id_cours");
                int nbh = rs.getInt("nbreheures");
                Cours cours = null;
                try(PreparedStatement pstm2 = dbConnect.prepareStatement(query2)){
                    pstm2.setInt(1,id_cours);
                    ResultSet rs2 = pstm2.executeQuery();
                    String code=null;
                    String intitule = null;
                    int id_salle = 0;
                    if(rs2.next()){
                        code = rs2.getString("code");
                        intitule = rs2.getString("intitule");
                        id_salle = rs2.getInt("id_salle");
                    }
                    Salle salle = daosalle.readSalle(id_salle);
                    cours = new Cours(cl.getId_classe(),code, intitule, salle);
                }
                catch(SQLException e){
                    System.err.println("erreur sql : "+e);
                    return null;
                }
                CoursHeures chch = new CoursHeures(cours,nbh);
                ch.add(chch);
            }
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
            return ch;
        }
        return ch;
    }

    @Override
    public boolean salleCapOK(Classe cl){
        int cap=0;
        int nb=0;
        List<Salle> ls = daosalle.getSalles();
        affListe(ls);
        System.out.println("id salle recherchee : ");
        int id_salle = sc.nextInt();
        String query1 = "select capacite from API_SALLE where id_salle = ?";
        String query2 = "select nbreEleves from API_CLASSE where id_classe = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(query1)){
            pstm1.setInt(1,(id_salle));
            ResultSet rs = pstm1.executeQuery();
            while(rs.next()){
                cap = rs.getInt("capacite");
            }
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
        }
        try(PreparedStatement pstm2 = dbConnect.prepareStatement(query2)){
            pstm2.setInt(1,cl.getId_classe());
            ResultSet rs2 = pstm2.executeQuery();
            while(rs2.next()){
                nb = rs2.getInt("nbreeleves");
            }
        }
        catch(SQLException e){
            System.err.println("erreur sql : "+e);
        }

        return cap >= nb;
    }

    @Override
    public boolean addCours(Classe cl,Cours co, Enseignant ens, int nb, Salle salle){
        String query1 = "insert into API_INFOS(nbreheures, id_cours, id_salle, id_enseignant, id_classe) values (?, ?, ?, ?, ?)";
        String query2 = "select id_infos from API_infos where id_cours= ? and id_salle =? and id_classe =?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setInt(1, nb);
            pstm1.setInt(2, co.getId_cours());
            pstm1.setInt(3, salle.getId_salle());
            pstm1.setInt(4, ens.getId_enseignant());
            pstm1.setInt(5, cl.getId_classe());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setInt(1, co.getId_cours());
                pstm2.setInt(2, salle.getId_salle());
                pstm2.setInt(3, cl.getId_classe());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    return true;
                } else {

                    System.err.println("record introuvable");
                    return false;
                }
            } else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

            return false;
        }
    }


    @Override
    public boolean modifCoursSalle(Classe cl,Cours cours, Salle salle){
        int id_salle = salle.getId_salle();
        int id_classe = cl.getId_classe();
        int id_cours = cours.getId_cours();
        String query = "update  API_INFOS set id_salle = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_salle);
            pstm.setInt(2,id_classe);
            pstm.setInt(3,id_cours);
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean modifCoursHeures(Classe cl,Cours cours, int nb){
        int id_classe = cl.getId_classe();
        int id_cours = cours.getId_cours();
        String query = "update  API_INFOS set nbreheures = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,nb);
            pstm.setInt(2,id_classe);
            pstm.setInt(3,id_cours);
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean modifCoursEns(Classe cl,Cours cours, Enseignant ens){
        int id_classe = cl.getId_classe();
        int id_cours = cours.getId_cours();
        int id_ens = ens.getId_enseignant();
        String query = "update  API_INFOS set id_enseignant = ? where id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_ens);
            pstm.setInt(2,id_classe);
            pstm.setInt(3,id_cours);
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public boolean supprCours(Classe cl, Cours cours){
        String query = "DELETE FROM  API_INFOS where  id_classe = ? AND id_cours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,cl.getId_classe());
            pstm.setInt(2,cours.getId_cours());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public List<Cours> getCoursClasse(Classe cl){
        List<Cours> co= new ArrayList<>();
        String query="select id_cours from API_INFOS where id_classe = ?";
        try(PreparedStatement stm = dbConnect.prepareStatement(query)) {
            stm.setInt(1,cl.getId_classe());
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int id_cours = rs.getInt("id_cours");
                Cours cours = daocours.readCours(id_cours);
                System.out.println(cl);
                co.add(cours);
            }
            return co;

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
            return null;
        }
    }
}
