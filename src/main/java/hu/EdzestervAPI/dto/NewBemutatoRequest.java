package hu.EdzestervAPI.dto;

import hu.EdzestervAPI.domain.Bemutato;

public class NewBemutatoRequest {
    private int feladatid;
    private String fajlNeve;
    private String fajlTipusa;

    public int getFeladatid() {
        return feladatid;
    }

    public void setFeladatid(int feladatid) {
        this.feladatid = feladatid;
    }

    public String getFajlNeve() {
        return fajlNeve;
    }

    public void setFajlNeve(String fajlNeve) {
        this.fajlNeve = fajlNeve;
    }

    public String getFajlTipusa() {
        return fajlTipusa;
    }

    public void setFajlTipusa(String fajlTipusa) {
        this.fajlTipusa = fajlTipusa;
    }

    @Override
    public String toString() {
        return "NewBemutatoRequest{" +
                "feladatid=" + feladatid +
                ", fajlNeve='" + fajlNeve + '\'' +
                ", fajlTipusa='" + fajlTipusa + '\'' +
                '}';
    }

    public Bemutato toBemutato(){
        Bemutato bemutato = new Bemutato();
        bemutato.setFeladatid(this.feladatid);
        bemutato.setFajl_neve(this.fajlNeve);
        bemutato.setFajl_tipusa(this.fajlTipusa);
        return bemutato;
    }
}
