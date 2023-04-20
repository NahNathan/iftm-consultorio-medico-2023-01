/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author nathan.santos
 */
public class Procedimento {
    
    private int id;
    private String nome;
    private Consulta consulta;
    private String diaHorario;
    private String estado;
    private BigDecimal valor;
    private String laudo;
    private Date dataCriacao;
    private Date dataModificacao;

    //Construtor
    public Procedimento(int id, String nome, Consulta consulta, String diaHorario, String estado, BigDecimal valor, String laudo, Date dataCriacao, Date dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.consulta = consulta;
        this.diaHorario = diaHorario;
        this.estado = estado;
        this.valor = valor;
        this.laudo = laudo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public String getDiaHorario() {
        return diaHorario;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getLaudo() {
        return laudo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public void setDiaHorario(String diaHorario) {
        this.diaHorario = diaHorario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Procedimento{" + "id=" + id + ", nome=" + nome + ", consulta=" + consulta + ", diaHorario=" + diaHorario + ", estado=" + estado + ", valor=" + valor + ", laudo=" + laudo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
}
