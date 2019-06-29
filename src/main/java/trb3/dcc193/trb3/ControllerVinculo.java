package trb3.dcc193.trb3;

import org.springframework.stereotype.Controller;

/**
 * ControllerVinculo
 */

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
public class ControllerVinculo {

    @Autowired
    RepositorioVinculo repositorioVinculo;


    @RequestMapping({"/vinculo","/vinculo/index.html"})
    public String vinculoIndex(){
        return "Itens/vinculo-index.html";
    }
 
    @RequestMapping(value="/vinculo/form.html", method=RequestMethod.POST)
    public ModelAndView criar(Vinculo vinculo) {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("redirect:/vinculo/list.html");
       repositorioVinculo.save(vinculo);
       mv.addObject("vinculo", vinculo);
       return mv;
   }


   @RequestMapping(value="/vinculo/edit/salvar.html", method=RequestMethod.POST)
   public ModelAndView salvar(Vinculo vinculo) {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("redirect:/vinculo/list.html");
      repositorioVinculo.save(vinculo);
      return mv;
  }


   @RequestMapping(value="/vinculo/criar.html", method=RequestMethod.GET)
   public ModelAndView criar() {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Criar/vinculo");
       List<Vinculo> aval = repositorioVinculo.findAll();
       mv.addObject("itens", aval);
       mv.addObject("vinculo", new Vinculo());
       return mv;
   }


   @GetMapping("/vinculo/edit/{id}")
   public ModelAndView  edit(@PathVariable("id") Long id) {
       System.out.println("asdasssssssssssssss>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>sdasd"+id);
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Vinculo/edit");
       mv.addObject("vinculo", repositorioVinculo.getOne(id));
       return mv;
   }

   @RequestMapping(value="/vinculo/list.html", method=RequestMethod.GET)
   public ModelAndView listar(){
       List<Vinculo> aval = repositorioVinculo.findAll();
       ModelAndView mv = new ModelAndView();
       mv.setViewName("Vinculo/listar");
       mv.addObject("itens", aval);
       return mv;
   }

    
}