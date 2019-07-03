package trb3.dcc193.trb3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerEtiquetas {

   
    @Autowired
    RepositorioEtiqueta repositorioEtiqueta;

    @Autowired
    RepositorioItem repositorioItem;


    @RequestMapping("/etiqueta")
    public String listar(Model model){
        model.addAttribute("etiquetas",repositorioEtiqueta.findAll());
        return "etiqueta/listar";
    }

    @RequestMapping("etiqueta/criar")
    public String criarEtiqueta(Model model){
        model.addAttribute("etiqueta",new Etiqueta());
        return "etiqueta/criar";
    }
    @RequestMapping("etiqueta/deletar/{id}")
    public String deletarEtiqueta(@PathVariable Long id){
        repositorioEtiqueta.deleteById(id);
        return "redirect:/etiqueta";
    }

    @RequestMapping("etiqueta/editar/{id}")
    public String editarEtiqueta(@PathVariable Long id, Model model){
        model.addAttribute("etiqueta",repositorioEtiqueta.findById(id).get());
        return "etiqueta/editar";
    }

    @RequestMapping("etiqueta/editar/salvar")
    public String editarsalvarEtiqueta(Etiqueta etiqueta){
        repositorioEtiqueta.save(etiqueta);
        return "redirect:/etiqueta";
    }

    @RequestMapping("etiqueta/salvar")
    public String salvarTrabalho(Etiqueta etiqueta){
        repositorioEtiqueta.save(etiqueta);
        return "redirect:/etiqueta";
    }

    @RequestMapping("/etiqueta/Itens/editar/{id}")
    public String listar(@PathVariable Long id, Model model){

        List<Item> vin= repositorioItem.findAll();
        

        List<Item> listaItemConteEtiqueta = new ArrayList<>();
        for(int i=0;i<vin.size();i++){
            List<Etiqueta> e = vin.get(i).getEtiquetas();
            for(int r=0;r<e.size();r++){
                if(e.get(r).getId()==id){
                    listaItemConteEtiqueta.add(vin.get(i));
                    System.out.println("ssss");
                }

            }
        }

        model.addAttribute("itens",listaItemConteEtiqueta);  
        model.addAttribute("etiqueta", repositorioEtiqueta.findById(id).get());    
        return "etiqueta/listarItens";

    }
    

}