/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCTR;

import SistemaDAO.UsuarioDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class UsuarioCTR {
    UsuarioDAO objusuarioDAO = new UsuarioDAO();
    ResultSet rs;
    public boolean CadastrarUsuarioCTR(String... parametros){
        try {
            objusuarioDAO.setLogin(parametros[0]);
            objusuarioDAO.setSenha(parametros[1]);
            objusuarioDAO.CadastrarUsuarioDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarUsuarioCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarUsuarioCTR(String... parametros){
        try {
            objusuarioDAO.setLogin(parametros[0]);
            objusuarioDAO.setSenha(parametros[1]);
            objusuarioDAO.setCodigo(parametros[2]);
            objusuarioDAO.AlterarUsuarioDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarUsuarioCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarUsuarioCTR(String login, String senha){
        try {
            objusuarioDAO.setLogin(login);
            objusuarioDAO.setSenha(senha);
            rs = objusuarioDAO.ConsultarUsuarioDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarUsuarioCTR "+e.getMessage());
            return rs;
        }
    }
    
    public ResultSet ConsultarLoginCTR(){
        try {
            
            rs = objusuarioDAO.ConsultarLoginDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarLoginCTR "+e.getMessage());
            return rs;
        }
    }
}
