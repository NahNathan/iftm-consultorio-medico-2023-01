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
public class FinanceiroAdm {


    private int id;
    private int tipoMovimento; // 0 - Entrada / 1- Saída
    private BigDecimal valor;
    private Unidade unidade;
    private int descritivoMovimento; // 0 - Consulta | 1 - Procedimento | 2 - Salário Funcionário | 3 - Energia | 4 - Água | 5 - Pagamento Franquia
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Getters

    public int getId() {
        return id;
    }

    public int getTipoMovimento() {
        return tipoMovimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public int getDescritivoMovimento() {
        return descritivoMovimento;
    }
    
    public int getDescritivoMovimentoString(String d) {
        switch (d) {
            case "Consulta":
                return 0;
            case "Procedimento":
                return 1;
            case "Pagamento Funcionario":
                return 2;
            case "Energia":
                return 3;
            case "Agua":
                return 4;
            case "Pagamento Franquia":
                return 5;
            default:
                return -1;
        }
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

    public void setTipoMovimento(int tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public void setDescritivoMovimento(int descritivoMovimento) {
        this.descritivoMovimento = descritivoMovimento;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getTipoMovimentoString(int movimento) {
        if(movimento == 0) {
            return "Entrada";
        } else { // movimento == 1 | Saída
            return "Saída";
        }
    }
    
    public String getDescritivoMovimentoString(int descritivo) {
        // 0 - Consulta | 1 - Procedimento | 2 - Salário Funcionário | 3 - Energia | 4 - Água | 5 - Pagamento Franquia
        switch (descritivo) {
            case 0:
                return "Consulta";
            case 1:
                return "Procedimento";
            case 2:
                return "Pagamento Funcionário";
            case 3:
                return "Energia";
            case 4:
                return "Água";
            default:
                // descritivo == 5 | Pagamento Franquia
                return "Pagamento Franquia";
        }
    }
    
    @Override
    public String toString() {
        return "\nId: " + this.id
                + "  |  Tipo de movimento: " + getTipoMovimentoString(this.tipoMovimento)
                + "  |  Valor: " + this.valor
                + "  |  Franquia: " + this.unidade.getFranquia().getNome()
                + "  |  Unidade: " + this.unidade.getCidade()
                + "  |  Descritivo movimento: " + getDescritivoMovimentoString(this.descritivoMovimento)
                + "  |  DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                + "  |  DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
