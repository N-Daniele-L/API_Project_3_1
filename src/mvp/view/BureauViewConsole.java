package mvp.view;

import TradUML.Bureau;
import TradUML.Employe;
import mvp.model.BureauSpecial;
import mvp.presenter.BureauPresenter;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class BureauViewConsole implements BureauViewInterface{

    private BureauPresenter presenter;
    private List<Bureau> lb;
    private Scanner sc = new Scanner(System.in);

    public BureauViewConsole() {

    }
    @Override
    public void setPresenter(BureauPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Bureau> bur) {
        this.lb = bur;
        affListe(bur);
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void affList(List infos) {
        affListe(infos);
    }

    @Override
    public Bureau selectionner(List<Bureau> lb) {
        int choix = Utilitaire.choixListe(lb);
        return lb.get(choix - 1);
    }

    private void menu() {
        do {

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "special", "fin"));
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    special();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    private void ajouter() {
        System.out.println("Entrez le sigle du bureau : ");
        String sigle = sc.nextLine();
        System.out.println("Entrez le numéro de téléphone du bureau");
        String tel = sc.nextLine();
        presenter.addBureau(new Bureau(0,sigle,tel));
        lb = presenter.getAll();
        affListe(lb);
    }

    private void retirer() {
        int nl = choixElt(lb)-1;
        Bureau bureau = lb.get(nl);
        presenter.removeBureau(bureau);
        lb = presenter.getAll();//rafraichissement
        affListe(lb);
    }
    private void rechercher() {
        System.out.println("id du bureau: ");
        int idBur = sc.nextInt();
        presenter.search(idBur);
    }
    private void modifier() {
        int nl = choixElt(lb) - 1;
        Bureau bureau = lb.get(nl);
        String sigle = modifyIfNotBlank("mail" , bureau.getSigle());
        String tel = modifyIfNotBlank("nom", bureau.getTel());
        presenter.update(new Bureau(bureau.getId(),sigle,tel));
        lb = presenter.getAll();//rafraichissement
        affListe(lb);
    }

    private void special() {
    }
}
