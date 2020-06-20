package cerva.com.cerva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClientesController {


    @RequestMapping("cadastrar")
    public String novo(){
        return "clientes/cadastro-cliente";
    }
}
