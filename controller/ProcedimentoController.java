/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Consulta;
import model.Procedimento;
import model.ProcedimentoDAO;
/**
 *
 * @author nathan.santos
 */
public class ProcedimentoController {
    private ProcedimentoDAO dao = new ProcedimentoDAO();
    
    
    public void adicionarProcedimento(Procedimento procedimento) {
        dao.adicionar(procedimento);
    }

    public Procedimento buscarProcedimentoPorId(int id) {
        return dao.buscarPorId(id);
    }

    public Procedimento[] buscarProcedimentosPorConsulta(Consulta consulta) {
        return dao.buscarPorConsulta(consulta);
    }
    
    public Procedimento[] listarProcedimentos() {
        return dao.listar();
    }

    public void editarProcedimento(Procedimento procedimentoAtualizado) {
        dao.atualizar(procedimentoAtualizado);
    }

    public void removerProcedimento(Procedimento procedimento) {
        dao.remover(procedimento);
    }
}
