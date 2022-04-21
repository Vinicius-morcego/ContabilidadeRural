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
public class JuridicoDAO {
    String codigo, nomefantasia, razaosocial, cnpj, inscricaoMunicipal, 
            inscricaoEstadual, tipoempresa, comando, pessoa;

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getTipoempresa() {
        return tipoempresa;
    }

    public void setTipoempresa(String tipoempresa) {
        this.tipoempresa = tipoempresa;
    }
    
    PreparedStatement pst;
    ResultSet rs;
    public boolean CadastrarJuridicoDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into juridico (nomefantasia, razaosocial, cnpj, "
                    + "tipoempresa, inscricaoestadual, inscricaomunicipal, pessoa) "
                    + "values(?,?,?,?,?,?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNomefantasia());
            pst.setString(2, getRazaosocial());
            pst.setString(3, getCnpj());
            pst.setString(4, getTipoempresa());
            pst.setString(5, getInscricaoEstadual());
            pst.setString(6, getInscricaoMunicipal());
            pst.setString(7, getPessoa());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarJuridicoDAO "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarJuridicoDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update juridico set nomefantasia = ?, razaosocial = ?, "
                    + "cnpj = ? ,tipoempresa = ?, inscricaoestadual = ?, "
                    + "inscricaomunicipal = ? where pessoa = ? ";
                    
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNomefantasia());
            pst.setString(2, getRazaosocial());
            pst.setString(3, getCnpj());
            pst.setString(4, getTipoempresa());
            pst.setString(5, getInscricaoEstadual());
            pst.setString(6, getInscricaoMunicipal());
            pst.setInt(7, Integer.parseInt(getPessoa()));
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarJuridicoDAO "+e.getMessage());
            return false;
        }
    }
}
