package cerva.com.cerva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

    @RequestMapping("/cidade")
    public String cadastroCidade(){
        return "/endereco/cadastro-cidade";
    }
}
