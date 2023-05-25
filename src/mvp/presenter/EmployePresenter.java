package mvp.presenter;

import jdk.jshell.spi.SPIResolutionException;
import TradUML.Bureau;
import TradUML.Employe;
import mvp.model.DAOBureau;
import mvp.model.EmployeSpecial;
import mvp.model.DAOEmploye;
import mvp.view.BureauViewInterface;
import mvp.view.EmployeViewInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.PublicKey;
import java.util.List;

public class EmployePresenter {
    private DAOEmploye model;
    private DAOBureau bureaumodel;
    private EmployeViewInterface view;
    private BureauPresenter bureauPresenter;
    private static final Logger logger = LogManager.getLogger(EmployePresenter.class);

    public void setBureauPresenter(BureauPresenter bureauPresenter){
        this.bureauPresenter = bureauPresenter;
    }
    public EmployePresenter(DAOEmploye model, EmployeViewInterface view) {
        this.model = model;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void start(){
        view.setListDatas(getAll());
    }

    public List<Employe> getAll(){
        return model.getEmploye();
    }
    public void addEmploye(Employe employe) {
        Bureau bureau = bureauPresenter.selectionner();
        if (bureau == null){
            view.affMsg("Erreur bureau null");
            return;
        }
        employe.setBureau(bureau);
        Employe em = model.addEmploye(employe);
        if(em!=null) view.affMsg("création de : "+em);
        else view.affMsg("erreur de création");

    }


    public void removeEmploye(Employe employe) {
        boolean ok = model.removeEmploye(employe);
        if(ok) view.affMsg("employé effacé");
        else view.affMsg("employé non effacé");
    }

    public Employe selectionner() {
        logger.info("appel de sélection");
        Employe em = view.selectionner(model.getEmploye());
        return em;
    }

    public void update(Employe employe) {

        Employe em =model.updateEmploye(employe);
        if(em==null) view.affMsg("mise à jour infrucueuse");
        else view.affMsg("mise à jour effectuée : "+em);
    }

    public Employe search(int idEmp) {
        Employe em = model.readEmploye(idEmp);
        if(em==null) view.affMsg("recherche infructueuse");
        else view.affMsg(em.toString());
        return em;
    }
}
