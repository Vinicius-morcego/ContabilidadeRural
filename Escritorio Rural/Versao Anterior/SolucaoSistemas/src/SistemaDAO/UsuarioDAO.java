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
public class UsuarioDAO {

    String codigo, login, senha, datacadastro, comando;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    PreparedStatement pst;
    ResultSet rs;

    public boolean CadastrarUsuarioDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into usuario (login, senha, datacadastro) "
                    + "values(?,md5(?),now())";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getLogin());
            pst.setString(2, getSenha());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao CadastrarUsuarioDAO " + e.getMessage());
            return false;
        }
    }

    public boolean AlterarUsuarioDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update usuario set login = ?, senha = md5(?) "
                    + "where codigo = ?";

            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getLogin());
            pst.setString(2, getSenha());
            pst.setInt(3, Integer.parseInt(getCodigo()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao AlterarUsuarioDAO " + e.getMessage());
            return false;
        }
    }

    public ResultSet ConsultarUsuarioDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select login, senha from usuario "
                    + "where login = '" + getLogin() + "' and "
                    + "senha = '" + getSenha() + "'";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Erro ao ConsultarUsuarioDAO " + e.getMessage());
            return rs;
        }
    }
    
    public ResultSet ConsultarLoginDAO() {
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select codigo, login, to_char(datacadastro, 'dd/mm/yyyy') "
                    + "as data, to_char(datacadastro, 'HH24:mi:ss') as hora "
                    + "from usuario order by codigo";
                    
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao ConsultarLoginDAO " + e.getMessage());
            return rs;
        }
    }
}
