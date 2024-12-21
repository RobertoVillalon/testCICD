package cl.beto.miApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MiController {

    @GetMapping
    public String testFunction(){

        return "Esta es una funcion que cambiara en el despliegue automatico";
    }

}
