/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.core.store.StoreService;
import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Mesa;
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
public class MesaDAO  extends AbstractJdbcDAO{
    
    public MesaDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public MesaDAO(String table, String idTable) {
        super("TB_MESA", "ID");
    }
    public MesaDAO(Connection cx){
        super(cx, "TB_MESA", "ID");
    }
    public MesaDAO(){
        super("TB_MESA", "ID");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Mesa m = (Mesa) entidade;


        try{

            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_MESA(id_garcom, qrcode, valor_total, mesaPaga, dt_cadastro)");
            sql.append("VALUES (?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, m.getId_garcom());
            pst.setString(2, m.getQrcode());
            pst.setDouble(3, m.getValorTotal());
            pst.setBoolean(4, m.isMesaPaga());

            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(5, ts);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idMesa=0;

            if(rs.next()){
                idMesa = rs.getInt(1);
            }

            m.setId(idMesa);
            

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
        Mesa m = (Mesa) entidade;


        try{

            connection.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE TB_MESA set id_garcom = ?, qrcode = ?, valor_total = ?, mesa_paga = ? WHERE id_mesa = ?");
            pst = connection.prepareStatement(sql.toString());

                
            pst.setInt(1, m.getId_garcom());
            pst.setString(2, m.getQrcode());
            pst.setDouble(3, m.getValorTotal());
            pst.setBoolean(4, m.isMesaPaga());
            pst.setInt(4, m.getId());

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
        
        List<EntidadeDominio> mesas = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_mesa";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Mesa m = new Mesa();
                
                m.setId(rs.getInt("id"));
                m.setId(rs.getInt("id_garcom"));
                m.setQrcode(rs.getString("qrcode"));
                m.setValorTotal(rs.getDouble("valor_total"));
                m.setMesaPaga(rs.getBoolean("mesa_paga"));
                
                mesas.add(m);
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
        return mesas;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection(); 
        }
        Mesa mesa = (Mesa) entidade;
        mesa.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_mesa WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, mesa.getId());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                mesa.setId(rs.getInt("id"));
                mesa.setId_garcom(rs.getInt("id_garcom"));
                mesa.setQrcode(rs.getString("qrcode"));
                mesa.setValorTotal(rs.getDouble("valor_total"));
                mesa.setMesaPaga(rs.getBoolean("mesa_paga"));

             
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
        
        return mesa;
    } 
    
}
