/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Dieta;
import Classes.Refeicoes;
import Classes.TipoDeDieta;
import java.time.LocalDate;

public class RefeicoesDAO {

    Refeicoes[] arrayRefeicao = new Refeicoes[10];

    public RefeicoesDAO() {
    }

    public Refeicoes[] getArrayRefeicao() {
        return arrayRefeicao;
    }

    public void setArrayRefeicao(Refeicoes[] arrayRefeicao) {
        this.arrayRefeicao = arrayRefeicao;
    }

    public void inserirRefeicao(String nomeRefeicao, Dieta dieta, TipoDeDieta tipoDieta) {
        double caloriasRefeicao = dieta.getCaloriasTotais() / dieta.getNroRefeicoes();
        double carboCaloria = caloriasRefeicao * tipoDieta.getCarboidrato();
        double proteinCaloria = caloriasRefeicao * tipoDieta.getProteina();
        double gorduraCaloria = caloriasRefeicao * tipoDieta.getGordura();

        for (int i = 0; i < arrayRefeicao.length; i++) {
            if (arrayRefeicao[i] == null && i < dieta.getNroRefeicoes()) {
                arrayRefeicao[i] = new Refeicoes();
                arrayRefeicao[i].setNomeRefeicao(nomeRefeicao);
                arrayRefeicao[i].setId(i);
                arrayRefeicao[i].setDieta(dieta);
                arrayRefeicao[i].setNomeDieta(dieta.getObjetivo());
                arrayRefeicao[i].setCalorias(caloriasRefeicao);
                arrayRefeicao[i].setCarboidrato(carboCaloria);
                arrayRefeicao[i].setProteina(proteinCaloria);
                arrayRefeicao[i].setGordura(gorduraCaloria);
                arrayRefeicao[i].setDataCriacao(LocalDate.now());
                arrayRefeicao[i].setDataModificao(LocalDate.now());
                break;
            }
        }
    }

    public void editarRefeicao(String nomeRefeicao, int idRefeicao) {
        for (int i = 0; i < arrayRefeicao.length; i++) {
            if (arrayRefeicao[i] != null && arrayRefeicao[i].getId() == idRefeicao) {
                arrayRefeicao[i].setNomeRefeicao(nomeRefeicao);
                arrayRefeicao[i].setDataModificao(LocalDate.now());
            }
        }
    }
    
    public String removerRefeicao(int idRefeicao){
        for (int i = 0; i < arrayRefeicao.length; i++) {
            if (arrayRefeicao[i] != null && arrayRefeicao[i].getId() == idRefeicao) {
                arrayRefeicao[i] = null;
                return "Refeição removida com sucesso.";
            }
        }
        return null;
    }

    public void imprimirRefeicoes(Refeicoes[] arrayRefeicao) {
        System.out.println("Lista de Refeições:");
        for (Refeicoes refeicao : arrayRefeicao) {
            if (refeicao != null) {
                System.out.println(refeicao.toString());
            }
        }
    }

}
