package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.Bemutato;
import hu.EdzestervAPI.domain.BemutatoList;
import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.services.BemutatoService;
import hu.EdzestervAPI.services.CelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BemutatoController {
    @Autowired
    private BemutatoService service;

    @GetMapping("/bemutatok")
    public List<BemutatoList> getBemutatok(){
        return service.getBemutatok();
    }
}
