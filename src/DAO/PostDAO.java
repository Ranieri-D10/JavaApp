/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Pessoa;
import Classes.Post;
import Classes.Seguir;
import java.time.LocalDate;
import java.util.Scanner;

public class PostDAO {

    Post[] arrayPost = new Post[100];

    public PostDAO() {
    }

    public Post[] getArrayPost() {
        return arrayPost;
    }

    public void inserirPostTeste(Pessoa usuarioLogado, Pessoa[] arrayPessoas) {
        Post post1 = new Post(usuarioLogado, "Bom dia ");
        Post post2 = new Post(usuarioLogado, "Boa tarde ");
        Post post3 = new Post(arrayPessoas[1], "Boa noite ");
        Post post4 = new Post(arrayPessoas[1], "Avante Palestraaaaaa! ");
        criarPost(post1);
        criarPost(post2);
        criarPost(post3);
        criarPost(post4);
    }

    public Post criarPost(Post p1) {

        for (int i = 0; i < arrayPost.length; i++) {
            if (arrayPost[i] == null) {
                arrayPost[i] = p1;
                arrayPost[i].setId(i);
                arrayPost[i].setDataCriacao(LocalDate.now());
                arrayPost[i].setDataModificacao(LocalDate.now());
                return arrayPost[i];
            }
        }
        return null;
    }

    public boolean excluirPost(Post p1, int id) {
        for (int i = 0; i < arrayPost.length; i++) {
            if (arrayPost[i] != null && arrayPost[i].getId() == id) {
                arrayPost[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean editarPost(Post p1, int id) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arrayPost.length; i++) {
            if (arrayPost[i] != null && arrayPost[i].getId() == id) {
                System.out.println("Digite o novo conteúdo do post");
                String msgEdit = sc.nextLine();
                arrayPost[i].setMensagem(msgEdit);
                return true;
            }
        }
        return false;
    }

    public void imprimirArrayPost(Post[] arrPosts) {
        System.out.println("\nTodos os Posts\n");
        for (Post post : arrPosts) {
            if (post != null) {
                System.out.println(post.toString());
            }
        }
    }

    public void timeline(Pessoa usuarioLogado, SeguirDAO seguirDAO) {
        Seguir[] seguidores = seguirDAO.getSeguidoresQueUsuarioSegue(usuarioLogado);

        for (Seguir seguir : seguidores) {
            if (seguir != null) { // Verifica se o objeto Seguir não é nulo
                Pessoa pessoaSeguida = seguir.getSeguindo();
                if (pessoaSeguida != null) { // Verifica se o objeto Pessoa não é nulo
                   //System.out.println("Posts de " + pessoaSeguida.getNome() + ":\n");

                    for (Post post : arrayPost) {
                        if (post != null && post.getPessoa() == pessoaSeguida) {
                            System.out.println(post.toString());
                        }
                    }
                }
            }
        }
    }
}
