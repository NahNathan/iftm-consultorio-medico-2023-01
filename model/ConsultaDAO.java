/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nathan.santos
 */
public class ConsultaDAO {
    private Consulta[] consultas;
    private static int proximoId = 1;

    public ConsultaDAO() {
        consultas = new Consulta[0];
    }

    public void criarConsulta(Consulta consulta) {
        consulta.setId(proximoId++);
        Consulta[] novoArray = new Consulta[consultas.length + 1];
        System.arraycopy(consultas, 0, novoArray, 0, consultas.length);
        novoArray[consultas.length] = consulta;
        consultas = novoArray;
    }

    public Consulta listarConsulta(int id) {
        for (Consulta consulta : consultas) {
            if (consulta.getId() == id) {
                return consulta;
            }
        }
        return null;
    }

    public Consulta[] listarTodas() {
        return consultas;
    }

    public void editarConsulta(Consulta consulta) {
        for (int i = 0; i < consultas.length; i++) {
            if (consultas[i].getId() == consulta.getId()) {
                consultas[i] = consulta;
                break;
            }
        }
    }

    public void deletarConsulta(int id) {
        for (int i = 0; i < consultas.length; i++) {
            if (consultas[i].getId() == id) {
                Consulta[] novoArray = new Consulta[consultas.length - 1];
                System.arraycopy(consultas, 0, novoArray, 0, i);
                System.arraycopy(consultas, i + 1, novoArray, i, consultas.length - i - 1);
                consultas = novoArray;
                break;
            }
        }
    }
}
