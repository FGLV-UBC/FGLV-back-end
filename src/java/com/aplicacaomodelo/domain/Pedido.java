/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.domain;

/**
 *
 * @author USER
 */
public class Pedido extends EntidadeDominio{
    
    private int id_mesa;
    private boolean pedidoPronto = false;
    private boolean pedidoFeito = false;
    
    public Pedido(){}

    public Pedido(int id_mesa,  boolean pedidoPronto, boolean pedidoFeito) {
        this.id_mesa = id_mesa;
        this.pedidoPronto = pedidoPronto;
        this.pedidoFeito = pedidoFeito;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public boolean isPedidoPronto() {
        return pedidoPronto;
    }

    public void setPedidoPronto(boolean pedidoPronto) {
        this.pedidoPronto = pedidoPronto;
    }

    public boolean isPedidoFeito() {
        return pedidoFeito;
    }

    public void setPedidoFeito(boolean pedidoFeito) {
        this.pedidoFeito = pedidoFeito;
    }
    
    
    
    
    
}
