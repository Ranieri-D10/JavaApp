/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Alimentos;
import Classes.AlimentosRefeicoes;
import Classes.Refeicoes;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AlimentosRefeicoesDAO {

    AlimentosRefeicoes[] arrayAlimRef = new AlimentosRefeicoes[20];

    public AlimentosRefeicoesDAO() {
    }

    public AlimentosRefeicoes[] getArrayAlimRef() {
        return arrayAlimRef;
    }

    public void setArrayAlimRef(AlimentosRefeicoes[] arrayAlimRef) {
        this.arrayAlimRef = arrayAlimRef;
    }


    public void inserirAlimentosNaRefeicao(Refeicoes[] arrayRefeicoes, AlimentosDAO arrayAlimentos, int idRef, AlimentosRefeicoes[] arrayAlimRef) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arrayRefeicoes.length; i++) {
            if (arrayRefeicoes[i] != null && arrayRefeicoes[i].getId() == idRef) {
                arrayAlimRef[i] = new AlimentosRefeicoes();
                arrayAlimRef[i].setRefeicoes(arrayRefeicoes[i]);
                System.out.println("Refei��o: " + arrayRefeicoes[i].getNomeRefeicao());
                double caloriasRef = arrayRefeicoes[i].getCalorias();
                double caloriasAteAgora = 0;
                double carboidratosAteAgora = 0; 
                double proteinasAteAgora = 0; 
                double gordurasAteAgora = 0;
                double porcaoAteAgora = 0;
                // Cria um array para armazenar os alimentos da refei��o
                Alimentos[] alimentosRefeicao = new Alimentos[20];
                arrayAlimentos.imprimirArrayAlimentos(arrayAlimentos.getArrayAlimentos());

                while (caloriasAteAgora < caloriasRef) {
                    System.out.println("Informe o id do alimento que deseja inserir na refei��o ");
                    int idAlim = Integer.parseInt(sc.nextLine());
                    Alimentos alimentoSelecionado = arrayAlimentos.arrayAlimentos[idAlim];

                    // Verifica se a adi��o do alimento n�o ultrapassa as calorias da refei��o
                    if (caloriasAteAgora + alimentoSelecionado.getCalorias() <= caloriasRef) {
                        for (int j = 0; j < alimentosRefeicao.length; j++) {
                            if (alimentosRefeicao[j] == null) {
                                alimentosRefeicao[j] = alimentoSelecionado;
                                caloriasAteAgora += alimentoSelecionado.getCalorias();
                                carboidratosAteAgora += alimentoSelecionado.getCarboidrato();
                                proteinasAteAgora += alimentoSelecionado.getProteina();
                                gordurasAteAgora += alimentoSelecionado.getGordura();
                                porcaoAteAgora += alimentoSelecionado.getPorcao();
                                break;
                            }
                        }
                    } else {
                        System.out.println("A adi��o deste alimento ultrapassaria as calorias da refei��o.");
                    }
                    if (caloriasAteAgora < caloriasRef) {
                        System.out.println("Deseja inserir outro alimento? (S para Sim, qualquer tecla para Voltar): ");
                        String resposta = sc.nextLine();
                        if (!resposta.equalsIgnoreCase("S")) {
                            break;
                        }
                    }
                }
                // Define os alimentos da refei��o no objeto AlimentosRefeicoes
                arrayAlimRef[i].setAlimentos(alimentosRefeicao);
                arrayAlimRef[i].setCalorias(caloriasAteAgora);
                arrayAlimRef[i].setCarboidrato(carboidratosAteAgora);
                arrayAlimRef[i].setProteina(proteinasAteAgora);
                arrayAlimRef[i].setGordura(gordurasAteAgora);
                arrayAlimRef[i].setPorcao(porcaoAteAgora);
                arrayAlimRef[i].setDataCriacao(LocalDate.now());
                arrayAlimRef[i].setDataModificacao(LocalDate.now());

            }
        }
    }

    public void imprimirAlimentosRefeicoes(AlimentosRefeicoes[] arrayAlimentoRefeicao) {
        System.out.println("Lista de Alimentos da Refei��o");
        for (AlimentosRefeicoes alimRef : arrayAlimentoRefeicao) {
            if (alimRef != null) {
                System.out.println(alimRef.toString());
            }
        }
    }
}
