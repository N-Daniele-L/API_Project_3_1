package exercicesJDBC;

import java.sql.*;
import java.util.Scanner;
import myconnections.DBConnection;

public class SQL {
    public void demo(){

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        String query = "select * from APIMESSAGE";
        try (Statement stmt = dbConnect.createStatement();
             ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                String objet = rs.getString("OBJET");
                String contenu = rs.getString("CONTENU");
                String idMess = "" + rs.getInt("ID_MESS");
                System.out.println(objet + " " + contenu + " " + idMess);
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL " + e);
        }

        DBConnection.closeConnection();
    }

    public static void main(String[] args) {
        SQL pgm = new SQL();
        pgm.demo();
    }
}
