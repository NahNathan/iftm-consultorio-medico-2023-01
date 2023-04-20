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
public class MovimentoFinanceiro {
    private int id;
    private String tipoMovimento;
    private Franquia franquia;
    private Unidade unidade;
    private String descritivoMovimento;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public MovimentoFinanceiro(int id, String tipoMovimento, Franquia franquia, Unidade unidade, String descritivoMovimento, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.tipoMovimento = tipoMovimento;
        this.franquia = franquia;
        this.unidade = unidade;
        this.descritivoMovimento = descritivoMovimento;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public Franquia getFranquia() {
        return franquia;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public String getDescritivoMovimento() {
        return descritivoMovimento;
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

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setDescritivoMovimento(String descritivoMovimento) {
        this.descritivoMovimento = descritivoMovimento;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "MovimentoFinanceiro{" + "id=" + id + ", tipoMovimento=" + tipoMovimento + ", franquia=" + franquia + ", unidade=" + unidade + ", descritivoMovimento=" + descritivoMovimento + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
