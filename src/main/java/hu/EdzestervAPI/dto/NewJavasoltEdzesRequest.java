package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.domain.JavasoltEdzes;

import java.util.Date;

public class NewJavasoltEdzesRequest {
    private int celid;
    private int feladatid;
    private Date datum;
    private int idotartam;

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

    @Override
    public String toString() {
        return "NewJavasoltEdzesRequest{" +
                "celid=" + celid +
                ", feladatid=" + feladatid +
                ", datum=" + datum +
                ", idotartam=" + idotartam +
                '}';
    }

    public JavasoltEdzes toJavasoltEdzes(){
        JavasoltEdzes javasoltEdzes = new JavasoltEdzes();
        javasoltEdzes.setCelid(this.celid);
        javasoltEdzes.setFeladatid(this.feladatid);
        javasoltEdzes.setDatum(this.datum);
        javasoltEdzes.setIdotartam(this.idotartam);
        return javasoltEdzes;
    }
}
