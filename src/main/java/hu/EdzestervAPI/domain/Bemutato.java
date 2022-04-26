package hu.EdzestervAPI.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bemutato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int feladatid;
    private String fajl_neve;
    private String fajl_tipusa;


    public Bemutato(int id, int feladatid, String fajlNeve, String fajlTipusa) {
        this.id = id;
        this.feladatid = feladatid;
        this.fajl_neve = fajlNeve;
        this.fajl_tipusa = fajlTipusa;
    }

    public Bemutato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeladatid() {
        return feladatid;
    }

    public void setFeladatid(int feladatid) {
        this.feladatid = feladatid;
    }

    public String getFajl_neve() {
        return fajl_neve;
    }

    public void setFajl_neve(String fajl_neve) {
        this.fajl_neve = fajl_neve;
    }

    public String getFajl_tipusa() {
        return fajl_tipusa;
    }

    public void setFajl_tipusa(String fajl_tipusa) {
        this.fajl_tipusa = fajl_tipusa;
    }
}
