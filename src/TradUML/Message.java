package TradUML;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * classe metier message
 *
 * @author Daniele Nicolo
 * @version 1.0
 * @see Infos
 */
public class Message {
    /**
     * id unique du message
     */
    private int id_mess;
    /**
     * objet du message
     */
    private String objet;
    /**
     * contenu du message
     */
    private String contenu;
    /**
     * date d'envoi du message
     */
    private LocalDate dateEnvoi;
    /**
     * employe qui a envoyer le message
     */

    private Employe emetteur;
    private int id_emp;
    /**
     * liste des infos du message
     * infos contient l'employe qui recois le message et la date de lecture du message
     * si la date de lecture est nulle alors le message n'a pas encore ete lu
     */
    private List<Infos> l_infos = new ArrayList<>();

    /**
     * constructeur parametre
     *
     * @param id_mess   identifiant numerique du message
     * @param objet     intitule du message
     * @param contenu   contenu du message
     * @param dateEnvoi date d'envoi du message
     * @param emetteur  employe qui envoie le message
     */
    public Message(int id_mess, String objet, String contenu, LocalDate dateEnvoi, Employe emetteur) {
        this.id_mess = id_mess;
        this.objet = objet;
        this.contenu = contenu;
        this.dateEnvoi = dateEnvoi;
        this.emetteur = emetteur;
    }

    public Message(int id_mess, String objet, String contenu, LocalDate date, int id_emp) {
        this.id_mess = id_mess;
        this.objet = objet;
        this.contenu = contenu;
        this.dateEnvoi = date;
        this.id_emp = id_emp;
    }

    /**
     * getter getid
     *
     * @return id unique du message
     */
    public int getId() {
        return id_mess;
    }

    /**
     * setter setid
     *
     * @param id_mess change l'id unique du message
     */
    public void setId(int id_mess) {
        this.id_mess = id_mess;
    }

    /**
     * getter getobjet
     *
     * @return l'objet, l'intitule du message
     */
    public String getObjet() {
        return objet;
    }

    /**
     * setter setobjet
     *
     * @param objet modifie l'objet, l'intitule du message
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * getter getcontenu
     *
     * @return le contenu du message
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * setter setcontenu
     *
     * @param contenu modifie le contenu du message
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * getter getdateenvoi
     *
     * @return date d'envoi du message
     */
    public LocalDate getDateEnvoi() {
        return dateEnvoi;
    }

    /**
     * setter setdateenvoi
     *
     * @param dateEnvoi modifie la date d'envoi du message
     */
    public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    /**
     * getter getemetteur
     *
     * @return l'employe qui envoie le message
     */
    public Employe getEmetteur() {
        return emetteur;
    }

    /**
     * setter setemetteur
     *
     * @param emetteur modifie l'employe qui envoie le message
     */
    public void setEmetteur(Employe emetteur) {
        this.emetteur = emetteur;
    }

    /**
     * getter getl_infos
     *
     * @return la liste des infos du message
     */
    public List<Infos> getL_infos() {
        return l_infos;
    }

    /**
     * setter setl_infos
     *
     * @param l_infos modifie la liste des infos du message
     */
    public void setL_infos(List<Infos> l_infos) {
        this.l_infos = l_infos;
    }

    /**
     * affichage des infos du message
     *
     * @return description complete du message
     */
    @Override
    public String toString() {
        return "Message{" +
                "id_mess=" + id_mess +
                ", objet='" + objet + '\'' +
                ", contenu='" + contenu + '\'' +
                ", dateEnvoi=" + dateEnvoi +
                ", id emetteur=" + id_mess +
                '}';
    }
}
