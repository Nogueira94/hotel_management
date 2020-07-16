package fatec.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hospedagem extends Reserva {
    private List<Servico> gastos = new ArrayList<Servico>();
    private int diarias;
    private double valorTotal;    
       
    
    public Hospedagem(Long codigo, String dataEntrada, String dataSaida, Cliente cliente, Double deposito, Quarto quarto) {
        super(codigo, dataEntrada, dataSaida, cliente, deposito, quarto);
    }
    
//    public void adicionarGasto(Servico obj){
//        gastos.add(obj);
//        calculaTotal();
//    }
        
    
//    public void calculaTotal(){
//        double totalDiarias = super.totalDiarias() * this.getQuarto().getValorDiaria();
//        double totalGastos =0;
//        for(Servico obj : gastos){
//           totalGastos += obj.getValor();
//        }
//        this.setValorTotal(totalDiarias+totalGastos);
//    }
    
        
//    public void fecharConta(){
//        //DAO
//        calculaTotal();        
//    }       
    
    
    /**
     * @return the gastos
     */
    public List<Servico> getGastos() {
        return gastos;
    }

    /**
     * @param gastos the gastos to set
     */
    public void setGastos(List<Servico> gastos) {
        this.gastos = gastos;
    }

    /**
     * @return the diarias
     */
    public int getDiarias() {
        return diarias;
    }

    /**
     * @param diarias the diarias to set
     */
    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }    
    
}
