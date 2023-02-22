package exercicesJDBC;

import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLrecherche2 {
    public void demo() {

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
                System.out.println( n_emp + " :" +nom + " " + prenom + " "+ mail + " : " + n_bur);
            }
            if (!trouve) {
                System.out.println("id de l'employé inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    public static void main(String[] args) {
        SQLrecherche2 pgm = new SQLrecherche2();
        pgm.demo();
    }
}
