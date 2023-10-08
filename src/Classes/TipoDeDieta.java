/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;

public class TipoDeDieta {

    private int id;
    private String nome;
    private int carboidrato;
    private int proteina;
    private int gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;    

    public TipoDeDieta() {
    }

    public TipoDeDieta(int id, String nome, int carboidrato, int proteina, int gordura, LocalDate dataCriacao, LocalDate dataModificao) {
        this.id = id;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.dataCriacao = dataCriacao;
        this.dataModificao = dataModificao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public int getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public int getGordura() {
        return gordura;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
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
    
    
    
    
}
