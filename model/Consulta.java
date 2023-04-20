/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author nathan.santos
 */
public class Consulta {
    private int id;
    private HorarioAgendaMedico horarioAgenda;
    private Pessoa paciente;
    private String estado;
    private BigDecimal valor;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public Consulta(int id, HorarioAgendaMedico horarioAgenda, Pessoa paciente, String estado, BigDecimal valor, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.horarioAgenda = horarioAgenda;
        this.paciente = paciente;
        this.estado = estado;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public HorarioAgendaMedico getHorarioAgenda() {
        return horarioAgenda;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getValor() {
        return valor;
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

    public void setHorarioAgenda(HorarioAgendaMedico horarioAgenda) {
        this.horarioAgenda = horarioAgenda;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", horarioAgenda=" + horarioAgenda + ", paciente=" + paciente + ", estado=" + estado + ", valor=" + valor + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
