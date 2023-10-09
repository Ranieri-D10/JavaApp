package Classes;

import Classes.Pessoa;
import java.time.LocalDate;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Post {

    private int id = 0;
    private Pessoa pessoa;
    private String mensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Post() {
    }

    public Post(Pessoa pessoa, String mensagem) {
        this.pessoa = pessoa;
        this.mensagem = mensagem;
    }

    public Post(int id, Pessoa pessoa, String mensagem, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
    public String toString() {
        return "Post #" + id + "\n"
                + "    Mensagem: " + mensagem + "\n"
                + "    Data de Criação: " + dataCriacao + "\n"
                + "    Data de Modificação: " + dataModificacao;
    }

}
