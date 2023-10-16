/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class Pessoa {

    private int id = 0;
    private String nome;
    private String sexo;
    private LocalDate nascimento;
    private String login;
    private String senha;
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    public Pessoa seguidores[] = new Pessoa[50]; // Vetor para armazenar os seguidores

    public Pessoa(int id, String nome, String sexo, LocalDate nascimento, String login, String senha, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.login = login;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public Pessoa() {
    }

    public Pessoa[] getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Pessoa[] seguidores) {
        this.seguidores = seguidores;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public void adicionarSeguidor(Pessoa usuarioLogado) {
        for (int i = 0; i < seguidores.length; i++) {
            if (seguidores[i] == null) {
                seguidores[i] = usuarioLogado;
                break;
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.sexo);
        hash = 23 * hash + Objects.hashCode(this.nascimento);
        hash = 23 * hash + Objects.hashCode(this.login);
        hash = 23 * hash + Objects.hashCode(this.senha);
        hash = 23 * hash + Objects.hashCode(this.tipoUsuario);
        hash = 23 * hash + Objects.hashCode(this.dataCriacao);
        hash = 23 * hash + Objects.hashCode(this.dataModificacao);
        hash = 23 * hash + Arrays.deepHashCode(this.seguidores);
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
        final Pessoa other = (Pessoa) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Usu�rio " + nome + " { \n"
                + "\tid = " + id + ",\n"
                + "\tsexo = '" + sexo + "',\n"
                + "\tnascimento = " + nascimento + "\n"
                + "\ttipoUsuario = '" + tipoUsuario + "',\n"
                + "\tlogin = '" + login + "',\n"
                + "\tsenha = '" + senha + "',\n"
                + "\tdataCriacao = " + dataCriacao + ",\n"
                + "\tdataModificacao = " + dataModificacao + "\n"
                + '}';
    }
}
