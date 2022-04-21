/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.ProfissaoDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class ProfissaoCTR {
    ProfissaoDAO objprofissaoDAO = new ProfissaoDAO();
    ResultSet rs;
    public boolean CadastrarProfissaoCTR(String descricao){
        try {
            objprofissaoDAO.setDescricao(descricao);
            objprofissaoDAO.CadastrarProfissaoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarProfissaoDAO "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarProfissaoCTR(String... parametros){
        try {
            objprofissaoDAO.setDescricao(parametros[0]);
            objprofissaoDAO.setCodigo(parametros[1]);
            objprofissaoDAO.AlterarProfissaoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarProfissaoDAO "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarProfissaoCTR(String... parametros){
        try {
            objprofissaoDAO.setCodigo(parametros[0]);
            objprofissaoDAO.setDescricao(parametros[1]);
            
            rs = objprofissaoDAO.ConsultarProfissaoDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarProfissaoDAO "+e.getMessage());
            return rs;
        }
    }
}
