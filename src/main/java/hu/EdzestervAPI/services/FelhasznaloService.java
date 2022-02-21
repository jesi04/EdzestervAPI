package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.FelhasznaloList;
import hu.EdzestervAPI.repositories.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

}
