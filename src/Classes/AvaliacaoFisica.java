/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.util.Objects;
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
    private double vezesExercicios;
    private double imc;
    private double tmb;
    private double bodyFat;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AvaliacaoFisica(int id, Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril, double vezesExercicios, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = id;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.vezesExercicios = vezesExercicios; // Defina o valor de vezesExercicios corretamente
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

    public double getVezesExercicios() {
        return vezesExercicios;
    }

    public void setVezesExercicios(double vezesExercicios) {
        this.vezesExercicios = vezesExercicios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.pessoa);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 67 * hash + this.idade;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.pescoco) ^ (Double.doubleToLongBits(this.pescoco) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.vezesExercicios) ^ (Double.doubleToLongBits(this.vezesExercicios) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.imc) ^ (Double.doubleToLongBits(this.imc) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.tmb) ^ (Double.doubleToLongBits(this.tmb) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.bodyFat) ^ (Double.doubleToLongBits(this.bodyFat) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
        hash = 67 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AvaliacaoFisica other = (AvaliacaoFisica) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Avaliação Física de " + pessoa.getNome() + " {"
                + "\n id = " + id + ", peso = " + peso + ", altura = " + altura
                + ", idade = " + idade + " \n pescoco = " + pescoco
                + ", cintura = " + cintura + ", quadril = " + quadril
                + "\n IMC = " + String.format("%.1f", imc())
                + ", TMB = " + String.format("%.1f", TaxaMetabolica(this)) + "Kcal/dia"
                + ", Gordura corporal = " + String.format("%.1f", percentualGordura()) + "%"
                + "\n Massa gorda = " + String.format("%.1f", massaGorda()) + " kg" + ", Massa magra = " + String.format("%.1f", massaMagra()) + " kg"
                + "\n Condição de Gordura Corporal = " + valoresGorduraCorp()
                + "\n dataCriacao = " + dataCriacao
                + ", dataModificacao = " + dataModificacao + " }";
    }

    public double imc() {
        double alturaMetros = getAltura() / 100;
        return this.imc = getPeso() / (alturaMetros * alturaMetros);
    }

    public double TaxaMetabolica(AvaliacaoFisica avFisica) {
        double tmb = 0;
        double fatorAtividade = 0.0;
        Program.limparTela();

        if (getVezesExercicios() <= 0) {
            fatorAtividade = 1.2; // Sedentário (pouco ou nenhum exercício)
        } else if (getVezesExercicios() >= 1 && getVezesExercicios() <= 3) {
            fatorAtividade = 1.375; // Levemente ativo (exercício leve 1 a 3 dias por semana)
        } else if (getVezesExercicios() >= 4 && getVezesExercicios() <= 6) {
            fatorAtividade = 1.55; // Moderadamente ativo (exercício moderado 4 a 6 dias por semana)
        } else if (getVezesExercicios() >= 7 && getVezesExercicios() <= 14) {
            fatorAtividade = 1.725; // Muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)
        } else {
            fatorAtividade = 1.9; // Extra ativo (exercício muito difícil, treinamento ou trabalho físico)
        }
        if (pessoa.getSexo().equalsIgnoreCase("M") || pessoa.getSexo().equalsIgnoreCase("Masculino")) {
            return tmb = fatorAtividade * ((66 + (13.7 * getPeso()) + (5 * getPeso()) - (6.8 * getIdade())));
        } else if (pessoa.getSexo().equalsIgnoreCase("F") || pessoa.getSexo().equalsIgnoreCase("Feminino")) {
            return tmb = fatorAtividade * ((655 + (9.6 * getPeso()) + (1.8 * getPeso()) - (4.7 * getIdade())));
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

    public String valoresGorduraCorp() {
        String condicao = "Não especificado"; // Default value

        double percentagemGordura = percentualGordura();

        if (pessoa.getSexo().equalsIgnoreCase("M") || pessoa.getSexo().equalsIgnoreCase("Masculino")) {
            if (idade >= 20 && idade <= 29) {
                if (percentagemGordura < 11) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 11 && percentagemGordura < 14) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 14 && percentagemGordura < 21) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 21 && percentagemGordura < 23) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 30 && idade <= 39) {
                if (percentagemGordura < 12) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 12 && percentagemGordura < 15) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 15 && percentagemGordura < 21) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 21 && percentagemGordura < 24) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 40 && idade <= 49) {
                if (percentagemGordura < 14) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 14 && percentagemGordura < 16) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 16 && percentagemGordura < 23) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 23 && percentagemGordura < 26) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 50 && idade <= 59) {
                if (percentagemGordura < 15) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 15 && percentagemGordura < 17) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 17 && percentagemGordura < 24) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 24 && percentagemGordura < 27) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            }
        } else if (pessoa.getSexo().equalsIgnoreCase("F") || pessoa.getSexo().equalsIgnoreCase("Feminino")) {
            // Código para mulheres
            if (idade >= 20 && idade <= 29) {
                if (percentagemGordura < 16) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 16 && percentagemGordura < 19) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 19 && percentagemGordura < 28) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 28 && percentagemGordura < 31) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 30 && idade <= 39) {
                // Valores para mulheres de 30 a 39 anos
                if (percentagemGordura < 17) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 17 && percentagemGordura < 20) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 20 && percentagemGordura < 29) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 29 && percentagemGordura < 32) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 40 && idade <= 49) {
                // Valores para mulheres de 40 a 49 anos
                if (percentagemGordura < 18) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 18 && percentagemGordura < 21) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 21 && percentagemGordura < 30) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 30 && percentagemGordura < 33) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            } else if (idade >= 50 && idade <= 59) {
                // Valores para mulheres de 50 a 59 anos
                if (percentagemGordura < 19) {
                    condicao = "Atleta";
                } else if (percentagemGordura >= 19 && percentagemGordura < 22) {
                    condicao = "Bom";
                } else if (percentagemGordura >= 22 && percentagemGordura < 31) {
                    condicao = "Normal";
                } else if (percentagemGordura >= 31 && percentagemGordura < 34) {
                    condicao = "Elevado";
                } else {
                    condicao = "Muito elevado";
                }
            }
        }

        return condicao;
    }

    public double massaGorda() {
        double massaGorda = 0;
        return massaGorda = getPeso() * (percentualGordura() / 100);
    }

    public double massaMagra() {
        double massaMagra = 0;
        return massaMagra = getPeso() - massaGorda();
    }
}
