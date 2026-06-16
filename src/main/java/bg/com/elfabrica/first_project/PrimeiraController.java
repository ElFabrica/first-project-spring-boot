package bg.com.elfabrica.first_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("primeiraController")
public class PrimeiraController {

    @GetMapping("/primeirometodo")
    public String primeiroMetodo(){
        return "Meu primeiro método api rest";
    }

}
