package mvp.presenter;

import TradUML.Employe;
import TradUML.Message;
import mvp.model.DAOEmploye;
import mvp.model.DAOMessage;
import mvp.view.MessageViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MessagePresenter {
    private DAOMessage model;
    private MessageViewInterface view;
    private EmployePresenter employePresenter;


    private static final Logger logger = LogManager.getLogger(MessagePresenter.class);

    public void setEmployepresenter(EmployePresenter employePresenterp) {
        this.employePresenter = employePresenterp;
    }

    public MessagePresenter(DAOMessage model,MessageViewInterface view){
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }
    public void start() {
        view.setListDatas(getAll());
    }

    public List<Message> getAll(){
        return model.getMessage();
    }

    public void addMessage(Message message) {
        Employe employe = employePresenter.selectionner();
        if(employe == null){
            view.affMsg("Erreur employe null");
            return;
        }
        message.setEmetteur(employe);
        Message m = model.addMessage(message);
        if(m!=null) view.affMsg("création de : "+m);
        else view.affMsg("erreur de création");
    }

    public void removeMessage(Message message) {
        boolean ok = model.removeMessage(message);
        if(ok) view.affMsg("message effacé");
        else view.affMsg("message non effacé");
    }

    public Message selectionner() {
        logger.info("appel de sélection");
        Message me = view.selectionner(model.getMessage());
        return me;
    }

    public void update(Message message) {
        Message me =model.updateMessage(message);
        if(me==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+me);
    }

    public Message search(int id_mess) {
        Message me = model.readMessage(id_mess);
        if(me==null) view.affMsg("recherche infructueuse");
        else view.affMsg(me.toString());
        return me;
    }
}
