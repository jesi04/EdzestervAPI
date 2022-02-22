package hu.EdzestervAPI.services;

import hu.EdzestervAPI.domain.FelhasznaloList;
import hu.EdzestervAPI.domain.JavasoltEdzesList;
import hu.EdzestervAPI.repositories.BemutatoRepository;
import hu.EdzestervAPI.repositories.JavasoltEdzesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


}
