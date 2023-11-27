/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.domain;

/**
 *
 * @author USER
 */
public class Produto extends EntidadeDominio{
    
    private String nome;
    private String descricao;
    private double valor;
    private String categoria;
    
    public Produto(){}
    
    public Produto(int i, String nome, String descricao, double valor, String categoria) {
        setId(i);
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;  
        this.categoria = categoria;  

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    
    

    
    
}
