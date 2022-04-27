package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.dto.NewFeladatRequest;
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
        List<Feladat> data = repository.getFeladatok();
        for (Feladat feladat : data) {
            int id = feladat.getId();
            String nev = feladat.getNev();
            int elegetettKcal = feladat.getElegetett_kcal();
            String leiras = feladat.getLeiras();
            String megjegyzes = feladat.getMegjegyzes();
            String izomcsoport = feladat.getIzomcsoport();
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

    public Feladat addFeladat(NewFeladatRequest newFeladatRequest){
        Feladat feladat=newFeladatRequest.toFeladat();
        System.out.println(newFeladatRequest);
        return repository.save(feladat);
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



}
