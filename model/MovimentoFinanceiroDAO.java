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
public class MovimentoFinanceiroDAO {
    private MovimentoFinanceiro[] movimentosFinanceiros = new MovimentoFinanceiro[0];
    private int proximoId = 1;
    
    public void criarMovimentoFInanceiro(MovimentoFinanceiro movimentoFinanceiro) {
        movimentoFinanceiro.setId(proximoId++);
        MovimentoFinanceiro[] novoArray = new MovimentoFinanceiro[movimentosFinanceiros.length + 1];
        for (int i = 0; i < movimentosFinanceiros.length; i++) {
            novoArray[i] = movimentosFinanceiros[i];
        }
        novoArray[movimentosFinanceiros.length] = movimentoFinanceiro;
        movimentosFinanceiros = novoArray;
    }
    
    public MovimentoFinanceiro buscarMovimentoFinanceiroPorId(int id) {
        for (MovimentoFinanceiro movimentoFinanceiro : movimentosFinanceiros) {
            if (movimentoFinanceiro.getId() == id) {
                return movimentoFinanceiro;
            }
        }
        return null;
    }

    public MovimentoFinanceiro[] listarTodos() {
        return movimentosFinanceiros;
    }

    public void editarMovimentoFinanceiro(MovimentoFinanceiro movimentoFinanceiro) {
        for (int i = 0; i < movimentosFinanceiros.length; i++) {
            if (movimentosFinanceiros[i].getId() == movimentoFinanceiro.getId()) {
                movimentosFinanceiros[i].setTipoMovimento(movimentoFinanceiro.getTipoMovimento());
                movimentosFinanceiros[i].setFranquia(movimentoFinanceiro.getFranquia());
                movimentosFinanceiros[i].setUnidade(movimentoFinanceiro.getUnidade());
                movimentosFinanceiros[i].setDescritivoMovimento(movimentoFinanceiro.getDescritivoMovimento());
                //movimentosFinanceiros[i].setDataModificacao(LocalDateTime.now());
                break;
            }
        }
    }

    public void deletarMovimentoFinanceiro(int id) {
        int indexParaRemover = -1;
        for (int i = 0; i < movimentosFinanceiros.length; i++) {
            if (movimentosFinanceiros[i].getId() == id) {
                indexParaRemover = i;
                break;
            }
        }
        if (indexParaRemover != -1) {
            MovimentoFinanceiro[] novoArray = new MovimentoFinanceiro[movimentosFinanceiros.length - 1];
            for (int i = 0, j = 0; i < movimentosFinanceiros.length; i++) {
                if (i != indexParaRemover) {
                    novoArray[j++] = movimentosFinanceiros[i];
                }
            }
            movimentosFinanceiros = novoArray;
        }
    }
    
}
