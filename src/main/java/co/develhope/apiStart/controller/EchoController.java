package co.develhope.apiStart.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping(value = "/echo")
    public String getRoute(){
        return "Ciao io sono GET";
    }

    @PostMapping(value = "/echo")
    public String postRoute(){
        return "Ciao io sono POST";
    }

    @DeleteMapping(value = "/echo")
    public String deleteRoute(){
        return "Ciao io sono DELETE";
    }
}
