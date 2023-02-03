package TradUML;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employe {
    private int id;
    private String mail;
    private String nom;
    private String prenom;
    private Bureau bureau;
    private List<Message> msg = new ArrayList<>();

    public Employe(int id, String mail, String nom, String prenom) {
        this.id = id;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Message> getMsg() {
        return msg;
    }

    public void setMsg(List<Message> msg) {
        this.msg = msg;
    }

    public Bureau getBureau() {
        return bureau;
    }

    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(mail, employe.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
