/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author nathan.santos
 */
public class Menu {

    public int inicio() {
        int op;
        Object[] options = {"Login", "Cadastrar"};
        op = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Bem vindo(a) ao sistema!", 0, 1, null, options, null);

        return op; // -1 : Sair || 0 : Login || 1 : Cadastrar
    }

    public String[] login() {
        String[] loginSenha = new String[2];
        loginSenha[0] = JOptionPane.showInputDialog(null, "Usuário", " Login", JOptionPane.QUESTION_MESSAGE);
        if (loginSenha[0] != null) {
            loginSenha[1] = JOptionPane.showInputDialog(null, "Senha", " Login", JOptionPane.QUESTION_MESSAGE);
        }
        if (loginSenha[1] != null) {
            return loginSenha;
        }
        return null;
    }

    public void loginNegado() {
        JOptionPane.showMessageDialog(null, "Acesso negado!", "Login", JOptionPane.ERROR_MESSAGE);
    }
    
    public void nenhumCadastro(){
        JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada no sistema!", "Pessoas Cadastradas", JOptionPane.INFORMATION_MESSAGE);
    }

    public String[] cadastrar() {
        String[] dadosUsuario = new String[5];
        // Entrada de dados pelo usuário
        dadosUsuario[0] = JOptionPane.showInputDialog(null, "Digite seu nome:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[1] = JOptionPane.showInputDialog(null, "Digite seu endereço:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[2] = JOptionPane.showInputDialog(null, "Digite seu CPF:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[3] = JOptionPane.showInputDialog(null, "Digite seu telefone:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[4] = JOptionPane.showInputDialog(null, "Digite uma senha para login:", "Cadastro", JOptionPane.QUESTION_MESSAGE);

        return dadosUsuario;
    }

    public void verificaCadastro(boolean verificado, String[] dadosUsuario) {
        if (verificado) {
            String acesso = "Dados para acesso:\nUsuário: " + dadosUsuario[0].toLowerCase().split(" ")[0].concat(dadosUsuario[2].substring(0, 3)) + "\nSenha: " + dadosUsuario[4];
            JOptionPane.showMessageDialog(null, acesso, "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não efetuado!", "Erro no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int menuPaciente(String nomeUsuario) { // Menu para pacientes
        String menu = "\tBem vindo(a) ao sistema!\n"
                + "\n1 - Alterar dados cadastrais"
                + "\n0 - Sair";
        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - Paciente", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 1);

        return menuOp;
    }

    public String[] menuAlterarDados(String nomeUsuario, String permissaoUsuario) {
        String menu = "";
        String[] menuOp = new String[2];

        if (permissaoUsuario.compareTo("Paciente") == 0) {
            menu = "1 - Alterar endereço\n"
                    + "2 - Alterar telefone\n"
                    + "3 - Alterar senha\n"
                    + "0 - Sair";
        } else if(permissaoUsuario.compareTo("Médico") == 0){
            
        } else if(permissaoUsuario.compareTo("Gerente Administrativo") == 0){
            
        } else if(permissaoUsuario.compareTo("Responsavel pela unidade") == 0){
            
        } else { // Administrador
            menu = "1 - Alterar endereço\n"
                    + "2 - Alterar telefone\n"
                    + "3 - Alterar senha\n"
                    + "4 - Alterar tipo de usuário\n"
                    + "0 - Sair";
        }

        do {
            menuOp[0] = JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - " + permissaoUsuario, JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[0]) < 0 || Integer.parseInt(menuOp[0]) > 4);

        switch (Integer.parseInt(menuOp[0])) {
            case 1:
                menuOp[1] = JOptionPane.showInputDialog(null, "Digite o endereço: ", "Usuário: " + nomeUsuario + " - " + permissaoUsuario, JOptionPane.QUESTION_MESSAGE);
                break;
            case 2:
                menuOp[1] = JOptionPane.showInputDialog(null, "Digite o telefone: ", "Usuário: " + nomeUsuario + " - " + permissaoUsuario, JOptionPane.QUESTION_MESSAGE);
                break;
            case 3:
                menuOp[1] = JOptionPane.showInputDialog(null, "Digite uma nova senha: ", "Usuário: " + nomeUsuario + " - " + permissaoUsuario, JOptionPane.QUESTION_MESSAGE);
                break;
            case 4:
                String menuTipo = "1 - Dono de uma unidade de franquia" 
                        + "\n2 - Gerente administrativo"
                        + "\n3 - Médico"
                        + "\n4 - Paciente"
                        + "\n0 - Sair";
                menuOp[1] = JOptionPane.showInputDialog(null, menuTipo, "Usuário: " + nomeUsuario + " - " + permissaoUsuario, JOptionPane.QUESTION_MESSAGE);
                break;
        }

        return menuOp;
    }

    public void menuDonoUnidadeFranquia() { // Dono da unidade de franquia
        String menu = "\tBem vindo(a) ao sistema!\n"
                + "\n1 - Alterar dados cadastrais"
                + "\n2 - Alterar dados cadastrais de um usuário"
                + "\n0 - Sair";
    }

    public int menuAdmin(String nomeUsuario) { // Menu do administrador do sistema || Dono da franquia 
        String menu = "\tBem vindo(a) ao sistema!\n"
                + "\n1 - Alterar dados cadastrais"
                + "\n2 - Alterar dados cadastrais de um usuário"
                + "\n0 - Sair";

        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - Admin", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 2);

        return menuOp;
    }
    
    public int mostrarPessoas(String nomeUsuario, String permissaoUsuario, String[] nomePessoa, String[] idPessoa){ // Listar todas as pessoas cadastradas, exceto o admin do sistema e o dono da franquia
        String listarPessoas = "Pessoas cadastradas\n\n";
        int menuOp;
        int i;
        for (i = 0; i < idPessoa.length; i++) {
            listarPessoas += idPessoa[i] + " - " + nomePessoa[i] + "\n";
        }
        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, listarPessoas, "Usuário: " + nomeUsuario + " - Admin", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > i+2);

        return menuOp;
    }
}
