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
public class CreditoDAO {

    String codigo, caixa, cliente, valor, saldo, tipo, observacao, planocontas,
            comando;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPlanocontas() {
        return planocontas;
    }

    public void setPlanocontas(String planocontas) {
        this.planocontas = planocontas;
    }

    ResultSet rs;
    PreparedStatement pst;

    public boolean CadastrarCreditoDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into credito (valor, tipo, caixa, "
                    + "cliente, saldo) values(?,?,"
                    + "(select max(codigo) from caixa),?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            
            pst.setDouble(1, Double.parseDouble(getValor().replace("R$", "").
                    replace(".", "").replace(",", ".")));
            pst.setString(2, getTipo());
            pst.setString(3, getCliente());
            pst.setDouble(4, Double.parseDouble(getSaldo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();

            return true;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao CadastrarCreditoDAO "+e.getMessage());
            return false;
        }
    }
}
