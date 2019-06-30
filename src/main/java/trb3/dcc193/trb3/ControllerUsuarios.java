package trb3.dcc193.trb3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerUsuarios {

    @Autowired
    RepositorioUsuario repositorioUsuario;


    @RequestMapping("usuario")
    public String listarUsuario(Model model){
        model.addAttribute("usuarios",repositorioUsuario.findAll());
        return "usuario/listar";
    }

    @RequestMapping("usuario/criar")
    public String criarUsuario(Model model){
        model.addAttribute("usuario",new Usuario());
        return "usuario/criar";
    }
    
    @RequestMapping("usuario/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id){
        repositorioUsuario.deleteById(id);
        return "redirect:/usuario";
    }

    @RequestMapping("usuario/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario",repositorioUsuario.findById(id).get());
        return "usuario/editar";
    }

    @RequestMapping("usuario/editar/salvar")
    public String editarsalvarUsuario(Usuario usuario){
        repositorioUsuario.save(usuario);
        return "redirect:/usuario";
    }

    @RequestMapping("usuario/salvar")
    public String salvarTrabalho(Usuario usuario){
        repositorioUsuario.save(usuario);
        return "redirect:/usuario";
    }


}