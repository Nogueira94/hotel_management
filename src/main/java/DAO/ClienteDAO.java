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
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update cliente set codigo=?, nome=?, cpf=?, dataNascimento=?, logradouro=?, bairro=?, cidade=?, estado=?, telefone=?, cep=? where cpf=?";
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
                stmt.setInt(11, obj.getCpf()); 
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

    public int remover (int cpf){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from cliente where cpf=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, cpf);
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

    public Cliente pesquisar(int codigo){
		return null;

    }
    
    public Cliente getClienteCpf (long cpf) {
    	
    	Cliente obj = new Cliente();   
            
    	try{
            if(conexao.conectar()){
                String sql = "select *  from cliente where cpf=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, cpf);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setNome(resultado.getString("nome"));
                	obj.setCpf(resultado.getInt("cpf"));
                	obj.setTelefone(resultado.getString("telefone"));               
                }
                
                return obj;
            } else {
            	return null;
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
            return null;
        }
        finally{
            conexao.desconectar();       
            
        }
    }

    public List<Cliente> returnList(String search){
        List<Cliente> list = new ArrayList<Cliente>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(search.length() > 0){          
                    stmt = conexao.prepareStatement("select *  from cliente "
                            + "where cpf like ? order by cpf");
                    stmt.setString(1, "%"+ search + "%");
                } else {
                    stmt = conexao.prepareStatement("select *  from cliente "
                            + "order by cpf");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                	Cliente obj = new Cliente();
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setNome(resultado.getString("nome"));
                	obj.setCpf(resultado.getInt("cpf"));
                	obj.setDataNascimento(resultado.getString("dataNascimento"));
                	obj.setLogradouro(resultado.getString("logradouro"));
                	obj.setBairro(resultado.getString("bairro"));
                	obj.setCidade(resultado.getString("cidade"));
                	obj.setEstado(resultado.getString("estado"));
                	obj.setTelefone(resultado.getString("telefone"));
                	obj.setCep(resultado.getInt("cep"));                	     
                    list.add(obj);
                }
            }
        } 
        catch(SQLException err){
         System.err.println(err.getMessage());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
            conexao.desconectar();
            return list;
        }	
    }

}
