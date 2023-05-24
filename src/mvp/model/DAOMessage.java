package mvp.model;

import TradUML.Employe;
import TradUML.Message;

import java.util.List;
public interface DAOMessage {
    Message addMessage(Message mes);

    boolean removeMessage(Message mes);

    Message updateMessage(Message mes);

    Message readMessage(int idMess);

    List<Message> getMessage();

}
