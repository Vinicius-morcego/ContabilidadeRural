/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.LogradouroDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class LogradouroCTR {
    LogradouroDAO objLogradouroDAO = new LogradouroDAO();
    ResultSet rs;
    public boolean CadastrarLogradouroCTR(String descricao){
        try {
            objLogradouroDAO.setDescricao(descricao);
            objLogradouroDAO.CadastrarLogradouroDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarLogradouroCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarLogradouroCTR(String descricao){
        try {
            objLogradouroDAO.setDescricao(descricao);
            rs = objLogradouroDAO.ConsultarLogradouroDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarLogradouroCTR "+e.getMessage());
            return rs;
        }
    }
}
