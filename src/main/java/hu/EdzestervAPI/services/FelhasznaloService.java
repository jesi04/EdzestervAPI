package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.domain.FelhasznaloList;
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

}
