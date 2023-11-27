/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.domain;

/**
 *
 * @author USER
 */
public class Mesa extends EntidadeDominio{
    
    private int id_garcom;
    private String qrcode;
    private double valorTotal;
    private boolean mesaPaga;
    
    public Mesa(){}

    public Mesa(int i, int id_garcom, String qrcode, double valorTotal, boolean mesaPaga) {
        setId(i);
        this.id_garcom = id_garcom;
        this.qrcode = qrcode;
        this.valorTotal = valorTotal;
        this.mesaPaga = mesaPaga;
    }

    public int getId_garcom() {
        return id_garcom;
    }

    public void setId_garcom(int id_garcom) {
        this.id_garcom = id_garcom;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isMesaPaga() {
        return mesaPaga;
    }

    public void setMesaPaga(boolean mesaPaga) {
        this.mesaPaga = mesaPaga;
    }
    
    
    
}
