package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.Cel;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.dto.NewCelRequest;
import hu.EdzestervAPI.services.CelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CelController {
    @Autowired
    private CelService service;

    @GetMapping("/celok")
    public List<CelList> getCelok(){
        return service.getCelok();
    }

    @GetMapping("/celok/{id}")
    public Cel getCel(@PathVariable("id") int id){
        return service.getCel(id);
    }


    @PostMapping("/celok")
    @ResponseStatus(HttpStatus.CREATED)
    public Cel addCel(@RequestBody NewCelRequest newCelRequest){
        return service.addCel(newCelRequest);
    }

    @PatchMapping("/celok/{id}")
    public Cel updateCel(@PathVariable("id") int id, @RequestBody Cel cel){
        int elerendoSuly = cel.getElerendo_suly();
        return service.updateCel(id, elerendoSuly);
    }

    @DeleteMapping("/celok/{id}")
    public void deleteCel(@PathVariable("id") int id){
        service.deleteCel(id);
    }

}
