package mvp.view;

import TradUML.Infos;
import TradUML.Message;
import mvp.presenter.InfosPresenter;
import mvp.presenter.MessagePresenter;
import utilitaires.Utilitaire;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.modifyIfNotBlank;

public class InfosViewConsole implements InfosViewInterface{

    private InfosPresenter presenter;
    private List<Infos> linfos;
    private Scanner sc = new Scanner(System.in);
    @Override
    public void setPresenter(InfosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Infos> infos) {
        this.linfos = infos;
        affListe(linfos);
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
    public Infos selectionner(List<Infos> linfos) {
        int choix = Utilitaire.choixListe(linfos);
        return linfos.get(choix - 1);
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
        presenter.addInfos(new Infos(null,null));
        linfos = presenter.getAll();
        affListe(linfos);
    }

    private void retirer() {
        int nl = choixElt(linfos)-1;
        Infos i = linfos.get(nl);
        presenter.removeInfos(i);
        linfos = presenter.getAll();//rafraichissement
        affListe(linfos);
    }

    private void rechercher() {

    }

    private void modifier() {

    }

    private void special() {
    }
}