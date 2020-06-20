package cerva.com.cerva.controller;


import cerva.com.cerva.model.Estilo;
import cerva.com.cerva.service.CadastroEstiloService;
import cerva.com.cerva.service.exception.NomeJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

    @Autowired
    private CadastroEstiloService service;

    @RequestMapping("/novo")
    public ModelAndView novo(Estilo estilo) {
        ModelAndView mv = new ModelAndView("/estilos/cadastro-estilos");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> cadastroRapido(@RequestBody @Valid Estilo estilo, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
        }
        estilo = service.cadastrarEstilo(estilo);
        System.out.println("cadastrando " + estilo.getNome());
        return ResponseEntity.ok(estilo);
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(estilo);
        }
        try {
            service.cadastrarEstilo(estilo);
        } catch (NomeJaCadastradoException e) {
            result.rejectValue("nome", e.getMessage(), e.getMessage());
            return novo(estilo);
        }
        attributes.addFlashAttribute("mensagem", "Novo estilo cadastrado");
        return new ModelAndView("redirect:/estilos/novo");
    }

}

