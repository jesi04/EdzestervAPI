package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Bemutato;
import hu.EdzestervAPI.domain.BemutatoList;
import hu.EdzestervAPI.dto.NewBemutatoRequest;
import hu.EdzestervAPI.repositories.BemutatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
        List<Bemutato> data = repository.getBemutatok();
        for (Bemutato bemutato : data) {
            int id = bemutato.getId();
            int feladatid = bemutato.getFeladatid();
            String faljNeve = bemutato.getFajl_neve();
            String fajlTipusa = bemutato.getFajl_tipusa();
            bemutatok.add(new BemutatoList(id, feladatid, faljNeve, fajlTipusa));
        }
        return bemutatok;
    }

    public Bemutato getBemutato(int id){
        Optional<Bemutato> bemutato = repository.findById(id);
        if(bemutato.isPresent())
            return bemutato.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Bemutato addBemutato(NewBemutatoRequest newBemutatoRequest){
        Bemutato bemutato=newBemutatoRequest.toBemutato();
        System.out.println(newBemutatoRequest);
        return repository.save(bemutato);
    }

    public Bemutato updateBemutato(int id, String fajlNeve) {
        Optional<Bemutato> optionalBemutato = repository.findById(id);
        if(optionalBemutato.isPresent()){
            Bemutato bemutato = optionalBemutato.get();
            bemutato.setFajl_neve(fajlNeve);
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
