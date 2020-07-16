package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import fatec.hotel.Cliente;
import fatec.hotel.Quarto;
import fatec.hotel.Reserva;
import fatec.hotel.Servico;
import DAO.ClienteDAO;
import DAO.QuartoDAO;
import DAO.ReservaDAO;
import DAO.ServicoDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class home extends JFrame {
	
	//////////////////////////////////////////////// CRIANDO OS MODELS PARA LISTAS //////////////////////////////////////////
	
	QuartoTableModel modeloQuarto = new QuartoTableModel();
	ClienteTableModel modeloCliente = new ClienteTableModel();
	ReservaTableModel modeloReserva = new ReservaTableModel();
	ServicoTableModel modeloServico = new ServicoTableModel();
	
	private void carregarListaQuarto() {			
		String busca = txtNumQuarto.getText();
		QuartoDAO dao = new QuartoDAO();
		List<Quarto> lista =dao.returnList("");
		modeloQuarto.setDados(lista);
		if (busca != "") {
			List<Quarto> lista2 =dao.returnList(busca);
			modeloQuarto.setDados(lista2);
		}			
		tableQuarto.setModel(modeloQuarto);
	}
	
	private void carregarListaCliente() {			
		String busca = txtCPFCliente.getText();
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> lista =dao.returnList("");
		modeloCliente.setDados(lista);
		if (busca != "") {
			List<Cliente> lista2 =dao.returnList(busca);
			modeloCliente.setDados(lista2);
		}			
		tableCliente.setModel(modeloCliente);
	}
	
	private void carregarListaReserva() {			
		String busca = txtCodigo.getText();
		ReservaDAO dao = new ReservaDAO();
		List<Reserva> lista =dao.returnList("");
		modeloReserva.setDados(lista);
		if (busca != "") {
			List<Reserva> lista2 =dao.returnList(busca);
			modeloReserva.setDados(lista2);
		}			
		tableReserva.setModel(modeloReserva);
	}
	
	private void carregarListaServico() {			
		String busca = txtCodigoServico.getText();
		ServicoDAO dao = new ServicoDAO();
		List<Servico> lista =dao.returnList("");
		modeloServico.setDados(lista);
		if (busca != "") {
			List<Servico> lista2 =dao.returnList(busca);
			modeloServico.setDados(lista2);
		}			
		tableServico.setModel(modeloServico);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private JPanel txtNome;
	private JTextField txtCodigo;
	private JTextField txtEntrada;
	private JTextField txtSaida;
	private JTextField txtDeposito;
	private JTextField txtQuarto;
	private JTextField txtCPF;
	private JTextField txtCodCliente;
	private JTextField txtNomeCliente;
	private JTextField txtLogradouroCliente;
	private JTextField txtDataNascimentoCliente;
	private JTextField txtCidadeCliente;
	private JTextField txtCPFCliente;
	private JTextField txtBairroCliente;
	private JTextField txtEstadoCliente;
	private JTextField txtCEPCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtNumQuarto;
	private JTextField txtValorQuarto;
	private JTextField txtDescricaoQuarto;
	private JTable tableQuarto;
	private JTable tableReserva;
	private JTable tableCliente;
	private JTextField txtCodigoServico;
	private JTextField txtValorServico;
	private JTextField txtDescricaoServico;
	private JTable tableServico;
	private JTextField textCodReservaFinal;
	private JTextField textInserirServicoFInal;
	private JTextField txtValorTotalDiarias;
	private JTextField txtValorTotalServico;
	private JTextField txtValorTotalReserva;
	private JTextField txtNumQuartoFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setTitle("HOTEL ALABAMA");		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 441);
		txtNome = new JPanel();
		txtNome.setBackground(new Color(211, 211, 211));
		txtNome.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(txtNome);
		txtNome.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(102, 102, 255));
		menu.setBounds(0, 0, 140, 407);
		txtNome.add(menu);
		menu.setLayout(null);
		
		
		
		
		JPanel cliente = new JPanel();
		cliente.setBounds(140, 0, 564, 407);
		txtNome.add(cliente);
		cliente.setBackground(new Color(211, 211, 211));
		cliente.setLayout(null);
		
		JLabel lblCodCliente = new JLabel("Código do Cliente");
		lblCodCliente.setBounds(10, 55, 134, 14);
		cliente.add(lblCodCliente);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setColumns(10);
		txtCodCliente.setBounds(10, 77, 191, 20);
		cliente.add(txtCodCliente);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 108, 134, 14);
		cliente.add(lblNomeCompleto);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(10, 130, 191, 20);
		cliente.add(txtNomeCliente);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(10, 161, 134, 14);
		cliente.add(lblLogradouro);
		
		txtLogradouroCliente = new JTextField();
		txtLogradouroCliente.setColumns(10);
		txtLogradouroCliente.setBounds(10, 183, 191, 20);
		cliente.add(txtLogradouroCliente);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(211, 108, 134, 14);
		cliente.add(lblDataDeNascimento);
		
		txtDataNascimentoCliente = new JTextField();
		txtDataNascimentoCliente.setColumns(10);
		txtDataNascimentoCliente.setBounds(211, 130, 191, 20);
		cliente.add(txtDataNascimentoCliente);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(211, 161, 134, 14);
		cliente.add(lblCidade);
		
		txtCidadeCliente = new JTextField();
		txtCidadeCliente.setColumns(10);
		txtCidadeCliente.setBounds(211, 183, 191, 20);
		cliente.add(txtCidadeCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				Cliente obj = new Cliente();
				obj.setCodigo(Long.parseLong(txtCodCliente.getText()));
				obj.setNome(txtNomeCliente.getText());
				obj.setCpf(Integer.parseInt(txtCPFCliente.getText()));
				obj.setDataNascimento(txtDataNascimentoCliente.getText());
				obj.setLogradouro(txtLogradouroCliente.getText());
				obj.setBairro(txtBairroCliente.getText());
				obj.setCidade(txtCidadeCliente.getText());
				obj.setEstado(txtEstadoCliente.getText());
				obj.setTelefone(txtTelefoneCliente.getText());
				obj.setCep(Integer.parseInt(txtCEPCliente.getText()));				
				
				
				ClienteDAO dao = new ClienteDAO();
				   if(dao.inserir(obj)==1){
			    	   JOptionPane.showMessageDialog(cliente, "Cadastrado com sucesso");
			       } else {
			    	   JOptionPane.showMessageDialog(cliente, "ERROR");
			       }
			}
		});
		btnCadastrarCliente.setBounds(412, 90, 134, 23);
		cliente.add(btnCadastrarCliente);
		
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Cliente");
		lblCadastroDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCadastroDeCliente.setBounds(10, 11, 216, 31);
		cliente.add(lblCadastroDeCliente);
		
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent arg0) {			
				tableCliente.repaint();
				carregarListaCliente();
			}
		});
		btnBuscarCliente.setBounds(412, 117, 134, 23);
		cliente.add(btnBuscarCliente);
		
		txtCPFCliente = new JTextField();
		txtCPFCliente.setColumns(10);
		txtCPFCliente.setBounds(211, 77, 191, 20);
		cliente.add(txtCPFCliente);
		
		JLabel lblCpfDoCliente_cliente = new JLabel("CPF do Cliente");
		lblCpfDoCliente_cliente.setBounds(211, 55, 134, 14);
		cliente.add(lblCpfDoCliente_cliente);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.setBounds(412, 142, 134, 23);
		cliente.add(btnAlterarCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.setBounds(412, 170, 134, 23);
		cliente.add(btnExcluirCliente);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 214, 134, 14);
		cliente.add(lblBairro);
		
		txtBairroCliente = new JTextField();
		txtBairroCliente.setColumns(10);
		txtBairroCliente.setBounds(10, 236, 191, 20);
		cliente.add(txtBairroCliente);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(211, 214, 134, 14);
		cliente.add(lblEstado);
		
		txtEstadoCliente = new JTextField();
		txtEstadoCliente.setColumns(10);
		txtEstadoCliente.setBounds(211, 236, 191, 20);
		cliente.add(txtEstadoCliente);
		
		JLabel lblTelefone = new JLabel("CEP");
		lblTelefone.setBounds(10, 267, 134, 14);
		cliente.add(lblTelefone);
		
		txtCEPCliente = new JTextField();
		txtCEPCliente.setColumns(10);
		txtCEPCliente.setBounds(10, 289, 191, 20);
		cliente.add(txtCEPCliente);
		
		JLabel lblTelefone_1 = new JLabel("Telefone");
		lblTelefone_1.setBounds(211, 267, 134, 14);
		cliente.add(lblTelefone_1);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(211, 289, 191, 20);
		cliente.add(txtTelefoneCliente);
		
		tableCliente = new JTable();
		tableCliente.setBounds(10, 317, 498, 79);
		cliente.add(tableCliente);
				
		
		JPanel reserva = new JPanel();
		reserva.setBackground(new Color(211, 211, 211));
		reserva.setBounds(140, 0, 564, 407);
		txtNome.add(reserva);
		reserva.setLayout(null);
		
		JLabel lblCod = new JLabel("Código da Reserva");
		lblCod.setBounds(10, 55, 134, 14);
		reserva.add(lblCod);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 77, 191, 20);
		reserva.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lvlDtEnt = new JLabel("Data de Entrada");
		lvlDtEnt.setBounds(10, 108, 134, 14);
		reserva.add(lvlDtEnt);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(10, 130, 191, 20);
		reserva.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JLabel lblDtSai = new JLabel("Data de Saida");
		lblDtSai.setBounds(10, 161, 134, 14);
		reserva.add(lblDtSai);
		
		txtSaida = new JTextField();
		txtSaida.setBounds(10, 183, 191, 20);
		reserva.add(txtSaida);
		txtSaida.setColumns(10);
		
		JLabel lblDepositoentrada = new JLabel("Deposito (Entrada)");
		lblDepositoentrada.setBounds(211, 108, 134, 14);
		reserva.add(lblDepositoentrada);
		
		txtDeposito = new JTextField();
		txtDeposito.setBounds(211, 130, 191, 20); 
		reserva.add(txtDeposito);
		txtDeposito.setColumns(10);
		
		JLabel lblNmeroDoQuarto = new JLabel("Número do Quarto");
		lblNmeroDoQuarto.setBounds(211, 161, 134, 14);
		reserva.add(lblNmeroDoQuarto);
		
		txtQuarto = new JTextField();
		txtQuarto.setBounds(211, 183, 191, 20);
		reserva.add(txtQuarto);
		txtQuarto.setColumns(10);	
		
		
		JButton btnReserva = new JButton("Confirmar Reserva");
		btnReserva.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				
				Cliente c = new ClienteDAO().getClienteCpf(Integer.parseInt(txtCPF.getText()));
				Cliente clientePesquisado;
				clientePesquisado = null;
				if(c == null) {
					JOptionPane.showMessageDialog(reserva, "Cliente nao encontrado");
				} else {
					clientePesquisado = c;
				}
				
				Quarto q = new QuartoDAO().isDisponivel(Integer.parseInt(txtQuarto.getText()));
				Quarto quarto_disponivel;
				quarto_disponivel=null;
				if (q==null) {
					JOptionPane.showMessageDialog(reserva, "Cliente nao encontrado");
				} else {
					quarto_disponivel = q;
				}
				
				Reserva obj = new Reserva();
				obj.setCodigo(Long.parseLong(txtCodigo.getText()));
				obj.setDataEntrada(txtEntrada.getText());
				obj.setDataSaida(txtSaida.getText());
				obj.setCliente(c);				
				obj.setDeposito(Double.parseDouble(txtDeposito.getText()));
				obj.setQuarto(quarto_disponivel);
				
				ReservaDAO dao = new ReservaDAO();
				   if(dao.inserir(obj)==1 && c.getCpf() != null && q.isDisponibilidae()){
			    	   JOptionPane.showMessageDialog(reserva, "Cadastrado com sucesso");
			    	   QuartoDAO disp = new QuartoDAO();
			    	   disp.changeDisponibilidade(q);
			    	   System.out.println(c.getCpf());
			    	   System.out.println(q.isDisponibilidae());
			       } else {
			    	   JOptionPane.showMessageDialog(reserva, "Cliente não Encontrado ou quarto Indisponivel");
			       }
			}
		});
		btnReserva.setBounds(412, 90, 134, 23);
		reserva.add(btnReserva);		
		
		JLabel lblNewLabel = new JLabel("Reserva de quartos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 216, 31);
		reserva.add(lblNewLabel);
		
		JButton btnBuscarReserva = new JButton("Buscar Reserva");
		btnBuscarReserva.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				tableReserva.repaint();
				carregarListaReserva();
			}
		});
		btnBuscarReserva.setBounds(412, 117, 134, 23);
		reserva.add(btnBuscarReserva);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(211, 77, 191, 20);
		reserva.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente");
		lblCpfDoCliente.setBounds(211, 55, 134, 14);
		reserva.add(lblCpfDoCliente);
		
		JButton btnAlterarReserva = new JButton("Alterar Reserva");
		btnAlterarReserva.setBounds(412, 142, 134, 23);
		reserva.add(btnAlterarReserva);
		
		JButton btnExcluirReserva = new JButton("Excluir Reserva");
		btnExcluirReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				ReservaDAO dao = new ReservaDAO();
				if (dao.remover(codigo) > 0) {
					Quarto q = new QuartoDAO().isDisponivel(Integer.parseInt(txtQuarto.getText()));					
					QuartoDAO disp = new QuartoDAO();
				    disp.changeDisponibilidade(q);					
					JOptionPane.showMessageDialog(cliente, "Reserva removida com sucesso");
				} else {
					JOptionPane.showMessageDialog(cliente, "Reserva não alterado");
				}

			}
		});
		btnExcluirReserva.setBounds(412, 170, 134, 23);
		reserva.add(btnExcluirReserva);		
		
		tableReserva = new JTable();
		tableReserva.setBounds(10, 214, 532, 182);
		reserva.add(tableReserva);
		
		
		JPanel quarto = new JPanel();
		quarto.setLayout(null);
		quarto.setBackground(new Color(211, 211, 211));
		quarto.setBounds(140, 2, 564, 407);
		txtNome.add(quarto);
		
		JLabel lblCdigoDoQuarto = new JLabel("Numero do Quarto");
		lblCdigoDoQuarto.setBounds(10, 55, 134, 14);
		quarto.add(lblCdigoDoQuarto);
		
		txtNumQuarto = new JTextField();
		txtNumQuarto.setColumns(10);
		txtNumQuarto.setBounds(10, 77, 191, 20);
		quarto.add(txtNumQuarto);
		
		JLabel lblValorDoQuarto = new JLabel("Valor do Quarto");
		lblValorDoQuarto.setBounds(10, 108, 134, 14);
		quarto.add(lblValorDoQuarto);
		
		txtValorQuarto = new JTextField();
		txtValorQuarto.setColumns(10);
		txtValorQuarto.setBounds(10, 130, 191, 20);
		quarto.add(txtValorQuarto);
					
		JLabel lblCriaoDeQuartos = new JLabel("Criação de Quartos");
		lblCriaoDeQuartos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCriaoDeQuartos.setBounds(10, 11, 216, 31);
		quarto.add(lblCriaoDeQuartos);
		
		JButton btnBuscarQuarto = new JButton("Buscar Quarto");
		btnBuscarQuarto.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent arg0) {
				tableQuarto.repaint();
				carregarListaQuarto();
			}
		});		
		btnBuscarQuarto.setBounds(412, 104, 134, 23);
		quarto.add(btnBuscarQuarto);
		
		txtDescricaoQuarto = new JTextField();
		txtDescricaoQuarto.setColumns(10);
		txtDescricaoQuarto.setBounds(211, 77, 191, 20);
		quarto.add(txtDescricaoQuarto);
		
		JButton btnCadastroQuarto = new JButton("Cadastrar Quarto");
		btnCadastroQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quarto obj = new Quarto();
				obj.setNumero(Long.parseLong(txtNumQuarto.getText()));
				obj.setDescritivo(txtDescricaoQuarto.getText());
				obj.setDisponibilidae(true);
				obj.setValorDiaria(Double.parseDouble(txtValorQuarto.getText()));
				
				QuartoDAO dao = new QuartoDAO();
				   if(dao.inserir(obj)==1){
			    	   JOptionPane.showMessageDialog(cliente, "Cadastrado com sucesso");
			       } else {
			    	   JOptionPane.showMessageDialog(cliente, "ERROR");
			       }
			}
		});
		
		btnCadastroQuarto.setBounds(412, 77, 134, 23);
		quarto.add(btnCadastroQuarto);
		
		JLabel lblDescriaDoQuarto = new JLabel("Descrição do Quarto");
		lblDescriaDoQuarto.setBounds(211, 55, 134, 14);
		quarto.add(lblDescriaDoQuarto);
		
		JButton btnAlterarQuarto = new JButton("Alterar Quarto");
		btnAlterarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quarto obj = new Quarto();
				obj.setNumero(Long.parseLong(txtNumQuarto.getText()));
				obj.setDescritivo(txtDescricaoQuarto.getText());
				obj.setDisponibilidae(true);
				obj.setValorDiaria(Double.parseDouble(txtValorQuarto.getText()));
				
				QuartoDAO dao = new QuartoDAO();
				   if(dao.alterar(obj)>0){
			    	   JOptionPane.showMessageDialog(cliente, "Quarto alterado com sucesso");
			       } else {
			    	   JOptionPane.showMessageDialog(cliente, "ERROR");
			       }
			}
		});
		btnAlterarQuarto.setBounds(412, 129, 134, 23);
		quarto.add(btnAlterarQuarto);
		
		JButton btnExcluirQuarto = new JButton("Excluir Quarto");
		btnExcluirQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(txtNumQuarto.getText());
				QuartoDAO dao = new QuartoDAO();				
				if (dao.remover(numero) > 0) {
					JOptionPane.showMessageDialog(cliente, "Quarto removido com sucesso");
				} else {
					JOptionPane.showMessageDialog(cliente, "Quarto não alterado");
				}
			}
		});
		btnExcluirQuarto.setBounds(412, 157, 134, 23);
		quarto.add(btnExcluirQuarto);
		
		tableQuarto = new JTable();
		tableQuarto.setBounds(29, 209, 498, 187);
		quarto.add(tableQuarto);
		
		
		
		JPanel servicos = new JPanel();
		servicos.setLayout(null);
		servicos.setBackground(new Color(211, 211, 211));
		servicos.setBounds(140, 0, 564, 407);
		txtNome.add(servicos);
		
		JLabel lblCodigoDoServio = new JLabel("Codigo do Serviço");
		lblCodigoDoServio.setBounds(10, 55, 134, 14);
		servicos.add(lblCodigoDoServio);
		
		txtCodigoServico = new JTextField();
		txtCodigoServico.setColumns(10);
		txtCodigoServico.setBounds(10, 77, 191, 20);
		servicos.add(txtCodigoServico);
		
		JLabel lblValorDoServio = new JLabel("Valor do Serviço");
		lblValorDoServio.setBounds(10, 108, 134, 14);
		servicos.add(lblValorDoServio);
		
		txtValorServico = new JTextField();
		txtValorServico.setColumns(10);
		txtValorServico.setBounds(10, 130, 191, 20);
		servicos.add(txtValorServico);
		
		JLabel lblCriaoDeServio = new JLabel("Criação de Serviço");
		lblCriaoDeServio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCriaoDeServio.setBounds(10, 11, 216, 31);
		servicos.add(lblCriaoDeServio);
		
		JButton btnBuscarServico = new JButton("Buscar Servico");
		btnBuscarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableServico.repaint();
				carregarListaServico();
			}
		});
		btnBuscarServico.setBounds(412, 104, 134, 23);
		servicos.add(btnBuscarServico);
		
		txtDescricaoServico = new JTextField();
		txtDescricaoServico.setColumns(10);
		txtDescricaoServico.setBounds(211, 77, 191, 20);
		servicos.add(txtDescricaoServico);
		
		JButton btnCadastrarServico = new JButton("Cadastrar Servico");
		btnCadastrarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servico obj = new Servico();
				obj.setCodigo(Long.parseLong(txtCodigoServico.getText()));
				obj.setDescritivo(txtDescricaoServico.getText());
				obj.setValor(Double.parseDouble(txtValorServico.getText()));				
				
				ServicoDAO dao = new ServicoDAO();
				   if(dao.inserir(obj)>0){
			    	   JOptionPane.showMessageDialog(cliente, "Servico inserido com sucesso");
			       } else {
			    	   JOptionPane.showMessageDialog(cliente, "ERROR");
			       }
			}
		});
		btnCadastrarServico.setBounds(412, 77, 134, 23);
		servicos.add(btnCadastrarServico);
		
		JLabel lblDescrioDoServio = new JLabel("Descrição do Serviço");
		lblDescrioDoServio.setBounds(211, 55, 134, 14);
		servicos.add(lblDescrioDoServio);
		
		JButton btnAlterarServico = new JButton("Alterar Servico");
		btnAlterarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servico obj = new Servico();
				obj.setCodigo(Long.parseLong(txtCodigoServico.getText()));
				obj.setDescritivo(txtDescricaoServico.getText());
				obj.setValor(Double.parseDouble(txtValorServico.getText()));				
				
				ServicoDAO dao = new ServicoDAO();
				   if(dao.alterar(obj)>0){
			    	   JOptionPane.showMessageDialog(cliente, "Servico alterado com sucesso");
			       } else {
			    	   JOptionPane.showMessageDialog(cliente, "ERROR");
			       }
			}
		});
		btnAlterarServico.setBounds(412, 129, 134, 23);
		servicos.add(btnAlterarServico);
		
		JButton btnExcluirServico = new JButton("Excluir Servico");
		btnExcluirServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigoServico.getText());
				ServicoDAO dao = new ServicoDAO();				
				if (dao.remover(codigo) > 0) {
					JOptionPane.showMessageDialog(cliente, "Servico removido com sucesso");
				} else {
					JOptionPane.showMessageDialog(cliente, "Servico não alterado");
				}
			}
		});
		btnExcluirServico.setBounds(412, 157, 134, 23);
		servicos.add(btnExcluirServico);
		
		tableServico = new JTable();
		tableServico.setBounds(29, 209, 498, 187);
		servicos.add(tableServico);		
		
		JPanel finalizar = new JPanel();
		finalizar.setLayout(null);
		finalizar.setBackground(new Color(211, 211, 211));
		finalizar.setBounds(140, 0, 564, 407);
		txtNome.add(finalizar);
		
		JLabel lblCodCliente_1 = new JLabel("Código da Reserva");
		lblCodCliente_1.setBounds(10, 55, 134, 14);
		finalizar.add(lblCodCliente_1);
		
		textCodReservaFinal = new JTextField();
		textCodReservaFinal.setColumns(10);
		textCodReservaFinal.setBounds(10, 77, 102, 20);
		finalizar.add(textCodReservaFinal);
		
		JButton btnBuscarReservaFinal = new JButton("Buscar Reserva");
		btnBuscarReservaFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double total;
				ReservaDAO dao = new ReservaDAO();
				dao.getReserva(Integer.parseInt(textCodReservaFinal.getText()));
				//txtValorTotalDiarias.setText(dao.getReserva(Integer.parseInt(textCodReservaFinal.getText())));	
				QuartoDAO qdao = new QuartoDAO();
				qdao.getValor(Integer.parseInt(txtNumQuartoFinal.getText()));
				
				total = qdao.getValor(Integer.parseInt(txtNumQuartoFinal.getText())) * dao.getReserva(Integer.parseInt(textCodReservaFinal.getText()) );
				
				if (total >0) {
					txtValorTotalDiarias.setText(""+total);
				} else {
					JOptionPane.showMessageDialog(reserva, "Reserva Não Encontrada");
				}
				
			}
		});
		btnBuscarReservaFinal.setBounds(238, 76, 134, 23);
		finalizar.add(btnBuscarReservaFinal);
		
		JLabel lblFecharReserva = new JLabel("Fechar Reserva");
		lblFecharReserva.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFecharReserva.setBounds(10, 11, 216, 31);
		finalizar.add(lblFecharReserva);
		
		JButton btnAdicionarServicoFinal = new JButton("Adicionar Serviço");
		btnAdicionarServicoFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ServicoDAO dao = new ServicoDAO();
				dao.valorTotalServico(Integer.parseInt(textInserirServicoFInal.getText()));
				double total;
				//total = dao.valorTotalServico(Integer.parseInt(textInserirServicoFInal.getText()));
				total = Double.parseDouble(txtValorTotalServico.getText()) + dao.valorTotalServico(Integer.parseInt(textInserirServicoFInal.getText()));
				
				if (total >0) {
					txtValorTotalServico.setText(""+total);
				} else {
					JOptionPane.showMessageDialog(reserva, "Servico Não Encontrado");
				}				
			}
		});
		btnAdicionarServicoFinal.setBounds(238, 132, 134, 23);
		finalizar.add(btnAdicionarServicoFinal);
		
		JButton btnFinalizarReserva = new JButton("Finalizar Reserva");
		btnFinalizarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total;
				ReservaDAO dao = new ReservaDAO();								
				double deposito;
				deposito = dao.getDeposito(Integer.parseInt(textCodReservaFinal.getText()));
				total = (Double.parseDouble(txtValorTotalServico.getText()) + Double.parseDouble(txtValorTotalDiarias.getText())) - deposito; 
				txtValorTotalReserva.setText(""+total);
				
			}
		});
		btnFinalizarReserva.setBounds(406, 77, 134, 78);
		finalizar.add(btnFinalizarReserva);
		
		textInserirServicoFInal = new JTextField();
		textInserirServicoFInal.setColumns(10);
		textInserirServicoFInal.setBounds(10, 133, 191, 20);
		finalizar.add(textInserirServicoFInal);
		
		JLabel lblCodCliente_1_1 = new JLabel("Inserir Serviço");
		lblCodCliente_1_1.setBounds(10, 108, 134, 14);
		finalizar.add(lblCodCliente_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Diarias");
		lblNewLabel_1.setBounds(10, 175, 84, 14);
		finalizar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Valor Servicos");
		lblNewLabel_1_1.setBounds(117, 175, 84, 14);
		finalizar.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Valor Total a Pagar");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(267, 175, 235, 37);
		finalizar.add(lblNewLabel_1_2);
		
		txtValorTotalDiarias = new JTextField();
		txtValorTotalDiarias.setEditable(false);
		txtValorTotalDiarias.setColumns(10);
		txtValorTotalDiarias.setBounds(10, 192, 84, 20);
		finalizar.add(txtValorTotalDiarias);
		
		txtValorTotalServico = new JTextField();
		txtValorTotalServico.setEditable(false);
		txtValorTotalServico.setColumns(10);
		txtValorTotalServico.setBounds(117, 192, 84, 20);
		finalizar.add(txtValorTotalServico);
		
		txtValorTotalReserva = new JTextField();
		txtValorTotalReserva.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtValorTotalReserva.setEditable(false);
		txtValorTotalReserva.setColumns(10);
		txtValorTotalReserva.setBounds(277, 223, 191, 31);
		finalizar.add(txtValorTotalReserva);
		
		JLabel lblCodCliente_1_2 = new JLabel("Numero Do Quarto");
		lblCodCliente_1_2.setBounds(117, 55, 134, 14);
		finalizar.add(lblCodCliente_1_2);
		
		txtNumQuartoFinal = new JTextField();
		txtNumQuartoFinal.setColumns(10);
		txtNumQuartoFinal.setBounds(117, 77, 102, 20);
		finalizar.add(txtNumQuartoFinal);
		
		JButton btnPagarConta = new JButton("Pagar Conta");
		btnPagarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deletar resera e mudar disponibiliade do quarto
				
				int codigo = Integer.parseInt(txtCodigo.getText());
				ReservaDAO dao = new ReservaDAO();
				if (dao.remover(codigo) > 0) {
					Quarto q = new QuartoDAO().isDisponivel(Integer.parseInt(txtQuarto.getText()));
					QuartoDAO disp = new QuartoDAO();
			    	disp.changeDisponibilidade(q);
				} else {
					JOptionPane.showMessageDialog(cliente, "ERRO AO PAGAR CONTA");
				}
			}
		});
		btnPagarConta.setBounds(305, 265, 134, 23);
		finalizar.add(btnPagarConta);
		
		///////////////////////////// BOTÕES DO MENU//////////////////////////////////////////////////////////

		JButton btnCallCliente = new JButton("Cliente");
		btnCallCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				servicos.setVisible(false);
				reserva.setVisible(false);
				quarto.setVisible(false);
				cliente.setVisible(true);
				finalizar.setVisible(false);
			}
		});
		btnCallCliente.setBounds(10, 78, 121, 23);
		menu.add(btnCallCliente);

		JButton btnCallReserva = new JButton("Reserva");
		btnCallReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicos.setVisible(false);
				reserva.setVisible(true);
				quarto.setVisible(false);
				cliente.setVisible(false);
				finalizar.setVisible(false);
			}
		});
		btnCallReserva.setBounds(10, 112, 121, 23);
		menu.add(btnCallReserva);

		JButton btnCallQuartos = new JButton("Quartos");
		btnCallQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicos.setVisible(false);
				reserva.setVisible(false);
				quarto.setVisible(true);
				cliente.setVisible(false);
				finalizar.setVisible(false);
			}
		});
		btnCallQuartos.setBounds(10, 146, 121, 23);
		menu.add(btnCallQuartos);

		JButton btnServicos = new JButton("Serviços");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicos.setVisible(true);
				reserva.setVisible(false);
				quarto.setVisible(false);
				cliente.setVisible(false);
				finalizar.setVisible(false);
			}
		});
		btnServicos.setBounds(10, 180, 121, 23);
		menu.add(btnServicos);

		JButton btnFecharReserva = new JButton("Fechar Reserva");
		btnFecharReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicos.setVisible(false);
				reserva.setVisible(false);
				quarto.setVisible(false);
				cliente.setVisible(false);
				finalizar.setVisible(true);
				txtValorTotalServico.setText("0");
			}
		});		
		btnFecharReserva.setBounds(10, 335, 121, 61);
		menu.add(btnFecharReserva);

		////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
