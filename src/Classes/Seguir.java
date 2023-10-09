/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Classes;

import java.time.LocalDate;

public class Seguir {
    private int id;
    private Pessoa origem;
    private Pessoa seguindo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Seguir() {
    }
    
    public Seguir(int id, Pessoa origem, Pessoa seguindo, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.origem = origem;
        this.seguindo = seguindo;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public Pessoa getOrigem() {
        return origem;
    }

    public Pessoa getSeguindo() {
        return seguindo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigem(Pessoa origem) {
        this.origem = origem;
    }

    public void setSeguindo(Pessoa seguindo) {
        this.seguindo = seguindo;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    
    @Override
    public String toString() {
        return " #" + id +
               " Seguindo: " + seguindo.getNome();
    }
}

