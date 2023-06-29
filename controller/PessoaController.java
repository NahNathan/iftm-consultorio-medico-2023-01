/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import model.Pessoa;
import model.PessoaDAO;

/**
 *
 * @author nathan.santos
 */
public class PessoaController {
    private PessoaDAO dao = new PessoaDAO();

    public boolean validarPessoaPorLogin(String[] loginSenha){
        return this.dao.validarPessoaPorLogin(loginSenha);
    }
    
    public boolean adicionarPessoa(String[] dadosUsuario) {
        // dadosUsuario[0]: nome | dadosUsuario[1]: endereco | dadosUsuario[2]: CPF | dadosUsuario[3]: telefone | dadosUsuario[4]: senha 
        Pessoa p = new Pessoa();
        p.setNome(dadosUsuario[0]);
        p.setEndereco(dadosUsuario[1]);
        p.setCpf(dadosUsuario[2]);
        p.setTelefone(dadosUsuario[3]);
        p.setLogin(dadosUsuario[0].toLowerCase().split(" ")[0].concat(dadosUsuario[2].substring(0, 3)));
        p.setSenha(dadosUsuario[4]);
        p.setTipoUsuario(4);
        p.setDataCriacao(LocalDate.now());
        p.setDataModificacao(LocalDate.now());
        dao.adicionarPessoa(p);

        return true;
    }
    
    public Map<String, String> obterPessoaPorLogin(String[] loginSenha){
        Pessoa p = this.dao.obterPessoaPorLogin(loginSenha);
        
        Map<String, String> map_infoPessoa = new HashMap<>();
        map_infoPessoa.put("id", Integer.toString(p.getId()));
        map_infoPessoa.put("nome", p.getNome());
        map_infoPessoa.put("endereco", p.getEndereco());
        map_infoPessoa.put("cpf", p.getCpf());
        map_infoPessoa.put("telefone", p.getTelefone());
        map_infoPessoa.put("login", p.getLogin());
        map_infoPessoa.put("senha", p.getSenha());
        map_infoPessoa.put("tipoUsuario", p.getTipoUsuarioString(p.getTipoUsuario()));
        map_infoPessoa.put("dataCriacao", p.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        map_infoPessoa.put("dataModificacao", p.getDataModificacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        return map_infoPessoa;
    }
   
    public Pessoa obterPessoaPorId(int id){
        return this.dao.obterPessoaPorId(id);
    }
    
//    public String[] obterNomesPessoas(){
//        return this.dao.obterNomesPessoas();
//    }
//    
//    public String[] obterIdPessoas(){
//        return this.dao.obterIdPessoas();
//    }
//    
//    public int obterQtdPessoas(){
//        return this.dao.obterQtdPessoas();
//    }
    
    public String listarPacientes() {
        return this.dao.listarPacientes();
    }
    
    public String listarPessoasCadastradas() {
        return this.dao.listarPessoasCadastradas();
    }
    
    public boolean editarPessoa(String[] dadoEditado) { 
        return this.dao.editarPessoa(dadoEditado);
    }
}
