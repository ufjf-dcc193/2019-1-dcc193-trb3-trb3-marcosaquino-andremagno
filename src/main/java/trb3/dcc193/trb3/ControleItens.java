package trb3.dcc193.trb3;

import java.util.List;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


   @RequestMapping(value="/item/edit/salvar.html", method=RequestMethod.POST)
   public ModelAndView salvar(Item item) {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:/item/list.html");
      repositorioItem.save(item);
      return mv;
  }


   @RequestMapping(value="/item/form.html", method=RequestMethod.GET)
   public ModelAndView criar() {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Itens/item-form");
       mv.addObject("item", new Item("Titulo"));
       return mv;
   }


   @GetMapping("/item/edit/{id}")
   public ModelAndView  edit(@PathVariable("id") Long id) {
       System.out.println("asdasssssssssssssss>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>sdasd"+id);
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Itens/item-edit");
       mv.addObject("item", repositorioItem.getOne(id));
       return mv;
   }

   @RequestMapping(value="/item/list.html", method=RequestMethod.GET)
   public ModelAndView listar(){
       List<Item> aval = repositorioItem.findAll();
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Itens/item-listar");
       mv.addObject("itens", aval);
       return mv;
   }



}