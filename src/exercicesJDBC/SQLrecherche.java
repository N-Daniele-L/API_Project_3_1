package exercicesJDBC;

import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLrecherche {
    public void demo() {

        Scanner sc = new Scanner(System.in);
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
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
                System.out.println( n_emp + " :" +nom + " " + prenom + " "+ mail + " : " + idBur);
            }
            if (!trouve) {
                System.out.println("id du bureau inconnu");
            }

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
        DBConnection.closeConnection();
    }

    public static void main(String[] args) {
        SQLrecherche pgm = new SQLrecherche();
        pgm.demo();
    }
}
