package com.prueba.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
    @GetMapping("/Hola")
    public String decirHola() {
        return "Hola Mundo desde Spring Boot!!";
    }
}
