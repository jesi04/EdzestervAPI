package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Cel;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.dto.NewCelRequest;
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
        List<Cel> data = repository.getCelok();
        for (Cel cel : data) {
            int id = cel.getId();
            int felhasznaloid = cel.getFelhasznaloid();
            int elerendo_suly = cel.getElerendo_suly();
            Date kezdes = cel.getKezdes();
            Date vege = cel.getVege();
            String megjegyzes = cel.getMegjegyzes();
            celok.add(new CelList(id, felhasznaloid, elerendo_suly, kezdes, vege, megjegyzes));
        }
        return celok;
    }

    public Cel getCel(int id){
        Optional<Cel> cel = repository.findById(id);
        if(cel.isPresent()){
            return cel.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }



    public Cel addCel(NewCelRequest newCelRequest){
        Cel cel=newCelRequest.toCel();
        System.out.println(newCelRequest);
        return repository.save(cel);
    }

    public Cel updateCel(int id, int elerendo_suly) {
        Optional<Cel> optionalCel = repository.findById(id);
        if(optionalCel.isPresent()){
            Cel cel = optionalCel.get();
            cel.setElerendo_suly(elerendo_suly);
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
