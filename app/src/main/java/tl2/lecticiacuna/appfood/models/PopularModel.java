package tl2.lecticiacuna.appfood.models;

public class PopularModel {
    String nome;
    String descricao;
    String avaliacao;
    String desconto;
    String tipo;
    String img_url;


    public PopularModel() {
    }

    public PopularModel(String nome, String descricao, String avaliacao, String desconto, String tipo, String img_url) {
        this.nome = nome;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.desconto = desconto;
        this.tipo = tipo;
        this.img_url = img_url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
