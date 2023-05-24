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
    private DAOEmploye employemodel;
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


}
