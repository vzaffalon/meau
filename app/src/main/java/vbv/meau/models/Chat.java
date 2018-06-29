package vbv.meau.models;

/**
 * Created by vzaffalon on 28/06/2018.
 */

public class Chat {
    private String nome;
    private String descricao;
    private String foto;

    public Chat(){

    }

    public Chat(String nome, String descricao,String foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
}
