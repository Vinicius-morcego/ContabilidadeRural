/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.FisicoDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class FisicoCTR {
    FisicoDAO objfisicoDAO = new FisicoDAO();
    ResultSet rs;
    public boolean CadastrarFisicoCTR(String... parametros){
        try {
            objfisicoDAO.setNome(parametros[0]);
            objfisicoDAO.setCpf(parametros[1]);
            objfisicoDAO.setRg(parametros[2]);
            objfisicoDAO.setDataNascimento(parametros[3]);
            objfisicoDAO.setIdade(parametros[4]);
            objfisicoDAO.setProfissao(parametros[5]);
            objfisicoDAO.setEstadocivil(parametros[6]);
            objfisicoDAO.setSexo(parametros[7]);
            objfisicoDAO.setPai(parametros[8]);
            objfisicoDAO.setMae(parametros[9]);
            objfisicoDAO.setPessoa(parametros[10]);
            objfisicoDAO.CadastrarFisicoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarFisicoCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarFisicoCTR(String... parametros){
        try {
            objfisicoDAO.setNome(parametros[0]);
            objfisicoDAO.setCpf(parametros[1]);
            objfisicoDAO.setRg(parametros[2]);
            objfisicoDAO.setDataNascimento(parametros[3]);
            objfisicoDAO.setIdade(parametros[4]);
            objfisicoDAO.setProfissao(parametros[5]);
            objfisicoDAO.setEstadocivil(parametros[6]);
            objfisicoDAO.setSexo(parametros[7]);
            objfisicoDAO.setPai(parametros[8]);
            objfisicoDAO.setMae(parametros[9]);
            objfisicoDAO.setPessoa(parametros[10]);
            objfisicoDAO.AlterarFisicoDAO();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao AlterarFisicoCTR "+e.getMessage());
            return false;
        }
    }
}
