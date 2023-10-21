/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.TipoDeDieta;
import java.time.LocalDate;
import java.util.Scanner;

public class TipoDeDietaDAO {

    TipoDeDieta[] arrayTipodeDieta = new TipoDeDieta[5];

    public TipoDeDietaDAO() {
    }

    public TipoDeDieta[] getArrayTipodeDieta() {
        return arrayTipodeDieta;
    }

    public void setArrayTipodedieta(TipoDeDieta[] arrayTipodedieta) {
        this.arrayTipodeDieta = arrayTipodedieta;
    }

    public TipoDeDieta selecionarTipoDeDieta(int tdieta) {
        double carb = 0, protein = 0, gordura = 0;
        String nomeDieta = "";
        TipoDeDieta tipoDieta = null;

        switch (tdieta) {
            case 1:
                nomeDieta = "Equilibrada";
                carb = 0.4;
                protein = 0.3;
                gordura = 0.3;
                break;
            case 2:
                nomeDieta = "Low Carb";
                carb = 0.3;
                protein = 0.5;
                gordura = 0.2;
                break;
            case 3:
                nomeDieta = "Cetogênica";
                carb = 0.3;
                protein = 0.5;
                gordura = 0.2;
                break;
        }

        tipoDieta = new TipoDeDieta();
        tipoDieta.setNome(nomeDieta);
        tipoDieta.setCarboidrato(carb);
        tipoDieta.setProteina(protein);
        tipoDieta.setGordura(gordura);

        return tipoDieta;
    }

    public TipoDeDieta inserirTipoDeDieta(TipoDeDieta tipoDieta) {
        for (int i = 0; i < arrayTipodeDieta.length; i++) {
            if (arrayTipodeDieta[i] == null) {
                tipoDieta.setId(i);
                tipoDieta.setDataCriacao(LocalDate.now());
                tipoDieta.setDataModificao(LocalDate.now());
                arrayTipodeDieta[i] = tipoDieta;
                return tipoDieta;
            }
        }
        return null; // Se o array estiver cheio, retorne null ou outra indicação de erro.
    }

    public TipoDeDieta editarTipoDieta(int tdieta, int idTipoDieta, TipoDeDieta tipoDieta) {
        for (int i = 0; i < arrayTipodeDieta.length; i++) {
            if (arrayTipodeDieta[i] != null && arrayTipodeDieta[i].getId() == idTipoDieta) {
                arrayTipodeDieta[i].setNome(tipoDieta.getNome());
                arrayTipodeDieta[i].setCarboidrato(tipoDieta.getCarboidrato());
                arrayTipodeDieta[i].setProteina(tipoDieta.getProteina());
                arrayTipodeDieta[i].setGordura(tipoDieta.getGordura());
                arrayTipodeDieta[i].setDataModificao(LocalDate.now());
                return arrayTipodeDieta[i];
            }
        }
        return null;
    }

    public void removerTipoDieta(int id) {
        for (int i = 0; i < arrayTipodeDieta.length; i++) {
            if (arrayTipodeDieta[i] != null && arrayTipodeDieta[i].getId() == id) {
                arrayTipodeDieta[i] = null;
                break;
            }
        }
    }

    public void imprimirArrayTipodedieta(TipoDeDieta[] arrayTipodeDieta1) {
        for (TipoDeDieta dieta : arrayTipodeDieta) {
            if (dieta != null) {
                System.out.println(dieta.toString());
                System.out.println(); // Adicione uma linha em branco entre cada elemento
            }
        }
    }
}
