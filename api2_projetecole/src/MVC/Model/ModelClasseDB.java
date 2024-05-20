package MVC.Model;

import metier.Classe;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelClasseDB extends DAOClasse {
    protected Connection dbConnect;
    Scanner sc = new Scanner(System.in);

    public ModelClasseDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");

            System.exit(1);
        }

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
            System.out.println("id de la classe recherchée :  ");
            int idrech = sc.nextInt();
            String query = "delete from API_CLASSE where id_classe = ?";
            boolean ok=false;
            try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1,idrech);
                int n = pstm.executeUpdate();
                if(n!=0) {
                    System.out.println(n+ "ligne supprimée");
                    ok = true;
                }
                else {
                    System.out.println("record introuvable");
                }

            } catch (SQLException e) {
                System.out.println("erreur sql :"+e);
            }
            return ok;
    }

    @Override
    public Classe updateClasse(Classe classe) {
        System.out.println("id de la classe recherchée ");
        int idrech = sc.nextInt();

        System.out.println("nouveau nombre d'élèves : ");
        int nbreEleves = sc.nextInt();
        String query = "update API_CLASSE set nbreEleves=? where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,nbreEleves);
            pstm.setInt(2,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return classe;
    }

    @Override
    public Classe readClasse(int idclasse) {
        Classe classe = null;  // Initialiser la variable classe
        String query = "SELECT * FROM API_CLASSE WHERE id_classe = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idclasse);  // Utiliser l'argument de la méthode
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves = rs.getInt(5);
                classe = new Classe(idclasse, sigle, annee, specialite, nbreEleves);
                System.out.println(classe);
            } else {
                System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }

        return classe;  // Retourner la variable classe
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
}
