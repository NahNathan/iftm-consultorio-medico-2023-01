/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author nathan.santos
 */
public class PessoaDAO {

    private Pessoa[] pessoas;

    public PessoaDAO() {
        this.pessoas = new Pessoa[100];

        Pessoa admin = new Pessoa("Luiz Felippe", "Rua Rahif Esper Sallum, 33", "00987654321", "034900000000", "admin");
        admin.setLogin("admin");
        admin.setTipoUsuario(0);
        adicionarPessoa(admin);
        Pessoa dono = new Pessoa("Nathan Rodrigues", "Rua dos Alfeneiros, 4", "12345678900", "034999999999", "123");
        dono.setLogin("nathan123");
        dono.setTipoUsuario(1);
        adicionarPessoa(dono);
        
        // Adicionando algumas pessoas no sistema para fins de teste
        //0 - Administrador do sistema / Dono Franquia || 1 - Dono unidade franquia || 2 - Administrativo || 3 - Médico || 4 - Paciente
        Pessoa p1 = new Pessoa("Amando Aula", "Rua Amado Batista, 28", "12345612398", "034999832145", "Senh4");
        p1.setLogin("amando123");
        p1.setTipoUsuario(4);
        adicionarPessoa(p1);
        Pessoa p2 = new Pessoa("Patricia Yugiohto", "Rua David Bowie, 72", "32335652798", "034997332105", "UberabA");
        p2.setLogin("patricia323");
        p2.setTipoUsuario(4);
        adicionarPessoa(p2);
        Pessoa p3 = new Pessoa("Gustavo Java", "Avenida da Desgraça, 113", "42009356711", "011998990876", "AmoC");
        p3.setLogin("gustavo420");
        p3.setTipoUsuario(3);
        adicionarPessoa(p3);
        Pessoa p4 = new Pessoa("Eduardo Belo Profe", "Rua Smart Fit, 308", "69089965209", "034900324567", "PasseiEmP00");
        p4.setLogin("eduardo690");
        p4.setTipoUsuario(2);
        adicionarPessoa(p4);
        Pessoa p5 = new Pessoa("Calvino Castejon Alves Massado", "Avenida do Cabelo, 998", "95175385233", "034978634589", "MimDePapai");
        p5.setLogin("calvino951");
        p5.setTipoUsuario(1);
        adicionarPessoa(p5);
    }

    public boolean adicionarPessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;

                return true;
            }
        }

        return false;
    }

    public Pessoa obterPessoaPorLogin(String[] loginSenha) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && (pessoas[i].getLogin().equals(loginSenha[0]) && pessoas[i].getSenha().equals(loginSenha[1]))) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa obterPessoaPorId(int id) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getId() == id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public boolean validarPessoaPorLogin(String[] loginSenha) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && (pessoas[i].getLogin().equals(loginSenha[0]) && pessoas[i].getSenha().equals(loginSenha[1]))) {
                return true;
            }
        }

        return false;
    }

    public void listarPessoas() {
        Pessoa[] pessoasExistentes = new Pessoa[Pessoa.contadorPessoas];
        for (int i = 0; i < Pessoa.contadorPessoas; i++) {
            pessoasExistentes[i] = pessoas[i];
        }

        for (int i = 0; i < pessoasExistentes.length; i++) {
            System.out.println(pessoasExistentes[i].toString());
        }
    }

    public Pessoa editarPessoa(Pessoa pessoa) {
        for (int i = 0; i < Pessoa.contadorPessoas; i++) {
            if (pessoas[i].getId() == pessoa.getId()) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void removerPessoa(int id) {
        for (int i = 0; i < Pessoa.contadorPessoas; i++) {
            if (pessoas[i].getId() == id) {
                pessoas[i] = null;
                //Arrumar as posições da frente
                for (int j = i; j < Pessoa.contadorPessoas - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                Pessoa.contadorPessoas--;
                break;
            }
        }
    }

    public String[] obterNomesPessoas() {
        String[] nomesPessoas = new String[Pessoa.contadorPessoas - 2]; // Subtrai o admin do sistema e o dono da franquia
        for (int i = 2; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                nomesPessoas[i - 2] = pessoas[i].getNome();
            }
        }
        return nomesPessoas;
    }

    public String[] obterIdPessoas() {
        String[] idPessoas = new String[Pessoa.contadorPessoas - 2]; // Subtrai o admin do sistema e o dono da franquia
        for (int i = 2; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                idPessoas[i - 2] = Integer.toString(pessoas[i].getId());
            }
        }
        return idPessoas;
    }

    public int obterQtdPessoas() {
        return Pessoa.contadorPessoas;
    }
}
