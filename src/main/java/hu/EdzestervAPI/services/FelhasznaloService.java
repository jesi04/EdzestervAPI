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



}
