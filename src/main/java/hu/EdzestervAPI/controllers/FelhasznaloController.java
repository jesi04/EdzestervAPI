package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.dto.NewFelhasznaloRequest;
import hu.EdzestervAPI.services.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/felhasznalok")
    @ResponseStatus(HttpStatus.CREATED)
    public Felhasznalo addFelhasznalo(@RequestBody NewFelhasznaloRequest newFelhasznaloRequest){
        return service.addFelhasznalo(newFelhasznaloRequest);
    }

    @PatchMapping("/felhasznalok/{id}")
    public Felhasznalo updateFelhasznalo(@PathVariable("id") int id, @RequestBody Felhasznalo felhasznalo){
        String email = felhasznalo.getEmail();
        return service.updateFelhasznalo(id, email);
    }

    @DeleteMapping("/felhasznalok/{id}")
    public void deleteFelhasznalo(@PathVariable("id") int id){
        service.deleteFelhasznalo(id);
    }



}
