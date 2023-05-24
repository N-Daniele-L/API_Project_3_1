package mvp.view;

import TradUML.Message;
import mvp.presenter.MessagePresenter;

import java.util.List;

public interface MessageViewInterface {
    public void setPresenter(MessagePresenter presenter);
    public void setListDatas(List<Message> employes);
    public void affMsg(String msg);
    void affList(List infos);
    public Message selectionner(List<Message> lem);
}
