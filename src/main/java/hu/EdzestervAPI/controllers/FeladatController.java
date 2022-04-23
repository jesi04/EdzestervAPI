package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.*;
import hu.EdzestervAPI.services.FeladatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeladatController {
    @Autowired
    private FeladatService service;

    @GetMapping("/feladatok")
    public List<FeladatList> getFeladatok(){
        return service.getFeladatok();
    }

    @GetMapping("/feladatok/{id}")
    public Feladat getFeladat(@PathVariable("id") int id){
        return service.getFeladat(id);
    }

    @PostMapping("/feladatok")
    @ResponseStatus(HttpStatus.CREATED)
    public Feladat addFeladat(@RequestBody Feladat feladat){
        return service.addFeladat(feladat);
    }

    @PatchMapping("/feladatok/{id}")
    public Feladat updateFeladatok(@PathVariable("id") int id, @RequestBody Feladat feladat){
        String leiras = feladat.getLeiras();
        return service.updateFeladat(id, leiras);
    }

    @DeleteMapping("/feladatok/{id}")
    public void deleteFeladatok(@PathVariable("id") int id){
        service.deleteFeladatok(id);
    }

    @GetMapping("/edzesnapfeladatok/{id}")
    public List<EdzesnapFeladat> getEdzesnapfeladatok(@PathVariable("id") int edzesnapFeladatId){
        return service.getEdzesnapFeladatok(edzesnapFeladatId);
    }
}
