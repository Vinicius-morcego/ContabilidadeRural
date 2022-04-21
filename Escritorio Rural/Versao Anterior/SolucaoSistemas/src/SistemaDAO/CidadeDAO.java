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
public class CidadeDAO {

    String codigo, nome, estado, comando;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    PreparedStatement pst;
    ResultSet rs;

    public boolean CadastrarCidadeDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into cidade (nome, estado) values(?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getEstado());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarCidadeDAO " + e.getMessage());
            return false;
        }
    }

    public boolean AlterarCidadeDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update cidade set nome = ?, estado = ? where codigo = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getEstado());
            pst.setInt(3, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarCidadeDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarCidadeDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct codigo, nome, estado from cidade "
                    + "where codigo = ? or estado = ? or nome like '" + getNome() + "%' "
                    + "order by nome limit 50";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            pst.setInt(1, Integer.parseInt(getCodigo()));
            pst.setString(2, getEstado());
            rs = pst.executeQuery();
            return rs;

        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarCidadeDAO " + e.getMessage());
            return rs;
        }
    }
}
