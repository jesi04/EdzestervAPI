package hu.EdzestervAPI.domain;

import java.util.Date;

public class JavasoltEdzesList {
    private int id;
    private int celid;
    private int feladatid;
    private String nap;
    private int idotartam;

    public JavasoltEdzesList(int id, int celid, int feladatid, String nap, int idotartam) {
        this.id = id;
        this.celid = celid;
        this.feladatid = feladatid;
        this.nap = nap;
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

    public String getNap() {
        return nap;
    }

    public void setNap(String nap) {
        this.nap = nap;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }
}
