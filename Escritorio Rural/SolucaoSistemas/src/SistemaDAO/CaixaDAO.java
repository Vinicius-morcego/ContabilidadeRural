/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Vinicius
 */
public class CaixaDAO {

    String codigo, dataCadastro, indice, historico, comando, cliente, saldoatual;

    public String getSaldoatual() {
        return saldoatual;
    }

    public void setSaldoatual(String saldoatual) {
        this.saldoatual = saldoatual;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
  

    ResultSet rs;
    PreparedStatement pst;

    public boolean CadastrarCaixaDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into caixa (datacadastro, indice, historico, cliente, saldoatual) "
                    + "values(?, ?, ?, ?, ?)";
            pst = ConectaBanco.con.prepareStatement(comando);           
            pst.setTimestamp(1, Timestamp.valueOf(getDataCadastro()));
            pst.setDouble(2, Double.parseDouble(getIndice().replace("R$", "").
                    replace(".", "").replace(",", ".")));
            pst.setString(3, getHistorico());
            pst.setString(4, getCliente());
            pst.setDouble(5, Double.parseDouble(getSaldoatual()));
            
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarCaixaDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarCaixaDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select c.codigo as cod, cr.cliente, c.indice, cr.valor, cr.tipo, "
                    + "cr.saldo, to_char(c.datacadastro, 'dd/mm/yyyy HH24:mi:ss') as hora "
                    + "from credito cr inner join caixa c on c.codigo = cr.caixa "                                    
//                    + "where to_char(c.datacadastro, 'yyyy-mm-dd') "
//                    + "between to_char(now(), 'yyyy-mm-dd') and "
//                    + "to_char(now(), 'yyyy-mm-dd') "
                    + "union "
                    + "select c.codigo as cod, d.cliente, c.indice, d.valor, d.tipo, "
                    + "d.saldo, to_char(c.datacadastro, 'dd/mm/yyyy HH24:mi:ss') as hora "
                    + "from debito d inner join caixa c on c.codigo = d.caixa "
                    + "order by cod desc limit 50";                                 
//                    + "where to_char(c.datacadastro, 'yyyy-mm-dd') "
//                    + "between to_char(now(), 'yyyy-mm-dd') and "
//                    + "to_char(now(), 'yyyy-mm-dd') order by cod desc";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarCaixaDAO "+e.getMessage());
            return rs;
        }
    }
    
    public ResultSet ConsultarAberturaCaixaDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select codigo from caixa where to_char(datacadastro, 'yyyy-mm-dd') = "
                    + "to_char(now(), 'yyyy-mm-dd')";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarAberturaCaixaDAO "+e.getMessage());
            return rs;
        }
    }
    
    public ResultSet ConsultarMaiorCodigoCaixaDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select max(codigo) from caixa";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erro ao ConsultarMaiorCodigoCaixaDAO "+e.getMessage());
            return rs;
        }
    }
    public ResultSet ConsultarSaldoAnteriorDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select saldoatual from caixa "
                    + "where cliente = '"+getCliente()+"' and codigo = "
                    + "(select max(codigo) from caixa where cliente = '"+getCliente()+"')";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Erro ao ConsultarSaldoAnteriorDAO "+e.getMessage());
            return rs;
        }
    }
   
}
