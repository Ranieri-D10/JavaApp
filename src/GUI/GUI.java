/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.Scanner;

public class GUI {

    Scanner sc = new Scanner(System.in);

    public int menuInicial() {
        System.out.println("Menu:");
        System.out.println("1. Criar novo usu�rio");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuUsuarioLogado() {
        System.out.println("Menu:");
        System.out.println("1. Menu Pessoas");
        System.out.println("2. Menu Alimentos");
        System.out.println("3. Avalia��o F�sica");
        System.out.println("4. Tipos de Dieta");
        System.out.println("5. Menu de Dieta");
        System.out.println("6. Refei��es");
        System.out.println("7. Alimentos/Refei��es");
        System.out.println("8. Redes Sociais");
        System.out.println("9. Voltar ao menu principal");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuPessoas() {
        System.out.println("Menu:");
        System.out.println("1. Editar usu�rio");
        System.out.println("2. Excluir usu�rio");
        System.out.println("3. Exibir lista de usu�rios");
        System.out.println("4. Buscar usu�rios");
        System.out.println("3. Voltar ao menu anterior");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuAlimentos() {
        System.out.println("Menu:");
        System.out.println("1. Editar alimento");
        System.out.println("2. Excluir alimento");
        System.out.println("3. Exibir lista de alimentos");
        System.out.println("4. Buscar Alimentos");
        System.out.println("3. Voltar ao menu anterior");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuAvaliacaoFisica() {
        System.out.println("Menu:");
        System.out.println("1. Fazer Avalia��o F�sica");
        System.out.println("2. Excluir Avalia��o F�sica");
        System.out.println("3. Editar Avalia��o F�sica");
        System.out.println("4. Voltar ao menu anterior");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuRedeSociais() {
        System.out.println("Menu");
        System.out.println("1. Menu Posts");
        System.out.println("2. Menu Seguidores");
        System.out.println("3. Menu mensagens");
        System.out.println("4. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuPost() {
        System.out.println("Menu");
        System.out.println("1. Escrever Post");
        System.out.println("2. Editar Post");
        System.out.println("3. Excluir Post");
        System.out.println("4. Exibir Posts");
        System.out.println("5. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuSeguir() {
        System.out.println("Menu");
        System.out.println("1. Seguir Algu�m");
        System.out.println("2. Deixar de seguir algu�m");
        System.out.println("3. Exibir Seguidores");
        System.out.println("4. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }
}
