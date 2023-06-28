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
public class UnidadeDAO {

    private FranquiaDAO franquiaDAO = new FranquiaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public boolean criarUnidade(Unidade unidade) {
        String sql = "insert into unidade"
                + " (franquia_id, cidade, endereco, responsavel_id, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setInt(1, unidade.getFranquia().getId());
            stmt.setString(2, unidade.getCidade());
            stmt.setString(3, unidade.getEndereco());
            stmt.setInt(4, unidade.getResponsavel().getId());
            stmt.setDate(5, java.sql.Date.valueOf(unidade.getDataCriacao()));
            stmt.setDate(6, java.sql.Date.valueOf(unidade.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public String listarUnidades() {
        String listaUnidades = "";

        String sql = "select f.nome, u.cidade, u.endereco from franquia f inner join unidade u on f.id = u.franquia_id";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaUnidades += "\n Franquia: " + rs.getString("f.nome")
                            + " | Cidade: " + rs.getString("u.cidade")
                            + " | Endereço: " + rs.getString("u.endereco");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (listaUnidades.equals("")) {
            listaUnidades += "Nenhuma unidade cadastrada!";
        }

        return listaUnidades;
    }

    public Unidade obterUnidadePorId(int id) {
        String sql = "select * from unidade where id = ?";
        Unidade u = new Unidade();

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u.setId(rs.getInt("id"));
                    u.setFranquia(franquiaDAO.buscarFranquiaPorId(rs.getInt("franquia_id")));
                    u.setCidade(rs.getString("cidade"));
                    u.setEndereco(rs.getString("endereco"));
                    u.setResponsavel(pessoaDAO.obterPessoaPorId(rs.getInt("responsavel_id")));
                    u.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    u.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    return u;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public int obterIdUnidadePorResponsavelId(int idResponsavel) {
        String sql = "select id from unidade where responsavel_id = ?";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, idResponsavel);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {

                    return rs.getInt("id");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

//    public boolean editarUnidade(Unidade unidade, String[] infoEditada) {
//        for (int i = 0; i < unidades.length; i++) {
//            if (unidades[i] != null && unidades[i].getId() == unidade.getId()) {
//                if (Integer.parseInt(infoEditada[0]) == 1) { // Editar cidade
//                    unidade.setCidade(infoEditada[1]);
//                } else { // Editar endereço
//                    unidade.setEndereco(infoEditada[1]);
//
//                    unidade.setDataModificacao(LocalDate.now());
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    public boolean alterarResponsavelUnidade(Unidade unidade, Pessoa novoResponsavel) { // Editar responsável pela unidade
//        for (int i = 0; i < Unidade.contadorUnidadesFranquias; i++) {
//            if (unidades[i] != null && unidades[i].getId() == unidade.getId()) {
//                unidade.setResponsavel(novoResponsavel);
//                unidade.setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }
}
