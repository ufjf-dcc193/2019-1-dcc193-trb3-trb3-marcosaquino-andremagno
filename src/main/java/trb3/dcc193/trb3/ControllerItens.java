package trb3.dcc193.trb3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerItens {

    @Autowired
    RepositorioItem repositorioItem;

    @Autowired
    RepositorioEtiqueta repositorioEtiqueta;


    @Autowired
    RepositorioVinculo repositorioVinculo;


    @Autowired
    RepositorioUsuario user;

    @RequestMapping("/c")
    public String Carregar(Model model){


        repositorioItem.save(new Item("111111111111"));
        repositorioItem.save(new Item("222222222222"));
        repositorioItem.save(new Item("333333333333"));
        repositorioItem.save(new Item("444444444444"));

        repositorioEtiqueta.save(new Etiqueta("Historio","Descrição da Etiqueta","URL da Etiqueta"));
        repositorioEtiqueta.save(new Etiqueta("Filosofia","Descrição da Etiqueta","URL da Etiqueta"));
        repositorioEtiqueta.save(new Etiqueta("Matematica","Descrição da Etiqueta","URL da Etiqueta"));

        user.save(new Usuario("Joao","111111","ssss","asdasd"));
        user.save(new Usuario("Maria","111111","ssss","asdasd"));
        user.save(new Usuario("Julio","111111","ssss","asdasd"));

     

        model.addAttribute("itens",repositorioItem.findAll());
        return "item/listar";
    }


    @RequestMapping("/item")
    public String listarItem(Model model){
        model.addAttribute("itens",repositorioItem.findAll());
        return "item/listar";
    }


    @RequestMapping("item/criar")
    public String criarItem(Model model){
        model.addAttribute("item",new Item());
        model.addAttribute("estiquetas",repositorioEtiqueta.findAll());
        return "item/criar";
    }
    @RequestMapping("item/deletar/{id}")
    public String deletarItem(@PathVariable Long id){
        repositorioItem.deleteById(id);
        return "redirect:/item";
    }

    @RequestMapping("item/editar/{id}")
    public String editarItem(@PathVariable Long id, Model model){
        model.addAttribute("item",repositorioItem.findById(id).get());
        model.addAttribute("estiquetass",repositorioEtiqueta.findAll());
        return "item/editar";
    }


    @RequestMapping("item/editar/salvar")
    public String editarsalvarItem(Item item){
        repositorioItem.save(item);
        return "redirect:/item";
    }

    @RequestMapping("item/salvar")
    public String salvarTrabalho(Item item){
        repositorioItem.save(item);
        return "redirect:/item";
    }

}