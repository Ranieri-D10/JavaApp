/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Classes.AvaliacaoFisica;
import java.time.LocalDate;


public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] arrayAvFisica = new AvaliacaoFisica[5];

    public AvaliacaoFisicaDAO() {
    }
    
    
    public boolean criarAvaliacaoFisica(AvaliacaoFisica avFisica){
        for (int i = 0; i < arrayAvFisica.length; i++) {
            if(arrayAvFisica[i] == null){
                arrayAvFisica[i] = avFisica;
                arrayAvFisica[i].setId(i);
                arrayAvFisica[i].setDataCriacao(LocalDate.now());
                arrayAvFisica[i].setdataModificacao(LocalDate.now());
                return true;
            }
        }
        return false;
    }
    
    
}
