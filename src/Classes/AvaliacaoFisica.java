/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class AvaliacaoFisica {

    private int id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double imc;
    private double tmb;
    private double bodyFat;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AvaliacaoFisica(int id, Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril, double imc, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.imc = imc;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public double getImc() {
        return imc;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getdataModificacao() {
        return dataModificacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setdataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "Avaliação Física de " + pessoa.getNome() + " {"
                + " \n id = " + id + ", peso = " + peso + ", altura = " + altura
                + ", idade = " + idade + " \n pescoco = " + pescoco
                + ", cintura = " + cintura + ", quadril = " + quadril
                + "\n IMC = " + String.format("%.1f", imc())
                + ", TMB = " + String.format("%.1f", TaxaMetabolica()) + "Kcal/dia"
                + ", Gordura corporal = " + String.format("%.1f", percentualGordura()) + "%"
                + "\n Massa gorda = " + String.format("%.1f", massaGorda()) + " kg" + ", Massa massa = " + String.format("%.1f", massaMagra())+ " kg"
                + "\n dataCriacao = " + dataCriacao
                + ", dataModificao = " + dataModificacao + " }";
    }

    public double imc() {
        double alturaMetros = altura / 100;
        return this.imc = peso / (alturaMetros * alturaMetros);
    }

    public double TaxaMetabolica() {
        Scanner sc = new Scanner(System.in);
        double tmb = 0;
        System.out.println("Quantas vezes você faz exercícios por semana?");
        double vezesExercicios = sc.nextDouble();
        double fatorAtividade = 0.0;
        Program.limparTela();

        if (vezesExercicios <= 0) {
            fatorAtividade = 1.2; // Sedentário (pouco ou nenhum exercício)
        } else if (vezesExercicios >= 1 && vezesExercicios <= 3) {
            fatorAtividade = 1.375; // Levemente ativo (exercício leve 1 a 3 dias por semana)
        } else if (vezesExercicios >= 4 && vezesExercicios <= 6) {
            fatorAtividade = 1.55; // Moderadamente ativo (exercício moderado 4 a 6 dias por semana)
        } else if (vezesExercicios >= 7 && vezesExercicios <= 14) {
            fatorAtividade = 1.725; // Muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)
        } else {
            fatorAtividade = 1.9; // Extra ativo (exercício muito difícil, treinamento ou trabalho físico)
        }
        if (pessoa.getSexo().equalsIgnoreCase("M") || pessoa.getSexo().equalsIgnoreCase("Masculino")) {
            return tmb = fatorAtividade * ((66 + (13.7 * peso) + (5 * altura) - (6.8 * idade)));
        } else if (pessoa.getSexo().equalsIgnoreCase("F") || pessoa.getSexo().equalsIgnoreCase("Feminino")) {
            return tmb = fatorAtividade * ((655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade)));
        } else {
            System.out.println("Formato do sexo não é válido \n Não foi possível calcular a Taxa metabólica Basal");
        }
        return tmb;

    }

    public double percentualGordura() {
        double bf = 0;
        if (pessoa.getSexo().equalsIgnoreCase("M") || pessoa.getSexo().equalsIgnoreCase("Masculino")) {
            //Descrição do trabalho não fala em receber valor do abdomen, estou considerando abdomen = cintura
            return bf = 86.010 * Math.log10(cintura - pescoco) - 70.041 * Math.log10(altura) + 36.76;
        } else if (pessoa.getSexo().equalsIgnoreCase("F") || pessoa.getSexo().equalsIgnoreCase("Feminino")) {
            return bf = 163.205 * Math.log10(cintura + quadril) - (97.684 * Math.log10(altura) - 78.387);
        } else {
            System.out.println("Formato do sexo não é válido \n Não foi possível calcular a Taxa metabólica Basal");
        }
        return bf;
    }
    
//    public String valoresGorduraCorp(){
//        String condicao;
//        if(percentualGordura() < 11 && idade > 20 || idade <= 29){
//            condicao = "Atleta"; 
//            return condicao;
//        }else if(percentualGordura() > 11 %% percentualGordura() <= 13&& idade > 20 || idade <= 29)
//        
//    }
    
    public double massaGorda(){
        double massaGorda = 0;
        return massaGorda = peso * (percentualGordura() / 100);
    }
    
    public double massaMagra(){
        double massaMagra = 0;
        return massaMagra = peso - massaGorda();
    }
}
