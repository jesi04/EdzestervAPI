package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.domain.FelhasznaloList;
import hu.EdzestervAPI.domain.JavasoltEdzes;
import hu.EdzestervAPI.domain.JavasoltEdzesList;
import hu.EdzestervAPI.repositories.BemutatoRepository;
import hu.EdzestervAPI.repositories.JavasoltEdzesRepository;
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
public class JavasoltEdzesService {
    @Autowired
    private JavasoltEdzesRepository repository;
    @Value("${server.port}")
    private int port;


    public List<JavasoltEdzesList> getJavasoltak() {
        List<JavasoltEdzesList> javasoltak = new ArrayList<>();
        List<Object[]> data = repository.getJavasoltak();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            int celid = (Integer)object[1];
            int feladatid = (Integer)object[2];
            Date datum = (Date) object[3];
            int idotartam = (Integer) object[4];
            javasoltak.add(new JavasoltEdzesList(id, celid, feladatid, datum, idotartam));
        }
        return javasoltak;
    }

    public JavasoltEdzes getJavasoltEdzes(int id){
        Optional<JavasoltEdzes> javasoltEdzes = repository.findById(id);
        if(javasoltEdzes.isPresent())
            return javasoltEdzes.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public JavasoltEdzes addJavasoltEdzes(JavasoltEdzes javasoltEdzes){
        Optional<JavasoltEdzes> optionalJavasoltEdzes = repository.findById(javasoltEdzes.getId());
        if(!optionalJavasoltEdzes.isPresent()){
            return repository.save(javasoltEdzes);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public JavasoltEdzes updateJavasoltEdzes(int id, int idotartam) {
        Optional<JavasoltEdzes> optionalJavasoltEdzes = repository.findById(id);
        if(optionalJavasoltEdzes.isPresent()){
            JavasoltEdzes javasoltEdzes = optionalJavasoltEdzes.get();
            javasoltEdzes.setIdotartam(idotartam);
            return repository.save(javasoltEdzes);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteJavasoltEdzes(int id) {
        Optional<JavasoltEdzes> optionalJavasoltEdzes = repository.findById(id);
        if(optionalJavasoltEdzes.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
