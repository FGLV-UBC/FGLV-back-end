/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.controle;

import com.aplicacaomodelo.core.aplicacao.Resultado;
import com.aplicacaomodelo.core.impl.negocio.ValidarNomeGarcom;
import com.aplicacaomodelo.core.impl.persistencia.GarcomDAO;
import com.aplicacaomodelo.core.impl.persistencia.ProdutoDAO;
import com.aplicacaomodelo.core.interfaces.IDAO;
import com.aplicacaomodelo.core.interfaces.IFachada;
import com.aplicacaomodelo.core.interfaces.IStrategy;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;
import com.aplicacaomodelo.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Caio Gustavo
 */
public class Fachada implements IFachada {

    /**
     * Mapa de DAOS, será indexado pelo nome da entidade O valor é uma instância
     * do DAO para uma dada entidade;
     */
    private Map<String, IDAO> daos;

    /**
     * Mapa para conter as regras de negócio de todas operações por entidade; O
     * valor é um mapa que de regras de negócio indexado pela operação
     */
    private Map<String, Map<String, List<IStrategy>>> rns;

    private Resultado resultado;

    public Fachada() {
        /* Intânciando o Map de DAOS */
        daos = new HashMap<String, IDAO>();
        /* Intânciando o Map de Regras de Negócio */
        rns = new HashMap<String, Map<String, List<IStrategy>>>();
        
        /* Criando instâncias dos DAOs a serem utilizados*/
        GarcomDAO garcomDAO = new GarcomDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        daos.put(Garcom.class.getName(), garcomDAO);
        daos.put(Produto.class.getName(), produtoDAO);

        
        //Instancia o mapa de validacoes da entitade garcom
        Map<String, List<IStrategy>> rnsGarcom = new HashMap<>();
        
        //Instancia a lista de validações especificas da operacao de salvar
        List<IStrategy> rnsSalvarGarcom = new ArrayList<>();
        
        //Instancia a validação de nome do garçom
        ValidarNomeGarcom validarNomeGarcom = new ValidarNomeGarcom();
        
        //Adiciona a validação de nome na lista de validações de salvar
        rnsSalvarGarcom.add(validarNomeGarcom);
        
        //Mapeia a lista de validações da operacao de salvar
        rnsGarcom.put("SALVAR", rnsSalvarGarcom);
        
        //Adiciona o mapa de validações do garcom nos mapas de regras de negocio
        rns.put(Garcom.class.getName(), rnsGarcom);
        
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        
        String msg = executarRegras(entidade, "SALVAR");
        
        if(msg == null){
            //IDAO dao = daos.get(nmClass);
            IDAO dao = daos.get(nmClasse);
            try{
                dao.salvar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
                
            } catch(SQLException e){
            
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar o registro!");
            
            }
            
        
        }
        else{
            resultado.setMsg(msg);
        }
        
        return resultado;
    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        
        String msg = executarRegras(entidade, "ALTERAR");
        
        if(msg == null){
            //IDAO dao = daos.get(nmClass);
            IDAO dao = daos.get(nmClasse);
            try{
                dao.alterar(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.add(entidade);
                resultado.setEntidades(entidades);
                
                
            } catch(SQLException e){
            
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a atualização!");
            
            }
            
        
        }
        else{
            resultado.setMsg(msg);
        }
        
        return resultado;
        
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();
        
        String msg = executarRegras(entidade, "EXCLUIR");
        
        if(msg == null){
            //IDAO dao = daos.get(nmClass);
            IDAO dao = daos.get(nmClasse);
            try{
                dao.excluir(entidade);
                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
                entidades.remove(entidade);
                resultado.setEntidades(entidades);
                
                
            } catch(SQLException e){
            
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a atualização!");
            
            }
            
        
        }
        else{
            resultado.setMsg(msg);
        }
        
        return resultado;
        
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        String msg = executarRegras(entidade, "CONSULTAR");

        if (msg == null) {

            IDAO dao = daos.get(nmClasse);

            try {

                resultado.setEntidades(dao.consultar(entidade));

            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a consulta!");

            }
        } else {
            resultado.setMsg(msg);
        }
        return resultado;
    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();	

        String msg = executarRegras(entidade, "VISUALIZAR");
        
        if(msg == null){
            IDAO dao = daos.get(nmClasse);

            try {
                List<EntidadeDominio> es = new ArrayList<>();
                es.add(dao.visualizar(entidade));
                resultado.setEntidades(es);
            } catch (SQLException e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a consulta!");

            }
        }else{
            resultado.setMsg(msg);
        }
        return resultado;
    }

    private String executarRegras(EntidadeDominio entidade, String operacao) {
        String nmClasse = entidade.getClass().getName();
        StringBuilder msg = new StringBuilder();

        Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);

        if (regrasOperacao != null) {
            List<IStrategy> regras = regrasOperacao.get(operacao);
            if (regras != null) {
                for (IStrategy s : regras) {
                    String m = s.processar(entidade);

                    if (m != null) {
                        msg.append(m);
                        msg.append("\n");
                    }
                }
            }
        }
        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return null;
        }
    }

}