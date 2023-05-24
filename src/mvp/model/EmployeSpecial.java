package mvp.model;

import TradUML.Employe;
import TradUML.Infos;
import TradUML.Message;

import java.util.List;

public interface EmployeSpecial {
    public List<Message> messageSend(Employe em);

    public List<Infos> messageReceived(Employe em);

    public List<Infos> messageNotRead(Employe em);
}
