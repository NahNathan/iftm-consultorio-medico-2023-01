/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan.santos
 */
public class PessoaDAO {

    private Pessoa pessoa = new Pessoa();

    // Adicionando uma pessoa ao banco
    public void adicionarPessoa(Pessoa p) {
        String sql = "insert into Pessoa"
                + " (nome, endereco, cpf, telefone, login, senha, tipoUsuario, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEndereco());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getTelefone());
            stmt.setString(5, p.getLogin());
            stmt.setString(6, p.getSenha());
            stmt.setInt(7, p.getTipoUsuario());
            stmt.setDate(8, java.sql.Date.valueOf(p.getDataCriacao()));
            stmt.setDate(9, java.sql.Date.valueOf(p.getDataModificacao()));

            stmt.execute();      
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      

        
    }

    // loginSenha[0] = login && loginSenha[1] = senha
    // Ao logar no sistema 
    public Pessoa obterPessoaPorLogin(String[] loginSenha) {
        String sql = "select * from pessoa where login = ? and senha = ?";
        //Map<Integer, Pessoa> map = new HashMap<>();
        Pessoa p = new Pessoa();
        //int id;

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setString(1, loginSenha[0]);
            ps.setString(2, loginSenha[1]);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    //id = rs.getInt("id");
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setCpf(rs.getString("cpf"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setLogin(rs.getString("login"));
                    p.setSenha(rs.getString("senha"));
                    p.setTipoUsuario(rs.getInt("tipoUsuario"));
                    
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                    //map.put(id, p);
                    return p;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Pessoa obterPessoaPorId(int id) {
        String sql = "select * from pessoa where id = ?";
        Pessoa p = new Pessoa();

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setCpf(rs.getString("cpf"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setLogin(rs.getString("login"));
                    p.setSenha(rs.getString("senha"));
                    p.setTipoUsuario(rs.getInt("tipoUsuario"));
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                    return p;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public boolean validarPessoaPorLogin(String[] loginSenha) {
        String sql = "select id from pessoa where login = ? and senha = ?";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setString(1, loginSenha[0]);
            ps.setString(2, loginSenha[1]);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public String listarPacientes() {
        String pacientes = "";
        String sql = "select id, nome, tipoUsuario from pessoa where tipoUsuario = 4";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                pacientes += "\n Pacientes cadastrados no sistema:\n";
                while (rs.next()) {
                    pacientes += "\n ID: " + rs.getString("id") + " | Nome: " + rs.getString("nome") + " | Tipo de Usuário: " + pessoa.getTipoUsuarioString(rs.getInt("tipoUsuario"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (pacientes.equals("")) {
            pacientes += "Nenhum paciente cadastrado!";
        }
        return pacientes;
    }

    public String listarPessoasCadastradas() { // Exceto admin e dono franquia
        String listaPessoas = "";
        String sql = "select id, nome, tipoUsuario from pessoa where tipoUsuario != 0";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                listaPessoas += "\n Pessoas cadastradas no sistema:\n";
                while (rs.next()) {
                    listaPessoas += "\n ID: " + rs.getString("id") + " | Nome: " + rs.getString("nome") + " | Tipo de Usuário: " + pessoa.getTipoUsuarioString(rs.getInt("tipoUsuario"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (listaPessoas.equals("")) {
            listaPessoas += "Nenhuma pessoa cadastrada!";
        }
        return listaPessoas;
    }

    public boolean editarPessoa(String[] dadosEditados) { // [0]: Id | [1]: tipo de Informação | [2]: Informação editada
        String sql = "update pessoa set ? = ?, dataModificacao = ? where id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            switch (Integer.parseInt(dadosEditados[1])) {
                case 1:
                    // Editar Nome
                    stmt.setString(1, "nome");
                    break;
                case 2:
                    // Editar Endereço
                    stmt.setString(1, "endereco");
                    break;
                case 3:
                    // Editar Telefone
                    stmt.setString(1, "telefone");
                    break;
                case 4:
                    // Editar Senha
                    stmt.setString(1, "senha");
                    break;
                case 5:
                    // Editar Tipo de Usuario
                    // 1 - Dono Unidade Franquia | 2 - Gerente Administrativo | 3 - Médico | 4 - Paciente
                    stmt.setString(1, "tipoUsuario");
                    break;
                default:
                    break;
            }

            stmt.setString(2, dadosEditados[2]);
            stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setInt(4, Integer.parseInt(dadosEditados[0]));
            stmt.execute();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public String[] obterNomesPessoas() {
//        String[] nomesPessoas = new String[Pessoa.contadorPessoas - 1]; // Subtrai o admin do sistema 
//        for (int i = 1; i < pessoas.length; i++) {
//            if (pessoas[i] != null) {
//                nomesPessoas[i - 1] = pessoas[i].getNome();
//            }
//        }
//        return nomesPessoas;
//    }
//
//    public String[] obterIdPessoas() {
//        String[] idPessoas = new String[Pessoa.contadorPessoas - 1]; // Subtrai o admin do sistema 
//        for (int i = 1; i < pessoas.length; i++) {
//            if (pessoas[i] != null) {
//                idPessoas[i - 1] = Integer.toString(pessoas[i].getId());
//            }
//        }
//        return idPessoas;
//    }
//
//    public int obterQtdPessoas() {
//        return Pessoa.contadorPessoas;
//    }
}
