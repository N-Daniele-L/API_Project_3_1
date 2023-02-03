package TradUML;

import java.util.Date;

public class Infos {
    private Date dateLecture;
    private Employe recepteur;

    public Infos(Date dateLecture, Employe recepteur) {
        this.dateLecture = dateLecture;
        this.recepteur = recepteur;
    }
    public Date getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(Date dateLecture) {
        this.dateLecture = dateLecture;
    }

    public Employe getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Employe recepteur) {
        this.recepteur = recepteur;
    }


}
