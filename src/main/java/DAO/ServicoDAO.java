package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Servico;

public class ServicoDAO {
	private SQLite_connection conexao = new SQLite_connection();

    public ServicoDAO(){
        String sql = "create table if not exists servico ( )" +
                "codigo int, descritivo varchar(100), valor double, tipo varchar(30), data varchar(20)";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Servico criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Servico obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into servico(codigo,descritivo,valor,tipo,data) values(?,?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getDescritivo());
                stmt.setDouble(3, obj.getValor());
                stmt.setString(4, obj.getTipo());
                stmt.setString(5, obj.getData());                
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

    public int alterar (Servico obj){
		return 0;

    }

    public int remover (Servico obj){
		return 0;

    }

    public Servico pesquisar(int codigo){
		return null;

    }        

    public List<Servico> returnList(String search){
        List<Servico> list = new ArrayList<Servico>();
		return list;
    }

}

