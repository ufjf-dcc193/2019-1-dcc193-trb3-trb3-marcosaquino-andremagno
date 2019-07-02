package trb3.dcc193.trb3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;

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
    RepositorioItem repositorioItem;

    @Autowired
    RepositorioEtiqueta repositorioEtiqueta;

    @Autowired
    RepositorioAnotacao repositorioAnotacao;

    @RequestMapping("/vinculo")
    public String listarVinculo(Model model){
        model.addAttribute("vinculos", repositorioVinculo.findAll());
        //System.out.println(repositorioVinculo.findById(3).get().etiqueta);
        return "vinculo/listar";
    }

    @RequestMapping("/vinculo/criar")
    public String criarVinculo(Model model){
        model.addAttribute("vinculo", new Vinculo());
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());
        model.addAttribute("listaEtiqueta", repositorioEtiqueta.findAll());
        model.addAttribute("listaAnotacoes", repositorioAnotacao.findAll());
        return "vinculo/criar";
    }

    @RequestMapping("/vinculo/deletar/{id}")
    public String deletarVinculo(@PathVariable Long id){
        repositorioVinculo.deleteById(id);
        return "redirect:/vinculo";
    }

    @RequestMapping("/vinculo/editar/{id}")
    public String editarVinculo(@PathVariable Long id, Model model){
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());
        model.addAttribute("listaEtiqueta", repositorioEtiqueta.findAll());
        model.addAttribute("listaAnotacoes", repositorioAnotacao.findAll());

        model.addAttribute("vinculo", repositorioVinculo.findById(id).get());
        return "vinculo/editar";
    }

    @RequestMapping("/vinculo/editar/salvar")
    public String editarsalvarVinculo(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/vinculo";
    }

    @RequestMapping("/vinculo/salvar")
    public String salvarTrabalho(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/vinculo";
    }



    ////////////////////////////


    @RequestMapping("item/vinculo/{id}")
    public String ItemVinculo(@PathVariable Long id, Model model){

        List<Vinculo> vin= repositorioVinculo.findAll();
        List<Vinculo> vinculosComId = new ArrayList<>();
        for(int i=0;i<vin.size();i++){
            if(vin.get(i).getOrigem().getId()==id){
                vinculosComId.add(vin.get(i));
            }
        }
        model.addAttribute("vinculos",vinculosComId);  
        model.addAttribute("id", id);     
        return "itemVinculo/listar";
    }


    @RequestMapping("item/vinculo/criar/{id}")
    public String criarItemVinculo(@PathVariable Long id, Model model){
        model.addAttribute("vinculo", new Vinculo());
        model.addAttribute("origem",repositorioItem.findById(id).get());
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());
        model.addAttribute("listaEtiqueta", repositorioEtiqueta.findAll());
        model.addAttribute("listaAnotacoes", repositorioAnotacao.findAll());
        return "itemVinculo/criar";
    }

    @RequestMapping("item/vinculo/editar/{id}")
    public String criarItemVinculoEditar(@PathVariable Long id, Model model){
        model.addAttribute("listaOrigem", repositorioItem.findAll());
        model.addAttribute("listaDestino", repositorioItem.findAll());
        model.addAttribute("listaEtiqueta", repositorioEtiqueta.findAll());
        model.addAttribute("listaAnotacoes", repositorioAnotacao.findAll());

        model.addAttribute("vinculo", repositorioVinculo.findById(id).get());
        return "itemVinculo/editar";
    }




    @RequestMapping("item/vinculo/editar/salvar")
    public String editarsalvarItemVinculo(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/item/vinculo/"+vinculo.getOrigem().getId();
    }

    @RequestMapping("item/vinculo/criar/salvar")
    public String salvarItemTrabalho(Vinculo vinculo){
        repositorioVinculo.save(vinculo);
        return "redirect:/item/vinculo/"+vinculo.getOrigem().getId();
    }

    
}