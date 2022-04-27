package hu.EdzestervAPI.domain;

import java.util.Date;

public class CelList {

    private int id;
    private int felhasznaloid;
    private int elerendo_suly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;

    public CelList(int id, int felhasznaloid, int elerendo_suly, Date kezdes, Date vege, String megjegyzes) {
        this.id = id;
        this.felhasznaloid = felhasznaloid;
        this.elerendo_suly = elerendo_suly;
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

    public int getElerendo_suly() {
        return elerendo_suly;
    }

    public void setElerendo_suly(int elerendo_suly) {
        this.elerendo_suly = elerendo_suly;
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
