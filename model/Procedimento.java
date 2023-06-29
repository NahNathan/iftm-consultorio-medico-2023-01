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
public class Procedimento {
    //static int contadorProcedimentos;
    private int id;
    private String nome;
    private Consulta consulta;
    private LocalTime horario;
    private LocalDate data;
    private int estado; // (0 - Agendada | 2 - Cancelada | 1 - Realizada)
    private BigDecimal valor;
    private String laudo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public LocalDate getData() {
        return data;
    }

    public int getEstado() {
        return estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getLaudo() {
        return laudo;
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

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    public String getEstadoString(int estado) {
        switch (estado) {
            case 0:
                return "Vazio";
            case 1:
                return "Agendado";
            case 2:
                return "Cancelado";
            default:
                // estado == 3
                return "Realizado";
        }
    }

    @Override
    public String toString() {
        return "\nId: " + this.id
                + "  |  Nome: " + this.nome
                + "  |  Horario: " + this.horario.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                + "  |  Data: " + this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "  |  Status: " + this.getEstadoString(this.estado)
                + "  |  Valor: R$" + this.valor
                + "  |  Laudo: " + this.laudo
                + "  |  DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "  |  DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
}
