package trb3.dcc193.trb3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario{


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nomeCompleto;
    private String codigo;
    private String descricao;
    private String email;

    public Usuario(){

    }

    public Usuario(String nomeCompleto, String codigo, String descricao, String email) {
        this.nomeCompleto = nomeCompleto;
        this.codigo = codigo;
        this.descricao = descricao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", descricao=" + descricao + ", email=" + email + ", id=" + id
                + ", nomeCompleto=" + nomeCompleto + "]";
    }

    
}