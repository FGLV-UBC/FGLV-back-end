/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.domain;

/**
 *
 * @author USER
 */
public class ItemPedido extends EntidadeDominio{
    
    private int id_pedido;
    private String nome;
    private double valor;
    private String categoria;
    private int quantidade;
    
    public ItemPedido(){}

    public ItemPedido(int i, int id_pedido, String nome, double valor, String categoria, int quantidade) {
        setId(i);
        this.id_pedido = id_pedido;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
