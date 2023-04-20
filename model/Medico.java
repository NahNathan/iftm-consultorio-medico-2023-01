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
public class Medico {
    private int id;
    private String CRM;
    private Pessoa pessoa;
    private String especialidade;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public Medico(int id, String CRM, Pessoa pessoa, String especialidade, Date dataCriacao, Date dataModificacao) {
        super();
        this.id = id;
        this.CRM = CRM;
        this.pessoa = pessoa;
        this.especialidade = especialidade;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

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
    
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", CRM=" + CRM + ", pessoa=" + pessoa + ", especialidade=" + especialidade + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
