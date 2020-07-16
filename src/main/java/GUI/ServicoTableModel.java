package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fatec.hotel.Servico;

public class ServicoTableModel extends AbstractTableModel{
	private List<Servico> dados = new ArrayList<Servico>();
    private String[] colunas = {"codigo","descritivo","valor"};
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
        case 1: return this.dados.get(linha).getDescritivo();
        case 2: return this.dados.get(linha).getValor();      
               
        default: return null;
		}		
	}
	@Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Servico> getDados() {
        return dados;
    }
    public void setDados(List<Servico> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Servico retornaObjeto(int linha){
        return dados.get(linha);
    }
}
