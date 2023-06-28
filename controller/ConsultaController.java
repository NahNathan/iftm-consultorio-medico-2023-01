/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import model.Consulta;
import model.ConsultaDAO;

/**
 *
 * @author nathan.santos
 */
public class ConsultaController {

    private ConsultaDAO dao = new ConsultaDAO();
    private PessoaController pessoaController = new PessoaController();
    private MedicoController medicoController = new MedicoController();
    private UnidadeController unidadeController = new UnidadeController();

    public boolean criarConsulta(String[] dadosConsulta) { // [0]: data | [1]: horario | [2]: descricao (infoConsulta) | [3]: valor | [4]: idpaciente | [5]: idmedico | [6]: idunidade
        Consulta c = new Consulta();
        LocalDate data = LocalDate.parse(dadosConsulta[0], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalTime horario = LocalTime.parse(dadosConsulta[1], DateTimeFormatter.ofPattern("HH:mm:ss"));
        BigDecimal valor = new BigDecimal(dadosConsulta[3]);
        c.setHorario(horario);
        c.setData(data);
        c.setPaciente(pessoaController.obterPessoaPorId(Integer.parseInt(dadosConsulta[4])));
        c.setMedico(medicoController.obterMedicoPorId(Integer.parseInt(dadosConsulta[5])));
        c.setUnidade(unidadeController.obterUnidadePorId(Integer.parseInt(dadosConsulta[6])));
        c.setEstado(1);
        c.setValor(valor);
        c.setDataCriacao(LocalDate.now());
        c.setDataModificacao(LocalDate.now());

        return this.dao.criarConsulta(c);
    }

    public Consulta obterConsultaPorId(int id) {
        return this.dao.obterConsultaPorId(id);
    }

    public String obterConsultasPorIdPaciente(int id) {
        return this.dao.obterConsultasPorIdPaciente(id);
    }
    
    public int obterUltimaConsulta() {
        return this.dao.obterUltimaConsulta();
    }
    
    public String listarConsultasRealizadasPorIdMedico(int id) {
        return this.dao.listarConsultasRealizadasPorIdMedico(id);
    }
    
    public String listarPacientesPorIdMedico(int id) {
        return this.dao.listarPacientesPorIdMedico(id);
    }
    
    public String obterInformacoesPacientePorIdMedicoIdPaciente(int idMedico, int idPaciente) {
        return this.dao.obterInformacoesPacientePorIdMedicoIdPaciente(idMedico, idPaciente);
    }

//    public boolean editarDataHoraConsulta(String[] dadosConsultaAlterado) {
//        LocalTime horario = LocalTime.parse(dadosConsultaAlterado[1]);
//        LocalDate data = LocalDate.parse(dadosConsultaAlterado[2]);
//        return this.dao.editarConsulta(this.obterConsultaPorId(Integer.parseInt(dadosConsultaAlterado[0])), horario, data);
//    }
//
//    public boolean editarMedicoConsulta(String[] dadosConsultaAlterado) {
//        return this.dao.editarConsulta(this.obterConsultaPorId(Integer.parseInt(dadosConsultaAlterado[0])), m.obterMedicoPorId(Integer.parseInt(dadosConsultaAlterado[1])));
//    }
//
//    public boolean editarUnidadeConsulta(String[] dadosConsultaAlterado) {
//        return this.dao.editarConsulta(this.obterConsultaPorId(Integer.parseInt(dadosConsultaAlterado[0])), u.obterUnidadePorId(Integer.parseInt(dadosConsultaAlterado[1])));
//    }
//
//    public boolean editarEstadoConsulta(String[] dadosConsultaAlterado) {
//        return this.dao.editarConsulta(this.obterConsultaPorId(Integer.parseInt(dadosConsultaAlterado[0])), Integer.parseInt(dadosConsultaAlterado[1]));
//    }
//
//    public boolean editarValorConsulta(String[] dadosConsultaAlterado) {
//        return this.dao.editarConsulta(this.obterConsultaPorId(Integer.parseInt(dadosConsultaAlterado[0])), new BigDecimal(dadosConsultaAlterado[1]));
//    }

}
