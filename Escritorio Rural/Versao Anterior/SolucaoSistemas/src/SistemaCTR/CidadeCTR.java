/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.CidadeDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class CidadeCTR {
    CidadeDAO objcidadeDAO = new CidadeDAO();
    ResultSet rs;
    public boolean CadastrarCidadeCTR(String... parametros){
        try {
            objcidadeDAO.setNome(parametros[0]);
            objcidadeDAO.setEstado(parametros[1]);
            objcidadeDAO.CadastrarCidadeDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarCidadeCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarCidadeCTR(String... parametros){
        try {
            objcidadeDAO.setNome(parametros[0]);
            objcidadeDAO.setEstado(parametros[1]);
            objcidadeDAO.setCodigo(parametros[2]);
            objcidadeDAO.AlterarCidadeDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarCidadeCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarCidadeCTR(String... parametros){
        try {
            objcidadeDAO.setCodigo(parametros[0]);
            objcidadeDAO.setEstado(parametros[1]);
            objcidadeDAO.setNome(parametros[2]);
            rs = objcidadeDAO.ConsultarCidadeDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarCidadeCTR "+e.getMessage());
            return rs;
        }
    }
}
