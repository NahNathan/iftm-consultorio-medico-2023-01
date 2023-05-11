/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
/**
 *
 * @author nathan.santos
 */
public class Medico {
    static int contadorMedicos;
    private int id;
    private String CRM;
    private Pessoa pessoa;
    private String especialidade;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Construtor
    public Medico(String CRM, Pessoa pessoa, String especialidade) {
        this.id = pessoa.getId();
        this.CRM = CRM;
        this.pessoa = pessoa;
        this.especialidade = especialidade;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        // Alterando algumas informações na pessoa já cadastrada que receberá o papel de médico
        this.pessoa.setTipoUsuario(3);
        this.pessoa.setDataModificacao(LocalDate.now());
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getCRM() {
        return CRM;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    //Setters
    private void setId(int id) {
        this.id = id;
    }
    
    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    private void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    private void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", CRM=" + CRM + ", pessoa=" + pessoa + ", especialidade=" + especialidade + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
}
