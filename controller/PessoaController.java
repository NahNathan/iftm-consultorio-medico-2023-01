/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Pessoa;
import model.PessoaDAO;

/**
 *
 * @author nathan.santos
 */
public class PessoaController {
    private PessoaDAO dao;

    public PessoaController() {
         this.dao = new PessoaDAO();
    }
    
    public boolean validarPessoaPorLogin(String[] loginSenha){
        return this.dao.validarPessoaPorLogin(loginSenha);
    }
    
    public boolean adicionarPessoa(String[] dadosPessoa) {
        Pessoa pessoa = new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2], dadosPessoa[3], dadosPessoa[4]);
        return this.dao.adicionarPessoa(pessoa);
    }
    
    public Pessoa obterPessoaPorLogin(String[] loginSenha){
        return this.dao.obterPessoaPorLogin(loginSenha);
    }

    public Pessoa obterPessoaPorId(int id){
        return this.dao.obterPessoaPorId(id);
    }
    
    public String[] obterNomesPessoas(){
        return this.dao.obterNomesPessoas();
    }
    
    public String[] obterIdPessoas(){
        return this.dao.obterIdPessoas();
    }
    
    public int obterQtdPessoas(){
        return this.dao.obterQtdPessoas();
    }
    
    public void listarPessoas() {
        this.dao.listarPessoas();
    }
    
    public boolean editarPessoa(Pessoa pessoa, String[] dadoEditado) {
        pessoa = this.dao.editarPessoa(pessoa);
        if(pessoa != null){
           if(Integer.parseInt(dadoEditado[0]) == 1){ // Editar Endereço
               pessoa.setEndereco(dadoEditado[1]);
           }
           if(Integer.parseInt(dadoEditado[0]) == 2){ // Editar Telefone
               pessoa.setTelefone(dadoEditado[1]);
           }
           if(Integer.parseInt(dadoEditado[0]) == 3){ // Editar Senha
               pessoa.setSenha(dadoEditado[1]);
           }
           if(Integer.parseInt(dadoEditado[0]) == 4){ // Editar Tipo de Usuario
               // 1 - Dono Unidade Franquia | 2 - Gerente Administrativo | 3 - Médico | 4 - Paciente
               pessoa.setTipoUsuario(Integer.parseInt(dadoEditado[1]));
           }
           
           pessoa.setDataModificacao(LocalDate.now());
           
           return true;
        }
        
        return false;
    }

    public void removerPessoa(int id) {
        this.dao.removerPessoa(id);
    }
}
