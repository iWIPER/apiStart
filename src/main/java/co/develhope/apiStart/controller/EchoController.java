package co.develhope.apiStart.controller;

import co.develhope.apiStart.DTO.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
// Spongo tutto sotto una api comune, che diventa /api/echo/id  -  (POST - http://localhost:8080/api/echo)
@RequestMapping("/api")
public class EchoController {



    // Metodo 1
    /*
    @GetMapping(value = "/echo")
    public String getRoute(){
        return "Ciao io sono GET";
    }
    http://localhost:8080/echo
     */

    // Metodo 2 - Si aggiunge id per prendere un valore da - Per dire che userId vale {id} uso @PathVariable
    /*
    @GetMapping(value = "/echo/{id}")
    public String getRoute(@PathVariable(required = false, value = "id") String userId){
        return "Ciao io sono GET " + userId;
    }
    http://localhost:8080/echo/partedue
    Se provasse a stampare solo con echo mi darebbe errore. Per risolvere basta inserire ? ("/echo/?{id}")
    Se il value è diverso da id, la risposta sarà null.
     */

    // Metodo 3 - Per risolvere il problema del valore nullo
    /*
    @GetMapping(value = "/echo")
    public String getRoute(@PathVariable String id){
        return "Ciao io sono GET " + id;
    }
    http://localhost:8080/echo/partedue
     */

    // Metodo 4 - Per prendere sei parametri in query string
    /*
    @GetMapping(value = "/echo")
    public String getRoute(@RequestParam(required = false) String id, @RequestParam(required = false) Integer quantity){
        return "Test Response " + id + " quantity is " + quantity;
    }
    http://localhost:8080/echo?id=abc&quantity=987
     */

    // Metodo 5  -  Inserisco un @PathVariable per vedere dei bigPicture  - Con un breakpoint vedo gli headers
    @GetMapping(value = "/echo/{id}")
    public String getRoute(@PathVariable String id, @RequestParam(required = false) Integer quantity, @RequestHeader HttpHeaders headers) {
        return "Test Response " + id + " quantity is " + quantity;
    }

    // Metodo 1 a 5
    /*
        @PostMapping(value = "/echo")
        public String postRoute() {
            return "Ciao io sono POST";
        }
     */

    // Metodo 6 - Il body della richiesta viene passato attraverso lo DTO
        // Per prendere la Request e la Response le inserisco (Request e Response) - Pero con le request faccio spring fare troppo sforzo
    @PostMapping(value = "/echo")
    public String postRoute(@Validated @RequestBody(required = false) UserDTO user, HttpServletRequest request, HttpServletResponse response) {
        return user.toString();
    }
    //Con @Validated faccio la validazione del body
    // http://localhost:8080/echo?id=abc&quantity=987
    // Da GET porto in POST (su postman) e scrivo in body -> JSON:
    /*
    {"name": "Wilk",
     "surname": "Pereira",
     "id": "1634-2344-7643"
    }
     */

        @DeleteMapping(value = "/echo")
        public String deleteRoute() {
            return "Ciao io sono DELETE";
        }
    }
