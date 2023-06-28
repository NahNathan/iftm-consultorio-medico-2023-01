/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MedicoDAO;
import model.Medico;
import controller.PessoaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import model.Pessoa;

/**
 *
 * @author nathan.santos
 */
public class MedicoController {

    private MedicoDAO dao = new MedicoDAO();
    private PessoaController pessoaController = new PessoaController();

    public boolean adicionarMedico(String[] dadosMedico) { // [0]: CRM | [1]: Especialidade | [2]: IdPessoa
        Medico medico = new Medico();
        medico.setCRM(dadosMedico[0]);
        medico.setEspecialidade(dadosMedico[1]);
        medico.setPessoa(pessoaController.obterPessoaPorId(Integer.parseInt(dadosMedico[2])));
        medico.setDataCriacao(LocalDate.now());
        medico.setDataModificacao(LocalDate.now());

        return this.dao.adicionarMedico(medico);
    }

    public Medico obterMedicoPorId(int id) {
        return this.dao.obterMedicoPorId(id);
    }

    public Map<String, String> obterMedicoPorIdPessoa(int id) {
        Map<String, String> infoMedico = new HashMap<>();
        Medico m = this.dao.obterMedicoPorIdPessoa(id);
        infoMedico.put("id", Integer.toString(m.getId()));
//        infoMedico.put("nome", m.getNome());
//        infoMedico.put("endereco", m.getEndereco());
//        infoMedico.put("cpf", m.getCpf());
//        infoMedico.put("telefone", m.getTelefone());
//        infoMedico.put("login", m.getLogin());
//        infoMedico.put("senha", m.getSenha());
//        infoMedico.put("tipoUsuario", m.getTipoUsuarioString(p.getTipoUsuario()));
//        infoMedico.put("dataCriacao", m.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//        infoMedico.put("dataModificacao", m.getDataModificacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return infoMedico;
    }

//    public String listarMedicos() {
//        return this.dao.listarMedicos();
//    }
    public boolean editarMedico(String[] dadosEditados) {
        return this.dao.editarMedico(dadosEditados);
    }
}
