/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Pessoa;
import Classes.Post;
import java.time.LocalDate;
import java.util.Scanner;

public class PostDAO {

    Post[] arrayPost = new Post[100];

    public PostDAO() {
    }

    public Post[] getArrayPost() {
        return arrayPost;
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
    

    public void imprimirArrayPost(Post[] arrPosts, Pessoa usuarioLogado) {
        System.out.println("\nPosts de " + usuarioLogado.getNome()+"\n");
        for (Post post : arrPosts) {
            if (post != null) {
                System.out.println(post.toString());
            }
        }
    }
}
