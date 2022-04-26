package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.JavasoltEdzes;

import java.util.Date;

public class NewJavasoltEdzesRequest {
    private int celid;
    private int feladatid;
    private String nap;
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

    @Override
    public String toString() {
        return "NewJavasoltEdzesRequest{" +
                "celid=" + celid +
                ", feladatid=" + feladatid +
                ", nap=" + nap +
                ", idotartam=" + idotartam +
                '}';
    }

    public JavasoltEdzes toJavasoltEdzes(){
        JavasoltEdzes javasoltEdzes = new JavasoltEdzes();
        javasoltEdzes.setCelid(this.celid);
        javasoltEdzes.setFeladatid(this.feladatid);
        javasoltEdzes.setNap(this.nap);
        javasoltEdzes.setIdotartam(this.idotartam);
        return javasoltEdzes;
    }
}
