/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Alunos
 */
public class Dieta {

    private int id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDeDieta tipoDieta;
    private String objetivo;
    private double caloriasTotais;
    private int nroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Dieta() {
    }

    public Dieta(Pessoa pessoa, AvaliacaoFisica avaliacaoFisica, TipoDeDieta tipoDieta, String objetivo, double caloriasTotais, int nroRefeicoes) {
        this.pessoa = pessoa;
        this.avaliacaoFisica = avaliacaoFisica;
        this.tipoDieta = tipoDieta;
        this.objetivo = objetivo;
        this.caloriasTotais = caloriasTotais;
        this.nroRefeicoes = nroRefeicoes;
    }

    public double getCaloriasTotais() {
        return caloriasTotais;
    }

    public void setCaloriasTotais(double caloriasTotais) {
        this.caloriasTotais = caloriasTotais;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.pessoa);
        hash = 89 * hash + Objects.hashCode(this.avaliacaoFisica);
        hash = 89 * hash + Objects.hashCode(this.tipoDieta);
        hash = 89 * hash + Objects.hashCode(this.objetivo);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.caloriasTotais) ^ (Double.doubleToLongBits(this.caloriasTotais) >>> 32));
        hash = 89 * hash + this.nroRefeicoes;
        hash = 89 * hash + Objects.hashCode(this.dataCriacao);
        hash = 89 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dieta other = (Dieta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloriasTotais) != Double.doubleToLongBits(other.caloriasTotais)) {
            return false;
        }
        if (this.nroRefeicoes != other.nroRefeicoes) {
            return false;
        }
        if (!Objects.equals(this.objetivo, other.objetivo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.avaliacaoFisica, other.avaliacaoFisica)) {
            return false;
        }
        if (!Objects.equals(this.tipoDieta, other.tipoDieta)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        return "Dieta de " + pessoa.getNome() + "\n"
                + "\tObjetivo: " + objetivo + "\n"
                + "\tTotal de calorias: " + String.format("%.0f", caloriasTotais) + "\n"
                + "\tNúmero de refeições: " + nroRefeicoes + "\n"
                + "\tData de Criação: " + dataCriacao + "\n"
                + "\tData de Modificação: " + dataModificacao;
    }

}
