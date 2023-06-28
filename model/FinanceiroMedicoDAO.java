/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.FranquiaController;
import controller.MedicoController;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author lfeli
 */
public class FinanceiroMedicoDAO {

    private MedicoDAO medicoDAO = new MedicoDAO();
    private FinanceiroMedico financeiromedico = new FinanceiroMedico();
    private FranquiaDAO franquiaDAO = new FranquiaDAO();
            

    public boolean adicionarFinanceiroMedico(FinanceiroMedico financeiro) {
        String sql = "insert into financeiromedico"
                + " (valor, medico_id, estado, franquia_id, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setBigDecimal(1, financeiro.getValor());
            stmt.setInt(2, financeiro.getMedico().getId());
            stmt.setInt(3, financeiro.getEstado());
            stmt.setInt(4,financeiro.getFranquia().getId());
            stmt.setDate(5, java.sql.Date.valueOf(financeiro.getDataCriacao()));
            stmt.setDate(6, java.sql.Date.valueOf(financeiro.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    

    public String listarFinanceiroMedicoPorIdMedico(int id) {
        String listaFinanceirosMedico = "";

        String sql = "SELECT * FROM financeiromedico where medico_id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                listaFinanceirosMedico += "\n Médico: " + medicoDAO.obterMedicoPorId(id).getPessoa().getNome() + "\n";
                while (rs.next()) {
                    listaFinanceirosMedico += "\n Valor: R$" + rs.getBigDecimal("valor") 
                            + "\n Estado: " + financeiromedico.getEstadoString(rs.getInt("estado"))
                            + "\n Franquia: " + franquiaDAO.buscarFranquiaPorId(rs.getInt("franquia_id"))
                            + "\n Data de Criação: " + rs.getDate("dataCriacao")
                            + "\n -----------------------------------------------------------------------------------\n";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (listaFinanceirosMedico.equals("")) {
            listaFinanceirosMedico += "Nenhuma informação cadastrada!";
        }

        return listaFinanceirosMedico;
    }

//    public boolean editarFinanceiroMedico(String[] dadoAtualizado) { // [0]: id | [1]: tipo dado | [2]: dado atualizado 
//        for (int i = 0; i < financeirosMedico.length; i++) {
//            if (financeirosMedico[i] != null && financeirosMedico[i].getId() == Integer.parseInt(dadoAtualizado[0])) {
//                if (Integer.parseInt(dadoAtualizado[1]) == 1) { // Valor
//                    financeirosMedico[i].setValor(new BigDecimal(dadoAtualizado[2]));
//                } else { // Integer.parseInt(dadoAtualizado[1]) == 2 | Estado
//                    financeirosMedico[i].setEstado(Integer.parseInt(dadoAtualizado[2]));
//                }
//
//                financeirosMedico[i].setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }

    
}
