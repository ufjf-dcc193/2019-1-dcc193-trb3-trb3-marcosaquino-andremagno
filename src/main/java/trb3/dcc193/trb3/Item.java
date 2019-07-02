package trb3.dcc193.trb3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message="Campo obrigatório!")
    private String titulo;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> anotacoes;
    @ManyToMany
    private List<Etiqueta> etiquetas;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Vinculo> vinculos;

    public Item(){

    }

    

    public Item(String titulo) {
        this.titulo = titulo;
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

    public List<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }

    @Override
    public String toString() {
        return "Item [anotacoes=" + anotacoes + ", etiquetas=" + etiquetas + ", id=" + id + ", titulo=" + titulo
                + ", vinculos=" + vinculos + "]";
    }


}