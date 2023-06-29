/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Franquia;
import model.Pessoa;
import model.Unidade;
import model.UnidadeDAO;

/**
 *
 * @author nathan.santos
 */
public class UnidadeController {

    private UnidadeDAO dao = new UnidadeDAO();
    private PessoaController pessoaController = new PessoaController();
    private FranquiaController franquiaController = new FranquiaController();

    // [0]: cidade | [1]: endereco | [2]: idResponsavel | [3]: idFranquia
    public boolean criarUnidade(String[] dadosUnidade) {
        Unidade unidade = new Unidade();
        unidade.setCidade(dadosUnidade[0]);
        unidade.setEndereco(dadosUnidade[1]);
        unidade.setResponsavel(this.pessoaController.obterPessoaPorId(Integer.parseInt(dadosUnidade[2])));
        unidade.setFranquia(this.franquiaController.buscarFranquiaPorId(Integer.parseInt(dadosUnidade[3])));
        
        // Alterando o tipo da pessoa destinada a dono de unidade de franquia e a data de modificacao
        //responsavel.setDataModificacao(LocalDate.now());
        //responsavel.setTipoUsuario(1);
        return this.dao.criarUnidade(unidade);
    }

    public Unidade obterUnidadePorId(int id) {
        return this.dao.obterUnidadePorId(id);
    }
    
    public int obterIdUnidadePorResponsavelId(int idResponsavel) {
        return this.dao.obterIdUnidadePorResponsavelId(idResponsavel);
    }

    public String listarUnidades() {
        return this.dao.listarUnidades();
    }

//    public boolean editarUnidade(Unidade unidade, String[] infoEditada) {
//        return dao.editarUnidade(unidade, infoEditada);
//    }

    public boolean alterarResponsavelUnidade(Unidade unidade, Pessoa novoResponsavel) {
        return alterarResponsavelUnidade(unidade, novoResponsavel);
    }
}
