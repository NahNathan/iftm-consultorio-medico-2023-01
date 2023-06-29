
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
public class Medico {
    private int id;
    private String CRM;
    private Pessoa pessoa;
    private String especialidade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Getters
    public int getId() {
        return id;
    }

    public String getCRM() {
        return CRM;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getEspecialidade() {
        return especialidade;
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
    
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "\nId: " + this.getId()
                + "  |  Nome: " + this.getPessoa().getNome()
                + "  |  CRM: " + this.getCRM()
                + "  |  Especialidade: " + this.especialidade
                + "  |  DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "  |  DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
}