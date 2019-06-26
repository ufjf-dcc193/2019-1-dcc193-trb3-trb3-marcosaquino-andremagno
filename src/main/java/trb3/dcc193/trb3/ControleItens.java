package trb3.dcc193.trb3;

import java.util.List;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControleItens {


    @Autowired
    RepositorioItem repositorioItem;


    @RequestMapping({"/item","/item/index.html"})
    public String itemIndex(){
        return "Itens/item-index.html";
    }
 
    @RequestMapping(value="/item/form.html", method=RequestMethod.POST)
    public ModelAndView criar(Item item) {
        
       ModelAndView mv = new ModelAndView();
       mv.setViewName("redirect:list.html");
       repositorioItem.save(item);
       mv.addObject("item", item);
       return mv;
   }

   @RequestMapping(value="/item/form.html", method=RequestMethod.GET)
   public ModelAndView criar() {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Itens/item-form");
       mv.addObject("item", new Item("Titulo"));
       return mv;
   }

   @RequestMapping(value="/item/list.html", method=RequestMethod.GET)
   public ModelAndView listar(){
       List<Item> aval = repositorioItem.findAll();
       System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa222222222222222222222222222222222222222222222222222222222222222222222222222222a"+aval.get(0));
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Itens/item-listar");
       mv.addObject("itens", aval);
       return mv;
   }

}