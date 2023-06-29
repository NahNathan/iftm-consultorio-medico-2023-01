/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author nathan.santos
 */
public class Pessoa {

    private int id;
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    private String login;
    private String senha;
    private int tipoUsuario; //0 - Administrador do sistema / Dono Franquia || 1 - Dono unidade franquia || 2 - Administrativo || 3 - Médico || 4 - Paciente
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //Getters
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getTipoUsuarioString(int tipo) {
        //0 - Administrador do sistema / Dono Franquia || 1 - Dono unidade franquia || 2 - Administrativo || 3 - Médico || 4 - Paciente
        switch (tipo) {
            case 0:
                return "Administrador";
            case 1:
                return "Responsavel pela Unidade";
            case 2:
                return "Gerente Administrativo";
            case 3:
                return "Médico";
            default:
                return "Paciente";
        }
    }

    @Override
    public String toString() {
        return "\n| " + this.getTipoUsuarioString(this.getTipoUsuario())
                        + " | Nome: " + this.nome
                        + " | CPF: " +  this.cpf
                        + " | Endereço: " + this.endereco
                        + " | Telefone: " + this.telefone
                        + " | DataCriação: " + this.dataCriacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + " | DataModificação: " + this.dataModificacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        + "\n";
    }
}
