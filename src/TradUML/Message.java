package TradUML;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {
    private int id;
    private String objet;
    private String contenu;
    private Date dateEnvoi;
    private Employe emetteur;
    private List<Infos> l_infos = new ArrayList<>();

    public Message(int id, String objet, String contenu, Date dateEnvoi, Employe emetteur) {
        this.id = id;
        this.objet = objet;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
        this.emetteur = emetteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Employe getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Employe emetteur) {
        this.emetteur = emetteur;
    }

    public List<Infos> getL_infos() {
        return l_infos;
    }

    public void setL_infos(List<Infos> l_infos) {
        this.l_infos = l_infos;
    }
}
