package TradUML;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * classe metier du bureau des employes
 *
 * @author Daniele Nicolo
 * @version 1.0
 * @see Employe
 */
public class Bureau {

    /**
     * id unique du bureau
     */
    private int id_bur;
    /**
     * sigle unique du bureau
     */
    private String sigle;
    /**
     * numero de telephone du bureau
     */
    private String tel;
    /**
     * liste des employes qui travaillent dans un bureau
     */
    private List<Employe> employe = new ArrayList<>();

    /**
     * constructeur parametre
     *
     * @param id_bur id numerique unique du bureau
     * @param sigle  acronyme unique du bureau
     * @param tel    numero de telephone du bureau

     */
    public Bureau(int id_bur, String sigle, String tel) {
        this.id_bur = id_bur;
        this.sigle = sigle;
        this.tel = tel;
    }

    /**
     * getter getid
     *
     * @return id unique du bureau
     */
    public int getId() {
        return id_bur;
    }

    /**
     * setter setid
     *
     * @param id_bur changement de l'id unique du bureau
     */
    public void setId(int id_bur) {
        this.id_bur = id_bur;
    }

    /**
     * getter getsigle
     *
     * @return sigle unique du bureau
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * setter setsigle
     *
     * @param sigle changement du sigle unique du bureau
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * getter gettel
     *
     * @return numero de telephone du bureau
     */
    public String getTel() {
        return tel;
    }

    /**
     * setter settel
     *
     * @param tel changement du numero de telephone du bureau
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * getter getemploye
     *
     * @return employe la liste de tout les employes du bureau
     */
    public List<Employe> getEmploye() {
        return employe;
    }

    /**
     * setter setemploye
     *
     * @param employe modifie la liste de tout les employes
     */
    public void setEmploye(List<Employe> employe) {
        this.employe = employe;
    }

    /**
     * egalite de deux bureaux basee sur le sigle du bureau
     *
     * @param o autre bureau
     * @return egalite ou pas
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bureau bureau = (Bureau) o;
        return Objects.equals(sigle, bureau.sigle);
    }

    /**
     * calcul du hashcode du bureau base sur le sigle du bureau
     *
     * @return hashcode du bureau
     */
    @Override
    public int hashCode() {
        return Objects.hash(sigle);
    }

    /**
     * affichage des infos du bureau
     *
     * @return description complete du bureau
     */
    @Override
    public String toString() {
        return "Bureau{" +
                "id=" + id_bur +
                ", sigle='" + sigle + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
