package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Bemutato;
import hu.EdzestervAPI.domain.BemutatoList;
import hu.EdzestervAPI.domain.Cel;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.repositories.BemutatoRepository;
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
public class BemutatoService {

    @Autowired
    private BemutatoRepository repository;
    @Value("${server.port}")
    private int port;

    public List<BemutatoList> getBemutatok() {
        List<BemutatoList> bemutatok = new ArrayList<>();
        List<Object[]> data = repository.getBemutatok();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            int feladatid = (Integer)object[1];
            String faljNeve = (String) object[2];
            String fajlTipusa = (String) object[3];
            bemutatok.add(new BemutatoList(id, feladatid, faljNeve, fajlTipusa));
        }
        return bemutatok;
    }

    public Bemutato getBemutato(int id){
        Optional<Bemutato> bemutato = repository.findById(id);
        System.out.println("bemutatoid");
        if(bemutato.isPresent())
            return bemutato.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Bemutato addBemutato(Bemutato bemutato){
        Optional<Bemutato> optionalBemutato = repository.findById(bemutato.getId());
        if(!optionalBemutato.isPresent()){
            return repository.save(bemutato);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public Bemutato updateBemutato(int id, String fajlNeve) {
        Optional<Bemutato> optionalBemutato = repository.findById(id);
        if(optionalBemutato.isPresent()){
            Bemutato bemutato = optionalBemutato.get();
            bemutato.setFajlNeve(fajlNeve);
            return repository.save(bemutato);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteBemutato(int id) {
        Optional<Bemutato> optionalBemutato = repository.findById(id);
        if(optionalBemutato.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
