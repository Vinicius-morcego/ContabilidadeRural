/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.PlanoContasDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class PlanoContasCTR {
    PlanoContasDAO objplanoDAO = new PlanoContasDAO();
    ResultSet rs;
    public boolean CadastrarPlanoContasCTR(String... parametros){
        try {
            objplanoDAO.setNome(parametros[0]);
            objplanoDAO.setTipo(parametros[1]);
            objplanoDAO.CadastrarPlanoContasDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarPlanoContasCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarPlanoContasCTR(String... parametros){
        try {
            objplanoDAO.setNome(parametros[0]);
            objplanoDAO.setTipo(parametros[1]);
            objplanoDAO.setCodigo(parametros[2]);
            objplanoDAO.AlterarPlanoContasDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarPlanoContasCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarPlanoContasCTR(String... parametros){
        try {
            objplanoDAO.setCodigo(parametros[0]);
            objplanoDAO.setNome(parametros[1]);
            objplanoDAO.setTipo(parametros[2]);
            rs = objplanoDAO.ConsultarPlanoContasDAO();
            return rs;
        } catch (Exception e) {
            
            return rs;
        }
    }
}
