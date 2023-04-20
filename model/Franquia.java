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
public class Franquia {
    private int id;
    private String nome;
    private String cnpj;
    private String cidade;
    private String endereco;
    private Pessoa responsavel;
    private Date dataCriacao;
    private Date dateCriacao;

    public Franquia(int id, String nome, String cnpj, String cidade, String endereco, Pessoa responsavel, Date dataCriacao, Date dateCriacao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.dataCriacao = dataCriacao;
        this.dateCriacao = dateCriacao;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
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

    public Date getDateCriacao() {
        return dateCriacao;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public void setDateCriacao(Date dateCriacao) {
        this.dateCriacao = dateCriacao;
    }

    @Override
    public String toString() {
        return "Franquia{" + "id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", cidade=" + cidade + ", endereco=" + endereco + ", responsavel=" + responsavel + ", dataCriacao=" + dataCriacao + ", dateCriacao=" + dateCriacao + '}';
    }
    
}
