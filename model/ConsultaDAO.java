/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

// Imports apenas para inicialização de consultas no construtor para teste de sistema
import controller.FinanceiroMedicoController;
import controller.MedicoController;
import controller.PessoaController;
import controller.UnidadeController;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nathan.santos
 */
public class ConsultaDAO {

    private PessoaDAO pessoaDAO = new PessoaDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();
    private UnidadeDAO unidadeDAO = new UnidadeDAO();
    private FinanceiroMedicoController fmc = new FinanceiroMedicoController();

    public boolean criarConsulta(Consulta consulta) {
        String sql = "insert into consulta"
                + " (horario, data, paciente_id, medico_id, unidade_id, estado, valor, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setTime(1, java.sql.Time.valueOf(consulta.getHorario()));
            stmt.setDate(2, java.sql.Date.valueOf(consulta.getData()));
            stmt.setInt(3, consulta.getPaciente().getId());
            stmt.setInt(4, consulta.getMedico().getId());
            stmt.setInt(5, consulta.getUnidade().getId());
            stmt.setInt(6, consulta.getEstado());
            stmt.setBigDecimal(7, consulta.getValor());
            stmt.setDate(8, java.sql.Date.valueOf(consulta.getDataCriacao()));
            stmt.setDate(9, java.sql.Date.valueOf(consulta.getDataModificacao()));

            stmt.execute();
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BigDecimal valorPago = consulta.getValor().multiply(new BigDecimal("0.7"));
        //Inserindo no financeiro médico

        // [0]: valor | [1]: idMedico | [2]: estado | [3]: idFranquia
        String[] dados = null;
        dados[0] = valorPago.toString();
        dados[1] = Integer.toString(consulta.getMedico().getId());
        dados[2] = "0";
        dados[3] = Integer.toString(consulta.getUnidade().getFranquia().getId());

        fmc.adicionarFinanceiroMedico(dados);

        return false;
    }

    public String listarConsultasRealizadasPorIdMedico(int id) {
        String detalhesConsultas = "";

        String sql = "select * from consulta where medico_id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setHorario(rs.getTime("horario").toLocalTime());
                    c.setData(rs.getDate("data").toLocalDate());
                    c.setPaciente(pessoaDAO.obterPessoaPorId(rs.getInt("paciente_id")));
                    c.setMedico(medicoDAO.obterMedicoPorId(rs.getInt("medico_id")));
                    c.setUnidade(unidadeDAO.obterUnidadePorId(rs.getInt("unidade_id")));
                    c.setEstado(rs.getInt("estado"));
                    c.setValor(rs.getBigDecimal("valor"));
                    c.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    c.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    detalhesConsultas += c.toString();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (detalhesConsultas.equals("")) {
            detalhesConsultas += "Nenhuma consulta cadastrada!";
        }

        return detalhesConsultas;
    }

