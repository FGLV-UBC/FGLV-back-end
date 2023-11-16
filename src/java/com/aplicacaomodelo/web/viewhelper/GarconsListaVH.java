/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.web.viewhelper;

/**
 *
 * @author autologon
 */

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;
import com.aplicacaomodelo.domain.Pessoa;
import com.aplicacaomodelo.web.interfaces.IViewHelper;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caio Gustavo
 */
public class GarconsListaVH implements IViewHelper {

    @Override
public EntidadeDominio getEntidade(HttpServletRequest request) {
    String nome = request.getParameter("nome");
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");
    String dtCadastroString = request.getParameter("dtCadastro");

    Garcom garcom = new Garcom();

    garcom.setNome(nome);
    garcom.setLogin(login);
    garcom.setSenha(senha);

    


    return garcom;
}

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("listaGarcons", resultado.getEntidades());

        request.getRequestDispatcher("admHome.jsp").forward(request, response);

    }

}