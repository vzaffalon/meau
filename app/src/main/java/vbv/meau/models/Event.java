package vbv.meau.models;

import java.util.Date;

/**
 * Created by vzaffalon on 01/06/2018.
 */

public class Event {
    private String nome;
    private String data;
    private String local;
    private String informacoes;

    public Event(){

    }

    public Event(String nome, String data, String local, String informacoes) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.informacoes = informacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }


}
