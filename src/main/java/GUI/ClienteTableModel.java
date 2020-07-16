package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fatec.hotel.Cliente;


public class ClienteTableModel extends AbstractTableModel {
	
	private List<Cliente> dados = new ArrayList<Cliente>();
    private String[] colunas = {"codigo","nome","cpf","telefone"};
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
        case 1: return this.dados.get(linha).getNome();
        case 2: return this.dados.get(linha).getCpf();
        case 3: return this.dados.get(linha).getTelefone();
        default: return null;
		}		
	}
	@Override
    public String getColumnName(int coluna) {
        return getColunas()[coluna];
    }
    public List<Cliente> getDados() {
        return dados;
    }
    public void setDados(List<Cliente> dados) {
        this.dados = dados;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    public Cliente retornaObjeto(int linha){
        return dados.get(linha);
    }
}
