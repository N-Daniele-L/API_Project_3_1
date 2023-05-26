package mvp.model;

import TradUML.Infos;
import TradUML.Message;

import java.util.List;

public interface DAOInfos {
    Infos addInfos(Infos inf);

    boolean removeInfos(Infos inf);

    Infos updateInfos(Infos inf);

    Infos readInfos(int id_emp, int id_mess);

    List<Infos> getInfos();
}
