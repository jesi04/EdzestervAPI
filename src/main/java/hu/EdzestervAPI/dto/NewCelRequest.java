package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Cel;

import java.util.Date;

public class NewCelRequest {
    private int felhasznaloid;
    private int elerendo_suly;
    private Date kezdes;
    private Date vege;
    private String megjegyzes;


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

    @Override
    public String toString() {
        return "NewCelRequest{" +
                "felhasznaloid='" + felhasznaloid + '\'' +
                ", elerendo_suly=" + elerendo_suly +
                ", kezdes=" + kezdes +
                ", vege=" + vege +
                ", megjegyzes='" + megjegyzes + '\'' +
                '}';
    }

    public Cel toCel(){
        Cel cel = new Cel();
        cel.setFelhasznaloid(this.felhasznaloid);
        cel.setElerendo_suly(this.elerendo_suly);
        cel.setKezdes(this.kezdes);
        cel.setVege(this.vege);
        cel.setMegjegyzes(this.megjegyzes);
        return cel;
    }
}
