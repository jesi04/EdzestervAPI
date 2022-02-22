package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Bemutato;
import hu.EdzestervAPI.domain.BemutatoList;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.repositories.BemutatoRepository;
import hu.EdzestervAPI.repositories.CelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


}
