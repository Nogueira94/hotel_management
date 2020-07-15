package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fatec.hotel.Cliente;
import fatec.hotel.Quarto;
import fatec.hotel.Reserva;
import DAO.ClienteDAO;
import DAO.ReservaDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 854);
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
				
		
		JPanel reserva = new JPanel();
		reserva.setBackground(new Color(211, 211, 211));
		reserva.setBounds(150, 0, 554, 407);
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
				
				Cliente c = new ClienteDAO().getClienteCpf(txtCPF.getText());
				Cliente clientePesquisado;
				clientePesquisado = null;
				if(c == null) {
					JOptionPane.showConfirmDialog(reserva, "Cliente nao encontrado");
				} else {
					clientePesquisado = c;
				}
				
				Reserva obj = new Reserva();
				obj.setCodigo(Long.parseLong(txtCodigo.getText()));
				obj.setDataEntrada(txtEntrada.getText());
				obj.setDataSaida(txtSaida.getText());
				obj.setCliente(c);				
				obj.setDeposito(Double.parseDouble(txtDeposito.getText()));
				obj.setQuarto(txtQuarto.getText());
				
				ReservaDAO dao = new ReservaDAO();
				   if(dao.inserir(obj)==1){
			    	   JOptionPane.showConfirmDialog(reserva, "Cadastrado com sucesso");
			       } else {
			    	   JOptionPane.showConfirmDialog(reserva, "ERROR");
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
		btnExcluirReserva.setBounds(412, 170, 134, 23);
		reserva.add(btnExcluirReserva);		
		
		
		JPanel cliente = new JPanel();
		cliente.setBackground(new Color(211, 211, 211));
		cliente.setBounds(150, 408, 564, 407);
		txtNome.add(cliente);
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
			    	   JOptionPane.showConfirmDialog(cliente, "Cadastrado com sucesso");
			       } else {
			    	   JOptionPane.showConfirmDialog(cliente, "ERROR");
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
		
		
		/////////////////////////////BOTÕES DO MENU
		
		JButton btnCallCliente = new JButton("Cliente");
		btnCallCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reserva.setVisible(false);
				cliente.setVisible(true);
			}
		});
		btnCallCliente.setBounds(10, 108, 121, 23);
		menu.add(btnCallCliente);
		
		JButton btnCallReserva = new JButton("Reserva");
		btnCallReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reserva.setVisible(true);
				cliente.setVisible(false);
			}
		});
		btnCallReserva.setBounds(10, 69, 121, 23);
		menu.add(btnCallReserva);
	}
}
