/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Alimentos;
import java.time.LocalDate;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class AlimentosDAO {

    Alimentos arrayAlimentos[] = new Alimentos[20];

    Alimentos alimento1 = new Alimentos(1, "Arroz", 45, 2, 0, 200.5, 100);
    Alimentos alimento2 = new Alimentos(2, "Frango", 0, 25, 3, 120.0, 100);
    Alimentos alimento3 = new Alimentos(3, "Brócolis", 5, 3, 0, 30.0, 100);
    Alimentos alimento4 = new Alimentos(4, "Batata", 20, 2, 0, 90.0, 100);
    Alimentos alimento5 = new Alimentos(5, "Salmão", 0, 22, 10, 180.0, 100);
    Alimentos alimento6 = new Alimentos(6, "Espinafre", 2, 3, 0, 23.0, 100);
    Alimentos alimento7 = new Alimentos(7, "Banana", 30, 1, 0, 105.0, 100);
    Alimentos alimento8 = new Alimentos(8, "Cenoura", 8, 1, 0, 35.0, 100);

    public AlimentosDAO() {
        criarAlimento(alimento1);
        criarAlimento(alimento2);
        criarAlimento(alimento3);
        criarAlimento(alimento4);
        criarAlimento(alimento5);
        criarAlimento(alimento6);
        criarAlimento(alimento7);
        criarAlimento(alimento8);
    }

    public Alimentos[] getArrayAlimentos() {
        return arrayAlimentos;
    }

    public void setArrayAlimentos(Alimentos[] arrayAlimentos) {
        this.arrayAlimentos = arrayAlimentos;
    }

    public String criarAlimento(Alimentos a1) {
        for (int i = 0; i < arrayAlimentos.length; i++) {
            if (arrayAlimentos[i] == null) {
                arrayAlimentos[i] = a1;
                arrayAlimentos[i].setId(i);
                arrayAlimentos[i].setDataCriacao(LocalDate.now());
                arrayAlimentos[i].setDataModificao(LocalDate.now());
                return "Alimento criado com sucesso!";
            }
        }
        return "Não foi possível criar o alimento.";
    }

    public Alimentos editarAlimento(Alimentos[] arrAlimentos) {
        Scanner sc = new Scanner(System.in);
        Alimentos alimentoEditado = null; // Variável para armazenar o objeto editado
        boolean encontrado = false;

        System.out.println("Digite o id do alimento que deseja editar");
        int idAlim = sc.nextInt();

        for (int i = 0; i < arrAlimentos.length; i++) {
            if (arrAlimentos[i] != null && idAlim == arrAlimentos[i].getId()) {
                System.out.print("Informe o novo nome do alimento: ");
                sc.nextLine();
                String novoNome = sc.nextLine();
                arrAlimentos[i].setNome(novoNome);

                System.out.print("Informe a quantidade de carboidratos: ");
                int novoCarboidrato = sc.nextInt();
                arrAlimentos[i].setCarboidrato(novoCarboidrato);

                System.out.print("Informe a quantidade de proteínas: ");
                int novoProteina = sc.nextInt();
                arrAlimentos[i].setProteina(novoProteina);

                System.out.print("Informe a quantidade de gorduras: ");
                int novoGordura = sc.nextInt();
                arrAlimentos[i].setGordura(novoGordura);

                System.out.print("Informe as calorias: ");
                double novoCalorias = sc.nextDouble();
                arrAlimentos[i].setCalorias(novoCalorias);

                System.out.print("Informe a porção: ");
                int novoPorcao = sc.nextInt();
                arrAlimentos[i].setPorcao(novoPorcao);

                Program.limparTela();
                System.out.println("Alimento editado com sucesso.");
                alimentoEditado = arrAlimentos[i]; // Atribui o objeto editado à variável
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("ID de alimento não encontrado.");
        }
        return alimentoEditado;
    }
    
public String excluirAlimento(Alimentos[] arrAlimentos) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o id do alimento que deseja excluir: ");
    int alimExcluir = sc.nextInt();

    for (int i = 0; i < arrAlimentos.length; i++) {
        if (arrAlimentos[i] != null && alimExcluir == arrAlimentos[i].getId()) {
            String alimExcluido = arrAlimentos[i].getNome();
            arrAlimentos[i] = null;
            return alimExcluido;
        }
    }
    return null; 
}

    public void imprimirArrayAlimentos(Alimentos[] arrAlimentos) {
        System.out.println("\nLista de Alimentos:");
        for (Alimentos arrAlimento : arrAlimentos) {
            if (arrAlimento != null) {
                System.out.println(arrAlimento.toString());
            }
        }
    }
}
