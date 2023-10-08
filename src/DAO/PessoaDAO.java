/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Pessoa;
import java.time.LocalDate;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class PessoaDAO {

    Pessoa arrayPessoas[] = new Pessoa[5];

    Pessoa p2 = new Pessoa(0, "João", "Masculino", LocalDate.of(1990, 5, 15), "joao", "123", LocalDate.now(), LocalDate.now());
    Pessoa p3 = new Pessoa(1, "Maria", "Feminino", LocalDate.of(1985, 9, 20), "maria", "456", LocalDate.now(), LocalDate.now());
    Pessoa p4 = new Pessoa(2, "Carlos", "Masculino", LocalDate.of(1995, 3, 10), "carlos", "789", LocalDate.now(), LocalDate.now());

    public PessoaDAO() {
        criarPessoa(p2);
        criarPessoa(p3);
        criarPessoa(p4);
    }

    public Pessoa[] getArrayPessoas() {
        return arrayPessoas;
    }

    public void setArrayPessoas(Pessoa[] arrayPessoas) {
        this.arrayPessoas = arrayPessoas;
    }

    public String criarPessoa(Pessoa p1) {
        boolean arrCheio = false;

        for (int i = 0; i < arrayPessoas.length; i++) {
            if (arrayPessoas[i] == null) {
                arrayPessoas[i] = p1;
                arrayPessoas[i].setId(i);
                arrayPessoas[i].setDataCriacao(LocalDate.now());
                arrayPessoas[i].setDataModificacao(LocalDate.now());
                arrCheio = true;
                return "Usuário Criado com sucesso!";
            }
        }
        if (!arrCheio) {
            return "Não foi possível criar o usuário, não há espaço disponível";

        }
        return null;
    }

    public Pessoa fazerLogin() {
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

    public String removePessoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Usuário que deseja excluir: ");
        String pExcluir = sc.nextLine();
        for (int i = 0; i < arrayPessoas.length; i++) {
            if (arrayPessoas[i] != null && arrayPessoas[i].getLogin().equalsIgnoreCase(pExcluir)) {
                String nomeExcluido = arrayPessoas[i].getNome();
                arrayPessoas[i] = null;
                return "Usuário(a) " + nomeExcluido + " excluído com sucesso!";
            }
        }
        return "Usuário " + pExcluir + " não encontrado!";
    }

    public void modificarPessoa(Pessoa usuarioLogado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Alterar nome ");
        System.out.println("Informe o novo nome: ");
        String novoNome = sc.nextLine();

        for (Pessoa arrayPessoa : arrayPessoas) {
            if (arrayPessoa != null && arrayPessoa.getLogin().equals(usuarioLogado.getLogin())) {
                arrayPessoa.setNome(novoNome);
                Program.limparTela();
                System.out.println("Nome alterado com sucesso!");
                break;
            }
        }
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
