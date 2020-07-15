package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Nota;

public class NotaDAO {

	private SQLite_connection conexao = new SQLite_connection();

    public NotaDAO(){
        String sql = "create table if not exists nota ( )" +
                "numero int, dataEmissao varchar(100), total double";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Nota criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Nota obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into nota(numero,dataEmissao,valor) values(?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getNumero());
                stmt.setString(2, obj.getDataEmissao());                
                stmt.setDouble(3, obj.getTotal());                                
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

    public int alterar (Nota obj){
		return 0;

    }

    public int remover (Nota obj){
		return 0;

    }

    public Nota pesquisar(int codigo){
		return null;

    }        

    public List<Nota> returnList(String search){
        List<Nota> list = new ArrayList<Nota>();
		return list;
    }
}
