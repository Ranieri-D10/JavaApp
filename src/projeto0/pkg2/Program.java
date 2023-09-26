/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar este modelo
 */
package projeto0.pkg2;

import Classes.Alimentos;
import Classes.AvaliacaoFisica;
import Classes.Pessoa;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Pessoa p1 = null;
        Pessoa arrayPessoas[] = new Pessoa[5];
        Pessoa p2 = new Pessoa(0, "João", "Masculino", LocalDate.of(1990, 5, 15), "joao", "123", LocalDate.now(), LocalDate.now());
        arrayPessoas[0] = p2;
        Pessoa p3 = new Pessoa(1, "Maria", "Feminino", LocalDate.of(1985, 9, 20), "maria", "456", LocalDate.now(), LocalDate.now());
        arrayPessoas[1] = p3;
        Pessoa p4 = new Pessoa(4, "Maria", "Feminino", LocalDate.of(1985, 9, 20), "maria", "456", LocalDate.now(), LocalDate.now());
        arrayPessoas[2] = p4;
        Pessoa p5 = new Pessoa(2, "Carlos", "Masculino", LocalDate.of(1995, 3, 10), "carlos", "789", LocalDate.now(), LocalDate.now());
        arrayPessoas[3] = p5;
//        Pessoa p6 = new Pessoa(3, "Ana", "Feminino", LocalDate.of(1992, 8, 5), "ana", "101", LocalDate.now(), LocalDate.now());
//        arrayPessoas[4] = p6;

        Alimentos alimento = null;
        Alimentos arrayAlimentos[] = new Alimentos[20];
        Alimentos alimento1 = new Alimentos(1, "Arroz", 45, 2, 0, 200.5, 100);
        Alimentos alimento2 = new Alimentos(2, "Frango", 0, 25, 3, 120.0, 100);
        Alimentos alimento3 = new Alimentos(3, "Brócolis", 5, 3, 0, 30.0, 100);
        Alimentos alimento4 = new Alimentos(4, "Batata", 20, 2, 0, 90.0, 100);
        Alimentos alimento5 = new Alimentos(5, "Salmão", 0, 22, 10, 180.0, 100);
        Alimentos alimento6 = new Alimentos(6, "Espinafre", 2, 3, 0, 23.0, 100);
        Alimentos alimento7 = new Alimentos(7, "Banana", 30, 1, 0, 105.0, 100);
        Alimentos alimento8 = new Alimentos(8, "Cenoura", 8, 1, 0, 35.0, 100);

        arrayAlimentos[0] = alimento1;
        arrayAlimentos[1] = alimento2;
        arrayAlimentos[2] = alimento3;
        arrayAlimentos[3] = alimento4;
        arrayAlimentos[4] = alimento5;
        arrayAlimentos[5] = alimento6;
        arrayAlimentos[6] = alimento7;
        arrayAlimentos[7] = alimento8;

        AvaliacaoFisica avFisica = null;

        int opc;

        do {
            limparTela();
            System.out.println("Menu:");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Fazer login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    limparTela();
                    System.out.println("Novo usuário!");
                    System.out.print("Informe Seu nome: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.print("Informe o sexo: ");
                    String sexo = sc.nextLine();
                    System.out.print("Informe a data de nascimento(dd/MM/yyyy): ");
                    String strNiver = sc.nextLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate birthday = LocalDate.parse(strNiver, dtf);
                    LocalDate nascimento = birthday;
                    System.out.print("Informe Seu login: ");
                    String login = sc.nextLine();
                    System.out.print("Informe sua senha: ");
                    String password = sc.nextLine();
                    int id = 0;
                    p1 = new Pessoa(id, nome, sexo, nascimento, login, password, LocalDate.now(), LocalDate.now());
                    String criarP = p1.criarPessoa(p1, arrayPessoas);
                    System.out.println(criarP);
                    p1.imprimirArrayPessoas(arrayPessoas);
                    break;
                case 2:
                    limparTela();
                    System.out.println("Fazer login!");
                    Pessoa usuarioLogado = null;
                    boolean loginSucesso = false;

                    while (!loginSucesso) {
                        usuarioLogado = Pessoa.fazerLogin(arrayPessoas);

                        if (usuarioLogado != null) {
                            limparTela();
                            System.out.println("Login realizado com sucesso");
                            System.out.println("Olá, " + usuarioLogado.getNome());
                            loginSucesso = true; // Define loginSucesso como true para sair do loop
                            int opcLogado;
                            do {
                                limparTela();
                                System.out.println("Menu:");
                                System.out.println("1. Editar usuário");
                                System.out.println("2. Excluir usuário");
                                System.out.println("3. Cadastrar Alimento");
                                System.out.println("4. Editar Alimentos");
                                System.out.println("5. Avaliação Física");
                                System.out.println("6. Voltar ao menu principal");
                                System.out.print("Escolha uma opção: ");
                                opcLogado = sc.nextInt();

                                switch (opcLogado) {
                                    case 1:
                                        limparTela();
                                        System.out.println("Opção: Editar usuário");
                                        Pessoa.modificarPessoa(arrayPessoas, usuarioLogado);
                                        limparTela();
                                        //usuarioLogado.imprimirArrayPessoas(arrayPessoas);
                                        System.out.println("Olá, " + usuarioLogado.getNome());
                                        break;
                                    case 2:
                                        limparTela();
                                        System.out.println("Opção: Excluir usuário");
                                        String result = Pessoa.removePessoa(arrayPessoas);
                                        limparTela();
                                        System.out.println(result);
                                        break;
                                    case 3:
                                        limparTela();
                                        System.out.println("Opção: Cadastrar Alimento");
                                        System.out.println("Digite os informacoes do Alimento:");
                                        System.out.print("Nome do Alimento: ");
                                        sc.nextLine();
                                        String nomeAlim = sc.nextLine();
                                        System.out.print("Carboidrato (g): ");
                                        int carboidrato = sc.nextInt();
                                        System.out.print("Proteína (g): ");
                                        int proteina = sc.nextInt();
                                        System.out.print("Gordura (g): ");
                                        int gordura = sc.nextInt();
                                        System.out.print("Calorias: ");
                                        double calorias = sc.nextDouble();
                                        System.out.print("Porção (g): ");
                                        int porcao = sc.nextInt();
                                        int idAlim = 0;

                                        // Criar um objeto Alimento com os valores fornecidos pelo usuário
                                        alimento = new Alimentos(idAlim, nomeAlim, carboidrato, proteina, gordura, calorias, porcao);
                                        alimento.criarAlimento(alimento, arrayAlimentos);
                                        alimento.imprimirArrayAlimentos(arrayAlimentos);
                                        break;
                                    case 4:
                                        System.out.println("Opção: Editar Alimentos.");

                                        int opcAlim = 0;
                                        do {
                                            limparTela();
                                            System.out.println("Menu:");
                                            System.out.println("1. Editar alimento");
                                            System.out.println("2. Excluir alimento");
                                            System.out.println("3. Voltar ao menu anterior");
                                            System.out.print("Escolha uma opção: ");
                                            opcAlim = sc.nextInt();
                                            switch (opcAlim) {
                                                case 1:
                                                    alimento1.imprimirArrayAlimentos(arrayAlimentos);
                                                    System.out.println("Editar alimento");
                                                    limparTela();
                                                    Alimentos alimEdit = alimento1.editarAlimento(arrayAlimentos);
                                                    System.out.println(alimEdit);
                                                    break;
                                                case 2:
                                                    System.out.println("Excluir alimento");
                                                    result = alimento1.excluirAlimento(arrayAlimentos);
                                                    System.out.println(result);
                                                    break;
                                                case 3:
                                                    opcAlim = 3;
                                                default:
                                                    limparTela();
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    break;
                                            }

                                        } while (opcAlim != 3);
                                        break;
                                    case 5:
                                        limparTela();
                                        System.out.println("Opção: Avaliação Física");
                                        System.out.println("Avaliação Física de " + usuarioLogado.getNome());
                                        limparTela();
                                        System.out.print("Informe o peso(kg): ");
                                        double peso = sc.nextDouble();
                                        System.out.print("Informe a altura(cm): ");
                                        double altura = sc.nextDouble();
                                        System.out.print("Informe a idade: ");
                                        int idade = sc.nextInt();
                                        System.out.print("Informe a medida do pescoço(cm): ");
                                        double pescoco = sc.nextDouble();
                                        System.out.print("Informe a medida da cintura(cm): ");
                                        double cintura = sc.nextDouble();
                                        System.out.print("Informe a medida do quadril(cm): ");
                                        double quadril = sc.nextDouble();
                                        int idAf = 0;
                                        limparTela();
                                        avFisica = new AvaliacaoFisica(idAf, usuarioLogado, peso, altura, idade, pescoco, cintura, quadril, peso, LocalDate.now(), LocalDate.now());


                                        System.out.println(avFisica.toString());
                                        break;
                                    case 6:
                                        System.out.println("Saindo do programa.");
                                        break;
                                    default:
                                        limparTela();
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }
                            } while (opcLogado != 6);
                        } else {
                            System.out.println("Ocorreu um problema ao fazer login.\nVerifique o usuário e senha ou crie uma conta.");
                            System.out.println("Deseja tentar novamente? (S para Sim, qualquer outra tecla para Sair)");
                            sc.nextLine();
                            String resposta = sc.next();
                            if (!resposta.equalsIgnoreCase("S")) {
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    opc = 6;
                    break;
            }
        } while (opc != 6);
    }

    public static void limparTela() {
        for (int i = 0; i < 2; i++) {
            System.out.println(); // Imprime linhas em branco para "limpar" o console
        }
    }
}
