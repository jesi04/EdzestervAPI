package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.repositories.FeladatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeladatService {

    @Autowired
    private FeladatRepository repository;
    @Value("${server.port}")
    private int port;


    public List<FeladatList> getFeladatok() {
        List<FeladatList> feladatok = new ArrayList<>();
        List<Object[]> data = repository.getFeladatok();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            String nev = (String) object[1];
            int elegetettKcal = (Integer)object[2];
            String leiras = (String) object[3];
            String megjegyzes = (String) object[4];
            String izomcsoport = (String) object[5];
            feladatok.add(new FeladatList(id, nev, elegetettKcal, leiras, megjegyzes, izomcsoport));
        }
        return feladatok;
    }

    public Feladat getFeladat(int id){
        Optional<Feladat> feladat = repository.findById(id);
        if(feladat.isPresent())
            return feladat.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Feladat addFeladat(Feladat feladat){
        Optional<Feladat> optionalFeladat = repository.findById(feladat.getId());
        if(!optionalFeladat.isPresent()){
            return repository.save(feladat);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public Feladat updateFeladat(int id, String leiras) {
        Optional<Feladat> optionalFeladat = repository.findById(id);
        if(optionalFeladat.isPresent()){
            Feladat feladat = optionalFeladat.get();
            feladat.setLeiras(leiras);
            return repository.save(feladat);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteFeladatok(int id) {
        Optional<Feladat> optionalFeladat = repository.findById(id);
        if(optionalFeladat.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<EdzesnapFeladat> getEdzesnapFeladatok(int edzesfelid) {
        List<EdzesnapFeladat> eredmeny = new ArrayList<>();
        List<Object[]> edzesnapFeladatok = repository.edzesnapFeladatok(edzesfelid);
        for (Object[] object : edzesnapFeladatok) {
            int id = (Integer) object[0];
            String nev = (String) object[1];
            String leiras = (String) object[2];
            String megjegyzes = (String) object[3];
            eredmeny.add(new EdzesnapFeladat(id, nev, leiras, megjegyzes));
        }
        return eredmeny;
    }
/*
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
*/

}
