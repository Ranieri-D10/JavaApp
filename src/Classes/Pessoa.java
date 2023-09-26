/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class Pessoa {

    int id = 0;
    public String nome;
    public String sexo;
    public LocalDate nascimento;
    public String login;
    public String senha;
    public String tipoUsuario;
    public LocalDate dataCriacao;
    public LocalDate dataModificacao;
    //static Pessoa arrayPessoas[] = new Pessoa[5];

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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public String criarPessoa(Pessoa p1, Pessoa[] arrayPessoas) {
        boolean arrCheio = false;
        for (int i = 0; i < arrayPessoas.length; i++) {
            if (arrayPessoas[i] == null) {
                arrayPessoas[i] = p1;
                arrayPessoas[i].id = i;
                arrayPessoas[i].dataCriacao = LocalDate.now();
                arrayPessoas[i].dataModificacao = LocalDate.now();
                arrCheio = true;
                return "Usuário Criado com sucesso!";
            }

        }
        if (!arrCheio) {
            return "Não foi possível criar o usuário, não há espaço disponível";

        }
        return null;
    }

    public static Pessoa fazerLogin(Pessoa[] arrayPessoas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o usuario: ");
        String user = sc.nextLine();
        System.out.print("Senha:");
        String senha = sc.nextLine();
        for (Pessoa arrayPessoa : arrayPessoas) {
            if (arrayPessoa != null && arrayPessoa.getLogin().equalsIgnoreCase(user) && arrayPessoa.getSenha().equalsIgnoreCase(senha)) {
                return arrayPessoa;
            }
        }
        return null;
    }

    public static String removePessoa(Pessoa[] arrayPessoas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Usuario que deseja excluir: ");
        String pExcluir = sc.nextLine();
        for (int i = 0; i < arrayPessoas.length; i++) {
            if (arrayPessoas[i].login.equalsIgnoreCase(pExcluir)) {
                String nomeExcluido = arrayPessoas[i].nome;
                arrayPessoas[i] = null;
                return "Usuário(a) " + nomeExcluido + " excluido com sucesso!";
            }
        }
        return "Usuario " + pExcluir + " nÃ£o encontrado!";
    }

    public static void modificarPessoa(Pessoa[] arrayPessoas, Pessoa usuarioLogado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Alterar nome ");
        System.out.println("Informe o novo nome: ");
        String novoNome = sc.nextLine();

        for (Pessoa arrayPessoa : arrayPessoas) {
            if (arrayPessoa != null && arrayPessoa.getLogin().equals(usuarioLogado.getLogin())) {
                arrayPessoa.nome = novoNome;
                Program.limparTela();
                System.out.println("Nome alterado com sucesso!");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Usuário " + nome + " { "
                + " \n  id = " + id
                + ", sexo = '" + sexo + '\''
                + ", nascimento = " + nascimento + "\n"
                + "  tipoUsuario = '" + tipoUsuario
                + ", login = '" + login + '\''
                + ", senha = '" + senha + '\''
                + "\n  dataCriacao = " + dataCriacao
                + ", dataModificacao = " + dataModificacao
                + '}';
    }

    public void imprimirArrayPessoas(Pessoa[] arrayPessoas) {
        System.out.println("\nLista de Pessoas:");
        for (Pessoa pessoa : arrayPessoas) {
            if (pessoa != null) {
                System.out.println(pessoa.toString());
            }
        }
    }

}
