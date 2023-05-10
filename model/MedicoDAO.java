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
public class MedicoDAO {
    private Medico[] medicos;
    private int proximoId;

    public MedicoDAO(int tamanhoMaximo) {
        this.medicos=new Medico[tamanhoMaximo];
        this.proximoId=1;
    }
   
    public void adicionarMedico(Medico medico) {
        medico.setId(proximoId);
        medico.setDataCriacao(new Date());
        medico.setDataModificacao(new Date());
        this.medicos[proximoId-1]=medico;
        proximoId++;
    }
    
    public Medico buscarMedicoPorId(int id) {
    	for (Medico medico : medicos) {
            if (medico!=null && medico.getId()==id) {
                return medico;
            }
        }
        return null;
    }
    
    public Medico[] listarMedicos() {
        return this.medicos;
    }
    
    public void atualizarMedico(Medico medico) {
        for (int i=0; i<medicos.length; i++) {
            if (medicos[i]!=null && medicos[i].getId()==medico.getId()) {
            	medicos[i] = medico;
            	medico.setDataModificacao(new Date());
                break;
            }
        }
    }
    
    public void excluirMedico(int id) {
    	for (int i=0; i< medicos.length; i++) {
            if (medicos[i]!=null && medicos[i].getId()==id) {
                medicos[i] = null;
                break;
            }
        }
    }
    
}
