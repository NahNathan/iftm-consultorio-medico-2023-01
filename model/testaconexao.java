/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lfeli
 */
public class testaconexao {

    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Conexao aberta!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
