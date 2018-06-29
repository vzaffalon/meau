package vbv.meau.models;

/**
 * Created by vzaffalon on 31/05/2018.
 */

public class User {
    private String nome_completo;
    private String idade;
    private String email;
    private String estado;
    private String cidade;
    private String endereco;
    private String celular;
    private String usuario;
    private String senha;
    private String url_foto;
    private String id_usuario_firebase;

    public User(){

    }

    public User(String nome_completo, String idade, String email, String estado, String cidade, String endereco, String celular, String usuario, String senha, String url_foto, String id_usuario_firebase) {
        this.nome_completo = nome_completo;
        this.idade = idade;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.celular = celular;
        this.usuario = usuario;
        this.senha = senha;
        this.url_foto = url_foto;
        this.id_usuario_firebase = id_usuario_firebase;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getId_usuario_firebase() {
        return id_usuario_firebase;
    }

    public void setId_usuario_firebase(String id_usuario_firebase) {
        this.id_usuario_firebase = id_usuario_firebase;
    }

}
