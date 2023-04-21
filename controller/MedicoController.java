/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import model.MedicoDAO;
import model.Medico;

/**
 *
 * @author nathan.santos
 */
public class MedicoController {
    private MedicoDAO dao = new MedicoDAO(1);

    public void adicionarMedico(Medico medico) {
        this.dao.adicionarMedico(medico);
    }

    public Medico buscarMedicoPorId(int id) {
        return this.dao.buscarMedicoPorId(id);
    }
    
    public Medico[] listarPessoas() {
        return this.dao.listarMedicos();
    }
    
    public void atualizarMedico(Medico medico) {
        this.dao.atualizarMedico(medico);
    }

    public void excluirrMedico(int id) {
        this.dao.excluirMedico(id);
    }
    
}
