package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fatec.hotel.Quarto;

public class QuartoTableModel extends AbstractTableModel {
	private List<Quarto> dados = new ArrayList<Quarto>();
    private String[] colunas = {"numero","descritivo","disponibilidade","valorDiaria"};
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
        case 0: return this.dados.get(linha).getNumero();
        case 1: return this.dados.get(linha).getDescritivo();
        case 2: return this.dados.get(linha).isDisponibilidae();
        case 3: return this.dados.get(linha).getValorDiaria();
        default: return null;
		}		
	}
	@Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Quarto> getDados() {
        return dados;
    }
    public void setDados(List<Quarto> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Quarto retornaObjeto(int linha){
        return dados.get(linha);
    }
	
}
