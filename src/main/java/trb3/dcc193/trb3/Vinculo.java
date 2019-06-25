import java.util.List;

public class Vinculo {

    private Long id;
    private Item origem;
    private Item destino;
    private List<Etiqueta> etiquetas;
    private List<Anotacao> anotacoes;

    public Vinculo() {

    }

    public Vinculo(Item origem, Item destino) {
        this.origem = origem;
        this.destino = destino;
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
}