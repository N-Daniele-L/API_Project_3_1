package TradUML;

import java.time.LocalDate;

/**
 * classe metier des informations des messages que les employes recoivent
 *
 * @author Daniele Nicolo
 * @version 1.0
 * @see Employe
 * @see Message
 */
public class Infos {
    /**
     * date de lecture du message par l'employe il est null par defaut
     */
    private LocalDate dateLecture = null;
    /**
     * employe recepteur qui recois le message
     */
    private Employe recepteur;
    private int id_emp;

    private Message mess;
    private int id_mess;

    /**
     * constructeur parametre
     *
     * @param recepteur employe qui recois le message
     */
    public Infos(Employe recepteur, Message mess) {
        this.recepteur = recepteur;
        this.mess = mess;
    }

    public Infos(int recepteur, int mess,LocalDate date) {
        this.id_emp = recepteur;
        this.id_mess = mess;
        this.dateLecture = date;
    }

    /**
     * getter datelecture
     *
     * @return la date de lecture de l'employe si elle est nulle alors l'employe n'a pas encore lu le message
     */
    public LocalDate getDateLecture() {
        return dateLecture;
    }

    /**
     * setter setdatelecture
     *
     * @param dateLecture qui sera attribuee automatiquement quand l'employe aura lu le message
     */
    public void setDateLecture(LocalDate dateLecture) {
        this.dateLecture = dateLecture;
    }

    /**
     * getter getrecepteur
     *
     * @return l'employe qui recois le message
     */
    public Employe getRecepteur() {
        return recepteur;
    }
    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public Message getMess() {
        return mess;
    }

    public void setMess(Message mess) {
        this.mess = mess;
    }

    public int getId_mess() {
        return id_mess;
    }

    public void setId_mess(int id_mess) {
        this.id_mess = id_mess;
    }

    /**
     * setter setrecepteur
     *
     * @param recepteur modifie l'employe qui recois le message
     */
    public void setRecepteur(Employe recepteur) {
        this.recepteur = recepteur;
    }

    /**
     * affichage des infos de la classe info, donc de la date de lecture et de l'employe recepteur
     *
     * @return description complete de la classe infos
     */
    @Override
    public String toString() {
        return "Infos{" +

                "Id du recepteur=" + id_emp +
                ", Id du message=" + id_mess +
                ", Date de lecture=" + dateLecture +
                '}';
    }
}
