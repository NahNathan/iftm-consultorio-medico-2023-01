/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author nathan.santos
 */
public class Franquia {
    static int contadorFranquias;
    private int id;
    private String nome;
    private String cnpj;
    private String cidade;
    private String endereco;
    private Pessoa responsavel;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
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

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "\nId: " + this.id
                + " | Nome: " + this.nome
                + " | CNPJ: " + this.cnpj
                + " | Cidade: " + this.cidade
                + " | Endereço: " + this.endereco
                + " | Responsável: " + this.responsavel.getNome()
                + " | DataCriacao: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + " | DataModificacao: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
}
