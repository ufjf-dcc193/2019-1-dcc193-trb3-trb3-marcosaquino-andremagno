package trb3.dcc193.trb3;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerHome {
        
    RepositorioUsuario repositorioUsuario;


    @RequestMapping({"","/","home"})
    public String home(Model model){
        model.addAttribute("usuario", new Usuario());
        return "Index";
    }




}