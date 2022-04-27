package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.JavasoltEdzes;
import hu.EdzestervAPI.domain.JavasoltEdzesList;
import hu.EdzestervAPI.dto.NewJavasoltEdzesRequest;
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
        List<JavasoltEdzes> data = repository.getJavasoltak();
        for (JavasoltEdzes javasoltEdzes : data) {
            int id = javasoltEdzes.getId();
            int celid = javasoltEdzes.getCelid();
            int feladatid = javasoltEdzes.getFeladatid();
            String nap = javasoltEdzes.getNap();
            int idotartam = javasoltEdzes.getIdotartam();
            javasoltak.add(new JavasoltEdzesList(id, celid, feladatid, nap, idotartam));
        }
        return javasoltak;
    }

    public JavasoltEdzes getJavasoltEdzes(int id){
        Optional<JavasoltEdzes> javasoltEdzes = repository.findById(id);
        if(javasoltEdzes.isPresent())
            return javasoltEdzes.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public JavasoltEdzes addJavasoltEdzes(NewJavasoltEdzesRequest newJavasoltEdzesRequest){
        JavasoltEdzes javasoltEdzes = newJavasoltEdzesRequest.toJavasoltEdzes();
        System.out.println(newJavasoltEdzesRequest);
        return repository.save(javasoltEdzes);
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
