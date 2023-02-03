package TradUML;

import java.util.ArrayList;
import java.util.List;

public class Bureau {
    private int id;
    private String sigle;
    private String tel;
    private List<Employe> employe = new ArrayList<>();

    public Bureau(int id, String sigle, String tel) {
        this.id = id;
        this.sigle = sigle;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(List<Employe> employe) {
        this.employe = employe;
    }
}
