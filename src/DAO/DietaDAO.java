/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Dieta;
import java.time.LocalDate;
import java.util.Scanner;

public class DietaDAO {

    Dieta[] arrayDieta = new Dieta[5];

    public DietaDAO() {
    }

    public Dieta[] getDieta() {
        return arrayDieta;
    }

    public void inserirDieta(Dieta dieta) {
        for (int i = 0; i < arrayDieta.length; i++) {
            if (arrayDieta[i] == null) {
                arrayDieta[i] = dieta;
                arrayDieta[i].setId(i);
                arrayDieta[i].setDataCriacao(LocalDate.now());
                arrayDieta[i].setDataModificacao(LocalDate.now());
            }
        }
    }

    public Dieta EditarDieta(Dieta dieta) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número de refeições");
        int nroRefeicoes = Integer.parseInt(sc.nextLine());
        dieta.setNroRefeicoes(nroRefeicoes);
        return dieta;
    }

    public void excluirDieta(Dieta dieta1) {
        dieta1 = null;
    }
}
