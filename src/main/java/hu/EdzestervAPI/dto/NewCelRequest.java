package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Cel;

import java.util.Date;

public class NewCelRequest {
    private int felhasznaloid;
    private int elerendoSuly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;


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

    @Override
    public String toString() {
        return "NewCelRequest{" +
                "felhasznaloid='" + felhasznaloid + '\'' +
                ", elerendoSuly=" + elerendoSuly +
                ", kezdes=" + kezdes +
                ", vege=" + vege +
                ", megjegyzes='" + megjegyzes + '\'' +
                '}';
    }

    public Cel toCel(){
        Cel cel = new Cel();
        cel.setFelhasznaloid(this.felhasznaloid);
        cel.setElerendo_suly(this.elerendoSuly);
        cel.setKezdes(this.kezdes);
        cel.setVege(this.vege);
        cel.setMegjegyzes(this.megjegyzes);
        return cel;
    }
}
