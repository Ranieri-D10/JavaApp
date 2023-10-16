/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Objects;

public class AlimentosRefeicoes {

    private int id;
    private Refeicoes refeicoes;
    private Alimentos[] alimentos;
    private double porcao;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AlimentosRefeicoes() {
    }

    public AlimentosRefeicoes(Refeicoes refeicoes, Alimentos[] alimentos, double porcao, double carboidrato, double proteina, double gordura, double calorias) {
        this.refeicoes = refeicoes;
        this.alimentos = alimentos;
        this.porcao = porcao;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Refeicoes getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Refeicoes refeicoes) {
        this.refeicoes = refeicoes;
    }

    public Alimentos[] getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(Alimentos[] alimentos) {
        this.alimentos = alimentos;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
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
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.refeicoes);
        hash = 37 * hash + Objects.hashCode(this.alimentos);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.porcao) ^ (Double.doubleToLongBits(this.porcao) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.carboidrato) ^ (Double.doubleToLongBits(this.carboidrato) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.proteina) ^ (Double.doubleToLongBits(this.proteina) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gordura) ^ (Double.doubleToLongBits(this.gordura) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.dataCriacao);
        hash = 37 * hash + Objects.hashCode(this.dataModificacao);
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
        final AlimentosRefeicoes other = (AlimentosRefeicoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.porcao) != Double.doubleToLongBits(other.porcao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidrato) != Double.doubleToLongBits(other.carboidrato)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteina) != Double.doubleToLongBits(other.proteina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordura) != Double.doubleToLongBits(other.gordura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (!Objects.equals(this.refeicoes, other.refeicoes)) {
            return false;
        }
        if (!Objects.equals(this.alimentos, other.alimentos)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        String alimentosString = "Alimentos da refeição:\n";
        for (Alimentos alimento : alimentos) {
            if (alimento != null) {
                alimentosString += alimento.toString() + "\n";
            }
        }
        return "Refeicao = " + refeicoes.getNomeRefeicao()
                + "\nid da Refeição = " + id + "\n"
                + "\n" + alimentosString
                + "\nporcao = " + porcao + "g"
                + "\ncalorias = " + calorias + "k/cal"
                + "\ncarboidrato = " + carboidrato + "g"
                + "\nproteina = " + proteina + "g"
                + "\ngordura = " + gordura + "g"
                + "\ndataCriacao = " + dataCriacao
                + "\ndataModificacao = " + dataModificacao;
    }

}