    public int obterUltimaConsulta() {
        String sql = "select id from consulta order by id desc limit 1";
        int id;

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");

                    return id;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public String obterConsultasPorIdPaciente(int id) {
        String detalhesConsultas = "";
        String sql = "select * from consulta where paciente_id = ?";
        //List<Consulta> consultas = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setHorario(rs.getTime("horario").toLocalTime());
                    c.setData(rs.getDate("data").toLocalDate());
                    c.setPaciente(pessoaDAO.obterPessoaPorId(rs.getInt("paciente_id")));
                    c.setMedico(medicoDAO.obterMedicoPorId(rs.getInt("medico_id")));
                    c.setUnidade(unidadeDAO.obterUnidadePorId(rs.getInt("unidade_id")));
                    c.setEstado(rs.getInt("estado"));
                    c.setValor(rs.getBigDecimal("valor"));
                    c.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    c.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    detalhesConsultas += c.toString();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (detalhesConsultas.equals("")) {
            detalhesConsultas += "Nenhuma consulta cadastrada!";
        }

        return detalhesConsultas;
    }

    public Consulta obterConsultaPorId(int id) {
        String sql = "select * from consulta where id = ?";
        Consulta c = new Consulta();

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            // Setando os valores para a query
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setId(rs.getInt("id"));
                    c.setHorario(rs.getTime("horario").toLocalTime());
                    c.setData(rs.getDate("data").toLocalDate());
                    c.setPaciente(pessoaDAO.obterPessoaPorId(rs.getInt("paciente_id")));
                    c.setMedico(medicoDAO.obterMedicoPorId(rs.getInt("medico_id")));
                    c.setUnidade(unidadeDAO.obterUnidadePorId(rs.getInt("unidade_id")));
                    c.setEstado(rs.getInt("estado"));
                    c.setValor(rs.getBigDecimal("valor"));
                    c.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    c.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    return c;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public String listarPacientesPorIdMedico(int id) {
        String pacientes = "";

        String sql = "select p.id, p.nome, p.telefone from pessoa p inner join consulta c on p.id = c.paciente_id inner join medico m on c.medico_id = m.id where m.id = ? group by p.id; ";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pacientes += "\n ID: " + rs.getInt("id")
                            + " | Paciente: " + rs.getString("nome")
                            + " | Telefone: " + rs.getString("telefone");
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

    public String obterInformacoesPacientePorIdMedicoIdPaciente(int idMedico, int idPaciente) {
        String informacoes = "";
        String sql = "select pe.nome, c.horario, c.data, c.valor, c.estado, ic.descricao, p.nome, p.horario, p.data, p.estado, p. valor, p.laudo, f.nome, u.cidade, u.endereco\n"
                + "	from pessoa pe inner join consulta c on pe.id = c.paciente_id\n"
                + "        inner join infoconsulta ic on c.id = ic.consulta_id\n"
                + "		inner join procedimento p on c.id = p.consulta_id\n"
                + "        inner join unidade u on c.unidade_id = u.id\n"
                + "        inner join franquia f on u.franquia_id = f.id\n"
                + "			where c.medico_id = ? and c.paciente_id = ?";

        try (Connection connection = new ConnectionFactory().getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idMedico);
            ps.setInt(2, idPaciente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    informacoes += "Paciente: " + rs.getString("pe.nome") + " | Franquia: " + rs.getString("f.nome") + " | Endereço: " + rs.getString("u.endereco") + " | " + rs.getString("u,cidade")
                            + "\n ===================== Consulta ===================== "
                            + "\n Horário: " + rs.getTime("c.horario")
                            + "\n Data: " + rs.getString("c.data")
                            + "\n Valor: R$" + rs.getFloat("c.valor")
                            + "\n Estado: " + rs.getInt("c.estado")
                            + "\n ===================== Descrição ===================== "
                            + "\n Descrição: " + rs.getString("descricao")
                            + "\n ===================== Procedimento ===================== "
                            + "\n Nome: " + rs.getString("p.nome")
                            + "\n Horário: " + rs.getTime("p.horario")
                            + "\n Data: " + rs.getDate("p.data")
                            + "\n Estado: " + rs.getInt("p.estado")
                            + "\n Valor: " + rs.getFloat("p.valor")
                            + "\n Laudo: " + rs.getString("p.laudo")
                            + "\n -------------------------------------------------------\n";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (informacoes.equals("")) {
            informacoes += "Nenhuma informacao encontrada!";
        }
        return informacoes;
    }

//    public boolean editarConsulta(Consulta consulta, LocalTime horario, LocalDate data) {
//        consulta.setHorario(horario);
//        consulta.setData(data);
//        consulta.setDataModificacao(LocalDate.now());
//        return false;
//    }
//
//    public boolean editarConsulta(Consulta consulta, Medico medico) {
//        consulta.setMedico(medico);
//        consulta.setDataModificacao(LocalDate.now());
//        return false;
//    }
//
//    public boolean editarConsulta(Consulta consulta, Unidade unidade) {
//        consulta.setUnidade(unidade);
//        consulta.setDataModificacao(LocalDate.now());
//        return false;
//    }
//
//    public boolean editarConsulta(Consulta consulta, int estado) {
//        consulta.setEstado(estado);
//        consulta.setDataModificacao(LocalDate.now());
//        return false;
//    }
//
//    public boolean editarConsulta(Consulta consulta, BigDecimal valor) {
//        consulta.setValor(valor);
//        consulta.setDataModificacao(LocalDate.now());
//        return false;
//    }
}
