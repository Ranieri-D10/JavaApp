/*
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para alterar esta licença
 * Clique nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar este modelo
 */
package projeto0.pkg2;

import Classes.Alimentos;
import Classes.AlimentosRefeicoes;
import DAO.AlimentosDAO;
import Classes.AvaliacaoFisica;
import Classes.Dieta;
import Classes.Mensagens;
import DAO.AvaliacaoFisicaDAO;
import GUI.GUI;
import Classes.Pessoa;
import Classes.Post;
import Classes.Refeicoes;
import Classes.Seguir;
import Classes.TipoDeDieta;
import DAO.AlimentosRefeicoesDAO;
import DAO.DietaDAO;
import DAO.MensagemDAO;
import DAO.PessoaDAO;
import DAO.PostDAO;
import DAO.RefeicoesDAO;
import DAO.SeguirDAO;
import DAO.TipoDeDietaDAO;
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

    TipoDeDietaDAO tipoDietadao = new TipoDeDietaDAO();
    TipoDeDieta tipoDieta = null;

    RefeicoesDAO refeicoesDao = new RefeicoesDAO();
    Refeicoes refeicao = null;

    AlimentosRefeicoesDAO alimRefDao = new AlimentosRefeicoesDAO();
    AlimentosRefeicoes alimRef = null;

    MensagemDAO mensagemDao = new MensagemDAO();
    Mensagens mensagem1 = null;

    public Program() {
        boolean postTesteInserido = false;
        boolean postavFisicaTeste = false;

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
                            if (!postavFisicaTeste) {
                                avFisica = avFisDAO.inserirAFTeste(usuarioLogado);
                                postavFisicaTeste = true;
                            }
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
                                                    //Adicionar Alimentos
                                                    alimento = gui.createAlimento();
                                                    alimDAO.criarAlimento(alimento);
                                                    limparTela();
                                                    System.out.println("Alimento adicionado.\n" + alimento.toString());
                                                    break;
                                                case 2:
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
                                                case 3:
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
                                                case 4:
                                                    //Exibir lista de alimentos
                                                    alimDAO.imprimirArrayAlimentos(alimDAO.getArrayAlimentos());
                                                    break;
                                                case 5:
                                                    opcAlim = 5;
                                                    break;
                                                default:
                                                    limparTela();
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    break;
                                            }
                                        } while (opcAlim != 5);
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
                                                    avFisDAO.imprimirAvaliacoesFisicas();
                                                    postdao.imprimirArrayPost(postdao.getArrayPost());

                                                    break;
                                                case 5:
                                                    opcAvFis = 5;
                                                    break;
                                                default:
                                                    limparTela();
                                                    System.out.println("Opção inválida. Tente novamente.");
                                                    limparTela();
                                                    break;
                                            }
                                        } while (opcAvFis != 5);
                                        break;
                                    case 4:
                                        // Tipo de Dieta
                                        int opcTipoDieta = 0;
                                        do {
                                            limparTela();
                                            opcTipoDieta = gui.menuTipoDieta();
                                            switch (opcTipoDieta) {
                                                case 1:
                                                    // Criar tipo de Dieta
                                                    limparTela();
                                                    // Variável que armazena o tipo de Dieta
                                                    int tdieta = gui.escolherTipoDeDieta();
                                                    tipoDieta = tipoDietadao.criarTipoDeDieta(tdieta);
                                                    limparTela();
                                                    System.out.println(tipoDieta.toString());
                                                    break;
                                                case 2:
                                                    // Editar tipo de Dieta
                                                    int tDietaEdit = gui.escolherTipoDeDieta();
                                                    int idTipoDieta = gui.buscarIdTipoDieta();
                                                    tipoDieta = tipoDietadao.editarTipoDieta(tDietaEdit, idTipoDieta);
                                                    limparTela();
                                                    if (tipoDieta != null) {
                                                        System.out.println(tipoDieta.toString());
                                                    } else {
                                                        System.out.println("Tipo de Dieta não encontrado ou não pode ser editado.");
                                                    }
                                                    break;

                                                case 3:
                                                    // Excluir tipo de Dieta
                                                    int idTipoDietaRemove = gui.buscarIdTipoDieta();
                                                    tipoDietadao.removerTipoDieta(idTipoDietaRemove);
                                                    break;
                                                case 4:
                                                    // Exibir lista dos tipos de Dieta
                                                    tipoDietadao.imprimirArrayTipodedieta(tipoDietadao.getArrayTipodeDieta());
                                                    break;
                                                case 5:
                                                    opcTipoDieta = 5;
                                                    break;
                                            }
                                        } while (opcTipoDieta != 5);
                                        break;
                                    case 5: {
                                        //Dieta
                                        int opcDieta = 0;
                                        do {
                                            limparTela();
                                            opcDieta = gui.menuDieta();
                                            switch (opcDieta) {
                                                case 1:
                                                    //Criar Dieta
                                                    limparTela();
                                                    dieta1 = gui.criarDieta(avFisica, usuarioLogado, tipoDieta);
                                                    dietadao.inserirDieta(dieta1);
                                                    limparTela();
                                                    dietadao.imprimirDietas(dietadao.getArrayDieta());
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
                                        } while (opcDieta != 4);

                                    }
                                    break;
                                    case 6:
                                        //Refeições
                                        int opcRefeicoes = 0;

                                        do {
                                            limparTela();
                                            opcRefeicoes = gui.menuRefeicoes();
                                            switch (opcRefeicoes) {
                                                case 1:
                                                    //Inserir Refeições
                                                    String nomeRefeicao = gui.nomeRefeicao();
                                                    refeicoesDao.inserirRefeicao(nomeRefeicao, dieta1, tipoDieta);
                                                    limparTela();
                                                    refeicoesDao.imprimirRefeicoes(refeicoesDao.getArrayRefeicao());
                                                    limparTela();
                                                    break;
                                                case 2:
                                                    //Editar Refeição
                                                    String nomeRefeicaoEdit = gui.nomeRefeicao();
                                                    int idRefeicaoEdit = gui.idRefeicao();
                                                    refeicoesDao.editarRefeicao(nomeRefeicaoEdit, idRefeicaoEdit);
                                                    break;
                                                case 3:
                                                    //Excluir Refeição
                                                    int idRemove = gui.idRefeicao();
                                                    String retornRemove = refeicoesDao.removerRefeicao(idRemove);
                                                    limparTela();
                                                    System.out.println(retornRemove);
                                                    break;
                                                case 4:
                                                    //Exibir Refeições
                                                    limparTela();
                                                    refeicoesDao.imprimirRefeicoes(refeicoesDao.getArrayRefeicao());
                                                    limparTela();
                                                    break;
                                                case 5:

                                                    break;

                                            }
                                        } while (opcRefeicoes != 5);

                                        break;
                                    case 7:
                                        //Alimentos/Refeições
                                        int opcAlimRef = 0;
                                        do {
                                            limparTela();
                                            opcAlimRef = gui.menuAlimentosRefeicoes();
                                            switch (opcAlimRef) {
                                                case 1:
                                                    //Adicionar Alimentos a refeicao
                                                    int idRef = gui.buscaIdRefeicao();
                                                    alimRefDao.inserirAlimentosNaRefeicao(refeicoesDao.getArrayRefeicao(), alimDAO, idRef, alimRefDao.getArrayAlimRef());
                                                    limparTela();
                                                    alimRefDao.imprimirAlimentosRefeicoes(alimRefDao.getArrayAlimRef());
                                                    break;
                                                case 2:
                                                    //Editar alimentos da refeicao

                                                    break;
                                                case 3:
                                                    //Remover alimentos da refeicao
                                                    break;
                                                case 4:
                                                    //Exibir alimentos da refeicao
                                                    break;
                                                default:
                                                    throw new AssertionError();
                                            }
                                        } while (opcAlimRef != 4);
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
                                                    //Mensagens
                                                    int opcMsg = 0;
                                                    do {
                                                        opcMsg = gui.MenuMensagens();
                                                        switch (opcMsg) {
                                                            case 1:
                                                                //Enviar mensagem
                                                                seguirdao.imprimirArraySeguidores(seguirdao.getSeguir(), usuarioLogado);
                                                                limparTela();
                                                                int idSeguidor = gui.buscarSeguidores(seguirdao, usuarioLogado);
                                                                mensagem1 = mensagemDao.enviarMensagem(idSeguidor, usuarioLogado, pessoaDAO.getArrayPessoas());
                                                                System.out.println(mensagem1.toString());
                                                                limparTela();
                                                                break;
                                                            case 2:
                                                                //Editar mensagem
                                                                System.out.println("2. Editar mensagem");
                                                                int idMsg = gui.buscarIdMensagem();
                                                                mensagemDao.editarMensagem(idMsg);
                                                                break;
                                                            case 3:
                                                                //Excluir mensagem
                                                                System.out.println("3. Excluir mensagem");
                                                                idMsg = gui.buscarIdMensagem();
                                                                mensagemDao.excluirMensagem(idMsg);
                                                                break;
                                                            case 4:
                                                                //Exibir mensagem
                                                                mensagemDao.imprimirArrayMensagens(mensagemDao.getArrayMensagem());
                                                                break;
                                                            case 5:
                                                                opcMsg = 5;
                                                                break;
                                                        }
                                                    } while (opcMsg != 5);
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
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Program();
    }
}
