package fatec.hotel;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Reserva {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
    private Long codigo;
    private String dataEntrada;
    private String dataSaida;
    private Cliente cliente;
    private double deposito;
    private Quarto quarto;
    
    

    public Reserva(Long codigo, String dataEntrada, String dataSaida, 
            Cliente cliente, double deposito, Quarto quarto){
        this.setCliente(cliente);
        this.setCodigo(codigo);
        this.setDataEntrada(dataEntrada);
        this.setDataSaida(dataSaida);
        this.setDeposito(deposito);
        this.setQuarto(quarto);
    }
    
    public Long totalDiarias(String dataEnt, String dataSai) {    	  	
        long diff = -1;
        String value=diff+"";
        try {          
          Date dataEntrada = sdf.parse(dataEnt);
          Date dataSaida = sdf.parse(dataSai);
          //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
          diff = Math.round((dataSaida.getTime() - dataEntrada.getTime()) / (double) 86400000);
          value = diff+"";
          
          
        } catch (Exception e) {
          System.out.println("ERRO: DATA DE ENTRADA APÓS DATA DE SAIDA");
         // System.out.println("---"+dataEnt);
          //System.out.println("---"+dataSai);
          //System.out.println("---------");
          //System.out.println("---"+dataEntrada);
          //System.out.println("---"+dataSaida);
        }
        return diff;
        
  }   
     
    public Reserva() {
		// TODO Auto-generated constructor stub
	}


	public void consultar(){
        //DAO
    }
    
    public boolean registrarReserva(){
        //DAO
        return false; 
    }
    
    
    /**
     * @return the codigo
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dataEntrada
     */
    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the deposito
     */
    public double getDeposito() {
        return deposito;
    }

    /**
     * @param deposito the deposito to set
     */
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
