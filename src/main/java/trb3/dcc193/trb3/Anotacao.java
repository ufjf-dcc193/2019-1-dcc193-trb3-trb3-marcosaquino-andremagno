

public class Anotacao{

    private Long id;
    private String titulo;
    private String descricao;
    private String url;
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

}