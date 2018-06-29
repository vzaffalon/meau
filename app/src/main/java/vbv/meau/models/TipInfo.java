package vbv.meau.models;

/**
 * Created by vzaffalon on 28/06/2018.
 */

public class TipInfo {
    private String image;
    private String titulo;
    private String descricao;

    public TipInfo(){

    }

    public TipInfo(String image, String titulo, String descricao) {
        this.image = image;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
