/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import model.Pessoa;
import model.PessoaDAO;

/**
 *
 * @author nathan.santos
 */
public class PessoaController {
    private PessoaDAO dao = new PessoaDAO();

    public void adicionarPessoa(Pessoa pessoa) {
        this.dao.adicionarPessoa(pessoa);
    }

    public Pessoa obterPessoaPorId(int id) {
        return this.dao.obterPessoaPorId(id);
    }
    
    public Pessoa[] listarPessoas() {
        return this.dao.listarPessoas();
    }
    
    public void editarPessoa(Pessoa pessoa) {
        this.dao.editarPessoa(pessoa);
    }

    public void removerPessoa(int id) {
        this.dao.removerPessoa(id);
    }
}
