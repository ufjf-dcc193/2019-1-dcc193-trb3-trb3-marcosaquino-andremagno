package trb3.dcc193.trb3;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Anotacao{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message="Campo obrigatório!")
    private String titulo;
    private String descricao;
    private String url;
    @OneToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    private String dataDeInclusao;
    private String dataDeAlteracao;

    public Anotacao(){

    }

    public Anotacao(String titulo, String descricao, String url, String dataDeInclusao, String dataDeAlteracao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
    }

    public Anotacao(String titulo, String descricao, String url, String dataDeInclusao, String dataDeAlteracao, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataDeInclusao = dataDeInclusao;
        this.dataDeAlteracao = dataDeAlteracao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(String dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    public String getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    public void setDataDeAlteracao(String dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    @Override
    public String toString() {
        return "Anotacao [dataDeAlteracao=" + dataDeAlteracao + ", dataDeInclusao=" + dataDeInclusao + ", descricao="
                + descricao + ", id=" + id + ", titulo=" + titulo + ", url=" + url + ", usuario=" + usuario + "]";
    }

    

}