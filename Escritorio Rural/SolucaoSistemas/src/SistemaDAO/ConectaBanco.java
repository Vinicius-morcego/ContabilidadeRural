/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDAO;


import SistemaVIEW.UtilVIEW;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vinicius
 */
public class ConectaBanco {

    public static Connection con;
    public static String driver, usuario, senha, url;

    public static Connection ConectaPostgres() {

        driver = "org.postgresql.Driver";
        usuario = "postgres";
        senha = "123456";

        url = UtilVIEW.Leitura();
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
            return con;
        } catch (ClassNotFoundException | SQLException | NullPointerException e) {
            System.out.println("Erro ao conectar " + e.getMessage());
            return con;
        }

    }

    
}
