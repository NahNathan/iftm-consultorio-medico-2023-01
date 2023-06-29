/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Franquia;
import model.FranquiaDAO;
import model.Pessoa;
import model.PessoaDAO;

/**
 *
 * @author nathan.santos
 */
public class FranquiaController {

    private FranquiaDAO dao = new FranquiaDAO();
    private PessoaController pessoaController = new PessoaController();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public String listarFranquias() {
        return this.dao.listarFranquias();
    }

    public Franquia buscarFranquiaPorId(int id) {
        return this.dao.buscarFranquiaPorId(id);
    }

    // dadosFranquia[0]: nome | dadosFranquia[1]: CNPJ | dadosFranquia[2]: cidade | dadosFranquia[3]: endereco | dadosFranquia[4]: idResponsavel
    public boolean criarFranquia(String[] dadosFranquia) {
        Franquia franquia = new Franquia();
        franquia.setNome(dadosFranquia[0]);
        franquia.setCnpj(dadosFranquia[1]);
        franquia.setCidade(dadosFranquia[2]);
        franquia.setEndereco(dadosFranquia[3]);
        franquia.setResponsavel(pessoaController.obterPessoaPorId(Integer.parseInt(dadosFranquia[4])));
        franquia.setDataModificacao(LocalDate.now());
        franquia.setDataCriacao(LocalDate.now());
        
        // [0]: Id | [1]: tipo de Informação | [2]: Informação editada
        // 1 - Dono Unidade Franquia | 2 - Gerente Administrativo | 3 - Médico | 4 - Paciente
        String[] dados = {dadosFranquia[4], "5", "1"};
        pessoaDAO.editarPessoa(dados);
 
        return this.dao.criarFranquia(franquia);
    }

//    public boolean editarFranquia(Franquia franquia, String[] infoEditada) {
//        return this.dao.editarFranquia(franquia, infoEditada);
//    }

//    public boolean alterarResponsavelFranquia(Franquia franquia, Pessoa novoResponsavel) {
//        return this.dao.alterarResponsavelFranquia(franquia, novoResponsavel);
//    }

}
