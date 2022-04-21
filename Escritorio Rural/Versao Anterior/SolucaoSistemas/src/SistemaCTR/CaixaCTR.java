/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.CaixaDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class CaixaCTR {
    CaixaDAO objcaixaDAO = new CaixaDAO();
    ResultSet rs = null;
    
    public boolean CadastrarCaixaCTR(String indice, String historico, String cliente, String saldoAtual,
            String dataCadastro){
        try {
            objcaixaDAO.setIndice(indice);
            objcaixaDAO.setHistorico(historico);
            objcaixaDAO.setCliente(cliente);
            objcaixaDAO.setSaldoatual(saldoAtual);
            objcaixaDAO.setDataCadastro(dataCadastro);            
            objcaixaDAO.CadastrarCaixaDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarCaixaCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarCaixaCTR(){
        try {
            
            rs = objcaixaDAO.ConsultarCaixaDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarCaixaCTR "+e.getMessage());
            return rs;
        }
    }
    
    public ResultSet ConsultarSaldoAnteriorCTR(String cliente){
        try {
            objcaixaDAO.setCliente(cliente);
            rs = objcaixaDAO.ConsultarSaldoAnteriorDAO();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarSaldoAnteriorCTR "+e.getMessage());
            return rs;
        }
    }
    
  
}
