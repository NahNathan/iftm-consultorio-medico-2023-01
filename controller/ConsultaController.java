/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Consulta;
import model.ConsultaDAO;
/**
 *
 * @author nathan.santos
 */
public class ConsultaController {
    private ConsultaDAO dao = new ConsultaDAO();
    
    public void criarConsulta(Consulta consulta) {
        dao.criarConsulta(consulta);
    }
    
    public Consulta listarConsulta(int id) {
        return dao.listarConsulta(id);
    }
    
    public Consulta[] listarTodas() {
        return dao.listarTodas();
    }

    public void editarConsulta(Consulta consulta) {
        dao.editarConsulta(consulta);
    }

    public void deletarConsulta(int id) {
        dao.deletarConsulta(id);
    }
}
