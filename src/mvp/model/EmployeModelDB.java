package mvp.model;

import TradUML.Bureau;
import TradUML.Employe;
import TradUML.Infos;
import TradUML.Message;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeModelDB implements DAOEmploye, EmployeSpecial{

    private static final Logger logger = LogManager.getLogger(EmployeModelDB.class);
    private Connection dbConnect;

    public EmployeModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            // System.err.println("erreur de connexion");
            logger.error("erreur de connexion");
            System.exit(1);
        }
        logger.info("connexion établie");
    }

    @Override
    public Employe addEmploye(Employe employe) {
        String query1 = "insert into APIEMPLOYE (mail_emp,nom,prenom,id_bureau) VALUES (?, ?, ?, ?)";
        String query2 = "select id_employe from APIEMPLOYE where nom= ? and prenom =? and mail_emp =?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, employe.getMail());
            pstm1.setString(2, employe.getNom());
            pstm1.setString(3, employe.getPrenom());
            pstm1.setInt(4, employe.getBureau().getId());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, employe.getNom());
                pstm2.setString(2, employe.getPrenom());
                pstm2.setString(3, employe.getMail());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int id_emp = rs.getInt(1);
                    employe.setId(id_emp);
                    return employe;
                } else {
                    logger.error("record introuvable");
                    //  System.err.println("record introuvable");
                    return null;
                }
            } else return null;

        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public boolean removeEmploye(Employe employe) {
        String query = "DELETE FROM APIEMPLOYE WHERE id_employe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,employe.getId());
            int n = pstm.executeUpdate();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            //  System.err.println("erreur sql :"+e);
            logger.error("erreur d'effacement : "+e);
            return false;
        }
    }
    @Override
    public Employe updateEmploye(Employe employe) {
        String query = "update apiemploye set mail_emp = ?, nom = ?, prenom = ?, id_bureau = ? WHERE id_employe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,employe.getMail());
            pstm.setString(2,employe.getNom());
            pstm.setString(3,employe.getPrenom());
            pstm.setInt(4, employe.getBureau().getId());
            pstm.setInt(5,employe.getId());
            int n = pstm.executeUpdate();
            if(n!=0) return readEmploye(employe.getId());
            else return null;

        } catch (SQLException e) {
            // System.err.println("erreur sql :" + e);
            logger.error("erreur d'update : "+e);
            return null;
        }
    }

    @Override
    public Employe readEmploye(int idEmp) {
        String query = "select * from APIEMPLOYE where id_employe = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idEmp);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String mail = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                int id_bur = rs.getInt(5);
                return new Employe(idEmp,mail,nom,prenom,id_bur);

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            // System.err.println("erreur sql :"+e);
            logger.error("erreur SQL : "+e);
            return null;
        }
    }


    @Override
    public List<Employe> getEmploye() {
        List<Employe> lc = new ArrayList<>();
        String query="select * from APIEMPLOYE ORDER BY id_employe";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_emp = rs.getInt(1);
                String mail = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                int id_bur = rs.getInt(5);
                Employe em = new Employe(id_emp,mail,nom,prenom,id_bur);
                lc.add(em);
            }
            return lc;
        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur SQL : "+e);
            return null;
        }
    }

    @Override
    public List<Message> messageSend(Employe em) {
        return null;
    }

    @Override
    public List<Infos> messageReceived(Employe em) {
        return null;
    }

    @Override
    public List<Infos> messageNotRead(Employe em) {
        return null;
    }
}
