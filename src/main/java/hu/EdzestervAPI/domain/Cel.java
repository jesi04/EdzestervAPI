package hu.EdzestervAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int felhasznaloid;
    private int elerendoSuly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;

    public Cel(int id, int felhasznaloid, int elerendoSuly, Date kezdes, Date vege, String megjegyzes) {
        this.id = id;
        this.felhasznaloid = felhasznaloid;
        this.elerendoSuly = elerendoSuly;
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

    public int getElerendoSuly() {
        return elerendoSuly;
    }

    public void setElerendoSuly(int elerendoSuly) {
        this.elerendoSuly = elerendoSuly;
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
