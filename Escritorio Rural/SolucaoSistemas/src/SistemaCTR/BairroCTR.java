/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.BairroDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class BairroCTR {
    BairroDAO objbairroDAO = new BairroDAO();
    ResultSet rs;
    public boolean CadastrarBairroCTR(String... parametros){
        try {
            objbairroDAO.setNome(parametros[0]);
            objbairroDAO.CadastrarBairroDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarBairroCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarBairroCTR(String... parametros){
        try {
            objbairroDAO.setNome(parametros[0]);
            objbairroDAO.setCodigo(parametros[1]);
            objbairroDAO.AlterarBairroDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarBairroCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarBairroCTR(String... parametros){
        try {
            objbairroDAO.setCodigo(parametros[0]);
            objbairroDAO.setNome(parametros[1]);
            rs = objbairroDAO.ConsultarBairroDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarBairroCTR "+e.getMessage());
            return rs;
        }
    }
}
