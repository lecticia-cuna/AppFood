package tl2.lecticiacuna.appfood.models;

public class RecommendedModel {
    String nome;
    String descricao;
    String avaliacao;
    String img_url;
    String preco;


    public RecommendedModel() {
    }

    public RecommendedModel(String nome, String descricao, String avaliacao, String img_url, String preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.img_url = img_url;
        this.preco = preco;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}







