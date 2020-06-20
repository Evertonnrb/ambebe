package cerva.com.cerva.controller;

import cerva.com.cerva.model.Cerveja;
import cerva.com.cerva.model.enuns.Origem;
import cerva.com.cerva.model.enuns.Sabor;
import cerva.com.cerva.repository.Cervejas;
import cerva.com.cerva.repository.Estilos;
import cerva.com.cerva.service.CadastroCervejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

    @Autowired
    private CadastroCervejaService service;

    @Autowired
    private Cervejas cervejas;

    @Autowired
    private Estilos estilos;

    @RequestMapping("/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView mv = new ModelAndView("cervejas/cadastro-cerveja.html");
        mv.addObject("sabores", Sabor.values());
        mv.addObject("estilos", estilos.findAll());
        mv.addObject("origens", Origem.values());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cerveja);
        }
        service.cadastar(cerveja);
        attributes.addFlashAttribute("mensagem", "Cerveja cadastrada");
        return new ModelAndView("redirect:/cervejas/novo");
    }
}
