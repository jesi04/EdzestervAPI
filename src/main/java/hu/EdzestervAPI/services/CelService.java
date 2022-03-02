package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Cel;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.repositories.CelRepository;
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

    public Cel getCel(int id){
        Optional<Cel> cel = repository.findById(id);
        if(cel.isPresent())
            return cel.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Cel addCel(Cel cel){
        Optional<Cel> optionalCel = repository.findById(cel.getId());
        if(!optionalCel.isPresent()){
            return repository.save(cel);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public Cel updateCel(int id, int elerendoSuly) {
        Optional<Cel> optionalCel = repository.findById(id);
        if(optionalCel.isPresent()){
            Cel cel = optionalCel.get();
            cel.setElerendoSuly(elerendoSuly);
            return repository.save(cel);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteCel(int id) {
        Optional<Cel> optionalCel = repository.findById(id);
        if(optionalCel.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
