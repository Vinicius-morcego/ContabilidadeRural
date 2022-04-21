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
public class PlanoContasDAO {

    String codigo, nome, tipo, comando;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    ResultSet rs;
    PreparedStatement pst;

    public boolean CadastrarPlanoContasDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into planocontas (descricao, tipo) values(?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getTipo());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarPlanoContasDAO " + e.getMessage());
            return false;
        }
    }

    public boolean AlterarPlanoContasDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update planocontas set descricao = ?, tipo = ? where codigo = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getTipo());
            pst.setInt(3, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarPlanoContasDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarPlanoContasDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct codigo, descricao, tipo from planocontas "
                    + "where codigo = ? or descricao like '" + getNome() + "%' or "
                    + "tipo like '" + getTipo() + "%' order by descricao limit 50";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            pst.setInt(1, Integer.parseInt(getCodigo()));
            rs = pst.executeQuery();
            return rs;
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Erro ao ConsultarPlanoContasDAO " + e.getMessage());
            return rs;
        }
    }
}
