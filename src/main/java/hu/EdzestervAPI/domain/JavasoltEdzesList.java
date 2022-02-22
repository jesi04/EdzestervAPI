package hu.EdzestervAPI.domain;

import java.util.Date;

public class JavasoltEdzesList {
    private int id;
    private int celid;
    private int feladatid;
    private Date datum;
    private int idotartam;

    public JavasoltEdzesList(int id, int celid, int feladatid, Date datum, int idotartam) {
        this.id = id;
        this.celid = celid;
        this.feladatid = feladatid;
        this.datum = datum;
        this.idotartam = idotartam;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCelid() {
        return celid;
    }

    public void setCelid(int celid) {
        this.celid = celid;
    }

    public int getFeladatid() {
        return feladatid;
    }

    public void setFeladatid(int feladatid) {
        this.feladatid = feladatid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }
}
