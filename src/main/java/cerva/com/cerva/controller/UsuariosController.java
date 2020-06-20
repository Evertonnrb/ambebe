package cerva.com.cerva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @RequestMapping("/novo")
    public String novo(){
        return "usuarios/cadastro-usuario";
    }


}

