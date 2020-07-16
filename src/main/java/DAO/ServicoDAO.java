package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fatec.hotel.Quarto;
import fatec.hotel.Servico;

public class ServicoDAO {
	private SQLite_connection conexao = new SQLite_connection();

    public ServicoDAO(){
        String sql = "create table if not exists servico (" +
                "codigo long, descritivo varchar(100), valor double)";

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
                String sql = "insert into servico(codigo,descritivo,valor) values(?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getDescritivo());
                stmt.setDouble(3, obj.getValor());                            
                cont = stmt.executeUpdate();            }
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
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "update servico set codigo=?,descritivo=?,valor=? where codigo=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getDescritivo());
                stmt.setDouble(3, obj.getValor()); 
                stmt.setLong(4, obj.getCodigo());
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
    
    public Double valorTotalServico (int codigo) {
    	Servico obj = new Servico();    	        
    	try{
            if(conexao.conectar()){
                String sql = "select *  from servico where codigo=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, codigo);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setCodigo(resultado.getLong("codigo"));                	
                	obj.setValor(resultado.getDouble("valor"));                	
                }
                
                return obj.getValor();
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

    public int remover (int codigo){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from servico where codigo=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, codigo);
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

    public Servico pesquisar(int codigo){
		return null;

    }        

    public List<Servico> returnList(String search){
        List<Servico> list = new ArrayList<Servico>();
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(search.length() > 0){          
                    stmt = conexao.prepareStatement("select *  from servico "
                            + "where codigo like ? order by codigo");
                    stmt.setString(1, "%"+ search + "%");
                } else {
                    stmt = conexao.prepareStatement("select *  from servico "
                            + "order by codigo");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                	Servico obj = new Servico();
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setDescritivo(resultado.getString("descritivo"));
                	obj.setValor(resultado.getDouble("valor"));                	
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

