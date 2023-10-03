/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Scanner;

public class GUI {

    Scanner sc = new Scanner(System.in);

    public int menuPrincipal() {
        System.out.println("Menu:");
        System.out.println("1. Criar novo usu�rio");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuUsuarioLogado() {
        System.out.println("Menu:");
        System.out.println("1. Editar usu�rio");
        System.out.println("2. Excluir usu�rio");
        System.out.println("3. Cadastrar Alimento");
        System.out.println("4. Editar Alimentos");
        System.out.println("5. Avalia��o F�sica");
        System.out.println("6. Voltar ao menu principal");
        System.out.print("Escolha uma op��o: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuAlimentos() {
        System.out.println("Menu:");
        System.out.println("1. Editar alimento");
        System.out.println("2. Excluir alimento");
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
}
