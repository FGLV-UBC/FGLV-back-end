/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aplicacaomodelo.core.impl.persistencia;

import com.aplicacaomodelo.domain.EntidadeDominio;
import com.aplicacaomodelo.domain.Garcom;
import com.aplicacaomodelo.domain.Pessoa;
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
public class GarcomDAO extends AbstractJdbcDAO{

    public GarcomDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public GarcomDAO(String table, String idTable) {
        super("TB_GARCOM", "TB_GARCOM");
    }
    public GarcomDAO(Connection cx){
        super(cx, "TB_GARCOM", "TB_GARCOM");
    }
    public GarcomDAO(){
        super("TB_GARCOM", "TB_GARCOM");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {

        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        Garcom g = (Garcom) entidade;


        try{

            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_GARCOM(login, senha, nome, dt_cadastro)");
            sql.append("VALUES (?,?,?,?)");


            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, g.getLogin());
            pst.setString(2, g.getSenha());
            pst.setString(3, g.getNome());

            Calendar calendar = Calendar.getInstance();

            Timestamp ts =  new Timestamp(calendar.getTime().getTime());

            pst.setTimestamp(4, ts);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            int idGarcom=0;

            if(rs.next()){
                idGarcom = rs.getInt(1);
            }

            g.setId(idGarcom);

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        if(connection == null){
            openConnection();
        }
        PreparedStatement ps = null;
        
        List<EntidadeDominio> garcons = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM tb_garcom";
            
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Garcom g = new Garcom();
                
                g.setId(rs.getInt("id_garcom"));
                g.setNome(rs.getString("nome"));
                g.setLogin(rs.getString("login"));
                g.setSenha(rs.getString("senha"));

                
                garcons.add(g);
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
        return garcons;
    }

    @Override
    public EntidadeDominio visualizar(EntidadeDominio entidade) throws SQLException {
        
        if(connection == null){
            openConnection(); 
        }
        Garcom garcom = (Garcom) entidade;
        garcom.setId(0);
        try {
            
            PreparedStatement ps;            
            String sql = "SELECT * FROM tb_garcom WHERE nome=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, garcom.getNome());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                garcom.setId(rs.getInt("id_garcom"));
                garcom.setNome(rs.getString("nome"));
                garcom.setLogin(rs.getString("login"));
                
                                
                
             
            }
                       
            ps.close();
            rs.close();
            if(ctrlTransaction){
                connection.close();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return garcom;
    } 
}
