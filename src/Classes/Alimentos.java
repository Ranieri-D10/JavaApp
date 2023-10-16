/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class Alimentos {

    private int id = 0;
    private String nome;
    private int carboidrato;
    private int proteina;
    private int gordura;
    private double calorias;
    private int porcao;
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;

    public Alimentos(int id, String nome, int carboidrato, int proteina, int gordura, double calorias, int porcao) {
        this.id = id;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.porcao = porcao;
    }

    public Alimentos(String nome) {
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public int getProteina() {
        return proteina;
    }

    public int getGordura() {
        return gordura;
    }

    public double getCalorias() {
        return calorias;
    }

    public int getPorcao() {
        return porcao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificao() {
        return dataModificao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificao(LocalDate dataModificao) {
        this.dataModificao = dataModificao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + this.carboidrato;
        hash = 29 * hash + this.proteina;
        hash = 29 * hash + this.gordura;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 29 * hash + this.porcao;
        hash = 29 * hash + Objects.hashCode(this.tipoUsuario);
        hash = 29 * hash + Objects.hashCode(this.dataCriacao);
        hash = 29 * hash + Objects.hashCode(this.dataModificao);
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
        final Alimentos other = (Alimentos) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Alimento {"
                + "id = " + id
                + ", nome = '" + nome + '\''
                + ", carboidrato = " + carboidrato + "g"
                + ", proteina = " + proteina + "g"
                + ", gordura = " + gordura + "g"
                + ", calorias = " + calorias + "k/cal"
                + ", porcao = " + porcao + "g"
                + '}';
    }
}