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
public class Servico {
    private long codigo;
    private String descritivo;
    private double valor; 
    
    public Servico(long codigo, String descritivo, double valor){
        this.setCodigo(codigo);
        this.setDescritivo(descritivo);    
        this.setValor(valor);
    }

    public Servico() {
		// TODO Auto-generated constructor stub
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
     * @return the descritivo
     */
    public String getDescritivo() {
        return descritivo;
    }

    /**
     * @param descritivo the descritivo to set
     */
    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}
