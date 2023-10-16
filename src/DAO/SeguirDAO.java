/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Pessoa;
import Classes.Post;
import Classes.Seguir;
import java.time.LocalDate;
import java.util.Scanner;

public class SeguirDAO {

    Seguir[] arraySeguindo = new Seguir[50];

    public SeguirDAO() {
    }

    public Seguir[] getSeguir() {
        return arraySeguindo;
    }

    public Pessoa seguirPessoa(Pessoa usuarioLogado, Pessoa p1) {
        for (int i = 0; i < arraySeguindo.length; i++) {
            if (arraySeguindo[i] == null) {
                Seguir seguir = new Seguir();
                seguir.setOrigem(usuarioLogado);
                seguir.setId(i);
                seguir.setSeguindo(p1);
                seguir.setDataCriacao(LocalDate.now());
                seguir.setDataModificacao(LocalDate.now());
                arraySeguindo[i] = seguir;

                p1.adicionarSeguidor(usuarioLogado);
                return seguir.getSeguindo();
            }
        }
        return null;
    }

    public Seguir[] getSeguidoresQueUsuarioSegue(Pessoa usuarioLogado) {
        Seguir[] seguidoresQueUsuarioSegue = new Seguir[arraySeguindo.length];
        int count = 0;

        for (Seguir seguir : arraySeguindo) {
            if (seguir != null && seguir.getOrigem() == usuarioLogado) {
                seguidoresQueUsuarioSegue[count] = seguir;
                count++;
            }
        }
        return seguidoresQueUsuarioSegue;
    }

    public void imprimirArraySeguidores(Seguir[] arrSeguindo, Pessoa usuarioLogado) {
        System.out.println("\nLista de pessoas que " + usuarioLogado.getNome() + " segue\n");
        for (Seguir seguir : arrSeguindo) {
            if (seguir != null && seguir.getOrigem() == usuarioLogado) {
                System.out.println(seguir.toString());
            }
        }
    }
    


    
}
