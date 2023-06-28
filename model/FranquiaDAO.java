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

/**
 *
 * @author nathan.santos
 */
public class FranquiaDAO {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public String listarFranquias() {
        String infoFranquias = "";

        String sql = "select nome, cidade, endereco from franquia";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    infoFranquias += "\n Nome da Franquia: " + rs.getString("nome")
                            + " | Cidade: " + rs.getString("cidade")
                            + " | Endereço: " + rs.getString("endereco");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (infoFranquias.equals("")) {
            infoFranquias += "Nenhuma franquia cadastrada!";
        }

        return infoFranquias;
    }

    public Franquia buscarFranquiaPorId(int id) {
        String sql = "select * from franquia where id = ?";
        Franquia f = new Franquia();

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    f.setId(rs.getInt("id"));
                    f.setNome(rs.getString("nome"));
                    f.setCnpj(rs.getString("cnpj"));
                    f.setCidade(rs.getString("cidade"));
                    f.setEndereco(rs.getString("endereco"));
                    f.setResponsavel(pessoaDAO.obterPessoaPorId(rs.getInt("responsavel_id")));
                    f.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    f.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    return f;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public boolean criarFranquia(Franquia franquia) {
        String sql = "insert into franquia"
                + " (nome, cnpj, cidade, endereco, responsavel_id, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setString(1, franquia.getNome());
            stmt.setString(2, franquia.getCnpj());
            stmt.setString(3, franquia.getCidade());
            stmt.setString(4, franquia.getEndereco());
            stmt.setInt(5, franquia.getResponsavel().getId());
            stmt.setDate(6, java.sql.Date.valueOf(franquia.getDataCriacao()));
            stmt.setDate(7, java.sql.Date.valueOf(franquia.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

//    public boolean editarFranquia(Franquia franquia, String[] infoEditada) {
//        for (int i = 0; i < Franquia.contadorFranquias; i++) {
//            if (franquias[i] != null && franquias[i].getId() == franquia.getId()) {
//                if (Integer.parseInt(infoEditada[0]) == 1) { // Editar nome
//                    franquia.setNome(infoEditada[1]);
//                } else if (Integer.parseInt(infoEditada[0]) == 2) { // Editar CNPJ
//                    franquia.setCnpj(infoEditada[1]);
//                } else if (Integer.parseInt(infoEditada[0]) == 3) { // Editar cidade
//                    franquia.setCidade(infoEditada[1]);
//                } else { // Editar endereço
//                    franquia.setEndereco(infoEditada[1]);
//                }
//
//                franquia.setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean alterarResponsavelFranquia(Franquia franquia, Pessoa novoResponsavel) { // Editar responsável pela franquia
//        for (int i = 0; i < Franquia.contadorFranquias; i++) {
//            if (franquias[i].getId() == franquia.getId()) {
//                franquia.setResponsavel(novoResponsavel);
//                franquia.setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }
}
