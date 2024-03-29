package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Hospedagem;

@SuppressWarnings("finally")
public class HospedagemDAO {

	private SQLite_connection conexao = new SQLite_connection();

    public HospedagemDAO(){
        String sql = "create table if not exists hospedagem (" +
                "codigo long, diarias int, valorTotal double";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Hospedagem criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Hospedagem obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into hospedagem(codigo,diarias, valorTotal) values(?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setInt(2, obj.getDiarias());
                stmt.setDouble(3, obj.getValorTotal());                                                
                cont = stmt.executeUpdate();
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();
            return cont;
        }

    }

    public int remover (Hospedagem obj){
		return 0;

    }
}
