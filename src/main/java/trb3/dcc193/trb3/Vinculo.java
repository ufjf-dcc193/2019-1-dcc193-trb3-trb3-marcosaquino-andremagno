package trb3.dcc193.trb3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Item origem;
    @OneToOne(fetch = FetchType.EAGER)
    private Item destino;
    @ManyToMany
    private List<Etiqueta> etiquetas;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Anotacao> anotacoes;

    public Vinculo() {

    }

    public Vinculo(Item origem, Item destino, List<Etiqueta> etiquetas) {
        this.origem = origem;
        this.destino = destino;
        this.etiquetas = etiquetas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getOrigem() {
        return origem;
    }

    public void setOrigem(Item origem) {
        this.origem = origem;
    }

    public Item getDestino() {
        return destino;
    }

    public void setDestino(Item destino) {
        this.destino = destino;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "Vinculo [anotacoes=" + anotacoes + ", destino=" + destino + ", etiquetas=" + etiquetas + ", id=" + id
                + ", origem=" + origem + "]";
    }


    
}