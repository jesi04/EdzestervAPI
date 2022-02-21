package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.FeladatList;
import hu.EdzestervAPI.services.FeladatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeladatController {
    @Autowired
    private FeladatService service;

    @GetMapping("/feladatok")
    public List<FeladatList> getFeladatok(){
        return service.getFeladatok();
    }
}
