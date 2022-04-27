package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.domain.JavasoltEdzes;
import hu.EdzestervAPI.domain.JavasoltEdzesList;
import hu.EdzestervAPI.dto.NewFelhasznaloRequest;
import hu.EdzestervAPI.dto.NewJavasoltEdzesRequest;
import hu.EdzestervAPI.services.CelService;
import hu.EdzestervAPI.services.JavasoltEdzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JavasoltEdzesController {
    @Autowired
    private JavasoltEdzesService service;

    @GetMapping("/javasoltak")
    public List<JavasoltEdzesList> getJavasoltak(){
        return service.getJavasoltak();
    }

    @GetMapping("/javasoltak/{id}")
    public JavasoltEdzes getJavasoltEdzes(@PathVariable("id") int id){
        return service.getJavasoltEdzes(id);
    }

    @PostMapping("/javasoltak")
    @ResponseStatus(HttpStatus.CREATED)
    public JavasoltEdzes addJavasoltEdzes(@RequestBody NewJavasoltEdzesRequest newJavasoltEdzesRequest){
        return service.addJavasoltEdzes(newJavasoltEdzesRequest);
    }

    @PatchMapping("/javasoltak/{id}")
    public JavasoltEdzes updateJavasoltEdzes(@PathVariable("id") int id, @RequestBody JavasoltEdzes javasoltEdzes){
        int idotartam = javasoltEdzes.getIdotartam();
        return service.updateJavasoltEdzes(id, idotartam);
    }

    @DeleteMapping("/javasoltak/{id}")
    public void deleteJavasoltEdzes(@PathVariable("id") int id){
        service.deleteJavasoltEdzes(id);
    }
}
