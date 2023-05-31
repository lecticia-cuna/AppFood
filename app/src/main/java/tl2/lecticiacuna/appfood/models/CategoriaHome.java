package tl2.lecticiacuna.appfood.models;

public class CategoriaHome {

    String nome;
    String tipo;
    String img_url;

    public CategoriaHome() {
    }

    public CategoriaHome(String nome, String tipo, String img_url) {
        this.nome = nome;
        this.tipo = tipo;
        this.img_url = img_url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
