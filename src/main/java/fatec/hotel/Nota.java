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
public class Nota {
    private Long numero;
    private String dataEmissao;
    private double total;
    
    public Nota(Long numero, String dataEmissao, double total){
        this.setDataEmissao(dataEmissao);
        this.setNumero(numero);
        this.setTotal(total);
    }

    
    public void consultar(){
        //DAO
    }
    
    public void emitir(){
        //DAO
    }
    /**
     * @return the numero
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * @return the dataEmissao
     */
    public String getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}
