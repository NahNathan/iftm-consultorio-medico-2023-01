/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Unidade;
import model.UnidadeDAO;
/**
 *
 * @author nathan.santos
 */
public class UnidadeController {
    private UnidadeDAO dao = new UnidadeDAO();

    public void criarUnidade(Unidade unidade) {
        dao.criarUnidade(unidade);
    }

    public Unidade listarUnidadePorId(int id) {
        return dao.obterUnidadePorId(id);
    }
    
    public Unidade[] listarTodas() {
        return dao.listarTodas();
    }

    public void editarUnidade(Unidade unidade) {
        dao.editarUnidade(unidade);
    }

    public void deletarUnidade(int id) {
        dao.deletarUnidade(id);
    }
    
}
