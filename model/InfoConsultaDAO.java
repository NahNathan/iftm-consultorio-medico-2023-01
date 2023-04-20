/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nathan.santos
 */
public class InfoConsultaDAO {
    private InfoConsulta[] infos;
    private int size;
    private static int proximoId = 1;

    public InfoConsultaDAO() {
        infos = new InfoConsulta[10];
        size = 0;
    }

    public void criarInfoConsulta(InfoConsulta info) {
        if (size == infos.length) {
            InfoConsulta[] newInfos = new InfoConsulta[infos.length * 2];
            System.arraycopy(infos, 0, newInfos, 0, size);
            infos = newInfos;
        }
        info.setId(proximoId++);
        infos[size++] = info;
    }

    public InfoConsulta obterInfoConsultaPorId(int id) {
        for (int i = 0; i < size; i++) {
            if (infos[i].getId() == id) {
                return infos[i];
            }
        }
        return null;
    }

    public InfoConsulta[] listarTodas() {
        InfoConsulta[] allInfos = new InfoConsulta[size];
        System.arraycopy(infos, 0, allInfos, 0, size);
        return allInfos;
    }

    public void editarInfoConsulta(InfoConsulta info) {
        for (int i = 0; i < size; i++) {
            if (infos[i].getId() == info.getId()) {
                infos[i] = info;
                break;
            }
        }
    }

    public void deletarInfoConsulta(int id) {
        for (int i = 0; i < size; i++) {
            if (infos[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    infos[j] = infos[j + 1];
                }
                infos[--size] = null;
                break;
            }
        }
    }
}
