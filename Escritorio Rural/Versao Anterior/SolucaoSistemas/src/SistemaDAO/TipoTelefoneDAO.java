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
public class TipoTelefoneDAO {

    String codigo, descricao, comando;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    PreparedStatement pst;
    ResultSet rs;

    public boolean CadastrarTipoTelefoneDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into tipotelefone (descricao) values(?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getDescricao());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarTipoTelefoneDAO " + e.getMessage());
            return false;

        }
    }
    
    public boolean AlterarTipoTelefoneDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update tipotelefone set descricao = ? where codigo = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getDescricao());
            pst.setInt(2, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarTipoTelefoneDAO " + e.getMessage());
            return false;

        }
    }

    public ResultSet ConsultarTipoTelefoneDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct descricao, codigo from tipotelefone where "
                    + "codigo = ? or descricao "
                    + "like '" + getDescricao() + "%' order by descricao";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setInt(1, Integer.parseInt(getCodigo()));
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarTipoTelefoneDAO " + e.getMessage());
            return rs;
        }
    }
}
