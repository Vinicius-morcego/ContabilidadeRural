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
public class PessoaDAO {
   String codigo, cidade, estado, endereco, numero, bairro, telefone1, telefone2, 
           tipotel1, tipotel2, email_face, foto, observacao, grupo, datacadastro,
           situacao, comando, cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTipotel1() {
        return tipotel1;
    }

    public void setTipotel1(String tipotel1) {
        this.tipotel1 = tipotel1;
    }

    public String getTipotel2() {
        return tipotel2;
    }

    public void setTipotel2(String tipotel2) {
        this.tipotel2 = tipotel2;
    }

    public String getEmail_face() {
        return email_face;
    }

    public void setEmail_face(String email_face) {
        this.email_face = email_face;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

   
    PreparedStatement pst;
    ResultSet rs;
    public boolean CadastrarPessoaDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "insert into pessoa (codigo, cidade, estado, endereco, "
                    + "numero, bairro, "
                    + "telefone1, telefone2, tipotel1, tipotel2, "
                    + "email_face, foto, observacao, grupo, datacadastro, "
                    + "situacao, cnpj) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = ConectaBanco.con.prepareStatement(comando);
            pst.setString(1, getCodigo());
            pst.setString(2, getCidade());
            pst.setString(3, getEstado());
            pst.setString(4, getEndereco());           
            pst.setString(5, getNumero());            
            pst.setString(6, getBairro());            
            pst.setString(7, getTelefone1());
            pst.setString(8, getTelefone2());
            pst.setString(9, getTipotel1());
            pst.setString(10, getTipotel2());
            pst.setString(11, getEmail_face());            
            pst.setString(12, getFoto());
            pst.setString(13, getObservacao());
            pst.setString(14, getGrupo());
            pst.setTimestamp(15, Timestamp.valueOf(getDatacadastro()));
            pst.setString(16, getSituacao());
            pst.setString(17, getCnpj());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao CadastrarPessoaDAO "+e.getMessage());
            return false;
        }
    }
    
    public boolean AlterarPessoaDAO(){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "update pessoa set cidade = ?, estado = ?, endereco = ?, "
                    + "numero = ?, "
                    + "bairro = ?, telefone1 = ?, "
                    + "telefone2 = ?, tipotel1 = ?, "
                    + "tipotel2 = ?, email_face = ?, foto = ?, observacao = ?, "
                    + "situacao = ?, cnpj = ? where codigo = ?";
            pst = ConectaBanco.con.prepareStatement(comando);
            
            pst.setString(1, getCidade());
            pst.setString(2, getEstado());
            pst.setString(3, getEndereco());           
            pst.setString(4, getNumero());            
            pst.setString(5, getBairro());            
            pst.setString(6, getTelefone1());
            pst.setString(7, getTelefone2());
            pst.setString(8, getTipotel1());
            pst.setString(9, getTipotel2());
            pst.setString(10, getEmail_face());            
            pst.setString(11, getFoto());
            pst.setString(12, getObservacao());            
            pst.setString(13, getSituacao()); 
            pst.setString(14, getCnpj());
            pst.setString(15, getCodigo());
            pst.execute();
            pst.close();
            ConectaBanco.con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao AlterarPessoaDAO "+e.getMessage());
            return false;
        }
    }   
   
    
    public ResultSet ConsultarClienteDAO(FisicoDAO objfisicoDAO){
        try {
            ConectaBanco.ConectaPostgres();
            comando = "select distinct p.codigo, f.nome, f.datanascimento, f.idade, "
                    + "f.rg, f.cpf, f.profissao, f.pai, f.mae, p.telefone1, p.tipotel1, "
                    + "p.telefone2, p.tipotel2, p.cnpj, p.email_face, f.sexo, p.endereco, "
                    + "p.numero, p.bairro, p.cidade, p.estado, p.observacao, p.situacao,"
                    + "p.foto, to_char(p.datacadastro, 'dd/mm/yyyy HH24:mi:ss') as dia "
                    + "from pessoa p inner join fisico f on f.pessoa = p.codigo "
                    + "where p.codigo = '"+getCodigo()+"' and p.situacao in('ATIVO') or "
                    + "f.nome like '"+objfisicoDAO.getNome()+"%' and p.situacao in('ATIVO') "
                    + "order by f.nome limit 50";
            pst = ConectaBanco.con.prepareCall(comando, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);         
           
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro ao ConsultarClienteDAO "+e.getMessage());
            return rs;
        }
    }
}
