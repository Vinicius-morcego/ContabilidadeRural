/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SistemaCTR;

import SistemaDAO.FisicoDAO;
import SistemaDAO.PessoaDAO;
import java.sql.ResultSet;

/**
 *
 * @author Vinicius
 */
public class PessoaCTR {
    PessoaDAO objpessoaDAO = new PessoaDAO();
    ResultSet rs;
    public boolean CadastrarPessoaCTR(String... parametros){
        try {
            objpessoaDAO.setCodigo(parametros[0]);
            objpessoaDAO.setCidade(parametros[1]);
            objpessoaDAO.setEstado(parametros[2]);
            objpessoaDAO.setEndereco(parametros[3]);
            objpessoaDAO.setNumero(parametros[4]);
            objpessoaDAO.setBairro(parametros[5]);
            objpessoaDAO.setTelefone1(parametros[6]);
            objpessoaDAO.setTelefone2(parametros[7]);
            objpessoaDAO.setTipotel1(parametros[8]);
            objpessoaDAO.setTipotel2(parametros[9]);
            objpessoaDAO.setEmail_face(parametros[10]);
            objpessoaDAO.setFoto(parametros[11]);
            objpessoaDAO.setObservacao(parametros[12]);
            objpessoaDAO.setGrupo(parametros[13]);
            objpessoaDAO.setDatacadastro(parametros[14]);
            objpessoaDAO.setSituacao(parametros[15]);
            objpessoaDAO.setCnpj(parametros[16]);
            objpessoaDAO.CadastrarPessoaDAO();
            return true;
                    
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarPessoaCTR "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarPessoaCTR(String... parametros){
        try {
            
            objpessoaDAO.setCidade(parametros[0]);
            objpessoaDAO.setEstado(parametros[1]);
            objpessoaDAO.setEndereco(parametros[2]);
            objpessoaDAO.setNumero(parametros[3]);
            objpessoaDAO.setBairro(parametros[4]);
            objpessoaDAO.setTelefone1(parametros[5]);
            objpessoaDAO.setTelefone2(parametros[6]);
            objpessoaDAO.setTipotel1(parametros[7]);
            objpessoaDAO.setTipotel2(parametros[8]);
            objpessoaDAO.setEmail_face(parametros[9]);
            objpessoaDAO.setFoto(parametros[10]);
            objpessoaDAO.setObservacao(parametros[11]);                       
            objpessoaDAO.setSituacao(parametros[12]);
            objpessoaDAO.setCnpj(parametros[13]);
            objpessoaDAO.setCodigo(parametros[14]);
            objpessoaDAO.AlterarPessoaDAO();
            return true;
                    
        } catch (Exception e) {
            System.out.println("Erro ao AterarPessoaCTR "+e.getMessage());
            return false;
        }
    }
    
    public ResultSet ConsultarClienteCTR(String... parametros){
        try {
            FisicoDAO objfisicoDAO = new FisicoDAO();
            objpessoaDAO.setCodigo(parametros[0]);
            objfisicoDAO.setNome(parametros[1]);
            rs = objpessoaDAO.ConsultarClienteDAO(objfisicoDAO);
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarClienteCTR "+e.getMessage());
            return rs;
        }
    }
}