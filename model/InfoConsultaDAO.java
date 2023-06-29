/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.ConsultaController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author nathan.santos
 */
public class InfoConsultaDAO {

    public boolean criarInfoConsulta(InfoConsulta info) {
        String sql = "insert into InfoConsulta"
                + " (consulta_id, descricao, dataCriacao, dataModificacao)"
                + " values (?, ?, ?, ?)";

        try (Connection c = new ConnectionFactory().getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            // Setando os valores 
            stmt.setInt(1, info.getConsulta().getId());
            stmt.setString(2, info.getDescricao());
            stmt.setDate(3, java.sql.Date.valueOf(info.getDataCriacao()));
            stmt.setDate(4, java.sql.Date.valueOf(info.getDataModificacao()));

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

//    public InfoConsulta obterInfoConsultaPorId(int id) {
//        for (int i = 0; i < infoConsultas.length; i++) {
//            if (infoConsultas[i] != null && infoConsultas[i].getId() == id) {
//                return infoConsultas[i];
//            }
//        }
//        return null;
//    }
//
//    public String obterDescricaoInfoConsultaPorId(int id) {
//        String descricao = "";
//
//        for (int i = 0; i < infoConsultas.length; i++) {
//            if (infoConsultas[i] != null && infoConsultas[i].getId() == id) {
//                descricao += infoConsultas[i].getDescricao();
//            }
//        }
//
//        if (descricao.equals("")) {
//            descricao = "\nInformação da consulta não encontrada!\n";
//        }
//        return descricao;
//    }

//    public boolean editarInfoConsulta(InfoConsulta info, String descricao) {
//        for (int i = 0; i < infoConsultas.length; i++) {
//            if (infoConsultas[i] != null && infoConsultas[i].getId() == info.getId()) {
//                info.setDescricao(descricao);
//                info.setDataModificacao(LocalDate.now());
//                return true;
//            }
//        }
//        return false;
//    }
}
