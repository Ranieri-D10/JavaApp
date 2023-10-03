/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class Alimentos {

    private int id = 0;
    private String nome;
    private int carboidrato;
    private int proteina;
    private int gordura;
    private double calorias;
    private int porcao;
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;

    public Alimentos(int id, String nome, int carboidrato, int proteina, int gordura, double calorias, int porcao) {
        this.id = id;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.porcao = porcao;
    }

    public Alimentos(String nome) {
    }
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public int getProteina() {
        return proteina;
    }

    public int getGordura() {
        return gordura;
    }

    public double getCalorias() {
        return calorias;
    }

    public int getPorcao() {
        return porcao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificao() {
        return dataModificao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificao(LocalDate dataModificao) {
        this.dataModificao = dataModificao;
    }

    

public String excluirAlimento(Alimentos[] arrAlimentos) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o id do alimento que deseja excluir: ");
    int alimExcluir = sc.nextInt();

    for (int i = 0; i < arrAlimentos.length; i++) {
        if (arrAlimentos[i] != null && alimExcluir == arrAlimentos[i].getId()) {
            String alimExcluido = arrAlimentos[i].getNome();
            arrAlimentos[i] = null;
            return "Alimento " + alimExcluido + " excluído!";
        }
    }
    return "Alimento " + alimExcluir + " não encontrado!";
}

    @Override
    public String toString() {
        return "Alimento{"
                + "id = " + id
                + ", nome = '" + nome + '\''
                + ", carboidrato = " + carboidrato
                + ", proteina = " + proteina
                + ", gordura = " + gordura
                + ", calorias = " + calorias
                + ", porcao = " + porcao
                + '}';
    }


}
