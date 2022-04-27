package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.Bemutato;
import hu.EdzestervAPI.domain.BemutatoList;
import hu.EdzestervAPI.dto.NewBemutatoRequest;
import hu.EdzestervAPI.services.BemutatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BemutatoController {
    @Autowired
    private BemutatoService service;

    @GetMapping("/bemutatok")
    public List<BemutatoList> getBemutatok(){
        return service.getBemutatok();
    }

    @GetMapping("/bemutatok/{id}")
    public Bemutato getBemutato(@PathVariable("id") int id){
        return service.getBemutato(id);
    }



    @PostMapping("/bemutatok")
    @ResponseStatus(HttpStatus.CREATED)
    public Bemutato addBemutato(@RequestBody NewBemutatoRequest newBemutatoRequest){
        return service.addBemutato(newBemutatoRequest);
    }

    @PatchMapping("/bemutatok/{id}")
    public Bemutato updateBemutato(@PathVariable("id") int id, @RequestBody Bemutato bemutato){
        String fajlNeve = bemutato.getFajl_neve();
        return service.updateBemutato(id, fajlNeve);
    }

    @DeleteMapping("/bemutatok/{id}")
    public void deleteBemutato(@PathVariable("id") int id){
        service.deleteBemutato(id);
    }

}
