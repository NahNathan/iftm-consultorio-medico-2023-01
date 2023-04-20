/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import model.Medico;
import model.Pessoa;

/**
 *
 * @author nathan.santos
 */
public class MedicoController {
    private Medico[] medicos;
    private int indice = 0;

    public MedicoController(int tamanho) {
        this.medicos = new Medico[tamanho];
    }
    
    public void cadastrarMedico(String nome, String CRM, String cpf, String telefone, String especialidade) {
        Pessoa pessoa = new Pessoa(0, nome, cpf, telefone, especialidade, especialidade, especialidade, especialidade, null, null);
        Medico medico = new Medico(this.indice + 1, CRM, pessoa, especialidade, new Date(), new Date());
        this.medicos[this.indice] = medico;
        this.indice++;
    }
    
    public void atualizarMedico(int id, String nome, String cpf, String telefone, String especialidade) {
        for (int i = 0; i < this.indice; i++) {
            if (this.medicos[i].getId() == id) {
                this.medicos[i].getPessoa().setNome(nome);
                this.medicos[i].getPessoa().setCpf(cpf);
                this.medicos[i].getPessoa().setTelefone(telefone);
                this.medicos[i].setEspecialidade(especialidade);
                this.medicos[i].setDataModificacao(new Date());
                break;
            }
        }
    }

    public void excluirMedico(int id) {
        for (int i = 0; i < this.indice; i++) {
            if (this.medicos[i].getId() == id) {
                for (int j = i; j < this.indice - 1; j++) {
                    this.medicos[j] = this.medicos[j + 1];
                }
                this.medicos[this.indice - 1] = null;
                this.indice--;
                break;
            }
        }
    }

    public Medico buscarPorId(int id) {
        for (int i = 0; i < this.indice; i++) {
            if (this.medicos[i].getId() == id) {
                return this.medicos[i];
            }
        }
        return null;
    }

    public Medico[] listarMedicos() {
        Medico[] resultado = new Medico[this.indice];
        for (int i = 0; i < this.indice; i++) {
            resultado[i] = this.medicos[i];
        }
        //System.arraycopy(this.medicos, 0, resultado, 0, this.indice);
        //Ou assim
        return resultado;
    }
    
}
