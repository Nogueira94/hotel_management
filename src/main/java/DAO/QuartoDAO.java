package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Quarto;

@SuppressWarnings("finally")
public class QuartoDAO {
	
	private SQLite_connection conexao = new SQLite_connection();

    public QuartoDAO(){
        String sql = "create table if not exists quarto ( " +
                "numero int, descritivo varchar(100), disponibilidade bit, valorDiaria double)";

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
	
	public int changeDisponibilidade (Quarto obj) {
		int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update quarto set disponibilidade=0 where numero=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getNumero());
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
    
    public Quarto isDisponivel (int quarto) {
    	Quarto obj = new Quarto();    	        
    	try{
            if(conexao.conectar()){
                String sql = "select *  from quarto where numero=? and disponibilidade = 1 ";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, quarto);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setNumero(resultado.getLong("numero"));
                	obj.setDescritivo(resultado.getString("descritivo"));
                	obj.setValorDiaria(resultado.getDouble("valorDiaria"));
                	obj.setDisponibilidae(resultado.getBoolean("disponibilidade"));
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
    
    public Quarto getQuartoNum (int quarto) {
    	Quarto obj = new Quarto();    	        
    	try{
            if(conexao.conectar()){
                String sql = "select *  from quarto where numero=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, quarto);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setNumero(resultado.getLong("numero"));
                	obj.setDescritivo(resultado.getString("descritivo"));
                	obj.setValorDiaria(resultado.getDouble("valorDiaria"));
                	obj.setDisponibilidae(resultado.getBoolean("disponibilidade"));
                }
                
                return obj;
            } else {
            	return obj;
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
            return obj;
        }
        finally{
            conexao.desconectar();       
            
        }
    	
    }
          
    public Double getValor (int quarto) {
    	Quarto obj = new Quarto();    	        
    	try{
            if(conexao.conectar()){
                String sql = "select *  from quarto where numero=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, quarto);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setNumero(resultado.getLong("numero"));
                	obj.setDescritivo(resultado.getString("descritivo"));
                	obj.setValorDiaria(resultado.getDouble("valorDiaria"));
                	obj.setDisponibilidae(resultado.getBoolean("disponibilidade"));
                }
                
                return obj.getValorDiaria();
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

    public int alterar (Quarto obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update quarto set numero=?,descritivo=?,valorDiaria=?, disponibilidade=1 where numero=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getNumero());
                stmt.setString(2, obj.getDescritivo());
                stmt.setDouble(3, obj.getValorDiaria());
                stmt.setLong(4, obj.getNumero());
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

    public int remover (int numero){    	
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from quarto where numero=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, numero);
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
         

    public List<Quarto> returnList(String search){
        List<Quarto> list = new ArrayList<Quarto>();        
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(search.length() > 0){          
                    stmt = conexao.prepareStatement("select *  from quarto "
                            + "where numero like ? order by numero");
                    stmt.setString(1, "%"+ search + "%");
                } else {
                    stmt = conexao.prepareStatement("select *  from quarto "
                            + "order by numero");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                	Quarto obj = new Quarto();
                	obj.setNumero(resultado.getLong("numero"));
                	obj.setDescritivo(resultado.getString("descritivo"));
                	obj.setValorDiaria(resultado.getDouble("valorDiaria"));
                	obj.setDisponibilidae(resultado.getBoolean("disponibilidade"));
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


	public Quarto pesquisar(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
}
