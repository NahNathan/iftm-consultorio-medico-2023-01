/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import model.FinanceiroMedico;
import model.FinanceiroMedicoDAO;

/**
 *
 * @author lfeli
 */
public class FinanceiroMedicoController {
    
    private FinanceiroMedicoDAO dao = new FinanceiroMedicoDAO();
    private FranquiaController f = new FranquiaController();
    private MedicoController m = new MedicoController();


    public boolean adicionarFinanceiroMedico(String[] dadosFinanceiroMedico) { // [0]: valor | [1]: idMedico | [2]: estado | [3]: idFranquia
        BigDecimal valor = new BigDecimal(dadosFinanceiroMedico[0]);
        int estado = Integer.parseInt(dadosFinanceiroMedico[2]);
        FinanceiroMedico fm = new FinanceiroMedico();
        fm.setValor(valor);
        fm.setMedico(m.obterMedicoPorId(Integer.parseInt(dadosFinanceiroMedico[1])));
        fm.setEstado(estado);
        fm.setFranquia(f.buscarFranquiaPorId(Integer.parseInt(dadosFinanceiroMedico[3])));
        fm.setDataCriacao(LocalDate.now());
        fm.setDataModificacao(LocalDate.now());
        return this.dao.adicionarFinanceiroMedico(fm);
    }
            
//    public FinanceiroMedico obterFinanceiroMedicoPorId(int id) {
//        return this.dao.obterFinanceiroMedicoPorId(id);
//    }
            
    public String listarFinanceiroMedicoPorIdMedico(int id) {
        return this.dao.listarFinanceiroMedicoPorIdMedico(id);
    }
            
//    public boolean editarFinanceiroMedico(String[] dadoAtualizado) {
//        return this.dao.editarFinanceiroMedico(dadoAtualizado);
//    }
                    
        
}
