/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class BairroDAO {

    String codigo, nome, comando;
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  

    PreparedStatement pst;
    ResultSet rs;

    public boolean CadastrarBairroDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into bairro (nome) values(?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());            
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarBairroDAO " + e.getMessage());
            return false;
        }
    }

    public boolean AlterarBairroDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update bairro set nome = ? where codigo = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());            
            pst.setInt(2, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarBairroDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarBairroDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct codigo, nome from bairro "
                    + "where codigo = ? "
                    + "or nome like '" + getNome() + "%'"
                    + " order by nome limit 50";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setInt(1, Integer.parseInt(getCodigo()));

            rs = pst.executeQuery();
            return rs;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao ConsultarBairroDAO " + e.getMessage());
            return rs;
        }
    }
}
