package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.Felhasznalo;
import hu.EdzestervAPI.domain.FelhasznaloList;
import hu.EdzestervAPI.services.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FelhasznaloController {

    @Autowired
    private FelhasznaloService service;

    @GetMapping("/felhasznalok")
    public List<FelhasznaloList> getFelhasznalok(){
        return service.getFelhasznalok();
    }

    @GetMapping("/felhasznalok/{id}")
    public Felhasznalo getFelhasznalo(@PathVariable("id") int id){
        return service.getFelhasznalo(id);
    }

}
