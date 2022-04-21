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
 * @author VINICIUS
 */
public class PorcentagemDAO {
    String codigo, comando;
    Integer acrescimo, desconto;
    PreparedStatement pst;
    ResultSet rs;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public Integer getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Integer acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Integer getDesconto() {
        return desconto;
    }

    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
    
    public boolean AtualizarPorcentagemDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update porcentagem set acrescimo = ?, desconto = ?, dia = now() where codigo = 1";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setInt(1, getAcrescimo());
            pst.setInt(2, getDesconto());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;                    
        } catch (SQLException e) {
            System.out.println("Erro ao AtualizarPorcentagemDAO "+e.getMessage());
            return false;
        }
    }
    public ResultSet ConsultarPorcentagemDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select acrescimo, desconto, to_char(dia, 'dd/mm/yyyy') as resultado from porcentagem where codigo = 1";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarPorcentagemDAO "+e.getMessage());
            return rs;
        }
    }
}
