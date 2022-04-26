package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.dto.NewFelhasznaloRequest;
import hu.EdzestervAPI.repositories.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FelhasznaloService {
    @Autowired
    private FelhasznaloRepository repository;
    @Value("${server.port}")
    private int port;

    public List<FelhasznaloList> getFelhasznalok() {
        List<FelhasznaloList> felhasznalok = new ArrayList<>();
        List<Felhasznalo> data = repository.getFelhasznalok();
        for (Felhasznalo felhasznalo : data) {
            int id = felhasznalo.getId();
            String email = felhasznalo.getEmail();
            String nev = felhasznalo.getNev();
            Date szuldat = felhasznalo.getSzuldat();
            int magassag = felhasznalo.getMagassag();
            String megjegyzes = felhasznalo.getMegjegyzes();
            felhasznalok.add(new FelhasznaloList(id, email, nev, szuldat, magassag, megjegyzes));
        }
        return felhasznalok;
    }

    public Felhasznalo getFelhasznalo(int id){
            Optional<Felhasznalo> felhasznalo = repository.findById(id);
            if(felhasznalo.isPresent())
                return felhasznalo.get();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    /*public Felhasznalo addFelhasznalo(Felhasznalo felhasznalo){
        Optional<Felhasznalo> optionalFelhasznalo = repository.findById(felhasznalo.getId());
        if(!optionalFelhasznalo.isPresent()){
            return repository.save(felhasznalo);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }*/

    public Felhasznalo addFelhasznalo(NewFelhasznaloRequest newFelhasznaloRequest){
        Felhasznalo felhasznalo=newFelhasznaloRequest.toFelhasznalo();
        System.out.println(newFelhasznaloRequest);
        return repository.save(felhasznalo);
    }

    public Felhasznalo updateFelhasznalo(int id, String email) {
        Optional<Felhasznalo> optionalFelhasznalo = repository.findById(id);
        if(optionalFelhasznalo.isPresent()){
            Felhasznalo felhasznalo = optionalFelhasznalo.get();
            felhasznalo.setEmail(email);
            return repository.save(felhasznalo);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteFelhasznalo(int id) {
        Optional<Felhasznalo> optionalFelhasznalo = repository.findById(id);
        if(optionalFelhasznalo.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Edzesterv> getEdzestervek() {
        List<Edzesterv> edzestervek = new ArrayList<>();
        List<Edzesterv> data = repository.getEdzestervek();
        for (Edzesterv edzesterv : data) {
            int id = edzesterv.getId();
            String email = edzesterv.getEmail();
            String nev = edzesterv.getNev();
            Date szuldat = edzesterv.getSzuldat();
            String felhasznaloMegjegyzes = edzesterv.getFelhasznaloMegjegyzes();
            int celId = edzesterv.getCelId();
            int felhasznaloid = edzesterv.getFelhasznaloid();
            int elerendoSuly = edzesterv.getElerendo_suly();
            Date kezdes = edzesterv.getKezdes();
            Date vege = edzesterv.getVege();
            String celMegjegyzes = edzesterv.getCelMegjegyzes();
            edzestervek.add(new Edzesterv(id, email, nev, szuldat, felhasznaloMegjegyzes, celId, felhasznaloid, elerendoSuly, kezdes, vege, celMegjegyzes));
        }
        return edzestervek;
    }

    public List<Edzesnap> getEdzesnapok(int felhid) {
        List<Edzesnap> eredmeny = new ArrayList<>();
        List<Edzesnap> edzesnapok = repository.edzesnapok(felhid);
        for (Edzesnap edzesnap : edzesnapok) {
            int id = edzesnap.getId();
            String izomcsoport = edzesnap.getIzomcsport();
            eredmeny.add(new Edzesnap(id, izomcsoport));
        }
        return eredmeny;
    }

}
