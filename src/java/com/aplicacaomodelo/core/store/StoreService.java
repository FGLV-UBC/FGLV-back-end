/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.store;

/**
 *
 * @author USER
 */
public class StoreService {
    
    private static int pedidoAtual = -1;
    private static int mesaAtual = -1;

    
    public static int getPedidoAtual(){
        return pedidoAtual;
    }
    
    public static void setPedidoAtual(int id){
        pedidoAtual = id;
    
    }
    
    public static int getMesaAtual(){
        return mesaAtual;
    }
    
    public static void setMesaAtual(int id){
        mesaAtual = id;
    
    }
    
    
}
