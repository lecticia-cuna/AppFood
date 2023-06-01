package tl2.lecticiacuna.appfood.models;

public class NavCategoriaModel {
    String nome;
    String descricao;
    String desconto;
    String img_url;

    public NavCategoriaModel() {
    }

    public NavCategoriaModel(String nome, String descricao, String desconto, String img_url) {
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
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

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
