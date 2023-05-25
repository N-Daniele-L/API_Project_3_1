package TradUML;

import java.time.LocalDate;
import java.util.Date;

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

    /**
     * constructeur parametre
     *
     * @param recepteur employe qui recois le message
     */
    public Infos(Employe recepteur) {
        this.recepteur = recepteur;
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
    public int getId() {
        return id_emp;
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
                "dateLecture=" + dateLecture +
                ",Id recepteur=" + id_emp +
                '}';
    }
}
