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
public class EnderecoDAO {

    String codigo, nome, logradouro, cep, bairro, comando;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    PreparedStatement pst;
    ResultSet rs;

    public boolean CadastrarEnderecoDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into endereco (nome, logradouro, cep) "
                    + "values(?,?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getLogradouro());
            pst.setString(3, getCep());            
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarEnderecoDAO " + e.getMessage());
            return false;
        }
    }

    public boolean AlterarEnderecoDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update endereco set nome = ?, logradouro = ?, cep = ? "
                    + "where codigo = ?";

            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getLogradouro());
            pst.setString(3, getCep());            
            pst.setInt(4, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarEnderecoDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarEnderecoDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct codigo, nome, logradouro, cep from endereco "
                    + "where codigo = ? or nome like '" + getNome() + "%' "
                    + "or logradouro like '" + getLogradouro() + "%' "
                    + "order by nome limit 50";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setInt(1, Integer.parseInt(getCodigo()));
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarEnderecoDAO " + e.getMessage());
            return rs;
        }
    }
}
