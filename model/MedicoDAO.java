/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// imports para teste do sistema
import controller.PessoaController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author nathan.santos, lfelippe
 */
public class MedicoDAO {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean adicionarMedico(Medico m) {
        String sql = "insert into medico"
                + " (CRM, pessoa_id, especialidade, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setString(1, m.getCRM());
            stmt.setInt(2, m.getPessoa().getId());
            stmt.setString(3, m.getEspecialidade());
            stmt.setDate(4, java.sql.Date.valueOf(m.getDataCriacao()));
            stmt.setDate(5, java.sql.Date.valueOf(m.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Medico obterMedicoPorId(int id) {
        String sql = "select * from medico where id = ?";
        Medico m = new Medico();

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    m.setId(rs.getInt("id"));
                    m.setCRM(rs.getString("CRM"));
                    m.setPessoa(pessoaDAO.obterPessoaPorId(rs.getInt("pessoa_id")));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    m.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    return m;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Medico obterMedicoPorIdPessoa(int id) {
        String sql = "select * from medico where pessoa_id = ?";
        Medico m = new Medico();

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    m.setId(rs.getInt("id"));
                    m.setCRM(rs.getString("CRM"));
                    m.setPessoa(pessoaDAO.obterPessoaPorId(rs.getInt("pessoa_id")));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    m.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    return m;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

//    public String listarMedicos() {
//        String listaMedicos = "";
//        for (int i = 0; i < medicos.length; i++) {
//            if (medicos[i] != null) {
//                listaMedicos += medicos[i].toString();
//            }
//        }
//
//        if (listaMedicos.equals("")) {
//            listaMedicos += "\nNenhum médico cadastrado!\n";
//        }
//
//        return listaMedicos;
//    }
    
    public boolean editarMedico(String[] dadosEditados) {  // [0]: Id | [1]: tipo de Informação | [2]: Informação editada
        String sql = "update medico set ? = ?, dataModificacao = ? where id = ?";

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
                    // Editar CRM
                    stmt.setString(1, "CRM");
                    break;
                case 6:
                    // Editar Especialidade
                    stmt.setString(1, "especialidade");
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
}
