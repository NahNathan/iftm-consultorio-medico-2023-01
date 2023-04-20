/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
/**
 *
 * @author nathan.santos
 */
public class Unidade {
    private int id;
    private Franquia franquia;
    private String cidade;
    private String endereco;
    private Pessoa responsavel;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public Unidade(int id, Franquia franquia, String cidade, String endereco, Pessoa responsavel, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.franquia = franquia;
        this.cidade = cidade;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    //Getters
    public int getId() {
        return id;
    }

    public Franquia getFranquia() {
        return franquia;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Unidade{" + "id=" + id + ", franquia=" + franquia + ", cidade=" + cidade + ", endereco=" + endereco + ", responsavel=" + responsavel + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    } 
}
