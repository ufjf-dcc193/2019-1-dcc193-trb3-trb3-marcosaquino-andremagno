package trb3.dcc193.trb3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * ControllerVinculo
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerVinculo {

    @Autowired
    RepositorioVinculo repositorioVinculo;

    @Autowired
    RepositorioVinculo repositorioItem;


    @RequestMapping("/vinculo")
    public String listarVinculo(Model model){
        model.addAttribute("vinculos", repositorioVinculo.findAll());
        return "vinculo/listar";
    }

    @RequestMapping("vinculo/criar")
    public String criarVinculo(Model model){
        model.addAttribute("vinculo", new Vinculo());
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());
        
        return "/vinculo/criar";
    }

    @RequestMapping("vinculo/deletar/{id}")
    public String deletarVinculo(@PathVariable Long id){
        repositorioVinculo.deleteById(id);
        return "redirect:/vinculo";
    }

    @RequestMapping("vinculo/editar/{id}")
    public String editarVinculo(@PathVariable Long id, Model model){
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());

        model.addAttribute("vinculo", repositorioItem.findById(id).get());
        return "/vinculo/editar";
    }

    @RequestMapping("vinculo/editar/salvar")
    public String editarsalvarVinculo(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/user/vinculo/";
    }

    @RequestMapping("vinculo/salvar")
    public String salvarTrabalho(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/user/vinculo/";
    }

    
}