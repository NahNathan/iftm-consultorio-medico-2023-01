/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import model.FinanceiroAdm;
import model.FinanceiroAdmDAO;

/**
 *
 * @author lfeli
 */
public class FinanceiroAdmController {

    private FinanceiroAdmDAO dao = new FinanceiroAdmDAO();
    private UnidadeController u = new UnidadeController();

    public boolean criarMovimentoFinanceiro(String[] dadosMovimentoFinanceiro) { // [0]: Tipo movimento | [1]: Valor | [2]: idUnidade | [3]: Descritivo Movimento
        int tipo = Integer.parseInt(dadosMovimentoFinanceiro[0]);
        BigDecimal valor = new BigDecimal(dadosMovimentoFinanceiro[1]);
        int descritivo = Integer.parseInt(dadosMovimentoFinanceiro[3]);
        FinanceiroAdm f = new FinanceiroAdm();
        f.setTipoMovimento(tipo);
        f.setValor(valor);
        f.setDescritivoMovimento(descritivo);
        f.setDataCriacao(LocalDate.now());
        f.setDataModificacao(LocalDate.now());
        f.setUnidade(u.obterUnidadePorId(Integer.parseInt(dadosMovimentoFinanceiro[2])));
        
        return this.dao.criarMovimentoFinanceiro(f);
    }
            
//    public FinanceiroAdm buscarMovimentoFinanceiroPorId(int id) {
//        return this.dao.buscarMovimentoFinanceiroPorId(id);
//    }
            
    public String listarMovimentosFinanceiros() {
        return this.dao.listarMovimentosFinanceiros();
    }
    
    public String listarMovimentosFinanceirosPorIdUnidade(int id) {
        return this.dao.listarMovimentosFinanceirosPorIdUnidade(id);
    }
            
//    public BigDecimal obterFaturamentoTotalPorIdUnidade(int id) {
//        return this.dao.obterFaturamentoTotalPorIdUnidade(id);
//    } 
            
//    public boolean editarMovimentoFinanceiro(String[] dadosEditados) {
//        return this.dao.editarMovimentoFinanceiro(dadosEditados);
//    }
}
