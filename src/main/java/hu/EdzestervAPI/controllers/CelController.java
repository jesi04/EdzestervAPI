package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.services.CelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CelController {
    @Autowired
    private CelService service;

    @GetMapping("/celok")
    public List<CelList> getCelok(){
        return service.getCelok();
    }
}
