/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan.santos
 */
public class Menu {

    public int inicio() {
        int op;
        Object[] options = {"Login", "Cadastrar", "Sair"};
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
        System.exit(0);
    }

    public void nenhumCadastro() {
        JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada no sistema!", "Pessoas Cadastradas", JOptionPane.INFORMATION_MESSAGE);
    }

    public String[] cadastrarUsuario() {
        String[] dadosUsuario = new String[5];
        // Entrada de dados pelo usuário
        // dadosUsuario[0]: nome | dadosUsuario[1]: endereco | dadosUsuario[2]: CPF | dadosUsuario[3]: telefone | dadosUsuario[4]: senha 
        dadosUsuario[0] = JOptionPane.showInputDialog(null, "Digite seu nome:", "Cadastro de usuário", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[1] = JOptionPane.showInputDialog(null, "Digite seu endereço:", "Cadastro de usuário", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[2] = JOptionPane.showInputDialog(null, "Digite seu CPF:", "Cadastro de usuário", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[3] = JOptionPane.showInputDialog(null, "Digite seu telefone:", "Cadastro de usuário", JOptionPane.QUESTION_MESSAGE);
        dadosUsuario[4] = JOptionPane.showInputDialog(null, "Digite uma senha para login:", "Cadastro de usuário", JOptionPane.QUESTION_MESSAGE);

        return dadosUsuario;
    }

    public String[] cadastrarMedico() {
        String[] dadosMedico = new String[10];
        // Entrada de dados pelo usuário
        dadosMedico[0] = JOptionPane.showInputDialog(null, "Digite o CRM:", "Cadastro de médico", JOptionPane.QUESTION_MESSAGE);
        dadosMedico[1] = JOptionPane.showInputDialog(null, "Digite a especialidade:", "Cadastro de médico", JOptionPane.QUESTION_MESSAGE);

        return dadosMedico;
    }

    public String[] cadastrarFranquia() {
        String[] dadosFranquia = new String[4];
        // Entrada de dados pelo usuário
        // dadosFranquia[0]: nome | dadosFranquia[1]: CNPJ | dadosFranquia[2]: cidade | dadosFranquia[3]: endereco
        dadosFranquia[0] = JOptionPane.showInputDialog(null, "Digite o nome da franquia:", "Cadastro de franquia", JOptionPane.QUESTION_MESSAGE);
        dadosFranquia[1] = JOptionPane.showInputDialog(null, "Digite o CNPJ da franquia:", "Cadastro de franquia", JOptionPane.QUESTION_MESSAGE);
        dadosFranquia[2] = JOptionPane.showInputDialog(null, "Digite a cidade da franquia:", "Cadastro de franquia", JOptionPane.QUESTION_MESSAGE);
        dadosFranquia[3] = JOptionPane.showInputDialog(null, "Digite o endereço da franquia:", "Cadastro de franquia", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Selecione um responsável pela franquia...", "Cadastro de franquia", JOptionPane.QUESTION_MESSAGE);

        return dadosFranquia;
    }

    public String[] cadastrarUnidadeFranquia() {
        String[] dadosUnidadeFranquia = new String[2];
        // Entrada de dados pelo usuário
        // [0]: cidade | [1]: endereco
        dadosUnidadeFranquia[0] = JOptionPane.showInputDialog(null, "Digite a cidade da unidade da franquia:", "Cadastro de unidade de franquia", JOptionPane.QUESTION_MESSAGE);
        dadosUnidadeFranquia[1] = JOptionPane.showInputDialog(null, "Digite o endereço da unidade da franquia:", "Cadastro de unidade de franquia", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Selecione um responsável pela unidade de franquia e a franquia à que esta unidade pertence...", "Cadastro de unidade de franquia", JOptionPane.QUESTION_MESSAGE);

        return dadosUnidadeFranquia;
    }

    public String[] cadastrarConsulta() {
        String[] dadosConsulta = new String[7];
        // [0]: data | [1]: horario | [2]: descricao (infoConsulta) | [3]: valor | [4]: idpaciente | [5]: idmedico | [6]: idunidade

        dadosConsulta[0] = JOptionPane.showInputDialog(null, "\nDia (dd-mm-yyyy):\n", "Cadastro de consulta", JOptionPane.QUESTION_MESSAGE);
        dadosConsulta[1] = JOptionPane.showInputDialog(null, "\nHorário (hh:mm:ss):\n", "Cadastro de consulta", JOptionPane.QUESTION_MESSAGE);
        dadosConsulta[2] = JOptionPane.showInputDialog(null, "\nDescrição:\n", "Cadastro de consulta", JOptionPane.QUESTION_MESSAGE);
        dadosConsulta[3] = JOptionPane.showInputDialog(null, "\nValor (R$):\n", "Cadastro de consulta", JOptionPane.QUESTION_MESSAGE);

        return dadosConsulta;
    }

    public void verificaCadastroUsuario(boolean verificado, String[] dadosUsuario) {
        if (verificado) {
            String acesso = "Dados para acesso:\nUsuário: " + dadosUsuario[0].toLowerCase().split(" ")[0].concat(dadosUsuario[2].substring(0, 3)) + "\nSenha: " + dadosUsuario[4];
            JOptionPane.showMessageDialog(null, acesso, "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não efetuado!", "Erro no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verificaCadastroFranquia(boolean verificado, String nomeFranquia, String nomeResponsavel) {
        if (verificado) {
            String mensagem = "Franquia cadastrada com sucesso!\n\nNome: " + nomeFranquia + "\nResponsável: " + nomeResponsavel;
            JOptionPane.showMessageDialog(null, mensagem, "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não efetuado!", "Erro no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void verificaCadastroUnidadeFranquia(boolean verificado, String nomeFranquia, String nomeResponsavel) {
        if (verificado) {
            String mensagem = "Unidade de franquia cadastrada com sucesso!\n\nFranquia: " + nomeFranquia + "\nResponsável pela unidade: " + nomeResponsavel;
            JOptionPane.showMessageDialog(null, mensagem, "Cadastrado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro não efetuado!", "Erro no sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int menuPaciente(String nomeUsuario) { // Menu para pacientes
        String menu = """
                      \tBem vindo(a) ao sistema!
                      
                      1 - Alterar dados cadastrais
                      2 - Visualizar consultas
                      3 - Visualizar procedimentos
                      4 - Gerar relat\u00f3rio de consultas e procedimentos
                      0 - Voltar
                      """;
        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - Paciente", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 4);

        return menuOp;
    }

    public String[] menuAlterarDadosPaciente(String[] dadosUsuario) { // dadosUsuario[0] = id | dadosUsuario[1] = nome | dadosUsuario[1] = permissao
        String menu = """
                      1 - Alterar nome
                      2 - Alterar endere\u00e7o
                      3 - Alterar telefone
                      4 - Alterar senha
                      0 - Voltar
                      """;

        String[] menuOp = new String[3];
        menuOp[0] = dadosUsuario[0];

        do {
            menuOp[1] = JOptionPane.showInputDialog(null, menu, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[1]) < 0 || Integer.parseInt(menuOp[1]) > 4);

        String mensagem = "";

        switch (Integer.parseInt(menuOp[1])) {
            case 1:
                mensagem += "Digite o nome: ";
                break;
            case 2:
                mensagem += "Digite o endereço: ";
                break;
            case 3:
                mensagem += "Digite o telefone: ";
                break;
            default:
                // Integer.parseInt(menuOp[1]) == 4
                mensagem += "Digite uma nova senha: ";
                break;
        }

        menuOp[2] = JOptionPane.showInputDialog(null, mensagem, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);

        return menuOp;
    }

    public int menuMedico(String nomeUsuario) { // Menu para medicos
        String menu = """
                      \tBem vindo(a) ao sistema!
                      
                      1 - Alterar dados cadastrais
                      2 - Visualizar consultas de um paciente
                      3 - Visualizar procedimentos de um paciente
                      4 - Visualizar agenda de consulta
                      5 - Visualizar consultas realizadas
                      6 - Criar consulta
                      7 - Gerar relat\u00f3rio de consultas e procedimentos de um paciente
                      8 - Gerar relat\u00f3rio de valores recebidos
                      0 - Voltar
                      """;
        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " | Médico", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 8);

        return menuOp;
    }

    public String[] menuAlterarDadosMedico(String[] dadosUsuario) { // dadosUsuario[0] = id | dadosUsuario[1] = nome | dadosUsuario[1] = permissao
        String menu = """
                      1 - Alterar nome
                      2 - Alterar endere\u00e7o
                      3 - Alterar telefone
                      4 - Alterar senha
                      5 - Alterar CRM
                      6 - Alterar especialidade
                      0 - Voltar
                      """;

        String[] menuOp = new String[3];
        menuOp[0] = dadosUsuario[0];

        do {
            menuOp[1] = JOptionPane.showInputDialog(null, menu, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[1]) < 0 || Integer.parseInt(menuOp[1]) > 6);

        String mensagem = "";

        switch (Integer.parseInt(menuOp[1])) {
            case 1:
                mensagem += "Digite o nome: ";
                break;
            case 2:
                mensagem += "Digite o endereço: ";
                break;
            case 3:
                mensagem += "Digite o telefone: ";
                break;
            case 4:
                mensagem += "Digite uma nova senha: ";
                break;
            case 5:
                mensagem += "Digite o novo CRM: ";
                break;
            default:
                // Integer.parseInt(menuOp[1]) == 6
                mensagem += "Digite a nova especialidade: ";
                break;
        }

        menuOp[2] = JOptionPane.showInputDialog(null, mensagem, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);

        return menuOp;
    }

    public int menuGerenteAdministrativo(String nomeUsuario) { // Menu para medicos
        String menu = """
                      \tBem vindo(a) ao sistema!
                      
                      1 - Alterar dados cadastrais
                      2 - Visualizar consultas
                      0 - Voltar
                      """;
        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - Paciente", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 2);

        return menuOp;
    }

    public String[] menuAlterarDadosGerenteAdministrativo(String[] dadosUsuario) { // dadosUsuario[0] = id | dadosUsuario[1] = nome | dadosUsuario[1] = permissao
        String menu = """
                      1 - Alterar endere\u00e7o
                      2 - Alterar telefone
                      3 - Alterar senha
                      4 - Alterar CRM
                      5 - Alterar especialidade
                      0 - Voltar
                      """;

        String[] menuOp = new String[3];
        menuOp[0] = dadosUsuario[0];

        do {
            menuOp[1] = JOptionPane.showInputDialog(null, menu, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[0]) < 0 || Integer.parseInt(menuOp[0]) > 5);

        String mensagem = "";

        switch (Integer.parseInt(menuOp[1])) {
            case 1:
                mensagem += "Digite o endereço: ";
                break;
            case 2:
                mensagem += "Digite o telefone: ";
                break;
            case 3:
                mensagem += "Digite uma nova senha: ";
                break;
            case 4:
                mensagem += "Digite o novo CRM: ";
                break;
            default:
                // Integer.parseInt(menuOp[1]) == 5
                mensagem += "Digite a nova especialidade: ";
                break;
        }

        menuOp[2] = JOptionPane.showInputDialog(null, mensagem, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);

        return menuOp;
    }

    public int menuDonoUnidade(String nomeUsuario) { // Menu para donos de unidades de franquia
        String menu = """
                      \tBem vindo(a) ao sistema!
                      
                      1 - Alterar dados cadastrais
                      2 - Alterar dados cadastrais de um usu\u00e1rio
                      3 - Cadastrar m\u00e9dico
                      4 - Gerar relat\u00f3rio financeiro mensal
                      0 - Voltar
                      """;
        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " - Paciente", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 4);

        return menuOp;
    }

    public String[] menuAlterarDadosDonoUnidade(String[] dadosUsuario) { // dadosUsuario[0] = id | dadosUsuario[1] = nome | dadosUsuario[2] = permissao
        String menu = """
                      1 - Alterar nome
                      2 - Alterar endere\u00e7o
                      3 - Alterar telefone
                      4 - Alterar senha
                      5 - Alterar tipo de usu\u00e1rio
                      0 - Voltar
                      """;

        String[] menuOp = new String[3];
        menuOp[0] = dadosUsuario[0];

        do {
            menuOp[1] = JOptionPane.showInputDialog(null, menu, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[1]) < 0 || Integer.parseInt(menuOp[1]) > 5);

        String mensagem = "";

        switch (Integer.parseInt(menuOp[1])) {
            case 1:
                mensagem += "Digite o nome: ";
                break;
            case 2:
                mensagem += "Digite o endereço: ";
                break;
            case 3:
                mensagem += "Digite o telefone: ";
                break;
            case 4:
                mensagem += "Digite uma nova senha: ";
                break;
            default:
                // Integer.parseInt(menuOp[1]) == 5
                mensagem += "1 - Dono de uma unidade de franquia"
                        + "\n2 - Gerente administrativo"
                        + "\n3 - Médico"
                        + "\n4 - Paciente"
                        + "\n0 - Voltar\n";
                break;
        }

        menuOp[2] = JOptionPane.showInputDialog(null, mensagem, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);

        return menuOp;
    }

    public int menuAdmin(String nomeUsuario) { // Menu do administrador do sistema || Dono da franquia 
        String menu = """
                      \tBem vindo(a) ao sistema!
                      
                      1 - Alterar dados cadastrais
                      2 - Alterar dados cadastrais de um usu\u00e1rio
                      3 - Cadastrar M\u00e9dico
                      4 - Criar uma nova franquia
                      5 - Criar uma nova unidade de franquia
                      6 - Gerar relat\u00f3rio da movimenta\u00e7\u00e3o financeira mensal
                      0 - Voltar
                      """;

        int menuOp;

        do {
            menuOp = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Usuário: " + nomeUsuario + " | Admin", JOptionPane.QUESTION_MESSAGE));
        } while (menuOp < 0 || menuOp > 6);

        return menuOp;
    }

    public String[] menuAlterarDadosAdministradorSistema(String[] dadosUsuario) { // dadosUsuario[0] = id | dadosUsuario[1] = nome | dadosUsuario[1] = permissao
        String menu = """
                      1 - Alterar nome
                      2 - Alterar endere\u00e7o
                      3 - Alterar telefone
                      4 - Alterar senha
                      5 - Alterar tipo de usu\u00e1rio
                      0 - Voltar
                      """;

        String[] menuOp = new String[3];
        menuOp[0] = dadosUsuario[0];

        do {
            menuOp[1] = JOptionPane.showInputDialog(null, menu, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
        } while (Integer.parseInt(menuOp[1]) < 0 || Integer.parseInt(menuOp[1]) > 5);

        String mensagem = "";

        switch (Integer.parseInt(menuOp[1])) {
            case 1:
                mensagem += "Digite o nome: ";
                break;
            case 2:
                mensagem += "Digite o endereço: ";
                break;
            case 3:
                mensagem += "Digite o telefone: ";
                break;
            case 4:
                mensagem += "Digite uma nova senha: ";
                break;
            default:
                // Integer.parseInt(menuOp[1]) == 5
                mensagem += """
                            1 - Dono de uma unidade de franquia
                            2 - Gerente administrativo
                            3 - M\u00e9dico
                            4 - Paciente
                            0 - Sair
                            """;
                break;
        }

        menuOp[2] = JOptionPane.showInputDialog(null, mensagem, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);

        return menuOp;
    }

    public String mostrarPessoas(String[] dadosUsuario, String pessoas) { // Listar todas as pessoas cadastradas, exceto o admin do sistema e o dono da franquia
        return JOptionPane.showInputDialog(null, "\nLista de pessoas cadastradas:\n" + pessoas, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
    }

    public int mostrarPacientes(String[] dadosUsuario, String pacientes) {
        if (pacientes.equals("Nenhum paciente cadastrado!")) {
            JOptionPane.showMessageDialog(null, pacientes, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
            return 0;
        } else {
            return Integer.parseInt(JOptionPane.showInputDialog(null, "\nLista de pacientes cadastrados:\n" + pacientes, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE));
        }
    }

    public String mostrarUnidadesFranquia(String[] dadosUsuario, String unidades) {
        return JOptionPane.showInputDialog(null, "\nLista de unidades cadastradas:\n" + unidades, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
    }

    public String mostrarFranquias(String[] dadosUsuario, String franquias) { // Listar todas as franquias cadastradas 
        return JOptionPane.showInputDialog(null, "\nLista de franquias cadastradas:\n" + franquias, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.QUESTION_MESSAGE);
    }

    public void mostrarInformacoesPaciente(String consultas, String[] dadosUsuario) {
        JOptionPane.showMessageDialog(null, consultas, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarInfoConsultas(String infoConsultas, String[] dadosUsuario) {
        JOptionPane.showMessageDialog(null, infoConsultas, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarProcedimentosPaciente(String procedimentos, String[] dadosUsuario) {
        JOptionPane.showMessageDialog(null, procedimentos, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarRelatorioConsultasProcedimentosPaciente(String procedimentos, String consultas, String[] dadosUsuario) {
        Object[] options = {"Gerar Relatório", "Sair"};
        int op = JOptionPane.showOptionDialog(null, "\nResumo de consultas e procedimentos:\n\n" + consultas + "\n" + procedimentos, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);

        if (op == 0) {
            String relatorio = "";
            String path = "./relatorios/" + dadosUsuario[1] + ".pdf";
            relatorio += "\nNome: " + dadosUsuario[1] + " | " + dadosUsuario[2]
                    + "\n\nRelatório Médico:"
                    + "\n---------------- Consultas ----------------"
                    + "\n" + consultas
                    + "\n---------------- Procedimentos ----------------"
                    + "\n" + procedimentos;

            try {
                CreatePDF gerarPDF = new CreatePDF(path, relatorio);
            } catch (DocumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //return op; // -1 : Sair || 0 : Login || 1 : Cadastrar
    }

    public void mostrarRelatorioFinanceiroFranquia(String financeiro, String[] dadosUsuario) {
        JOptionPane.showMessageDialog(null, "\nRelatório financeiro:\n" + financeiro, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarRelatorioFinanceiroUnidadeFranquia(String financeiro, String[] dadosUsuario) {
        Object[] options = {"Gerar Relatório", "Sair"};
        int op = JOptionPane.showOptionDialog(null, "\nResumo financeiro da unidade:\n\n" + financeiro, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);

        if (op == 0) {
            String relatorio = financeiro;
            String path = "./relatorios/" + dadosUsuario[1] + ".pdf";

            try {
                CreatePDF gerarPDF = new CreatePDF(path, relatorio);
            } catch (DocumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "\nRelatório financeiro:\n" + financeiro, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarRelatorioValoresRecebidosMedico(String financeiroMedico, String[] dadosUsuario) {
        Object[] options = {"Gerar Relatório", "Sair"};
        int op = JOptionPane.showOptionDialog(null, "\nResumo de valores recebidos:\n\n" + financeiroMedico, "Usuário: " + dadosUsuario[1] + " | " + dadosUsuario[2], 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);

        if (op == 0) {
            String relatorio = financeiroMedico;
            String path = "./relatorios/" + dadosUsuario[1] + ".pdf";

            try {
                CreatePDF gerarPDF = new CreatePDF(path, relatorio);
            } catch (DocumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }

        //return op; // -1 : Sair || 0 : Login || 1 : Cadastrar
    }
}
