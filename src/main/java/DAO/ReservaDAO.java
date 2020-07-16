package DAO;

import fatec.hotel.Cliente;
import fatec.hotel.Quarto;
import fatec.hotel.Reserva;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ReservaDAO {

	private SQLite_connection conexao = new SQLite_connection();

    public ReservaDAO(){
        String sql = "create table if not exists reserva (" +
                "codigo int, dtEntr DATE, dtSaida DATE, cliente varchar(100), " +
                "deposito float, quarto int)";

        try{
            if(this.conexao.conectar()){
                Statement stmt = this.conexao.criarStatement();
                stmt.execute(sql);
                System.out.println("Tabela Reserva criada com sucesso!");
            }
        }
        catch(SQLException err){
            System.err.println(err.getMessage());
        }
        finally{
            conexao.desconectar(); //executa independente do try/catch
        }
    }

    public int inserir (Reserva obj){
    	int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "insert into reserva(codigo,dtEntr,dtSaida,cliente,deposito,quarto) values(?,?,?,?,?,?)";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, obj.getCodigo());
                stmt.setString(2, obj.getDataEntrada());
                stmt.setString(3, obj.getDataSaida());
                stmt.setObject(4, obj.getCliente().getCpf());
                stmt.setDouble(5, obj.getDeposito());
                stmt.setObject(6, obj.getQuarto().getNumero());
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

    public int alterar (Reserva obj){
		return 0;

    }

    public int remover (int codigo){		
		int cont = 0;
        try{
            if(conexao.conectar()){
                String sql = "delete from reserva where codigo=?";
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
    
    public Double getDeposito(int codigo){
    	
    	Reserva obj = new Reserva();   
    	
        Double value = (double) 0;
    	
    	try{
            if(conexao.conectar()){
                String sql = "select *  from reserva where codigo=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, codigo);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setDataEntrada(resultado.getString("dtEntr"));
                	obj.setDataSaida(resultado.getString("dtSaida"));
                	obj.setDeposito(resultado.getDouble("deposito"));
                	//obj.setQuarto(resultado.getObject("quarto"));                	
                	//QuartoDAO q = new QuartoDAO();
                	//obj.setQuarto(q.pesquisar(resultado.getInt("quarto")));
                	//obj.setQuarto(q.getQuarto(resultado.getInt("quarto")));                 	              
                }
                
                value = obj.getDeposito();
                //price = price + obj.getQuarto().getValorDiaria();
                return value;
                
            } else {
            	return value;
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
            return value;
        }
        finally{
            conexao.desconectar();    
            System.err.println(obj.getQuarto());
            
        }
    }

    public Long getReserva(int codigo){
    	Reserva obj = new Reserva();   
    	
        Long value = (long)0;
    	
    	try{
            if(conexao.conectar()){
                String sql = "select *  from reserva where codigo=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setLong(1, codigo);
                ResultSet resultado = stmt.executeQuery();
                if(! resultado.isClosed()){
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setDataEntrada(resultado.getString("dtEntr"));
                	obj.setDataSaida(resultado.getString("dtSaida"));
                	obj.setDeposito(resultado.getDouble("deposito"));
                	//obj.setQuarto(resultado.getObject("quarto"));                	
                	//QuartoDAO q = new QuartoDAO();
                	//obj.setQuarto(q.pesquisar(resultado.getInt("quarto")));
                	//obj.setQuarto(q.getQuarto(resultado.getInt("quarto")));                 	              
                }
                
                value = obj.totalDiarias(obj.getDataEntrada(),obj.getDataSaida());
                //price = price + obj.getQuarto().getValorDiaria();
                return value;
                
            } else {
            	return value;
            }
        } 
        catch(SQLException err){
            System.err.println(err.getMessage());
            return value;
        }
        finally{
            conexao.desconectar();    
            System.err.println(obj.getQuarto());
            
        }
    }
    
    //public Double getValorReserva (String dtEntrada, String dtSaida) {
    	
    //}

    public List<Reserva> returnList(String search){
        List<Reserva> list = new ArrayList<Reserva>();
        
        //Cliente c = new ClienteDAO().getClienteCpf(Integer.parseInt(search));
		//Cliente clientePesquisado;
		//clientePesquisado = c;		
		
		//Quarto q = new QuartoDAO().isDisponivel(1);
		//Quarto quarto_disponivel;
		//quarto_disponivel=q;
		
        try{
            if(conexao.conectar()){
                PreparedStatement stmt;
                if(search.length() > 0){          
                    stmt = conexao.prepareStatement("select *  from reserva "
                            + "where codigo like ? order by codigo");
                    stmt.setString(1, "%"+ search + "%");
                } else {
                    stmt = conexao.prepareStatement("select *  from reserva "
                            + "order by codigo");
                }
                ResultSet resultado = stmt.executeQuery();
                while(resultado.next()){
                	Reserva obj = new Reserva();
                	obj.setCodigo(resultado.getLong("codigo"));
                	obj.setDataEntrada(resultado.getString("dtEntr"));
                	obj.setDataSaida(resultado.getString("dtSaida"));
                	ClienteDAO cliente = new ClienteDAO();
                	obj.setCliente(cliente.getClienteCpf(resultado.getInt("cliente")));
                	obj.setDeposito(resultado.getDouble("deposito"));
                	QuartoDAO quarto = new QuartoDAO();
                	obj.setQuarto(quarto.getQuartoNum(resultado.getInt("quarto")));                	
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
	

