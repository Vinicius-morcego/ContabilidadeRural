/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.EnderecoDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class EnderecoCTR {
    EnderecoDAO objenderecoDAO = new EnderecoDAO();
    ResultSet rs;
    public boolean CadastrarEnderecoCTR(String... parametros){
        try {
            objenderecoDAO.setNome(parametros[0]);
            objenderecoDAO.setLogradouro(parametros[1]);
            objenderecoDAO.setCep(parametros[2]);
            objenderecoDAO.CadastrarEnderecoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarEnderecoCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarEnderecoCTR(String... parametros){
        try {
            objenderecoDAO.setNome(parametros[0]);
            objenderecoDAO.setLogradouro(parametros[1]);
            objenderecoDAO.setCep(parametros[2]);
            objenderecoDAO.setCodigo(parametros[3]);
            objenderecoDAO.AlterarEnderecoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarEnderecoCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarEnderecoCTR(String... parametros){
        try {
            objenderecoDAO.setCodigo(parametros[0]);
            objenderecoDAO.setNome(parametros[1]);            
            rs = objenderecoDAO.ConsultarEnderecoDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarEnderecoCTR "+e.getMessage());
            return rs;
        }
    }
}
