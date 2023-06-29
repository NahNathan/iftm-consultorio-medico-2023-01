/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import model.Consulta;
import model.Procedimento;
import model.ProcedimentoDAO;
/**
 *
 * @author nathan.santos, lfelippe
 */
public class ProcedimentoController {
    private ProcedimentoDAO dao = new ProcedimentoDAO();
    private ConsultaController c = new ConsultaController();

    public boolean adicionarProcedimento(String[] dadosProcedimento) {
        // String[0] = nome | String[1] = idConsulta | String[2] = horario | String[3] = data | String[4] = valor | String[5] = laudo 
        String nome = dadosProcedimento[0];
        Consulta consulta = c.obterConsultaPorId(Integer.parseInt(dadosProcedimento[1]));
        LocalTime horario = LocalTime.parse(dadosProcedimento[2]);
        LocalDate data = LocalDate.parse(dadosProcedimento[3]);
        BigDecimal valor = new BigDecimal(dadosProcedimento[4]);
        String laudo = dadosProcedimento[5];
        Procedimento p = new Procedimento();
        p.setNome(nome);
        p.setConsulta(consulta);
        p.setHorario(horario);
        p.setData(data);
        p.setEstado(0);
        p.setValor(valor);
        p.setLaudo(laudo);
        p.setDataCriacao(LocalDate.now());
        p.setDataModificacao(LocalDate.now());
        
        return this.dao.adicionarProcedimento(p);
    }

//    public Procedimento obterProcedimentoPorId(int id) {
//        return this.dao.obterProcedimentoPorId(id);
//    }

    public String listarProcedimentosPorIdPaciente(int id) {
        return this.dao.listarProcedimentosPorIdPaciente(id);
    }
    
//    public String listarProcedimentosPorIdMedico(int id) {
//        return this.dao.listarProcedimentosPorIdMedico(id);
//    }

//    public boolean atualizarProcedimento(String[] dadoAtualizado) {
//        return this.dao.atualizarProcedimento(dadoAtualizado);
//    }
}
