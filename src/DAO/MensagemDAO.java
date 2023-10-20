/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Mensagens;
import Classes.Pessoa;
import java.time.LocalDate;
import java.util.Scanner;

public class MensagemDAO {

    Mensagens[] arrayMensagem = new Mensagens[100];

    public MensagemDAO() {
    }

    public Mensagens[] getArrayMensagem() {
        return arrayMensagem;
    }

    public void setArrayMensagem(Mensagens[] arrayMensagem) {
        this.arrayMensagem = arrayMensagem;
    }

    public Mensagens enviarMensagem(int idSeguidor, Pessoa usuarioLogado, Pessoa[] arrayPessoa) {
        Scanner sc = new Scanner(System.in);
        String mensagem = "";
        for (int i = 0; i < arrayMensagem.length; i++) {
            if (arrayMensagem[i] == null) {
                System.out.println("Digite a mensagem: ");
                arrayMensagem[i] = new Mensagens();
                mensagem = sc.nextLine();
                arrayMensagem[i].setId(i);
                arrayMensagem[i].setPessoaOrigem(usuarioLogado);
                arrayMensagem[i].setPessoaDestino(arrayPessoa[idSeguidor]);
                arrayMensagem[i].setMensagem(mensagem);
                arrayMensagem[i].setDataCriacao(LocalDate.now());
                arrayMensagem[i].setDataModificacao(LocalDate.now());
                
                return arrayMensagem[i];
            }
        }
        return null;
    }

    public void editarMensagem(int idMsgEdit) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editar mensagem: ");
        String msgEditada = sc.nextLine();
        arrayMensagem[idMsgEdit].setMensagem(msgEditada);
        arrayMensagem[idMsgEdit].setDataModificacao(LocalDate.now());
    }
    
    public void excluirMensagem(int idMSgRemove){
        arrayMensagem[idMSgRemove] = null;
    }

    public void imprimirArrayMensagens(Mensagens[] arrayMensagens) {
        for (Mensagens arrayMensagen : arrayMensagens) {
            if (arrayMensagen != null) {
                System.out.println(arrayMensagen.toString());
            }
        }
    }
}
