package demodb;

import metier.Classe;
import myconnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class GestionClasse {
    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);
    }

    public void ajout(){
        // entrer sigle, année, spécialité, nbreeleves
        System.out.println("Entrez le sigle de la classe : ");
        String sigle = sc.nextLine();
        System.out.println("Entrez l'année de la classe : ");
        Integer annee = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrez la spécialité de la classe : ");
        String specialite = sc.nextLine();
        System.out.println("Entrez le nombre d'élèves de la classe : ");
        Integer nbreEleves = sc.nextInt();

        String query1 = "insert into API_CLASSE(sigle,annee,specialite,nbreEleves) values(?,?,?,?)";
        String query2 = "select id_classe from API_CLASSE where sigle= ?";

        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,sigle);
            pstm1.setInt(2,annee);
            pstm1.setString(3,specialite);
            pstm1.setInt(4,nbreEleves);
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
            if(n==1){
                pstm2.setString(1,sigle);
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int id_client= rs.getInt(1);
                    System.out.println("id_classe = "+id_client);
                }
                else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }

    public void recherche(){
        System.out.println("id de la classe recherchée ");
        int idrech = sc.nextInt();
        String query = "select * from API_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                int annee = rs.getInt(3);
                String specialite = rs.getString(4);
                int nbreEleves = rs.getInt(5);
                Classe cl = new Classe(idrech,sigle,annee,specialite,nbreEleves);
                System.out.println(cl);
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        }

    public void modification() {
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
    }

    public void suppression() {
        System.out.println("id de la classe recherchée :  ");
        int idrech = sc.nextInt();
        String query = "delete from API_CLASSE where id_classe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    private void tous() {
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
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }

    public static void main(String[] args) {

        GestionClasse g = new GestionClasse();
        g.gestion();
    }
    }


