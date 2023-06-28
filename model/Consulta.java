/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nathan.santos
 */
public class Consulta {

    //static int contadorConsultas;
    private int id;
    private LocalTime horario;
    private LocalDate data;
    private Pessoa paciente;
    private Medico medico;
    private Unidade unidade;
    private int estado; // (0 - vazio, 1 - agendada, 2- cancelada, 3- realizada)
    private BigDecimal valor;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    // Getters
    public int getId() {
        return id;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public LocalDate getData() {
        return data;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public int getEstado() {
        return estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String estadoConsulta() {
        String estadoConsulta;
        if (this.estado == 0) {
            estadoConsulta = "Vazio";
        } else if (this.estado == 1) {
            estadoConsulta = "Agendada";
        } else if (this.estado == 2) {
            estadoConsulta = "Cancelada";
        } else { // estado == 3
            estadoConsulta = "Realizada";
        }
        return estadoConsulta;
    }

    @Override
    public String toString() {
        return "\nId: " + this.id
                + " | Paciente: " + this.paciente.getNome()
                + " | Medico: " + this.medico.getPessoa().getNome()
                + " | Franquia Médica: " + this.unidade.getFranquia().getNome()
                + " - Unidade : " + this.unidade.getCidade()
                + " | Estado: " + this.estadoConsulta()
                + " | Valor: " + this.valor
                + " | Data: " + this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + " | Horário: " + this.horario.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                + " | DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + " | DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "\n";
    }
}
