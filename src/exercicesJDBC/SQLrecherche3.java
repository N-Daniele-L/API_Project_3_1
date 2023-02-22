package exercicesJDBC;

import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLrecherche3 {
    public void demo() {

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
                             + nom + "'AND PRENOM = '"+ prenom +"'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;

                int idBur = rs.getInt("ID_BUREAU");
                String mail = rs.getString("MAIL_EMP");
                int n_emp = rs.getInt("ID_EMPLOYE");
                System.out.println( n_emp + " :" +nom + " " + prenom + " "+ mail + " : " + idBur);
            }
            if (!trouve) {
                System.out.println("employé inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    public static void main(String[] args) {
        SQLrecherche3 pgm = new SQLrecherche3();
        pgm.demo();
    }
}
