/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;

/**
 *
 * @author r
 */
public class Refeicoes {

    private int id = 0;
    private Dieta dieta;
    private String nomeDieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String NomeRefeicao;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;

    public Refeicoes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
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

    public String getNomeRefeicao() {
        return NomeRefeicao;
    }

    public void setNomeRefeicao(String NomeRefeicao) {
        this.NomeRefeicao = NomeRefeicao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificao() {
        return dataModificao;
    }

    public void setDataModificao(LocalDate dataModificao) {
        this.dataModificao = dataModificao;
    }

    @Override
    public String toString() {
        return "\tNome da Refeição: " + NomeRefeicao + "\n"
                + "\tNúmero de Refeição (id): " + id + "\n"
                + "\tObjetivo da Dieta: " + nomeDieta + "\n"
                + "\tCalorias: " + String.format("%.0f", calorias) + "\n"
                + "\tCarboidrato: " + String.format("%.0f", carboidrato) + "\n"
                + "\tProteína: " + String.format("%.0f", proteina) + "\n"
                + "\tGordura: " + String.format("%.0f", gordura) + "\n"
                + "\tData de Criação: " + dataCriacao + "\n"
                + "\tData de Modificação: " + dataModificao + "\n"
                + "\t -----------------------------";
    }

}
