/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCTR;

import SistemaDAO.PorcentagemDAO;
import java.sql.ResultSet;

/**
 *
 * @author VINICIUS
 */
public class PorcentagemCTR {
    PorcentagemDAO objporcentagemDAO = new PorcentagemDAO();
    ResultSet rs;
    public boolean AtualizarPorcentagemCTR(Integer... parametros){
        try {
            objporcentagemDAO.setAcrescimo(parametros[0]);
            objporcentagemDAO.setDesconto(parametros[1]);
            objporcentagemDAO.AtualizarPorcentagemDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AtualizarPorcentagemCTR "+e.getMessage());
            return false;
        }
    }
    public ResultSet ConsultarPorcentagemCTR(){
        try {
            rs = objporcentagemDAO.ConsultarPorcentagemDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarPorcentagemCTR "+e.getMessage());
            return rs;
        }
    }
}
