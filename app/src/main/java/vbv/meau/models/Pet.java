package vbv.meau.models;

import java.util.List;

/**
 * Created by vzaffalon on 10/05/2018.
 */

public class Pet {
    private String nome;
    private String sexo;
    private String porte;
    private String especie; // cachorro ou gato
    private String idade;
    private String localizacao;
    private String saude;
    private String doencas;
    private String temperamento;
    private String exigencias_do_doador;
    private String sobre_o_animal;
    private String fotos;
    private String necessidades_animal;
    private String tipo_de_cadastro; //auxilio,ajuda, apadrinhamento
    private boolean favorito;


    public Pet(String nome, String sexo, String porte, String especie, String idade, String localizacao, String saude, String doencas, String temperamento, String exigencias_do_doador, String sobre_o_animal, String fotos, String necessidades_animal, String tipo_de_cadastro, boolean favorito) {
        this.nome = nome;
        this.sexo = sexo;
        this.porte = porte;
        this.especie = especie;
        this.idade = idade;
        this.localizacao = localizacao;
        this.saude = saude;
        this.doencas = doencas;
        this.temperamento = temperamento;
        this.exigencias_do_doador = exigencias_do_doador;
        this.sobre_o_animal = sobre_o_animal;
        this.fotos = fotos;
        this.necessidades_animal = necessidades_animal;
        this.tipo_de_cadastro = tipo_de_cadastro;
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }


    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getExigencias_do_doador() {
        return exigencias_do_doador;
    }

    public void setExigencias_do_doador(String exigencias_do_doador) {
        this.exigencias_do_doador = exigencias_do_doador;
    }

    public String getSobre_o_animal() {
        return sobre_o_animal;
    }

    public void setSobre_o_animal(String sobre_o_animal) {
        this.sobre_o_animal = sobre_o_animal;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getNecessidades_animal() {
        return necessidades_animal;
    }

    public void setNecessidades_animal(String necessidades_animal) {
        this.necessidades_animal = necessidades_animal;
    }

    public String getTipo_de_cadastro() {
        return tipo_de_cadastro;
    }

    public void setTipo_de_cadastro(String tipo_de_cadastro) {
        this.tipo_de_cadastro = tipo_de_cadastro;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }



//    private String nome;
//    private String sexo;
//    private String porte;
//    private String idade;
//    private String localizacao;
//    private List<String> saude;
//    private List<String> doencas;
//    private List<String> temperamento;
//    private List<String> exigencias_do_doador;
//    private String sobre_o_animal;
//    private List<String> fotos;
//    private List<String> necessidades_animal;
//    private String tipo_de_cadastro; //auxilio,ajuda, apadrinhamento
//    private boolean favorito;
//
//    public Pet(String nome, String sexo, String porte, String idade, String localizacao, List<String> saude, List<String> doencas, List<String> temperamento, List<String> exigencias_do_doador, String sobre_o_animal, List<String> fotos, List<String> necessidades_animal, String tipo_de_cadastro) {
//        this.nome = nome;
//        this.sexo = sexo;
//        this.porte = porte;
//        this.idade = idade;
//        this.localizacao = localizacao;
//        this.saude = saude;
//        this.doencas = doencas;
//        this.temperamento = temperamento;
//        this.exigencias_do_doador = exigencias_do_doador;
//        this.sobre_o_animal = sobre_o_animal;
//        this.fotos = fotos;
//        this.necessidades_animal = necessidades_animal;
//        this.tipo_de_cadastro = tipo_de_cadastro;
//    }
//
//    public boolean isFavorito() {
//        return favorito;
//    }
//
//    public void setFavorito(boolean favorito) {
//        this.favorito = favorito;
//    }
//
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getSexo() {
//        return sexo;
//    }
//
//    public void setSexo(String sexo) {
//        this.sexo = sexo;
//    }
//
//    public String getPorte() {
//        return porte;
//    }
//
//    public void setPorte(String porte) {
//        this.porte = porte;
//    }
//
//    public String getIdade() {
//        return idade;
//    }
//
//    public void setIdade(String idade) {
//        this.idade = idade;
//    }
//
//    public String getLocalizacao() {
//        return localizacao;
//    }
//
//    public void setLocalizacao(String localizacao) {
//        this.localizacao = localizacao;
//    }
//
//    public List<String> getSaude() {
//        return saude;
//    }
//
//    public void setSaude(List<String> saude) {
//        this.saude = saude;
//    }
//
//    public List<String> getDoencas() {
//        return doencas;
//    }
//
//    public void setDoencas(List<String> doencas) {
//        this.doencas = doencas;
//    }
//
//    public List<String> getTemperamento() {
//        return temperamento;
//    }
//
//    public void setTemperamento(List<String> temperamento) {
//        this.temperamento = temperamento;
//    }
//
//    public List<String> getExigencias_do_doador() {
//        return exigencias_do_doador;
//    }
//
//    public void setExigencias_do_doador(List<String> exigencias_do_doador) {
//        this.exigencias_do_doador = exigencias_do_doador;
//    }
//
//    public String getSobre_o_animal() {
//        return sobre_o_animal;
//    }
//
//    public void setSobre_o_animal(String sobre_o_animal) {
//        this.sobre_o_animal = sobre_o_animal;
//    }
//
//    public List<String> getFotos() {
//        return fotos;
//    }
//
//    public void setFotos(List<String> fotos) {
//        this.fotos = fotos;
//    }
//
//    public List<String> getNecessidades_animal() {
//        return necessidades_animal;
//    }
//
//    public void setNecessidades_animal(List<String> necessidades_animal) {
//        this.necessidades_animal = necessidades_animal;
//    }
//
//    public String getTipo_de_cadastro() {
//        return tipo_de_cadastro;
//    }
//
//    public void setTipo_de_cadastro(String tipo_de_cadastro) {
//        this.tipo_de_cadastro = tipo_de_cadastro;
//    }

}
