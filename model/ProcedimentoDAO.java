
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.ConsultaController;
import controller.FinanceiroMedicoController;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
//import java.time.format.DateTimeFormatter;

/**
 *
 * @author nathan.santos
 */
public class ProcedimentoDAO {

    private ConsultaDAO consultaDAO = new ConsultaDAO();
    private FinanceiroMedicoController fmc = new FinanceiroMedicoController();
            
    public boolean adicionarProcedimento(Procedimento procedimento) {
        String sql = "insert into procedimento"
                + " (nome, consulta_id, horario, data, estado, valor, laudo, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setString(1, procedimento.getNome());
            stmt.setInt(2, procedimento.getConsulta().getId());
            stmt.setTime(3, java.sql.Time.valueOf(procedimento.getHorario()));
            stmt.setDate(4, java.sql.Date.valueOf(procedimento.getData()));
            stmt.setInt(5, 0);
            stmt.setBigDecimal(6, procedimento.getValor());
            stmt.setString(7, procedimento.getLaudo());
            stmt.setDate(8, java.sql.Date.valueOf(procedimento.getDataCriacao()));
            stmt.setDate(9, java.sql.Date.valueOf(procedimento.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BigDecimal valorPago = procedimento.getValor().multiply(new BigDecimal("0.5"));
        //Inserindo no financeiro médico

        // [0]: valor | [1]: idMedico | [2]: estado | [3]: idFranquia
        String[] dados = null;
        dados[0] = valorPago.toString();
        dados[1] = Integer.toString(procedimento.getConsulta().getMedico().getId());
        dados[2] = "0";
        dados[3] = Integer.toString(procedimento.getConsulta().getUnidade().getFranquia().getId());

        fmc.adicionarFinanceiroMedico(dados);

        return false;
    }

//    public Procedimento obterProcedimentoPorId(int id) {
//        for (int i = 0; i < procedimentos.length; i++) {
//            if (procedimentos[i] != null && procedimentos[i].getId() == id) {
//                return procedimentos[i];
//            }
//        }
//        return null;
//    }
    public String listarProcedimentosPorIdPaciente(int id) {
        String detalhesProcedimento = "";
        String sql = "select * from procedimento p inner join consulta c on p.consulta_id = c.id where c.paciente_id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Procedimento p = new Procedimento();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setConsulta(consultaDAO.obterConsultaPorId(rs.getInt("consulta_id")));
                    p.setHorario(rs.getTime("horario").toLocalTime());
                    p.setData(rs.getDate("data").toLocalDate());
                    p.setEstado(rs.getInt("estado"));
                    p.setValor(rs.getBigDecimal("valor"));
                    p.setLaudo(rs.getString("laudo"));
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    detalhesProcedimento += p.toString();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (detalhesProcedimento.equals("")) {
            detalhesProcedimento += "Nenhum procedimento cadastrado!";
        }

        return detalhesProcedimento;
    }

//    public String listarProcedimentosPorIdMedico(int id) {
//        String detalhesProcedimento = "";
//        for (int i = 0; i < procedimentos.length; i++) {
//            if (procedimentos[i] != null && procedimentos[i].getConsulta().getMedico().getId() == id) {
//                detalhesProcedimento += procedimentos[i].toString();
//            }
//        }
//
//        if (detalhesProcedimento.equals("")) {
//            detalhesProcedimento += "Nenhum procedimento cadastrado!";
//        }
//
//        return detalhesProcedimento;
//    }
//
//    public boolean atualizarProcedimento(String[] dadoAtualizado) { // dadoAtualizado[0] = id | dadoAtualizado[1] = int informacao | dadoAtualizado[2] = informacao atualizada
//        for (int i = 0; i < procedimentos.length; i++) {
//            if (procedimentos[i] != null && procedimentos[i].getId() == Integer.parseInt(dadoAtualizado[0])) {
//                if (Integer.parseInt(dadoAtualizado[1]) == 1) { // Nome
//                    procedimentos[i].setNome(dadoAtualizado[2]);
//                } else if (Integer.parseInt(dadoAtualizado[1]) == 2) { // Dia
//                    LocalDate data = LocalDate.parse(dadoAtualizado[2]);
//                    procedimentos[i].setData(data);
//                } else if (Integer.parseInt(dadoAtualizado[1]) == 3) { // Horário
//                    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//                    LocalTime horario = LocalTime.parse(dadoAtualizado[2]);
//                    procedimentos[i].setHorario(horario);
//                } else if (Integer.parseInt(dadoAtualizado[1]) == 4) { // Estado
//                    procedimentos[i].setEstado(Integer.parseInt(dadoAtualizado[2]));
//                } else if (Integer.parseInt(dadoAtualizado[1]) == 5) { // Valor
//                    procedimentos[i].setValor(new BigDecimal(dadoAtualizado[2]));
//                } else { // Integer.parseInt(dadoAtualizado[1]) == 5 // Laudo
//                    procedimentos[i].setLaudo(dadoAtualizado[2]);
//                }
//
//                procedimentos[i].setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }
}
