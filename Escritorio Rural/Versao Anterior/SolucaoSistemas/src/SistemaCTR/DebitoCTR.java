/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaCTR;

import SistemaDAO.DebitoDAO;

/**
 *
 * @author Vinicius
 */
public class DebitoCTR {

    DebitoDAO objdebitoDAO = new DebitoDAO();

    public boolean CadastrarDebitoCTR(String... parametros) {
        try {
            objdebitoDAO.setValor(parametros[0]);
            objdebitoDAO.setTipo(parametros[1]);
            objdebitoDAO.setCliente(parametros[2]);
            objdebitoDAO.setSaldo(parametros[3]);
            objdebitoDAO.CadastrarDebitoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarDebitoCTR " + e.getMessage());
            return false;

        }
    }
}
