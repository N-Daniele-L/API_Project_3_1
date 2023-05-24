package mvp;

import TradUML.*;
import mvp.model.*;
import mvp.presenter.*;
import mvp.view.*;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestEmploye {
    private DAOEmploye cm;
    private EmployePresenter cp;
    private EmployeViewInterface cv;
    private DAOBureau bm;
    private BureauPresenter bp;
    private BureauViewInterface bv;
    private DAOMessage mm;
    private MessagePresenter mp;
    private MessageViewInterface mv;



    public void gestion(){
        bm = new BureauModelDB();
        bv = new BureauViewConsole();
        bp = new BureauPresenter(bm,bv);

        cm = new EmployeModelDB();
        cv = new EmployeViewConsole();
        cp = new EmployePresenter(cm,cv);
        cp.setBureauPresenter(bp);

        mm = new MessageModelDB();
        mv = new MessageViewConsole();
        mp = new MessagePresenter(mm,mv);
        mp.setEmployepresenter(cp);




        List<String> loptions = Arrays.asList("Employe","Bureau","Messages","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: cp.start();
                    break;
                case 2 : bp.start();
                    break;
                case 3: mp.start();
                    break;
                case 4: System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestEmploye ge = new GestEmploye();
        ge.gestion();
    }
}
