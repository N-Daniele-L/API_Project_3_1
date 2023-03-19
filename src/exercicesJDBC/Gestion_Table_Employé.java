package exercicesJDBC;

import myconnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class Gestion_Table_Employé {


    public void add() throws SQLException {

        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        System.out.println("Entrez le nom de l'employé : ");
        String nomEmp = sc.nextLine();
        System.out.println("Entrez le prenom de l'employé : ");
        String prenomEmp = sc.nextLine();
        System.out.println("Entrez le mail de l'employé : ");
        String mailEmp = sc.nextLine();
        System.out.println("Voici les id de bureau disponible : ");

        affiche_all_bur();

        System.out.println("Entrez l'id du bureau' : ");
        int idBur = sc.nextInt();


        PreparedStatement pstmt = dbConnect.prepareStatement("insert into apiemploye (id_employe,mail_emp,nom,prenom,id_bureau) VALUES (APIEMPLOYE_SEQ.nextval,?, ?, ?, ?)");
        pstmt.setString(1, mailEmp);
        pstmt.setString(2, nomEmp);
        pstmt.setString(3, prenomEmp);
        pstmt.setInt(4, idBur);
        pstmt.executeUpdate();

        System.out.println("Employé ajouté avec succés ! ");

        DBConnection.closeConnection();
    }

    private void select_all() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT *  FROM APIEMPLOYE ");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;

                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");
                String mail = rs.getString("MAIL_EMP");
                int n_emp = rs.getInt("ID_EMPLOYE");
                int n_bur = rs.getInt("ID_BUREAU");
                System.out.println(n_emp + ") " + nom + " " + prenom + " " + mail + " id du bureau : " + n_bur);
            }
            if (!trouve) {
                System.out.println("id du bureau inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    public void select_by_id_bur() {

        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");

        affiche_all_bur();

        System.out.println("Id du bureau recherche : ");
        String idBur = sc.nextLine();

        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT *  FROM APIEMPLOYE WHERE ID_BUREAU = '"
                             + idBur + "'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;

                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");
                String mail = rs.getString("MAIL_EMP");
                int n_emp = rs.getInt("ID_EMPLOYE");
                System.out.println(n_emp + " :" + nom + " " + prenom + " " + mail + " : " + idBur);
            }
            if (!trouve) {
                System.out.println("id du bureau inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }


    private void select_by_id_emp() {
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        System.out.println("Id de l'employé recherche : ");
        String n_emp = sc.nextLine();

        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT *  FROM APIEMPLOYE WHERE ID_EMPLOYE = '"
                             + n_emp + "'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;

                String nom = rs.getString("NOM");
                String prenom = rs.getString("PRENOM");
                String mail = rs.getString("MAIL_EMP");

                int n_bur = rs.getInt("ID_BUREAU");
                System.out.println(n_emp + ") " + nom + " " + prenom + " " + mail + " id du bureau : " + n_bur);
            }
            if (!trouve) {
                System.out.println("id de l'employé inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    private void select_by_name() {
        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        System.out.println("Nom de employé recherche : ");
        String nom = sc.nextLine();
        System.out.println("Prenom de employé recherche : ");
        String prenom = sc.nextLine();


        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT *  FROM APIEMPLOYE WHERE NOM = '"
                             + nom + "'AND PRENOM = '" + prenom + "'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;

                int idBur = rs.getInt("ID_BUREAU");
                String mail = rs.getString("MAIL_EMP");
                int n_emp = rs.getInt("ID_EMPLOYE");
                System.out.println(n_emp + " :" + nom + " " + prenom + " " + mail + " : " + idBur);
            }
            if (!trouve) {
                System.out.println("employé inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    private void update() {
    }

    private void delete() {
    }

    public static void main(String[] args) throws SQLException {

        Gestion_Table_Employé pgm = new Gestion_Table_Employé();

        int choix;
        String tmp;
        String liste = "\t1.Ajout Employé\n\t2.Recherche Employé\n\t3.Modifier Employé\n\t4.Supprimé Employé\n\t5.Quitté Programme";
        do {
            System.out.println(liste);
            System.out.println("\nQuel choix ? ");
            tmp = controle("[1-5]", "Num entre 1 et 5 : ");
            choix = Integer.parseInt(tmp);
            switch (choix) {
                case 1 -> pgm.add();
                case 2 -> select();
                case 3 -> pgm.update();
                case 4 -> pgm.delete();
                case 5 -> System.out.println("Fin de programme");
                default -> System.out.println("Erreur ");
            }
        } while (choix != 5);
    }

    public static void select() {
        Gestion_Table_Employé pgm = new Gestion_Table_Employé();

        int choix;
        String tmp;
        String liste = "\t1.Recherche tout les employés\n\t2.Recherche les employé par section\n\t3.Recherche un employé par son id\n\t4.Recherche un employé par son nom et prénom\n\t5.Retour";
        do {
            System.out.println(liste);
            System.out.println("\nQuel choix ? ");
            tmp = controle("[1-5]", "Num entre 1 et 5 : ");
            choix = Integer.parseInt(tmp);
            switch (choix) {
                case 1 -> pgm.select_all();
                case 2 -> pgm.select_by_id_bur();
                case 3 -> pgm.select_by_id_emp();
                case 4 -> pgm.select_by_name();
                case 5 -> System.out.println("Retour");
                default -> System.out.println("Erreur ");
            }
        } while (choix != 5);
    }


    public void affiche_all_bur() {
        Connection dbConnect = DBConnection.getConnection();
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT *  FROM APIBUREAU ");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                int id = rs.getInt("ID_BUREAU");
                String sigle = rs.getString("SIGLE");
                System.out.println(id + " :" + sigle);
            }
            if (!trouve) {
                System.out.println("pas de bureau");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
    }

    public static String controle(String regex, String erreur) {
        String ctrl;
        Scanner sc = new Scanner(System.in);
        ctrl = sc.nextLine();
        while (!ctrl.matches(regex)) {
            System.out.println(erreur);
            ctrl = sc.nextLine();
        }
        return ctrl;

    }
}
