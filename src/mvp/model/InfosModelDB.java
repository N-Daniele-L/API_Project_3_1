package mvp.model;

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

public class InfosModelDB implements DAOInfos {

    private static final Logger logger = LogManager.getLogger(EmployeModelDB.class);
    private Connection dbConnect;

    public InfosModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            // System.err.println("erreur de connexion");
            logger.error("erreur de connexion");
            System.exit(1);
        }
        logger.info("connexion établie");
    }

    @Override
    public Infos addInfos(Infos inf) {
        String query1 = "insert into APIINFOS (id_employe,id_mess,datelecture) VALUES (?, ?,NULL)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
        ) {
            pstm1.setInt(1, inf.getRecepteur().getId());
            pstm1.setInt(2, inf.getMess().getId());
            int n = pstm1.executeUpdate();
           return inf;
        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public boolean removeInfos(Infos inf) {
        return false;
    }

    @Override
    public Infos updateInfos(Infos inf) {
        return null;
    }

    @Override
    public Infos readInfos(int id_emp, int id_mess) {
        return null;
    }

    @Override
    public List<Infos> getInfos() {
        List<Infos> linfos = new ArrayList<>();
        String query="select * from APIINFOS ORDER BY id_employe";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id_emp = rs.getInt(1);
                int id_mess = rs.getInt(2);
                Date date = rs.getDate(3);
                if(date != null) {
                    LocalDate localdate = date.toLocalDate();
                    Infos i = new Infos(id_emp, id_mess, localdate);
                    linfos.add(i);
                }else {
                    Infos i = new Infos(id_emp, id_mess, null);
                    linfos.add(i);
                }
            }
            return linfos;
        } catch (SQLException e) {
            //System.err.println("erreur sql :"+e);
            logger.error("erreur SQL : "+e);
            return null;
        }
    }
    }


