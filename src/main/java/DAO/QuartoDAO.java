package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Quarto;


public class QuartoDAO {
	
	private SQLite_connection conexao = new SQLite_connection();

    public QuartoDAO(){
        String sql = "create table if not exists quarto ( )" +
                "numero int, descritivo varchar(100), disponibilidade boolean, valorDiaria double";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Quarto criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Quarto obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into quarto(numero,descritivo,disponibilidade,valorDiaria) values(?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getNumero());
                stmt.setString(2, obj.getDescritivo());
                stmt.setBoolean(3, obj.isDisponibilidae());
                stmt.setDouble(4, obj.getValorDiaria());                                
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

    public int alterar (Quarto obj){
		return 0;

    }

    public int remover (Quarto obj){
		return 0;

    }

    public Quarto pesquisar(int codigo){
		return null;

    }        

    public List<Quarto> returnList(String search){
        List<Quarto> list = new ArrayList<Quarto>();
		return list;
    }
}
