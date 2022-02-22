package hu.EdzestervAPI.domain;

import java.util.Date;

public class CelList {

    private int id;
    private int felhasznaloid;
    private int elerendoSuly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;

    public CelList(int id, int felhasznaloid, int elerendoSuly, Date kezdes, Date vege, String megjegyzes) {
        this.id = id;
        this.felhasznaloid = felhasznaloid;
        this.elerendoSuly = elerendoSuly;
        this.kezdes = kezdes;
        this.vege = vege;
        this.megjegyzes = megjegyzes;
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
