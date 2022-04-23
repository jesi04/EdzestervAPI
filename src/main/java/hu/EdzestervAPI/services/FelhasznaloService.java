package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.dto.NewFelhasznaloRequest;
import hu.EdzestervAPI.repositories.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
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
        List<Object[]> data = repository.getFelhasznalok();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            String email = (String) object[1];
            String nev = (String) object[2];
            Date szuldat = (Date) object[3];
            int magassag = (Integer) object[4];
            String megjegyzes = (String) object[5];
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
        List<Object[]> data = repository.getEdzestervek();
        for (Object[] object : data) {
            int id = (Integer) object[0];
            String nev = (String) object[1];
            int elerendoSuly = (Integer) object[2];
            String celMegjegyzes = (String) object[3];
            edzestervek.add(new Edzesterv(id, nev, elerendoSuly, celMegjegyzes));
        }
        return edzestervek;
    }

    public List<Edzesnap> getEdzesnapok(int felhid) {
        List<Edzesnap> eredmeny = new ArrayList<>();
        List<Object[]> edzesnapok = repository.edzesnapok(felhid);
        for (Object[] object : edzesnapok) {
            int id = (Integer) object[0];
            String izomcsoport = (String) object[1];
            eredmeny.add(new Edzesnap(id, izomcsoport));
        }
        return eredmeny;
    }

}
