package trb3.dcc193.trb3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerUsuarios {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrousuario")
    public String inicio(){


        return "cadastro/cadastrousuario";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvarusuario")
    public String salvar(Usuario usuario){

        repositorioUsuario.save(usuario);
        return "cadastro/cadastrousuario";


    }

}