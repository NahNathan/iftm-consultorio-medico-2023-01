/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lfeli
 */
public class FinanceiroMedico {
    static int contadorFinanceiroMedico;
    private int id;
    private BigDecimal valor;
    private Medico medico;
    private int estado; // 0 - Agendado | 1 - Pago
    private Franquia franquia;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
   
    // Getters
    public int getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Medico getMedico() {
        return medico;
    }

    public int getEstado() {
        return estado;
    }

    public Franquia getFranquia() {
        return franquia;
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

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setFranquia(Franquia franquia) {
        this.franquia = franquia;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getEstadoString(int estado) {
        if(estado == 0) {
            return "Agendado";
        } else { // estado == 1
            return "Pago";
        }
    }
    
    @Override
    public String toString() {
        return "\nId: " + this.id
                + "  |  Valor: " + this.valor
                + "  |  Médico: " + this.medico.getPessoa().getNome()
                + "  |  Estado: " + getEstadoString(this.estado)
                + "  |  Franquia: " + this.franquia.getNome()
                + "  |  DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "  |  DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
}


