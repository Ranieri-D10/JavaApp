/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Classes.Alimentos;
import Classes.AvaliacaoFisica;
import Classes.Dieta;
import Classes.Pessoa;
import Classes.Seguir;
import Classes.TipoDeDieta;
import DAO.SeguirDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import projeto0.pkg2.Program;

public class GUI {

    Scanner sc = new Scanner(System.in);

    public int menuInicial() {
        System.out.println("Menu:");
        System.out.println("1. Criar novo usuário");
        System.out.println("2. Fazer login");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuUsuarioLogado() {
        System.out.println("Menu:");
        System.out.println("1. Menu Pessoas");
        System.out.println("2. Menu Alimentos");
        System.out.println("3. Avaliação Física");
        System.out.println("4. Tipos de Dieta");
        System.out.println("5. Menu de Dieta");
        System.out.println("6. Refeições");
        System.out.println("7. Alimentos/Refeições");
        System.out.println("8. Redes Sociais");
        System.out.println("9. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuPessoas() {
        System.out.println("Menu Pessoas:");
        System.out.println("1. Editar usuário");
        System.out.println("2. Excluir usuário");
        System.out.println("3. Exibir lista de usuários");
        System.out.println("4. Voltar ao menu anterior");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuAlimentos() {
        System.out.println("Menu Alimentos:");
        System.out.println("1. Adicionar alimento");
        System.out.println("2. Editar alimento");
        System.out.println("3. Excluir alimento");
        System.out.println("4. Exibir lista de alimentos");
        System.out.println("5. Voltar ao menu anterior");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuAvaliacaoFisica() {
        System.out.println("Menu Avaliação Física:");
        System.out.println("1. Fazer Avaliação Física");
        System.out.println("2. Excluir Avaliação Física");
        System.out.println("3. Editar Avaliação Física");
        System.out.println("4. Exibir Avaliação Física");
        System.out.println("5. Voltar ao menu anterior");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuRedeSociais() {
        System.out.println("Menu Redes Sociais");
        System.out.println("1. Menu Posts");
        System.out.println("2. Menu Seguidores");
        System.out.println("3. Menu mensagens");
        System.out.println("4. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuPost() {
        System.out.println("Menu Post");
        System.out.println("1. Escrever Post");
        System.out.println("2. Editar Post");
        System.out.println("3. Excluir Post");
        System.out.println("4. Exibir Posts");
        System.out.println("5. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuSeguir() {
        System.out.println("Menu Seguir");
        System.out.println("1. Seguir Alguém");
        System.out.println("2. Deixar de seguir alguém");
        System.out.println("3. Exibir Seguidores");
        System.out.println("4. Voltar ao menu anterior");
        return Integer.parseInt(sc.nextLine());
    }

    public int menuDieta() {
        System.out.println("Menu");
        System.out.println("1. Criar dieta. ");
        System.out.println("2. Editar dieta. ");
        System.out.println("3. Remover dieta. ");
        System.out.println("4. Exibir lista de dietas. ");
        System.out.println("5. Voltar ao menu anterior");
        int opcDieta = Integer.parseInt(sc.nextLine());
        return opcDieta;
    }

    public int menuRefeicoes() {
        System.out.println("Menu Refeições");
        System.out.println("1. Adicionar refeição. ");
        System.out.println("2. Editar refeição. ");
        System.out.println("3. Remover refeição. ");
        System.out.println("4. Exibir refeiçcões. ");
        System.out.println("5. Voltar ao menu anterior");
        int opcRefeicoes = Integer.parseInt(sc.nextLine());
        return opcRefeicoes;
    }

    public int menuTipoDieta() {
        System.out.println("Menu Tipo de Dieta");
        System.out.println("1. Escolher tipo de Dieta.");
        System.out.println("2. Editar tipo de Dieta.");
        System.out.println("3. Remover escolha da dieta.");
        System.out.println("4. Exibir tipos de dieta do usuário.");
        System.out.println("5. Voltar ao menu anterior.");
        int opcTipoDieta = Integer.parseInt(sc.nextLine());
        return opcTipoDieta;
    }

    public int menuAlimentosRefeicoes() {
        System.out.println("Menu Alimentos da Refeição");
        System.out.println("1. Adicionar alimento à refeição");
        System.out.println("2. Editar alimentos da refeição");
        System.out.println("3. Excluir alimentos da refeição");
        System.out.println("4. Exibir refeição");
        System.out.println("5. Voltar ao menu anterior");
        int opcAlimentosRefeicoes = Integer.parseInt(sc.nextLine());
        return opcAlimentosRefeicoes;
    }
    
    public int MenuMensagens() {
        System.out.println("Menu Mensagens");
        System.out.println("1. Enviar mensagem");
        System.out.println("2. Editar mensagem");
        System.out.println("3. Excluir mensagem");
        System.out.println("4. Exibir lista de mensagens");
        System.out.println("5. Voltar ao menu anterior");
        int opcMensagens = Integer.parseInt(sc.nextLine());
        return opcMensagens;
    }

    //CRUD Pessoa
    public Pessoa criarUser() {
        Pessoa p1 = null;
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
        return p1;
    }

    public String editUser() {
        System.out.println("Opção: Editar usuário");
        System.out.println("Informe o novo nome: ");
        String novoNome = sc.nextLine();
        return novoNome;
    }

    public String removePessoa() {
        System.out.println("Opção: Excluir usuário");
        System.out.println("Digite o Usuário que deseja excluir: ");
        String pExcluir = sc.nextLine();
        return pExcluir;
    }

    //CRUD Alimentos
    public Alimentos createAlimento() {
        System.out.println("Opção: Cadastrar Alimento");
        System.out.println("Digite os informacoes do Alimento:");
        System.out.print("Nome do Alimento: ");
        String nomeAlim = sc.nextLine();
        System.out.print("Carboidrato (g): ");
        int carboidrato = Integer.parseInt(sc.nextLine());
        System.out.print("Proteína (g): ");
        int proteina = Integer.parseInt(sc.nextLine());
        System.out.print("Gordura (g): ");
        int gordura = Integer.parseInt(sc.nextLine());
        System.out.print("Calorias: ");
        double calorias = Double.parseDouble(sc.nextLine());
        System.out.print("Porção (g): ");
        int porcao = Integer.parseInt(sc.nextLine());
        int idAlim = 0;
        // Criar um objeto Alimento com os valores fornecidos pelo usuário
        Alimentos alimento = new Alimentos(idAlim, nomeAlim, carboidrato, proteina, gordura, calorias, porcao);
        return alimento;
    }

    public int buscaIdAlim(Alimentos[] arrAlimentos) {
        System.out.println("Editar alimento");
        System.out.println("Digite o id do alimento que deseja editar");
        int idAlim = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < arrAlimentos.length; i++) {
            if (arrAlimentos[i] != null && idAlim == arrAlimentos[i].getId()) {
                return idAlim;
            }
        }
        return -1;
    }

    public Alimentos editAlimento(Alimentos[] arrAlimentos, int idAlim) {
        System.out.println("Informe o novo nome do alimento: ");
        String novoNome = sc.nextLine();
        System.out.print("Informe a quantidade de carboidratos: ");
        int novoCarboidrato = Integer.parseInt(sc.nextLine());
        System.out.print("Informe a quantidade de proteínas: ");
        int novoProteina = Integer.parseInt(sc.nextLine());
        System.out.print("Informe a quantidade de gorduras: ");
        int novoGordura = Integer.parseInt(sc.nextLine());
        System.out.print("Informe as calorias: ");
        double novoCalorias = Double.parseDouble(sc.nextLine());
        System.out.print("Informe a porção: ");
        int novoPorcao = Integer.parseInt(sc.nextLine());
        Alimentos alimEdit = new Alimentos(idAlim, novoNome, novoCarboidrato, novoProteina, novoGordura, novoCalorias, novoPorcao);
        return alimEdit;
    }

    public int removeAlim(Alimentos[] arrAlimentos) {
        System.out.println("Excluir alimento");
        int remAlim = buscaIdAlim(arrAlimentos);
        return remAlim;
    }

    //CRUD Avaliação Física
    public AvaliacaoFisica createAvFisica(Pessoa usuarioLogado) {
        System.out.println("1. Fazer Avaliação Física");
        System.out.println("Avaliação Física de " + usuarioLogado.getNome());
        Program.limparTela();
        System.out.print("Informe o peso(kg): ");
        double peso = Double.parseDouble(sc.nextLine());
        System.out.print("Informe a altura(cm): ");
        double altura = Double.parseDouble(sc.nextLine());;
        System.out.print("Informe a idade: ");
        int idade = Integer.parseInt(sc.nextLine());
        System.out.print("Informe a medida do pescoço(cm): ");
        double pescoco = Double.parseDouble(sc.nextLine());
        System.out.print("Informe a medida da cintura(cm): ");
        double cintura = Double.parseDouble(sc.nextLine());
        System.out.print("Informe a medida do quadril(cm): ");
        double quadril = Double.parseDouble(sc.nextLine());
        System.out.println("Quantas vezes você faz exercícios por semana?");
        double vezesExercicios = Double.parseDouble(sc.nextLine());
        int idAf = 0;
        AvaliacaoFisica avFisica = new AvaliacaoFisica(idAf, usuarioLogado, peso, altura, idade, pescoco, cintura, quadril, vezesExercicios, LocalDate.now(), LocalDate.now());
        return avFisica;
    }

    public int buscaIdAvFis(AvaliacaoFisica[] arrAvFisica) {
        System.out.println("Digite o id do avaliação física: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < arrAvFisica.length; i++) {
            if (arrAvFisica[i] != null && id == arrAvFisica[i].getId()) {
                return id;
            }
        }
        return -1;
    }

    //CRUD TIPO DE DIETA
    public int escolherTipoDeDieta() {
        System.out.println("Escolha um tipo de dieta: ");
        System.out.println("1. Dieta Equilibrada.");
        System.out.println("2. Dieta Low Carb.");
        System.out.println("3. Dieta Cetogênica.");
        int tdieta = Integer.parseInt(sc.nextLine());
        return tdieta;
    }

    public int buscarIdTipoDieta() {
        System.out.println("Informe o id do tipo de dieta: ");
        int id = Integer.parseInt(sc.nextLine());
        return id;
    }

    //CRUD DIETA
    public Dieta criarDieta(AvaliacaoFisica avFisica, Pessoa usuarioLogado, TipoDeDieta tipoDieta) {
        System.out.println("Qual o seu objetivo? : ");
        System.out.println("1. Diminuir o peso.");
        System.out.println("2. Manter o peso.");
        System.out.println("3. Melhorar composição corporal.");
        System.out.println("4. Aumentar o peso.");
        int obj = Integer.parseInt(sc.nextLine());
        String objetivo = "Indefinido";
        double caloriasDieta = 0;
        switch (obj) {
            case 1:
                caloriasDieta = avFisica.TaxaMetabolica(avFisica) - 500;
                objetivo = "Diminuir o peso";
                break;
            case 2:
                caloriasDieta = avFisica.TaxaMetabolica(avFisica);
                objetivo = "Manter o peso";
                break;
            case 3:
                caloriasDieta = avFisica.TaxaMetabolica(avFisica) + 200;
                objetivo = "Melhorar composição corporal";
                break;
            case 4:
                caloriasDieta = avFisica.TaxaMetabolica(avFisica) + 500;
                objetivo = "Aumentar o peso";
        }
        System.out.println("Informe o número de refeições: ");
        int nroRefeicoes = Integer.parseInt(sc.nextLine());
        Dieta dieta = new Dieta(usuarioLogado, avFisica, tipoDieta, objetivo, caloriasDieta, nroRefeicoes);
        return dieta;
    }
    
    public int buscarIdDieta(){
        System.out.println("Informe o id da dieta: ");
        int idEdit = Integer.parseInt(sc.nextLine());
        return idEdit;
    }

    //CRUD REFEIÇÕES
    public String nomeRefeicao() {
        System.out.println("Informe o nome da refeição: ");
        String nomeRef = sc.nextLine();
        return nomeRef;
    }

    public int idRefeicao() {
        System.out.println("Informe o id da refeição: ");
        int idRef = Integer.parseInt(sc.nextLine());
        return idRef;
    }

    //CRUD ALIMENTOS/REFEICOES
    public int buscaIdRefeicao() {
        System.out.println("Informe o id da refeição: ");
        int id = Integer.parseInt(sc.nextLine());
        return id;
    }

    //CRUD POST
    public String escreverPost() {
        System.out.println("1. Escrever Post");
        System.out.println("Digite o conteúdo da post: ");
        String mensagem = sc.nextLine();
        return mensagem;
    }

    public int buscarIdPost() {
        int idEdit = Integer.parseInt(sc.nextLine());
        return idEdit;
    }

    //CRUD Seguir
    public int buscaIdSeguir(Seguir[] arrSeguindo) {
        System.out.println("1. Seguir Alguém");
        System.out.println("Informe o id da pessoa que deseja seguir: ");
        int encId = Integer.parseInt(sc.nextLine());
        return encId;
    }
    
    //CRUD Mensagem
    public int buscarSeguidores(SeguirDAO seguidores, Pessoa usuarioLogado){
        System.out.println("Informe o id da pessoa que deseja enviar mensagem: ");
        int idSeguidor = Integer.parseInt(sc.nextLine());
        return idSeguidor;
    }
    
    public int buscarIdMensagem(){
        System.out.println("Informe o id da mensagem: ");
        int idMsgEdit = Integer.parseInt(sc.nextLine());
        return idMsgEdit;
    }
}
