/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCTR;

import SistemaDAO.TipoTelefoneDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class TipoTelefoneCTR {

    TipoTelefoneDAO objtipoDAO = new TipoTelefoneDAO();
    ResultSet rs;

    public boolean CadastrarTipoTelefoneCTR(String descricao) {
        try {
            objtipoDAO.setDescricao(descricao);
            objtipoDAO.CadastrarTipoTelefoneDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarTipoTelefoneCTR " + e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarTipoTelefoneCTR(String... parametros) {
        try {
            objtipoDAO.setDescricao(parametros[0]);
            objtipoDAO.setCodigo(parametros[1]);
            objtipoDAO.AlterarTipoTelefoneDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarTipoTelefoneCTR " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarTipoTelefoneCTR(String descricao, String codigo) {
        try {
            objtipoDAO.setDescricao(descricao);
            objtipoDAO.setCodigo(codigo);
            rs = objtipoDAO.ConsultarTipoTelefoneDAO();
            return rs;
        } catch (Exception e) {

            return rs;
        }
    }
}
