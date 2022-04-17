package hu.EdzestervAPI.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cel")
public class Cel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int felhasznaloid;
    private int elerendosuly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;


    public Cel(int id, int felhasznaloid, int elerendosuly, Date kezdes, Date vege, String megjegyzes) {
        this.id = id;
        this.felhasznaloid = felhasznaloid;
        this.elerendosuly = elerendosuly;
        this.kezdes = kezdes;
        this.vege = vege;
        this.megjegyzes = megjegyzes;
    }

    public Cel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFelhasznaloid() {
        return felhasznaloid;
    }

    public void setFelhasznaloid(int felhasznaloid) {
        this.felhasznaloid = felhasznaloid;
    }

    public int getElerendosuly() {
        return elerendosuly;
    }

    public void setElerendosuly(int elerendosuly) {
        this.elerendosuly = elerendosuly;
    }

    public Date getKezdes() {
        return kezdes;
    }

    public void setKezdes(Date kezdes) {
        this.kezdes = kezdes;
    }

    public Date getVege() {
        return vege;
    }

    public void setVege(Date vege) {
        this.vege = vege;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
