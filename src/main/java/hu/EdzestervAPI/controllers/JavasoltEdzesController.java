package hu.EdzestervAPI.controllers;

import hu.EdzestervAPI.domain.CelList;
import hu.EdzestervAPI.domain.JavasoltEdzes;
import hu.EdzestervAPI.domain.JavasoltEdzesList;
import hu.EdzestervAPI.services.CelService;
import hu.EdzestervAPI.services.JavasoltEdzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JavasoltEdzesController {
    @Autowired
    private JavasoltEdzesService service;

    @GetMapping("/javasoltak")
    public List<JavasoltEdzesList> getJavasoltak(){
        return service.getJavasoltak();
    }
}
