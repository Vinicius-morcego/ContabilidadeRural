/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCTR;

import SistemaDAO.CreditoDAO;

/**
 *
 * @author Vinicius
 */
public class CreditoCTR {
    CreditoDAO objcreditoDAO = new CreditoDAO();
    public boolean CadastrarCreditoCTR(String... parametros){
        try {
           
            objcreditoDAO.setValor(parametros[0]);
            objcreditoDAO.setTipo(parametros[1]);
            objcreditoDAO.setCliente(parametros[2]);
            objcreditoDAO.setSaldo(parametros[3]);
            objcreditoDAO.CadastrarCreditoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarCreditoCTR "+e.getMessage());
            return false;
            
        }
    }
}
