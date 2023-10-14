/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar este modelo
 */
package projeto0.pkg2;

import Classes.Alimentos;
import DAO.AlimentosDAO;
import Classes.AvaliacaoFisica;
import Classes.Dieta;
import DAO.AvaliacaoFisicaDAO;
import GUI.GUI;
import Classes.Pessoa;
import Classes.Post;
import Classes.Seguir;
import Classes.TipoDeDieta;
import DAO.DietaDAO;
import DAO.PessoaDAO;
import DAO.PostDAO;
import DAO.SeguirDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

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
    
    DietaDAO dietadao = new DietaDAO();
    Dieta dieta1 = null;

    public Program() {
        boolean postTesteInserido = false;

        int opc;

        do {
            opc = gui.menuInicial();
            switch (opc) {
                case 1:
                    //Criar Usuário
                    limparTela();
                    p1 = gui.criarUser();
                    String criarP = pessoaDAO.criarPessoa(p1);
                    System.out.println(criarP);
                    pessoaDAO.imprimirArrayPessoas(pessoaDAO.getArrayPessoas());
                    break;
                case 2:
                    //Fazer Login
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
                                int opcPessoa = 0;
                                switch (opcLogado) {
                                    case 1:
                                        //Menu Pessoas
                                        do {
                                            limparTela();
                                            opcPessoa = gui.menuPessoas();
                                            switch (opcPessoa) {
                                                case 1:
                                                    //Modificar Pessoa
                                                    limparTela();
                                                    String novoNome = gui.editUser();
                                                    pessoaDAO.modificarPessoa(usuarioLogado, novoNome);
                                                    limparTela();
                                                    System.out.println("Olá, " + usuarioLogado.getNome());
                                                    break;
                                                case 2:
                                                    //Remover Pessoa
                                                    limparTela();
                                                    String pExcluir = gui.removePessoa();
                                                    String result = pessoaDAO.removePessoa(pExcluir);
                                                    limparTela();
                                                    System.out.println(result);
                                                    break;
                                                case 3:
                                                    //Exibir Lista de Pessoas
                                                    pessoaDAO.imprimirArrayPessoas(pessoaDAO.getArrayPessoas());
                                                    break;
                                                case 4:
                                                    opcPessoa = 4;
                                                    break;
                                            }
                                        } while (opcPessoa != 4);
                                        break;
                                    case 2:
                                        //Menu Alimentos
                                        int opcAlim = 0;
                                        do {
                                            limparTela();
                                            opcAlim = gui.menuAlimentos();
                                            switch (opcAlim) {
                                                case 1:
                                                    //Editar Alimento
                                                    alimDAO.imprimirArrayAlimentos(alimDAO.getArrayAlimentos());
                                                    limparTela();
                                                    int buscaId = gui.buscaIdAlim(alimDAO.getArrayAlimentos());
                                                    if (buscaId != -1) {
                                                        Alimentos alimEditando = gui.editAlimento(alimDAO.getArrayAlimentos(), buscaId);
                                                        Alimentos alimEditado = alimDAO.editarAlimento(alimDAO.getArrayAlimentos(), alimEditando, buscaId);
                                                        System.out.println(alimEditado);
                                                    }
                                                    break;
                                                case 2:
                                                    //Excluir Alimento
                                                    int idRemove = gui.buscaIdAlim(alimDAO.getArrayAlimentos());
                                                    if (idRemove != -1) {
                                                        String resulExc = alimDAO.excluirAlimento(alimDAO.getArrayAlimentos(), idRemove);
                                                        if (resulExc != null) {
                                                            System.out.println("Alimento " + resulExc + "  excluído com sucesso!");
                                                        } else {
                                                            System.out.println("Não foi possível excluir o alimento!");
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    //Exibir lista de alimentos
                                                    alimDAO.imprimirArrayAlimentos(alimDAO.getArrayAlimentos());
                                                    break;
                                                case 4:
                                                    opcAlim = 4;
                                                    break;
                                                default:
                                                    limparTela();
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    break;
                                            }
                                        } while (opcAlim != 4);
                                        break;
                                    case 3:
                                        //Avaliação Física
                                        limparTela();
                                        int opcAvFis = 0;
                                        do {
                                            opcAvFis = gui.menuAvaliacaoFisica();
                                            switch (opcAvFis) {
                                                case 1:
                                                    limparTela();
                                                    //Fazer Avaliação Física
                                                    avFisica = gui.createAvFisica(usuarioLogado);

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
                                                    //Excluir Avaliação Física
                                                    System.out.println("2. Excluir Avaliação Física");
                                                    int idRemAF = gui.buscaIdAvFis(avFisDAO.getArrayAvFisica());
                                                    if (idRemAF != -1) {
                                                        boolean resulRemAF = avFisDAO.removerAvaliacaoFisica(avFisDAO.getArrayAvFisica(), idRemAF);
                                                        if (resulRemAF) {
                                                            System.out.println("Avaliação Física removida com sucesso!");
                                                        } else {
                                                            System.out.println("Não foi possível remover avaliação Física.");
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    //Editar Avaliação Física
                                                    System.out.println("3. Editar Avaliação Física");
                                                    int idEditAF = gui.buscaIdAvFis(avFisDAO.getArrayAvFisica());
                                                    if (idEditAF != -1) {
                                                        System.out.println("Imforme o peso: ");
                                                        double novoPeso = Double.parseDouble(sc.nextLine());
                                                        AvaliacaoFisica resulEdiAF = avFisDAO.editarAvaliacaoFisica(avFisDAO.getArrayAvFisica(), idEditAF, novoPeso);
                                                        System.out.println(resulEdiAF.toString());
                                                        limparTela();
                                                    }
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
                                    case 4:
                                        System.out.println("Falta implementar");
                                        break;
                                    case 5: {
                                        //Dieta
                                        int opcDieta = gui.menuDieta();
                                        
                                        do {
                                            switch (opcDieta) {
                                                case 1:
                                                    //Criar Dieta
                                                    
                                                    //Falta o código da classe TipoDeDieta
                                                    TipoDeDieta tipoDieta = null;
                                                    dieta1 = gui.criarDieta(avFisica, usuarioLogado, tipoDieta);
                                                    dietadao.inserirDieta(dieta1);
                                                    break;
                                                case 2:
                                                    //Editar Dieta
                                                    dieta1 = dietadao.EditarDieta(dieta1);
                                                    break;
                                                case 3:
                                                    //Excluir Dieta
                                                    dietadao.excluirDieta(dieta1);
                                                    break;
                                                case 4:
                                                    opcDieta = 4;
                                                    break;
                                            }
                                        } while (opc != 4);

                                    }
                                    break;

                                    case 6:
                                        System.out.println("Falta implementar");
                                        break;
                                    case 7:
                                        System.out.println("Falta implementar");
                                        break;
                                    case 8:
                                        limparTela();
                                        System.out.println("========================================");
                                        System.out.println("     Timeline de " + usuarioLogado.getNome());
                                        System.out.println("========================================");

                                        postdao.timeline(usuarioLogado, seguirdao);
                                        // Insere posts na memória para teste
                                        if (!postTesteInserido) {
                                            postdao.inserirPostTeste(usuarioLogado, pessoaDAO.getArrayPessoas());
                                            postTesteInserido = true;
                                        }
                                        limparTela();
                                        System.out.println("========================================");
                                        System.out.println("    Seguidores");
                                        System.out.println("========================================");

                                        limparTela();
                                        pessoaDAO.imprimirSeguidores(usuarioLogado.getSeguidores());
                                        limparTela();
                                        int opcRS = 0;
                                        do {
                                            opcRS = gui.menuRedeSociais();
                                            switch (opcRS) {
                                                case 1:
                                                    //Post
                                                    int opcPost = 0;
                                                    do {
                                                        opcPost = gui.menuPost();
                                                        switch (opcPost) {
                                                            case 1:
                                                                //Escrever Post
                                                                String mensagem = gui.escreverPost();
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
                                                                //Editar Post
                                                                System.out.println("2. Editar Post");
                                                                System.out.println("Digite o id do post que deseja editar");
                                                                int idEdit = gui.buscarIdPost();
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
                                                                int idExcluir = gui.buscarIdPost();
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
                                                                postdao.imprimirArrayPost(postdao.getArrayPost());
                                                                limparTela();
                                                                break;
                                                            case 5:
                                                                opcRS = 5;
                                                                break;
                                                        }
                                                    } while (opcPost != 5);
                                                    break;
                                                case 2:
                                                    //Seguir
                                                    int opcSeguir = 0;
                                                    do {
                                                        opcSeguir = gui.menuSeguir();
                                                        switch (opcSeguir) {
                                                            case 1:
                                                                //Seguir Alguém
                                                                int encId = gui.buscaIdSeguir(seguirdao.getSeguir());
                                                                Pessoa pEncontrar = pessoaDAO.encontrarPessoaPorId(encId);
                                                                if (pEncontrar != null) {
                                                                    Pessoa pSeguindo = seguirdao.seguirPessoa(usuarioLogado, pEncontrar);
                                                                    System.out.println("Agora você está seguindo " + pEncontrar.getNome());
                                                                } else {
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
                            String resposta = sc.nextLine();
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

    public static void main(String[] args) {
        new Program();
    }
}
