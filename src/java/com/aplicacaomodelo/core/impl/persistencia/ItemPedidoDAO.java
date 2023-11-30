/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.core.store.StoreService;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.ItemPedido;
import com.aplicacaomodelo.domain.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author USER
 */
public class ItemPedidoDAO extends AbstractJdbcDAO{
    
    public ItemPedidoDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public ItemPedidoDAO(String table, String idTable) {
        super("TB_ITEM_PEDIDO", "ID");
    }
    public ItemPedidoDAO(Connection cx){
        super(cx, "TB_ITEM_PEDIDO", "ID");
    }
    public ItemPedidoDAO(){
        super("TB_ITEM_PEDIDO", "ID");
    }
    
    PedidoDAO pedidoDAO = new PedidoDAO();

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        ItemPedido itemPedido = (ItemPedido) entidade;


        try{

            int pedidoAtual = StoreService.getPedidoAtual();
            //StoreService.setMesaAtual(); Setar a mesa com base no URL Param do id da mesa
            StoreService.setMesaAtual(1); 
            int mesaAtual = StoreService.getMesaAtual();
            
            if (pedidoAtual == -1) {
                Pedido novaEntidade = new Pedido();
                novaEntidade.setId_mesa(mesaAtual);
                
                pedidoDAO.salvar(novaEntidade);
                pedidoAtual = StoreService.getPedidoAtual();
            }
            if(pedidoAtual == -2){
                //Implementar erro ao salvar e retornar id
            }
            
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_ITEM_PEDIDO(nome, valor, categoria, quantidade, dt_cadastro, id_pedido)");
            sql.append("VALUES (?,?,?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            //pst.setInt(1, itemPedido.getId_pedido());
            pst.setString(1, itemPedido.getNome());
            pst.setDouble(2, itemPedido.getValor());
            pst.setString(3, itemPedido.getCategoria());
            pst.setInt(4, itemPedido.getQuantidade());


            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(5, ts);
            pedidoAtual = StoreService.getPedidoAtual(); 
            pst.setInt(6, pedidoAtual);


            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idItemPedido=0;

            if(rs.next()){
                idItemPedido = rs.getInt(1);
            }

            itemPedido.setId(idItemPedido);

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
         
        //Atrelar pedido ao item_pedido
        
        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        EntidadeDominio entidade2 = entidade;
        ItemPedido itemPedido = (ItemPedido) entidade;


        try{

            connection.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TB_ITEM_PEDIDO set id_pedido = ? WHERE id = ?");
            pst = connection.prepareStatement(sql.toString());

                
            pst.setInt(1, itemPedido.getId_pedido());
            pst.setInt(4, itemPedido.getId());

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
        
        List<EntidadeDominio> itensPedido = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_item_pedido";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ItemPedido itemPedido = new ItemPedido();
                
                itemPedido.setId(rs.getInt("id"));
                itemPedido.setId_pedido(rs.getInt("id_pedido"));
                itemPedido.setNome(rs.getString("nome"));
                itemPedido.setValor(rs.getDouble("valor"));
                itemPedido.setCategoria(rs.getString("categoria"));
                itemPedido.setQuantidade(rs.getInt("quantidade"));

                itensPedido.add(itemPedido);
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
        return itensPedido;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection(); 
        }
        ItemPedido itemPedido = (ItemPedido) entidade;
        itemPedido.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_item_pedido WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, itemPedido.getId());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                itemPedido.setId(rs.getInt("id"));
                itemPedido.setId_pedido(rs.getInt("id_pedido"));
                itemPedido.setNome(rs.getString("nome"));
                itemPedido.setValor(rs.getDouble("valor"));
                itemPedido.setCategoria(rs.getString("categoria"));
                itemPedido.setQuantidade(rs.getInt("quantidade"));
                
                                
                
             
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
        
        return itemPedido;
    } 
    
}
