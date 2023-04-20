/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



/**
 *
 * @author nathan.santos
 */
public class UnidadeDAO {
    private Unidade[] unidades=new Unidade[10];
    private int proximoId=1;
    
    public void criarUnidade(Unidade unidade) {
        unidade.setId(proximoId++);
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i] == null) {
                unidades[i] = unidade;
                return;
            }
        }
    }
    
    public Unidade[] listarTodas() {
        return unidades;
    }

    public Unidade obterUnidadePorId(int id) {
        for (int i=0; i<proximoId; i++) {
            if (unidades[i].getId()==id) {
                return unidades[i];
            }
        }
        return null;
    }
    
    public void editarUnidade(Unidade unidade) {
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i] != null && unidades[i].getId() == unidade.getId()) {
                unidades[i] = unidade;
                return;
            }
        }
    }

    public void deletarUnidade(int id) {
        for (int i = 0; i < unidades.length; i++) {
            if (unidades[i] != null && unidades[i].getId() == id) {
                unidades[i] = null;
                return;
            }
        }
    }

}
