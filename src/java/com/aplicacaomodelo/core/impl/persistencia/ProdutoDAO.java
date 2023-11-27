/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.domain.Categoria;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;
import com.aplicacaomodelo.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Caio Gustavo
 */
public class ProdutoDAO extends AbstractJdbcDAO{

    public ProdutoDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public ProdutoDAO(String table, String idTable) {
        super("TB_PRODUTO", "ID");
    }
    public ProdutoDAO(Connection cx){
        super(cx, "TB_PRODUTO", "ID");
    }
    public ProdutoDAO(){
        super("TB_PRODUTO", "ID");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Produto p = (Produto) entidade;


        try{

            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_PRODUTO(nome, descricao, valor, categoria, dt_cadastro)");
            sql.append("VALUES (?,?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, p.getNome());
            pst.setString(2, p.getDescricao());
            pst.setDouble(3, p.getValor());
            
            try{
                Categoria categorias = Categoria.valueOf(p.getCategoria());
                pst.setString(4, p.getCategoria());
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }
            
            //pst.setString(4, p.getCategoria());// debugar isso aqui

            

            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(5, ts);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idProduto=0;

            if(rs.next()){
                idProduto = rs.getInt(1);
            }

            p.setId(idProduto);

            connection.commit();




        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        EntidadeDominio entidade2 = entidade;
        Produto p = (Produto) entidade;


        try{

            connection.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TB_PRODUTO set nome = ?, descricao = ?, valor = ?, categoria = ? WHERE id = ?");
            pst = connection.prepareStatement(sql.toString());

                
            pst.setString(1, p.getNome());
            pst.setString(2, p.getDescricao());
            pst.setDouble(3, p.getValor());
            pst.setString(4, p.getCategoria());
            pst.setInt(5, p.getId());


            //ResultSet rs = pst.executeQuery();

            pst.executeUpdate();

            //pst.getGeneratedKeys();
            
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        
        
    }
    
    

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        if(connection == null){
            openConnection();
        }
        PreparedStatement ps = null;
        
        List<EntidadeDominio> produtos = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_produto ORDER BY categoria";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setValor(rs.getDouble("valor"));
                p.setCategoria(rs.getString("categoria"));

                
                produtos.add(p);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                if(ctrlTransaction){
                    connection.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return produtos;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        /*if(connection == null){
            openConnection(); 
        }
        Produto produto = (Produto) entidade;
        produto.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_produto WHERE nome=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setLogin(rs.getString("login"));
                
                                
                
             
            }else{
                
            
            }
                       
            ps.close();
            rs.close();
            if(ctrlTransaction){
                connection.close();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
        return null;
    }
}
