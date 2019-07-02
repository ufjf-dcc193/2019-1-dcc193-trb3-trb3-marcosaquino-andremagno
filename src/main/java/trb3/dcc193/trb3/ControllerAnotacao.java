package trb3.dcc193.trb3;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ControllerAnotacao
 */
@Controller

public class ControllerAnotacao {

    @Autowired
    RepositorioAnotacao repositorioAnotacao;

    @Autowired
    RepositorioUsuario repositorioUsuario;

    @RequestMapping("anotacao")
    public String listarAnotacao(Model model){
       
        model.addAttribute("anotacoes",repositorioAnotacao.findAll());
        return "anotacao/listar";
    }
    
    @RequestMapping("anotacao/criar")
    public String criarAnotacao(Model model){
        model.addAttribute("anotacao", new Anotacao());
        model.addAttribute("usuarios",repositorioUsuario.findAll());
        return "anotacao/criar";
    }

    @RequestMapping("anotacao/deletar/{id}")
    public String deletarAnotacao(@PathVariable Long id){
        repositorioAnotacao.deleteById(id);
        return "redirect:/anotacao";
    }

    @RequestMapping("anotacao/editar/{id}")
    public String editarAnotacao(@PathVariable Long id, Model model){
        model.addAttribute("anotacao",repositorioAnotacao.findById(id).get());
        return "anotacao/editar";
    }

    @RequestMapping("anotacao/editar/salvar")
    public String editarSalvarAnotacao(Anotacao anotacao){
        Date data=new Date();
        anotacao.setDataDeAlteracao(data.toString());
        repositorioAnotacao.save(anotacao);
        return "redirect:/anotacao";
    }

    @RequestMapping("anotacao/salvar")
    public String salvarTrabalho(Anotacao anotacao){
        repositorioAnotacao.save(anotacao);
        return "redirect:/anotacao";
    }

    
}