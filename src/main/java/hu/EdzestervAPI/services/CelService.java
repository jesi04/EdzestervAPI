package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.repositories.CelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CelService {

    @Autowired
    private CelRepository repository;
    @Value("${server.port}")
    private int port;


    public List<CelList> getCelok() {
        List<CelList> celok = new ArrayList<>();
        List<Object[]> data = repository.getCelok();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            int felhasznaloid = (Integer)object[1];
            int elerendoSuly = (Integer)object[2];
            Date kezdes = (Date)object[3];
            Date vege = (Date)object[4];
            String megjegyzes = (String) object[5];
            celok.add(new CelList(id, felhasznaloid, elerendoSuly, kezdes, vege, megjegyzes));
        }
        return celok;
    }
}
