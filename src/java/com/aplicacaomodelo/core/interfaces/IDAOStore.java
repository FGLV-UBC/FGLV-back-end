/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aplicacaomodelo.core.interfaces;

import com.aplicacaomodelo.domain.EntidadeDominio;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public interface IDAOStore {
    
        public int salvarEReturnId (EntidadeDominio entidade) throws SQLException;

    
}
