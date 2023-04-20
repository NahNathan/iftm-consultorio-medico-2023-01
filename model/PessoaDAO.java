/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author nathan.santos
 */
public class PessoaDAO {
    private Pessoa[] pessoas;
    private int pessoasCount;

    public PessoaDAO() {
        this.pessoas = new Pessoa[100];
        this.pessoasCount=0;
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoa.setId(pessoasCount+1);
        pessoa.setDataCriacao(new Date());
        pessoa.setDataModificacao(new Date());
        this.pessoas[pessoasCount] = pessoa;
        pessoasCount++;
    }
    
    public Pessoa obterPessoaPorId(int id) {
        for (int i=0; i<pessoasCount; i++) {
            if (pessoas[i].getId()==id) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa[] listarPessoas() {
        Pessoa[] pessoasExistentes=new Pessoa[pessoasCount];
        for (int i=0; i<pessoasCount; i++) {
            pessoasExistentes[i] = pessoas[i];
        }
        //System.arraycopy(pessoas, 0, pessoasExistentes, 0, pessoasCount);
        //Talvez assim funcione melhor?
        return pessoasExistentes;
    }
    
    public void editarPessoa(Pessoa pessoa) {
        for (int i=0; i<pessoasCount; i++) {
            if (pessoas[i].getId()==pessoa.getId()) {
                pessoas[i]=pessoa;
                pessoa.setDataModificacao(new Date());
                break;
            }
        }
    }
    
    public void removerPessoa(int id) {
        for (int i=0; i<pessoasCount; i++) {
            if (pessoas[i].getId()==id) {
                pessoas[i]=null;
                //Arrumar as posições da frente
                for (int j=i; j<pessoasCount-1; j++) {
                    pessoas[j]=pessoas[j+1];
                }
                pessoasCount--;
                break;
            }
        }
    }
    
}
