/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UnidadeController;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author lfeli
 */
public class FinanceiroAdmDAO {

    private UnidadeDAO unidadeDAO = new UnidadeDAO();

    public boolean criarMovimentoFinanceiro(FinanceiroAdm fa) {
        String sql = "insert into financeiroadm"
                + " (tipoMovimento, valor, unidade_id, descritivoMovimento, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setInt(1, fa.getTipoMovimento());
            stmt.setBigDecimal(2, fa.getValor());
            stmt.setInt(3, fa.getUnidade().getId());
            stmt.setString(4, fa.getDescritivoMovimentoString(fa.getDescritivoMovimento()));
            stmt.setDate(5, java.sql.Date.valueOf(fa.getDataCriacao()));
            stmt.setDate(6, java.sql.Date.valueOf(fa.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

//    public FinanceiroAdm buscarMovimentoFinanceiroPorId(int id) {
//        for (int i = 0; i < movimentosFinanceiros.length; i++) {
//            if (movimentosFinanceiros[i] != null && movimentosFinanceiros[i].getId() == id) {
//                return movimentosFinanceiros[i];
//            }
//        }
//        return null;
//    }
    public String listarMovimentosFinanceiros() {
        String listaMovimentosFinanceiros = "";

        String sql = "select * from financeiroadm";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FinanceiroAdm f = new FinanceiroAdm();
                    f.setId(rs.getInt("id"));
                    f.setTipoMovimento(rs.getInt("tipoMovimento"));
                    f.setValor(rs.getBigDecimal("valor"));
                    f.setUnidade(unidadeDAO.obterUnidadePorId(rs.getInt("unidade_id")));
                    f.setDescritivoMovimento(f.getDescritivoMovimentoString(rs.getString("descritivoMovimento")));
                    f.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    f.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    listaMovimentosFinanceiros += f.toString();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (listaMovimentosFinanceiros.equals("")) {
            listaMovimentosFinanceiros += "\nNenhum movimento financeiro encontrado!\n";
        }

        return listaMovimentosFinanceiros;
    }

    public String listarMovimentosFinanceirosPorIdUnidade(int id) {
        String listaMovimentosFinanceiros = "";

        String sql = "select * from financeiroadm where unidade_id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FinanceiroAdm f = new FinanceiroAdm();
                    f.setId(rs.getInt("id"));
                    f.setTipoMovimento(rs.getInt("tipoMovimento"));
                    f.setValor(rs.getBigDecimal("valor"));
                    f.setUnidade(unidadeDAO.obterUnidadePorId(rs.getInt("unidade_id")));
                    f.setDescritivoMovimento(f.getDescritivoMovimentoString(rs.getString("descritivoMovimento")));
                    f.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    f.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    listaMovimentosFinanceiros += f.toString();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (listaMovimentosFinanceiros.equals("")) {
            listaMovimentosFinanceiros += "Nenhuma movimento financeiro registrado este mês.";
        }

        return listaMovimentosFinanceiros;
    }

//    public String listarMovimentosFinanceirosMensal(String mes) {
//        String listaMovimentosFinanceiros = "";
//
//        for (int i = 0; i < movimentosFinanceiros.length; i++) {
//            if (movimentosFinanceiros[i] != null) {
//                listaMovimentosFinanceiros += movimentosFinanceiros[i].toString();
//            }
//        }
//
//        if (listaMovimentosFinanceiros.equals("")) {
//            listaMovimentosFinanceiros += "\nNenhum movimento financeiro encontrado!\n";
//        }
//
//        return listaMovimentosFinanceiros;
//    }
//    public BigDecimal obterFaturamentoTotalPorIdUnidade(int id) {
//        BigDecimal total = new BigDecimal("0");
//        for (int i = 0; i < movimentosFinanceiros.length; i++) {
//            if (movimentosFinanceiros[i] != null && movimentosFinanceiros[i].getUnidade().getId() == id && movimentosFinanceiros[i].getTipoMovimento() == 0) {
//                total.add(movimentosFinanceiros[i].getValor());
//            }
//        }
//        return total;
//    }

//    public boolean editarMovimentoFinanceiro(String[] dadosEditados) { // [0]: id Movimento | [1]: tipo de dado | [2]: dado alterado
//        for (int i = 0; i < movimentosFinanceiros.length; i++) {
//            if (movimentosFinanceiros[i] != null && movimentosFinanceiros[i].getId() == Integer.parseInt(dadosEditados[0])) {
//                if (Integer.parseInt(dadosEditados[1]) == 0) { // Valor
//                    movimentosFinanceiros[i].setValor(new BigDecimal(dadosEditados[2]));
//                } else if (Integer.parseInt(dadosEditados[1]) == 1) { // Unidade
//                    movimentosFinanceiros[i].setUnidade(u.obterUnidadePorId(Integer.parseInt(dadosEditados[2])));
//                } else { // Integer.parseInt(dadosEditados[1]) == 2 | Descritivo movimento
//                    movimentosFinanceiros[i].setDescritivoMovimento(Integer.parseInt(dadosEditados[2]));
//                }
//
//                movimentosFinanceiros[i].setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//
//        return false;
//    }
}
