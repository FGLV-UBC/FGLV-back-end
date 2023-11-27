/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.negocio;

import com.aplicacaomodelo.core.interfaces.IStrategy;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;

/**
 *
 * @author autologon
 */
public class ValidarNomeGarcom implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
        StringBuilder sb = new StringBuilder();

        Garcom garcom = (Garcom)entidade;
        
        
        if(garcom.getNome().isEmpty()){
            sb.append("O campo nome não foi preenchido");
        }
        else if(garcom.getNome().length() < 3) {
            sb.append("O campo nome é inválido");
        }
        
        if(!sb.toString().isEmpty()){
            return sb.toString();
        }else{
            return null;
        }
        
        
    }
    
}