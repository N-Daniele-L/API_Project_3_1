package mvp.view;

import TradUML.Bureau;
import TradUML.Employe;
import mvp.presenter.BureauPresenter;

import java.util.List;

public interface BureauViewInterface {
    public void setPresenter(BureauPresenter presenter);
    public void setListDatas(List<Bureau> bur);
    public void affMsg(String msg);
    void affList(List infos);
    public Bureau selectionner(List<Bureau> lb);
}
