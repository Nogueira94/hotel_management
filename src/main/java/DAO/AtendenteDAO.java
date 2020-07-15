package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Atendente;

public class AtendenteDAO {

	private SQLite_connection conexao = new SQLite_connection();

    public AtendenteDAO(){
        String sql = "create table if not exists atendente ( )" +
                "codigo int, nome varchar(100), email varchar(100), senha varchar(100)";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Atendente criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Atendente obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into atendente(codigo,nome,email,senha) values(?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getNome());                
                stmt.setString(3, obj.getEmail());    
                stmt.setString(4, obj.getSenha());    
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

    public int alterar (Atendente obj){
		return 0;

    }

    public int remover (Atendente obj){
		return 0;

    }

    public Atendente pesquisar(int codigo){
		return null;

    }        

    public List<Atendente> returnList(String search){
        List<Atendente> list = new ArrayList<Atendente>();
		return list;
    }
}
