package mvp.view;


import TradUML.Employe;
import TradUML.Message;
import mvp.presenter.MessagePresenter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import static utilitaires.Utilitaire.affListe;
import static utilitaires.Utilitaire.choixListe;

public class MessageViewConsole implements MessageViewInterface{
    private MessagePresenter presenter;
    private List<Message> lm;
    private Scanner sc = new Scanner(System.in);

    public MessageViewConsole() {

    }

    @Override
    public void setPresenter(MessagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Message> messages) {
        this.lm = messages;
        affListe(lm);
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
    public Message selectionner(List<Message> lem) {
        return null;
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
        LocalDate now = LocalDate.now();
        System.out.println("Entrez l'objet du message': ");
        String obj = sc.nextLine();
        System.out.println("Entrez le contenu du message");
        String cont = sc.nextLine();

        presenter.addMessage(new Message(0,obj,cont,now,0));
        lm = presenter.getAll();
        affListe(lm);
    }

    private void retirer() {
    }

    private void rechercher() {
    }

    private void modifier() {
    }

    private void special() {
    }

}
