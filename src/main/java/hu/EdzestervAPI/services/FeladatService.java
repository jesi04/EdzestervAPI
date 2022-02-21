package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.FeladatList;
import hu.EdzestervAPI.repositories.FeladatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeladatService {

    @Autowired
    private FeladatRepository repository;
    @Value("${server.port}")
    private int port;


    public List<FeladatList> getFeladatok() {
        List<FeladatList> feladatok = new ArrayList<>();
        List<Object[]> data = repository.getFeladatok();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            String nev = (String) object[1];
            int elegetettKcal = (Integer)object[2];
            String leiras = (String) object[3];
            String megjegyzes = (String) object[4];
            feladatok.add(new FeladatList(id, nev, elegetettKcal, leiras, megjegyzes));
        }
        return feladatok;
    }
}
