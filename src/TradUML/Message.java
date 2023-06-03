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
    protected int id_mess;
    /**
     * objet du message
     */
    protected String objet;
    /**
     * contenu du message
     */
    protected String contenu;
    /**
     * date d'envoi du message
     */
    protected LocalDate dateEnvoi;
    /**
     * employe qui a envoyer le message
     */

    protected Employe emetteur;
    protected int id_emp;
    /**
     * liste des infos du message
     * infos contient l'employe qui recois le message et la date de lecture du message
     * si la date de lecture est nulle alors le message n'a pas encore ete lu
     */
    protected List<Infos> l_infos = new ArrayList<>();

    /**
     * constructeur parametre
     *
     * @param bm objet de la classe BuilderMessage
     */
    public Message(MessageBuilder bm) {
        this.id_mess = bm.id_mess;
        this.objet = bm.objet;
        this.contenu = bm.contenu;
        this.dateEnvoi = bm.dateEnvoi;
        this.id_emp = bm.id_emp;
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
     * getter getobjet
     *
     * @return l'objet, l'intitule du message
     */
    public String getObjet() {
        return objet;
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
     * getter getdateenvoi
     *
     * @return date d'envoi du message
     */
    public LocalDate getDateEnvoi() {
        return dateEnvoi;
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
     * getter getl_infos
     *
     * @return la liste des infos du message
     */
    public List<Infos> getL_infos() {
        return l_infos;
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

    public static class MessageBuilder{
        /**
         * id unique du message
         */
        protected int id_mess;
        /**
         * objet du message
         */
        protected String objet;
        /**
         * contenu du message
         */
        protected String contenu;
        /**
         * date d'envoi du message
         */
        protected LocalDate dateEnvoi;
        /**
         * employe qui a envoyer le message
         */

        protected Employe emetteur;
        protected int id_emp;
        /**
         * liste des infos du message
         * infos contient l'employe qui recois le message et la date de lecture du message
         * si la date de lecture est nulle alors le message n'a pas encore ete lu
         */
        protected List<Infos> l_infos = new ArrayList<>();

        /**
         * setter setid
         *
         * @param id_mess change l'id unique du message
         */
        public MessageBuilder setId(int id_mess) {
            this.id_mess = id_mess;
            return this;
        }
        /**
         * setter setobjet
         *
         * @param objet modifie l'objet, l'intitule du message
         */
        public MessageBuilder setObjet(String objet) {
            this.objet = objet;
            return this;
        }

        /**
         * setter setcontenu
         *
         * @param contenu modifie le contenu du message
         */
        public MessageBuilder setContenu(String contenu) {
            this.contenu = contenu;
            return this;
        }

        /**
         * setter setdateenvoi
         *
         * @param dateEnvoi modifie la date d'envoi du message
         */
        public MessageBuilder setDateEnvoi(LocalDate dateEnvoi) {
            this.dateEnvoi = dateEnvoi;
            return this;
        }

        /**
         * setter setemetteur
         *
         * @param emetteur modifie l'employe qui envoie le message
         */
        public MessageBuilder setEmetteur(Employe emetteur) {
            this.emetteur = emetteur;
            return this;
        }

        /**
         * setter setl_infos
         *
         * @param l_infos modifie la liste des infos du message
         */
        public MessageBuilder setL_infos(List<Infos> l_infos) {
            this.l_infos = l_infos;
            return this;
        }

        public MessageBuilder setId_emp(int id_emp){
            this.id_emp = id_emp;
            return this;
        }

        public Message build() throws Exception{
            /*if(l_infos.isEmpty()) throw new
                    Exception("informations de construction incomplètes aka : linfos est vide");*/
            return new Message(this);
        }
    }
}
