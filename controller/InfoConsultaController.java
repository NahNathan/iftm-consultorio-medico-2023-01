/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.InfoConsulta;
import model.InfoConsultaDAO;
/**
 *
 * @author nathan.santos
 */
public class InfoConsultaController {
    private InfoConsultaDAO dao = new InfoConsultaDAO();
    
    public void criarInfoConsulta(InfoConsulta info) {
        dao.criarInfoConsulta(info);
    }

    public InfoConsulta obterInfoConsultaPorId(int id) {
        return dao.obterInfoConsultaPorId(id);
    }

    public InfoConsulta[] listarTodas() {
        return dao.listarTodas();
    }

    public void editarInfoConsulta(InfoConsulta info) {
        dao.editarInfoConsulta(info);
    }

    public void deletarInfoConsulta(int id) {
        dao.deletarInfoConsulta(id);
    }
}
