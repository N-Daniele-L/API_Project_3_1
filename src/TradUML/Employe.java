package TradUML;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe metier des employes
 *
 * @author Daniele Nicolo
 * @version 1.0
 * @see Bureau
 * @see Infos
 */
public class Employe {
    /**
     * id unique de l'employe
     */
    private int id_emp;
    /**
     * adresse mail unique de l'employe
     */
    private String mail;
    /**
     * nom de l'employe
     */
    private String nom;
    /**
     * prenom de l'employe
     */
    private String prenom;
    /**
     * bureau ou l'employe travaille
     */
    private Bureau bureau;
    private int id_bur;

    public int getId_emp() {
        return id_emp;
    }

    public int getId_bur() {
        return id_bur;
    }

    /**
     * message que l'employe a ecrit
     */
    private List<Message> msg = new ArrayList<>();

    /**
     * constructeur parametre
     *
     * @param id_emp id numerique unique de l'employe
     * @param mail   adresse mail unique de l'employe
     * @param nom    nom de l'employe
     * @param prenom prenom de l'employe

     */

    public Employe(int id_emp, String mail, String nom, String prenom, int id_bur) {
        this.id_emp = id_emp;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.id_bur = id_bur;
    }

    /**
     * getter getid
     *
     * @return id unique de l'employe
     */
    public int getId() {
        return id_emp;
    }

    /**
     * setter setid
     *
     * @param id_emp changement de l'id unique de l'employe
     */
    public void setId(int id_emp) {
        this.id_emp = id_emp;
    }

    /**
     * getter getmail
     *
     * @return adresse mail unique de l'employe
     */
    public String getMail() {
        return mail;
    }

    /**
     * setter setmail
     *
     * @param mail changement du mail unique de l'employe
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * getter getnom
     *
     * @return nom de l'employe
     */
    public String getNom() {
        return nom;
    }

    public int getIdBur(){
        return id_bur;
    }
    /**
     * setter setnom
     *
     * @param nom de l'employe
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter getprenom
     *
     * @return prenom de l'employe
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * setter setprenom
     *
     * @param prenom de l'employe
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * getter getmsg
     *
     * @return la liste des messages ecrit de l'employe
     */
    public List<Message> getMsg() {
        return msg;
    }

    /**
     * setter setmsg
     *
     * @param msg modifie la liste des messages ecrit de l'employe
     */
    public void setMsg(List<Message> msg) {
        this.msg = msg;
    }

    /**
     * getter getbureau
     *
     * @return le bureau de l'employe ou il travaille
     */
    public Bureau getBureau() {
        return bureau;
    }

    /**
     * setter setbureau
     *
     * @param bureau modifie le bureau de l'employe ou il travaille
     */
    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
    }

    /**
     * egalite de deux employes basee sur l'adresse mail de l'employe
     *
     * @param o autre employe
     * @return egalite ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(mail, employe.mail);
    }

    /**
     * calcul du hashcode du produit base sur l'adresse mail de l'employe
     *
     * @return hashcode de l'employe
     */
    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    /**
     * affichage des infos de l'employe
     *
     * @return description complete de l'employe
     */
    @Override
    public String toString() {
        return "Employe{" +
                "id_emp=" + id_emp +
                ", mail='" + mail + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", bureau=" + bureau +
                '}';
    }
}

