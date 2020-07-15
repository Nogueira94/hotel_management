package DAO;

import fatec.hotel.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private SQLite_connection conexao = new SQLite_connection();

    public ClienteDAO(){
        String sql = "create table if not exists cliente (" +
                "codigo long, nome varchar(100), cpf int, dataNascimento varchar(20), " +
                "logradouro varchar(50), bairro varchar(20), cidade varchar(50), estado varchar(2)," +
                "telefone varchar(15), cep int)";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Cliente criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Cliente obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into cliente(codigo,nome,cpf,dataNascimento,logradouro,bairro,cidade,estado,telefone,cep) values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getNome());                
                stmt.setInt(3, obj.getCpf());    
                stmt.setString(4, obj.getDataNascimento());   
                stmt.setString(5, obj.getLogradouro()); 
                stmt.setString(6, obj.getBairro());
                stmt.setString(7, obj.getCidade()); 
                stmt.setString(8, obj.getEstado());    
                stmt.setString(9, obj.getTelefone()); 
                stmt.setInt(10, obj.getCep());                 
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

    public int alterar (Cliente obj){
		return 0;

    }

    public int remover (Cliente obj){
		return 0;

    }

    public Cliente pesquisar(int codigo){
		return null;

    }
    
    public Cliente getClienteCpf (String cpf) {
    	try{
            if(conexao.conectar()){
                String sql = "select *  from cliente where cpf=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, cpf);
                ResultSet resultado = stmt.executeQuery();
                return (Cliente) resultado;
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar();       
            return null;
        }
    }

    public List<Cliente> returnList(String search){
        List<Cliente> list = new ArrayList<Cliente>();
		return list;
    }

}
