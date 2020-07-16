package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import DAO.ClienteDAO;
import fatec.hotel.Cliente;
import fatec.hotel.Reserva;

public class ReservaTableModel extends AbstractTableModel {
	private List<Reserva> dados = new ArrayList<Reserva>();
    private String[] colunas = {"codigo","dtEntr","dtSaida","cliente","deposito","quarto"};
	@Override
    public int getRowCount() {
        return getDados().size();
    }
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

	@Override
	public Object getValueAt(int linha, int coluna) {		
		switch(coluna){
        case 0: return this.dados.get(linha).getCodigo();
        case 1: return this.dados.get(linha).getDataEntrada();
        case 2: return this.dados.get(linha).getDataSaida();        
        case 3: return this.dados.get(linha).getCliente().getCpf();
        case 4: return this.dados.get(linha).getDeposito();
        case 5: return this.dados.get(linha).getQuarto().getNumero();        
        default: return null;
		}		
	}
	@Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Reserva> getDados() {
        return dados;
    }
    public void setDados(List<Reserva> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Reserva retornaObjeto(int linha){
        return dados.get(linha);
    }
}
