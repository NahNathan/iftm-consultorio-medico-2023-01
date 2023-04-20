/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Franquia;
import model.FranquiaDAO;
/**
 *
 * @author nathan.santos
 */
public class FranquiaController {
    private FranquiaDAO dao=new FranquiaDAO();
    
    public Franquia[] buscarTodas() {
        return dao.buscarTodas();
    }

    public Franquia buscarFranquia(int id) {
        return dao.buscarFranquia(id);
    }

    public void criarFranquia(Franquia franquia) {
        dao.criarFranquia(franquia);
    }

    public void editarFranquia(Franquia franquia) {
        dao.editarFranquia(franquia);
    }

    public void deletarFranquia(int id) {
        dao.deletarFranquia(id);
    }
}
