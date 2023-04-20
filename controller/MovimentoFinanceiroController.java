/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MovimentoFinanceiro;
import model.MovimentoFinanceiroDAO;
/**
 *
 * @author nathan.santos
 */
public class MovimentoFinanceiroController {
    private MovimentoFinanceiroDAO dao = new MovimentoFinanceiroDAO();

    public void criarMovimentoFinanceiro(MovimentoFinanceiro movimentoFinanceiro) {
        dao.criarMovimentoFInanceiro(movimentoFinanceiro);
    }
    
    public MovimentoFinanceiro[] listarTodos() {
        MovimentoFinanceiro[] movimentosFinanceiros = new MovimentoFinanceiro[dao.listarTodos().length];
        for (int i = 0; i < dao.listarTodos().length; i++) {
            movimentosFinanceiros[i] = dao.listarTodos()[i];
        }
        return movimentosFinanceiros;
    }
    
    public MovimentoFinanceiro buscarMovimentoFinanceiroPorId(int id) {
        return dao.buscarMovimentoFinanceiroPorId(id);
    }

    public void atualizar(MovimentoFinanceiro movimentoFinanceiro) {
        dao.editarMovimentoFinanceiro(movimentoFinanceiro);
    }

    public void deletar(int id) {
        dao.deletarMovimentoFinanceiro(id);
    }

}
