package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class SQLite_connection {
    private Connection conexao;

    public boolean conectar(){
        try{
            String url ="jdbc:sqlite:db/hotel.db";
            this.conexao = DriverManager.getConnection(url);
        }
        catch(SQLException err) {
            System.err.println(err.getMessage());
            return false;
        }
        return true;
    }

    public boolean desconectar(){
        try{
            if(this.conexao.isClosed()==false){
                this.conexao.close();
            }
        }
        catch(SQLException err) {
            System.err.println(err.getMessage());
            return false;
        }
        return true;
    }

    public Statement  criarStatement() {
        try{
            return this.conexao.createStatement();
        }
        catch(SQLException err) {
            System.err.println(err.getMessage());
            return null;
        }
    }

    public Connection getConnection(){
        return this.conexao;
    }

    public PreparedStatement  prepareStatement(String sql) {
        try{
            return this.conexao.prepareStatement(sql);
        }
        catch(SQLException err) {
            System.err.println(err.getMessage());
            return null;
        }
    }

}
