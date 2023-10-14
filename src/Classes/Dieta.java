/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;

/**
 *
 * @author Alunos
 */
public class Dieta {
    private int id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDeDieta tipoDieta;
    private int objetivo;
    private int nroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Dieta() {
    }

    public Dieta(Pessoa pessoa, AvaliacaoFisica avaliacaoFisica, TipoDeDieta tipoDieta, int objetivo, int nroRefeicoes) {
        this.pessoa = pessoa;
        this.avaliacaoFisica = avaliacaoFisica;
        this.tipoDieta = tipoDieta;
        this.objetivo = objetivo;
        this.nroRefeicoes = nroRefeicoes;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public AvaliacaoFisica getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public TipoDeDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDeDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

    public int getNroRefeicoes() {
        return nroRefeicoes;
    }

    public void setNroRefeicoes(int nroRefeicoes) {
        this.nroRefeicoes = nroRefeicoes;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    
}
