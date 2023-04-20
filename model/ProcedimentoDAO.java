/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nathan.santos
 */
public class ProcedimentoDAO {
    private static Procedimento[] procedimentos = new Procedimento[10];
    private static int nextIndex = 0;

    public void adicionar(Procedimento procedimento) {
        procedimentos[nextIndex++] = procedimento;
    }

    public Procedimento[] listar() {
        Procedimento[] listaProcedimentos = new Procedimento[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            listaProcedimentos[i] = procedimentos[i];
        }
        return listaProcedimentos;
    }

    public Procedimento buscarPorId(int id) {
        for (int i = 0; i < nextIndex; i++) {
            if (procedimentos[i].getId() == id) {
                return procedimentos[i];
            }
        }
        return null;
    }

    public Procedimento[] buscarPorConsulta(Consulta consulta) {
        Procedimento[] procedimentosConsulta = new Procedimento[10];
        int count = 0;
        for (int i = 0; i < nextIndex; i++) {
            if (procedimentos[i].getConsulta().equals(consulta)) {
                procedimentosConsulta[count++] = procedimentos[i];
            }
        }
        return procedimentosConsulta;
    }

    public void atualizar(Procedimento procedimentoAtualizado) {
        for (int i = 0; i < nextIndex; i++) {
            if (procedimentos[i].getId() == procedimentoAtualizado.getId()) {
                procedimentos[i] = procedimentoAtualizado;
                break;
            }
        }
    }

    public void remover(Procedimento procedimento) {
        for (int i = 0; i < nextIndex; i++) {
            if (procedimentos[i].equals(procedimento)) {
                for (int j = i; j < nextIndex - 1; j++) {
                    procedimentos[j] = procedimentos[j + 1];
                }
                procedimentos[--nextIndex] = null;
                break;
            }
        }
    }
}
