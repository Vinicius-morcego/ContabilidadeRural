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
public class EstadoDAO {

    String codigo, sigla, comando;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    PreparedStatement pst;
    ResultSet rs;

    public ResultSet ConsultarEstadoDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct sigla from estado order by sigla";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {

            return rs;
        }
    }
}
