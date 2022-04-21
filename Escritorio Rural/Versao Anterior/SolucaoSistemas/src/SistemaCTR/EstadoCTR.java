/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.EstadoDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class EstadoCTR {
    ResultSet rs = null;
    public ResultSet ConsultarEstadoCTR(){
        try {
            EstadoDAO objestadoDAO = new EstadoDAO();
            
            rs = objestadoDAO.ConsultarEstadoDAO();
            return rs;
        } catch (Exception e) {
            return rs;            
        }
    }
}
