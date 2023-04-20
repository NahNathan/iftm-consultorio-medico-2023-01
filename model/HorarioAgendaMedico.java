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
public class HorarioAgendaMedico {
    private int id;
    private String diaHorario;
    private String estado;
    private Medico medico;
    private Unidade unidade;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public HorarioAgendaMedico(int id, String diaHorario, String estado, Medico medico, Unidade unidade, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.diaHorario = diaHorario;
        this.estado = estado;
        this.medico = medico;
        this.unidade = unidade;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getDiaHorario() {
        return diaHorario;
    }

    public String getEstado() {
        return estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public Unidade getUnidade() {
        return unidade;
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

    public void setDiaHorario(String diaHorario) {
        this.diaHorario = diaHorario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "HorarioAgendaMedico{" + "id=" + id + ", diaHorario=" + diaHorario + ", estado=" + estado + ", medico=" + medico + ", unidade=" + unidade + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
