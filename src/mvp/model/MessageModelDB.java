package mvp.model;

import TradUML.Bureau;
import TradUML.Employe;
import TradUML.Infos;
import TradUML.Message;
import myconnections.DBConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageModelDB implements DAOMessage{

    private static final Logger logger = LogManager.getLogger(EmployeModelDB.class);
    private Connection dbConnect;

    public MessageModelDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            // System.err.println("erreur de connexion");
            logger.error("erreur de connexion");
            System.exit(1);
        }
        logger.info("connexion établie");
    }

    @Override
    public Message addMessage(Message mes) {
        Message m;
        String query1 = "insert into APIMESSAGE (objet,contenu,id_employe,dateenvoi) VALUES (?, ?,?, CURRENT_DATE)";
        String query2 = "select id_message from APIMESSAGE where objet= ? and contenu = ? and date_envoi = CURRENT_DATE";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, mes.getObjet());
            pstm1.setString(2, mes.getContenu());
            pstm1.setInt(3, mes.getEmetteur().getId());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, mes.getObjet());
                pstm2.setString(2, mes.getContenu());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int id_mes = rs.getInt(1);
                    m = new Message.MessageBuilder()
                            .setId(id_mes)
                            .setObjet(mes.getObjet())
                            .setContenu(mes.getContenu())
                            .setId_emp(mes.getEmetteur().getId())
                            .build();
                    return mes;
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeMessage(Message mes) {
        String query = "DELETE FROM APIMESSAGE WHERE id_mess = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,mes.getId());
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
    public Message updateMessage(Message mes) {
        String query = "update APIMESSAGE set objet = ?, contenu = ?, dateenvoi = CURRENT_DATE WHERE id_mess = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,mes.getObjet());
            pstm.setString(2,mes.getContenu());
            pstm.setInt(3,mes.getId());
            int n = pstm.executeUpdate();
            if(n!=0) return readMessage(mes.getId());
            else return null;

        } catch (SQLException e) {
            // System.err.println("erreur sql :" + e);
            logger.error("erreur d'update : "+e);
            return null;
        }
    }

    @Override
    public Message readMessage(int id_mess) {
        String query = "select * from APIMESSAGE where id_mess = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,id_mess);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String objet = rs.getString(2);
                String cont = rs.getString(3);
                LocalDate date = rs.getDate(4).toLocalDate();
                int id_emp = rs.getInt(5);
                return new Message.MessageBuilder()
                        .setId_emp(id_mess)
                        .setObjet(objet)
                        .setContenu(cont)
                        .setDateEnvoi(date)
                        .setId_emp(id_emp)
                        .build();

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            // System.err.println("erreur sql :"+e);
            logger.error("erreur SQL : "+e);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Message> getMessage() {
        List<Message> lm = new ArrayList<>();
        String query="select * from APIMESSAGE ORDER BY id_mess";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_mess = rs.getInt(1);
                String objet = rs.getString(2);
                String cont = rs.getString(3);
                LocalDate date = rs.getDate(4).toLocalDate();
                int id_emp = rs.getInt(5);

                Message mes = new Message.MessageBuilder()
                        .setId(id_mess)
                        .setObjet(objet)
                        .setContenu(cont)
                        .setDateEnvoi(date)
                        .setId_emp(id_emp)
                        .build();
                lm.add(mes);
            }
            return lm;
        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur SQL : "+e);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
