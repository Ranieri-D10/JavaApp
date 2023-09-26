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

    public String criarAlimento(Alimentos a1, Alimentos[] arrayAlimentos) {

        for (int i = 0; i < arrayAlimentos.length; i++) {
            if (arrayAlimentos[i] == null) {
                arrayAlimentos[i] = a1;
                arrayAlimentos[i].id = i;
                arrayAlimentos[i].dataCriacao = LocalDate.now();
                arrayAlimentos[i].dataModificao = LocalDate.now();
                return "Usuário Criado com sucesso!";
            }
        }
        return "N?o foi possível criar usuário.";
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

    public void imprimirArrayAlimentos(Alimentos[] arrAlimentos) {
        System.out.println("\nLista de Alimentos:");
        for (Alimentos arrAlimento : arrAlimentos) {
            if (arrAlimento != null) {
                System.out.println(arrAlimento.toString());
            }
        }
    }
}
