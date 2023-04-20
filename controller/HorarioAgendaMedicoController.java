/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.HorarioAgendaMedico;
import model.HorarioAgendaMedicoDAO;
/**
 *
 * @author nathan.santos
 */
public class HorarioAgendaMedicoController {
    private HorarioAgendaMedicoDAO dao = new HorarioAgendaMedicoDAO();

    public void criarAgendaMedico(HorarioAgendaMedico horario) {
        dao.criarAgendaMedico(horario);
    }
    
    public HorarioAgendaMedico obterAgendaMedicoPorId(int id) {
        return dao.listarHorarioAM(id);
    }
    
    public HorarioAgendaMedico[] listarTodos() {
        return dao.listarTodos();
    }

    public void editarAgendaMedico(HorarioAgendaMedico horario) {
        dao.editarAgendaMedico(horario);
    }

    public void deletarAgendaMedico(int id) {
        dao.deletarAgendaMedico(id);
    }
}
