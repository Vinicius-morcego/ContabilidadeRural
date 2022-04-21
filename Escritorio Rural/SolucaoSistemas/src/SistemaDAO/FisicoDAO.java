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
public class FisicoDAO {
    String codigo, nome, cpf, rg, idade, profissao, estadocivil, 
            sexo, pai, mae, pessoa, comando, dataNascimento;
     

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
    
    PreparedStatement pst;
    ResultSet rs;
    
    
    public boolean CadastrarFisicoDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into fisico (nome, cpf, rg, datanascimento, idade, profissao, "
                    + "estadocivil, sexo, pai, mae, pessoa) values(?,?,?,?,?,?,?,"
                    + "?,?,?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getCpf());
            pst.setString(3, getRg());
            pst.setString(4, getDataNascimento());
            pst.setString(5, getIdade());
            pst.setString(6, getProfissao());
            pst.setString(7, getEstadocivil());
            pst.setString(8, getSexo());
            pst.setString(9, getPai());
            pst.setString(10, getMae());
            pst.setString(11, getPessoa());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarFisicoDAO "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarFisicoDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update fisico set nome = ?, cpf = ?, rg = ?, datanascimento = ?, "
                    + "idade = ?, profissao = ?, estadocivil = ?, sexo = ?, pai = ?, "
                    + "mae = ? where pessoa = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getNome());
            pst.setString(2, getCpf());
            pst.setString(3, getRg());
            pst.setString(4, getDataNascimento());
            pst.setString(5, getIdade());
            pst.setString(6, getProfissao());
            pst.setString(7, getEstadocivil());
            pst.setString(8, getSexo());
            pst.setString(9, getPai());
            pst.setString(10, getMae());
            pst.setString(11, getPessoa());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarFisicoDAO "+e.getMessage());
            return false;
        }
    }
}
