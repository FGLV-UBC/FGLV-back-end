/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.core.interfaces.IDAOStore;
import com.aplicacaomodelo.core.store.StoreService;
import com.aplicacaomodelo.domain.EntidadeDominio;
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
public class PedidoDAO extends AbstractJdbcDAO implements IDAOStore{
    
    public PedidoDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public PedidoDAO(String table, String idTable) {
        super("TB_PEDIDO", "ID");
    }
    public PedidoDAO(Connection cx){
        super(cx, "TB_PEDIDO", "ID");
    }
    public PedidoDAO(){
        super("TB_PEDIDO", "ID");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Pedido p = (Pedido) entidade;


        try{

            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_PEDIDO(id_mesa, pedido_pronto, pedido_feito, dt_cadastro)");
            sql.append("VALUES (?,?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, p.getId_mesa());
            pst.setBoolean(2, p.isPedidoPronto());
            pst.setBoolean(3, p.isPedidoFeito());


            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(4, ts);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idPedido=0;

            if(rs.next()){
                idPedido = rs.getInt(1);
            }

            p.setId(idPedido);
            StoreService.setPedidoAtual(idPedido);

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
        Pedido p = (Pedido) entidade;


        try{

            connection.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TB_PEDIDO set pedido_pronto = ?, pedido_feito = ?, valor_total_pedido = ? WHERE id = ?");
            pst = connection.prepareStatement(sql.toString());

                
            pst.setBoolean(1, p.isPedidoPronto());
            pst.setBoolean(2, p.isPedidoFeito());
            pst.setInt(3, p.getId());

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
        
        List<EntidadeDominio> pedidos = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_pedido";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Pedido p = new Pedido();
                
                p.setId(rs.getInt("id"));
                p.setId_mesa(rs.getInt("id_mesa"));
                p.setPedidoFeito(rs.getBoolean("pedido_feito"));
                p.setPedidoPronto(rs.getBoolean("pedido_pronto"));
                
                pedidos.add(p);
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
        return pedidos;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection(); 
        }
        Pedido pedido = (Pedido) entidade;
        pedido.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_pedido WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pedido.getId());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                pedido.setId(rs.getInt("id"));
                pedido.setId_mesa(rs.getInt("id_mesa"));
                pedido.setPedidoFeito(rs.getBoolean("pedido_feito"));
                pedido.setPedidoPronto(rs.getBoolean("pedido_pronto"));
             
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
        
        return pedido;
    } 

    @Override
    public int salvarEReturnId(EntidadeDominio entidade) throws SQLException {
        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Pedido p = (Pedido) entidade;


        try{

            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_PEDIDO(id_mesa, pedido_pronto, pedido_feito, dt_cadastro)");
            sql.append("VALUES (?,?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, p.getId_mesa());
            pst.setBoolean(2, p.isPedidoPronto());
            pst.setBoolean(3, p.isPedidoFeito());


            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(4, ts);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idPedido=0;

            if(rs.next()){
                idPedido = rs.getInt(1);
            }

            p.setId(idPedido);

            connection.commit();
            
            return idPedido;



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
      return -2;  
    }
    
    
    
}
