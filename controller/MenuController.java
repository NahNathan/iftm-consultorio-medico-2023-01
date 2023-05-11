/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;
import model.Pessoa;

/**
 *
 * @author lfeli
 */
public class MenuController {

    private Menu viewMenu;
    private Pessoa pessoa;
    private PessoaController pessoaController;
    private String[] loginSenha = new String[2];

    public MenuController() {
        this.viewMenu = new Menu();
        this.pessoaController = new PessoaController();
    }

    private Pessoa verificaLogin() {
        boolean verifica;

        do {
            loginSenha = viewMenu.login();
            if (loginSenha != null) {
                verifica = this.pessoaController.validarPessoaPorLogin(loginSenha);

                if (!verifica) {
                    viewMenu.loginNegado();
                }
            } else {
                return null;
            }
        } while (!verifica);

        return this.pessoaController.obterPessoaPorLogin(loginSenha);
    }

    private String verificaTipoUsuario(int tipoUsuario) { //0 - Administrador do sistema / Dono Franquia || 1 - Dono unidade franquia || 2 - Administrativo || 3 - Médico || 4 - Paciente
        if (tipoUsuario == 0) {
            return "Administrador";
        } else if (tipoUsuario == 1) {
            return "Responsavel pela unidade";
        } else if (tipoUsuario == 2) {
            return "Gerente Administrativo";
        } else if (tipoUsuario == 3) {
            return "Médico";
        } else {
            return "Paciente";
        }
    }

    public void run() {
        int op;
        do {
            op = viewMenu.inicio();

            switch (op) {
                case 0:
                    this.pessoa = verificaLogin();
                    if (this.pessoa != null) {
                        int menuOp;
                        String[] dadoAlterado = new String[2];
                        String nomeUsuario = this.pessoa.getNome();
                        String permissaoUsuario = verificaTipoUsuario(this.pessoa.getTipoUsuario());

                        if (this.pessoa.getTipoUsuario() == 4) { // Paciente
                            menuOp = viewMenu.menuPaciente(nomeUsuario);

                            if (menuOp == 1) { // Alterar dados cadastrais
                                dadoAlterado = viewMenu.menuAlterarDados(nomeUsuario, permissaoUsuario);
                                this.pessoaController.editarPessoa(this.pessoa, dadoAlterado);
                            } else if (menuOp == 2) {

                            }
                        } else if (this.pessoa.getTipoUsuario() == 3) { // Médico

                        } else if (this.pessoa.getTipoUsuario() == 2) { // Gerente Administrativo

                        } else if (this.pessoa.getTipoUsuario() == 1) { // Responsavel pela Unidade de Franquia

                        } else if (this.pessoa.getTipoUsuario() == 0) { // Administrador do Sistema / Dono da Franquia
                            menuOp = viewMenu.menuAdmin(nomeUsuario);

                            if (menuOp == 1) {
                                dadoAlterado = viewMenu.menuAlterarDados(nomeUsuario, permissaoUsuario);
                                this.pessoaController.editarPessoa(this.pessoa, dadoAlterado);
                            } else if (menuOp == 2) {
                                if (this.pessoaController.obterQtdPessoas() > 2) { // Verifica se possui pessoas cadastradas, que não seja o admin de sistema ou o dono da franquia
                                    String[] idUsuarios = new String[this.pessoaController.obterQtdPessoas()];
                                    String[] nomesUsuarios = new String[this.pessoaController.obterQtdPessoas()];
                                    idUsuarios = this.pessoaController.obterIdPessoas();
                                    nomesUsuarios = this.pessoaController.obterNomesPessoas();
                                    int idUsuario = viewMenu.mostrarPessoas(nomeUsuario, permissaoUsuario, nomesUsuarios, idUsuarios);
                                    dadoAlterado = viewMenu.menuAlterarDados(nomeUsuario, permissaoUsuario);
                                    this.pessoaController.editarPessoa(this.pessoaController.obterPessoaPorId(idUsuario), dadoAlterado);
                                } else {
                                    this.viewMenu.nenhumCadastro();
                                }
                            }
                        }

                        //TESTE
                        this.pessoaController.listarPessoas();
                    }

                    break;
                case 1:
                    String[] dadosUsuario = new String[5];
                    dadosUsuario = viewMenu.cadastrar();
                    viewMenu.verificaCadastro(pessoaController.adicionarPessoa(dadosUsuario), dadosUsuario);

                    //TESTE
                    this.pessoaController.listarPessoas();
                    break;
                case -1:
                    break;
            }

        } while (op > 0);
    }
}
