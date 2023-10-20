/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Objects;

public class Mensagens {

    private int id;
    private Pessoa pessoaOrigem;
    private Pessoa pessoaDestino;
    private String mensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Mensagens() {
    }

    public Mensagens(int id, Pessoa pessoaOrigem, Pessoa pessoaDestino, String mensagem, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.pessoaOrigem = pessoaOrigem;
        this.pessoaDestino = pessoaDestino;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(Pessoa pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public Pessoa getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(Pessoa pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.pessoaOrigem);
        hash = 83 * hash + Objects.hashCode(this.pessoaDestino);
        hash = 83 * hash + Objects.hashCode(this.mensagem);
        hash = 83 * hash + Objects.hashCode(this.dataCriacao);
        hash = 83 * hash + Objects.hashCode(this.dataModificacao);
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
        final Mensagens other = (Mensagens) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaOrigem, other.pessoaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaDestino, other.pessoaDestino)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        return "================================================="+
                "\nPara : " + pessoaDestino.getNome() + "\n"
                + "----------------------------------------------\n"
                + "Mensagem:" + "\t" + mensagem + "\n"
                + "----------------------------------------------\n"
                + " id da mensagem = " + id + "\n"
                + " dataCriacao = " + dataCriacao + "\n"
                + " dataModificacao = " + dataModificacao
                + "\n=================================================";
        
    }

}
