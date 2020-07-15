/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.hotel;

/**
 *
 * @author norton
 */
public class Reserva {
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
