/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import model.Consulta;
import model.InfoConsulta;
import model.InfoConsultaDAO;
/**
 *
 * @author nathan.santos, lfelippe
 */
public class InfoConsultaController {
    private InfoConsultaDAO dao = new InfoConsultaDAO();
    private ConsultaController consultaController = new ConsultaController();
    
    public boolean criarInfoConsulta(String descricao, int idConsulta) {
        InfoConsulta info = new InfoConsulta();
        info.setConsulta(this.consultaController.obterConsultaPorId(idConsulta));
        info.setDataCriacao(LocalDate.now());
        info.setDataModificacao(LocalDate.now());
        
        return this.dao.criarInfoConsulta(info);
    }

//    public InfoConsulta obterInfoConsultaPorId(int id) {
//        return this.dao.obterInfoConsultaPorId(id);
//    }
//
//    public String obterDescricaoInfoConsultaPorId(int id) {
//        return this.dao.obterDescricaoInfoConsultaPorId(id);
//    }

//    public boolean editarInfoConsulta(String[] infoConsultaEditada) {
//        return this.dao.editarInfoConsulta(this.obterInfoConsultaPorId(Integer.parseInt(infoConsultaEditada[0])), infoConsultaEditada[1]);
//    }
}
