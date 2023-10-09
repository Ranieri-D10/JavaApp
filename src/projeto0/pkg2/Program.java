/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar este modelo
 */
package projeto0.pkg2;

import Classes.Alimentos;
import DAO.AlimentosDAO;
import Classes.AvaliacaoFisica;
import DAO.AvaliacaoFisicaDAO;
import GUI.GUI;
import Classes.Pessoa;
import Classes.Post;
import Classes.Seguir;
import DAO.PessoaDAO;
import DAO.PostDAO;
import DAO.SeguirDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        foraDaMain();
    }

    private static void foraDaMain() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        GUI gui = new GUI();

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa p1 = null;

        AlimentosDAO alimDAO = new AlimentosDAO();
        Alimentos alimento = null;

        AvaliacaoFisica avFisica = null;
        AvaliacaoFisicaDAO avFisDAO = new AvaliacaoFisicaDAO();

        PostDAO postdao = new PostDAO();
        Post post1 = null;
        Post post2 = null;

        SeguirDAO seguirdao = new SeguirDAO();
        Seguir seguir1 = null;

        int opc;

        do {
            limparTela();

            opc = gui.menuInicial();
            switch (opc) {
                case 1:
                    limparTela();
                    System.out.println("Novo usuário!");
                    System.out.print("Informe Seu nome: ");
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
                    String criarP = pessoaDAO.criarPessoa(p1);
                    System.out.println(criarP);
                    pessoaDAO.imprimirArrayPessoas(pessoaDAO.getArrayPessoas());
                    break;
                case 2:
                    limparTela();
                    System.out.println("Fazer login!");
                    Pessoa usuarioLogado = null;
                    boolean loginSucesso = false;

                    while (!loginSucesso) {
                        usuarioLogado = pessoaDAO.fazerLogin();

                        if (usuarioLogado != null) {
                            limparTela();
                            System.out.println("Login realizado com sucesso");
                            System.out.println("Olá, " + usuarioLogado.getNome());
                            loginSucesso = true; // Define loginSucesso como true para sair do loop
                            int opcLogado;
                            do {
                                limparTela();
                                opcLogado = gui.menuUsuarioLogado();
                                switch (opcLogado) {
                                    case 1:
                                        limparTela();
                                        System.out.println("Opção: Editar usuário");
                                        pessoaDAO.modificarPessoa(usuarioLogado);
                                        limparTela();
                                        //usuarioLogado.imprimirArrayPessoas(arrayPessoas);
                                        System.out.println("Olá, " + usuarioLogado.getNome());
                                        break;
                                    case 2:
                                        limparTela();
                                        System.out.println("Opção: Excluir usuário");
                                        String result = pessoaDAO.removePessoa();
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
                                        alimDAO.criarAlimento(alimento);
                                        alimDAO.imprimirArrayAlimentos(alimDAO.getArrayAlimentos());
                                        break;
                                    case 4:
                                        System.out.println("Opção: Editar Alimentos.");

                                        int opcAlim = 0;
                                        do {
                                            limparTela();

                                            opcAlim = gui.menuAlimentos();
                                            switch (opcAlim) {
                                                case 1:
                                                    alimDAO.imprimirArrayAlimentos(alimDAO.getArrayAlimentos());
                                                    System.out.println("Editar alimento");
                                                    limparTela();
                                                    Alimentos alimEdit = alimDAO.editarAlimento(alimDAO.getArrayAlimentos());
                                                    System.out.println(alimEdit);
                                                    break;
                                                case 2:
                                                    System.out.println("Excluir alimento");
                                                    String resulExc = alimDAO.excluirAlimento(alimDAO.getArrayAlimentos());
                                                    if (resulExc != null) {
                                                        System.out.println("Alimento " + resulExc + "  excluído com sucesso!");
                                                    } else {
                                                        System.out.println("Não foi possível excluir o alimento!");
                                                    }
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
                                        limparTela();
                                        int opcAvFis = 0;
                                        do {
                                            opcAvFis = gui.menuAvaliacaoFisica();
                                            switch (opcAvFis) {
                                                case 1:
                                                    limparTela();
                                                    System.out.println("1. Fazer Avaliação Física");
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
                                                    System.out.println("Quantas vezes você faz exercícios por semana?");
                                                    double vezesExercicios = sc.nextDouble();
                                                    int idAf = 0;
                                                    limparTela();
                                                    avFisica = new AvaliacaoFisica(idAf, usuarioLogado, peso, altura, idade, pescoco, cintura, quadril, vezesExercicios, LocalDate.now(), LocalDate.now());
                                                    boolean booAvFis = avFisDAO.criarAvaliacaoFisica(avFisica);

                                                    avFisica.TaxaMetabolica(avFisica);

                                                    if (booAvFis) {
                                                        System.out.println("Avaliação Física registrada com sucesso.");
                                                        System.out.println(avFisica.toString());
                                                        limparTela();
                                                    } else {
                                                        System.out.println("Não foi possível registar avaliação Física.");
                                                        limparTela();
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("2. Excluir Avaliação Física");
                                                    break;
                                                case 3:
                                                    System.out.println("3. Editar Avaliação Física");
                                                    break;
                                                case 4:
                                                    opcAvFis = 4;
                                                    break;
                                                default:
                                                    limparTela();
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    limparTela();
                                                    break;
                                            }
                                        } while (opcAvFis != 4);
                                        break;
                                    case 6:
                                        System.out.println("Falta implementar");
                                        break;
                                    case 7:
                                        System.out.println("Falta implementar");
                                        break;
                                    case 8:
                                        System.out.println("Redes Sociais");
                                        System.out.println("Seguidores ---------------------");
                                        pessoaDAO.imprimirSeguidores(usuarioLogado.getSeguidores());
                                        int opcRS = 0;
                                        do {
                                            opcRS = gui.menuRedeSociais();
                                            switch (opcRS) {
                                                case 1:
                                                    int opcPost = 0;
                                                    do {
                                                        opcPost = gui.menuPost();
                                                        switch (opcPost) {
                                                            case 1:
                                                                System.out.println("1. Escrever Post");
                                                                System.out.println("Digite o conteúdo da post: ");
                                                                String mensagem = sc.nextLine();
                                                                post1 = new Post(usuarioLogado, mensagem);
                                                                post2 = postdao.criarPost(post1);
                                                                if (post2 != null) {
                                                                    limparTela();
                                                                    System.out.println("Post criado com sucesso");
                                                                    System.out.println(post1.toString());
                                                                    limparTela();
                                                                } else {
                                                                    limparTela();
                                                                    System.out.println("Não foi possível criar post!");
                                                                    limparTela();
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("2. Editar Post");
                                                                System.out.println("Digite o id do post que deseja editar");
                                                                int idEdit = Integer.parseInt(sc.nextLine());
                                                                boolean resulEdit = postdao.editarPost(post1, idEdit);
                                                                if (resulEdit) {
                                                                    System.out.println("Post editado com sucesso!");
                                                                    limparTela();
                                                                } else {
                                                                    System.out.println("Não foi possível editar o post.");
                                                                    limparTela();
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.println("3. Excluir Post");
                                                                System.out.println("Digite o id do post que deseja excluir: ");
                                                                int idExcluir = Integer.parseInt(sc.nextLine());
                                                                boolean resulExc = postdao.excluirPost(post1, idExcluir);
                                                                if (resulExc) {
                                                                    System.out.println("Post excluído com sucesso");
                                                                    limparTela();
                                                                } else {
                                                                    System.out.println("ID não encontrado, não foi possível excluir");
                                                                    limparTela();
                                                                }
                                                                break;
                                                            case 4:
                                                                System.out.println("4. Exibir Posts");
                                                                postdao.imprimirArrayPost(postdao.getArrayPost(), usuarioLogado);
                                                                limparTela();
                                                                break;
                                                            case 5:
                                                                opcRS = 5;
                                                                break;
                                                        }
                                                    } while (opcPost != 5);
                                                    break;
                                                case 2:
                                                    int opcSeguir = 0;
                                                    do {
                                                        opcSeguir = gui.menuSeguir();
                                                        switch (opcSeguir) {
                                                            case 1:
                                                                System.out.println("1. Seguir Alguém");
                                                                System.out.println("Informe o id da pessoa que deseja seguir: ");
                                                                int encId = Integer.parseInt(sc.nextLine());
                                                                Pessoa pEncontrar = pessoaDAO.encontrarPessoaPorId(encId);
                                                                if(pEncontrar != null) {
                                                                Pessoa pSeguindo = seguirdao.seguirPessoa(usuarioLogado,pEncontrar);
                                                                    System.out.println("Agora você está seguindo " + pEncontrar.getNome());
                                                                }else{
                                                                    System.out.println("Não foi possível encontrar pessoa pelo id");
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("2. Deixar de seguir alguém");

                                                                break;
                                                            case 3:
                                                                System.out.println("3. Exibir Seguidores");
                                                                seguirdao.imprimirArraySeguidores(seguirdao.getSeguir(), usuarioLogado);
                                                                limparTela();
                                                                break;
                                                            case 4:
                                                                break;

                                                        }
                                                    } while (opcSeguir != 4);
                                                    break;
                                                case 3:

                                                    break;
                                                case 4:

                                                    break;
                                            }
                                        } while (opcRS != 4);

                                        break;
                                    case 9:
                                        System.out.println("Saindo do programa.");
                                        break;
                                    default:
                                        limparTela();
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }

                            } while (opcLogado != 9);
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
                    opc = 3;
                    break;
            }
        } while (opc != 3);
    }

    public static void limparTela() {
        for (int i = 0; i < 2; i++) {
            System.out.println(); // Imprime linhas em branco para "limpar" o console
        }
    }

}
