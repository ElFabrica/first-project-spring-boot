package bg.com.elfabrica.first_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {

    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id){
        return "Meu primeiro método api rest " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id){
        return "O parametro com queryParams é " + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams){
        return "O parametro com queryParams é " + allParams.entrySet();
    }

    @PostMapping("/meotodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario user){
        return "meu body:  " + user.username;
    }

    @PostMapping("/meotodoComHeaders")
    public String metodoComHeaders(@RequestHeader("name") String user){
        return "Meu header: " + user;
    }
    @PostMapping("/meotodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers){
        return "Meus vários headers: " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id){
        var usuario = new Usuario("El Fabrica");

        if(id > 5){
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Numero menor que 5");
    }

    record Usuario(String username){}

}
