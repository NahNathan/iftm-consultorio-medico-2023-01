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

    static int contadorFinanceiroAdm;
    private int id;
    private int tipoMovimento; // 0 - Entrada / 1- Saída
    private BigDecimal valor;
    private Unidade unidade;
    private int descritivoMovimento; // 0 - Consulta | 1 - Procedimento | 2 - Salário Funcionário | 3 - Energia | 4 - Água | 5 - Pagamento Franquia
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Getters
    public static int getContadorFinanceiroAdm() {    
        return contadorFinanceiroAdm;
    }

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
        if(d.equals("Consulta"))
            return 0;
        else if(d.equals("Procedimento"))
            return 1;
        else if(d.equals("Pagamento Funcionario"))
            return 2;
        else if(d.equals("Energia"))
            return 3;
        else if(d.equals("Agua"))
            return 4;
        else if(d.equals("Pagamento Franquia")){ 
            return 5;
        } else {
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
    public static void setContadorFinanceiroAdm(int contadorFinanceiroAdm) {
        FinanceiroAdm.contadorFinanceiroAdm = contadorFinanceiroAdm;
    }

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
        if(descritivo == 0) {
            return "Consulta";
        } else if(descritivo == 1) {
            return "Procedimento";
        } else if(descritivo == 2) {
            return "Pagamento Funcionário";
        } else if(descritivo == 3) {
            return "Energia";
        } else if(descritivo == 4) {
            return "Água";
        } else { // descritivo == 5 | Pagamento Franquia
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
