	package ui;

	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.File;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;

	import arquivos.DataHora;
	import arquivos.GerarCodigo;
	import dao.MovimentoDao;


	public class FrameEstacionamento {
		
		private JLabel labelEntrada;
		private JLabel labelPlaca;
		private JTextField textPlaca;
		private JLabel labelModelo;
		private JTextField textModelo;
		private JButton buttonEntrar;
		private JLabel labelSaida;
		private JLabel labelBuscarPlaca;
		private JTextField textBuscarPlaca;
		private JButton buttonBuscar;
		private JLabel labelModelo2;
		private JTextField textModelo2;
		private JLabel labelDataEntrada;
		private JTextField textDataEntrada;
		private JLabel labelHoraEntrada;
		private JTextField textHoraEntrada;
		private JLabel labelDataSaida;
		private JTextField textDataSaida;
		private JLabel labelHoraSaida;
		private JTextField textHoraSaida;
		private JLabel labelTempo;
		private JTextField textTempo;
		private JLabel labelValorPagar;
		private JTextField textValorPagar;
		private JButton buttonSaida;
		private JButton buttonFecharSistema;
		
		private JScrollPane scrollTable;
		private JTable tabelaVeiculo;
		private DefaultTableModel tabelaVeiculoModelo;
		
	 
		public void criarTela() {
			
			Font fonte = new Font("Verdana", Font.BOLD, 18);	
			Font fonte2 = new Font("Verdana", Font.ITALIC, 25);
			
			
			JFrame tela = new JFrame();
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setTitle("Registros do Estacionamento");
			tela.setSize(665, 670);
			tela.setLayout(null);
			tela.setResizable(false);
			tela.setLocationRelativeTo(null);
			
			labelEntrada = new JLabel("ENTRADA");
			labelEntrada.setBounds(30, 20, 100, 30);
			labelEntrada.setForeground(new Color(148, 180, 123));
			labelEntrada.setFont(fonte);
			
			
			labelPlaca = new JLabel("PLACA: ");
			labelPlaca.setBounds(30, 60, 60, 30);
			textPlaca = new JTextField();
			textPlaca.setBounds(30, 90, 230, 30);
			
			labelModelo = new JLabel("MODELO:");
			labelModelo.setBounds(270, 60, 60, 30);
			textModelo = new JTextField();
			textModelo.setBounds(270, 90, 230, 30);
			
			buttonEntrar = new JButton("ENTRAR");
			buttonEntrar.setBounds(515, 90, 100, 30);
			buttonEntrar.setBackground(new Color( 78, 143, 206));
			buttonEntrar.setForeground(Color.white);
			buttonEntrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (validarCampos(textPlaca.getText(), textModelo.getText())) {
					MovimentoDao.gravarDadosTxt(GerarCodigo.getCodigo(), textPlaca.getText(), textModelo.getText(), DataHora.getDataEntrada(), DataHora.getHoraEntrada(), tabelaVeiculo);
					
				}
				}
			});
			
			
			
			
			
			criarTabela();
			
			
			labelSaida = new JLabel("SAÍDA");
			labelSaida.setBounds(30, 310, 80, 30);
			labelSaida.setForeground(new Color(148, 180, 123));
			labelSaida.setFont(fonte);
			
		    labelBuscarPlaca = new JLabel("PLACA: ");
			labelBuscarPlaca.setBounds(30, 350, 60, 30);
			textBuscarPlaca = new JTextField();
			textBuscarPlaca.setBounds(30, 380, 140, 30);
			
			buttonBuscar = new JButton("BUSCAR");
			buttonBuscar.setBounds(190, 380, 100, 30);
			buttonBuscar.setBackground(new Color( 78, 143, 206));
			buttonBuscar.setForeground(Color.white);
			buttonBuscar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (validaCampo(textBuscarPlaca.getText())) {
					MovimentoDao.getVeiculoEstacionado(textBuscarPlaca.getText(), textModelo2, textDataEntrada, textHoraEntrada, textDataSaida, textHoraSaida, textTempo);
		
				}
				}	

			});
			
//			buttonBuscar.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					
//					if (validarCampos(textPlaca.getText(), textModelo.getText())) {
//					MovimentoDao.gravarDadosSaida(textPlaca.getText(), textModelo, textDataEntrada, textHoraEntrada, textDataSaida, textHoraSaida, textTempo);	
//
//					}
//				}
//			});
			
		
			labelModelo2 = new JLabel("MODELO:");
			labelModelo2.setBounds(30, 430, 60, 30);
			textModelo2 = new JTextField();
			textModelo2.setBounds(30, 460, 80, 30);
			
			
			labelDataEntrada = new JLabel("DATA ENTRADA:");
			labelDataEntrada.setBounds(120, 430, 100, 30);
			textDataEntrada = new JTextField();
			textDataEntrada.setBounds(120, 460, 100, 30);
			
			labelHoraEntrada = new JLabel("HORA ENTRADA:");
			labelHoraEntrada.setBounds(230, 430, 100, 30);			
			textHoraEntrada = new JTextField();
			textHoraEntrada.setBounds(230, 460, 100, 30);
			
			
			
			labelDataSaida = new JLabel("DATA SAÍDA:");
			labelDataSaida.setBounds(340, 430, 100, 30);
			textDataSaida = new JTextField();
			textDataSaida.setBounds(340, 460, 100, 30);
			
			labelHoraSaida = new JLabel("HORA SAÍDA:");
			labelHoraSaida.setBounds(450, 430, 100, 30);
			textHoraSaida = new JTextField();
			textHoraSaida.setBounds(450, 460, 100, 30);
			
			
			labelTempo = new JLabel("TEMPO:");
			labelTempo.setBounds(560, 430, 80, 30);
			textTempo = new JTextField();
			textTempo.setBounds(560, 460, 50, 30);
			
			
			labelValorPagar = new JLabel("VALOR A PAGAR:");
			labelValorPagar.setBounds(30, 530, 100, 30);
			textValorPagar = new JTextField();
			textValorPagar.setBounds(140, 520, 130, 50);
			textValorPagar.setFont(fonte2);
			
			
			buttonSaida = new JButton("EFETUAR SAÍDA");
			buttonSaida.setBounds(280, 520, 160, 50);
			buttonSaida.setBackground(new Color( 78, 143, 206));
			buttonSaida.setForeground(Color.white);
			
			
			buttonFecharSistema = new JButton("FECHAR SISTEMA");
			buttonFecharSistema.setBounds(450, 520, 160, 50);
			buttonFecharSistema.setBackground(new Color(255, 12, 0));
			buttonFecharSistema.setForeground(Color.white);
			
			
			
			tela.getContentPane().add(scrollTable);
			
			tela.getContentPane().add(labelEntrada);
			tela.getContentPane().add(labelPlaca);
			tela.getContentPane().add(textPlaca);
			tela.getContentPane().add(labelModelo);
			tela.getContentPane().add(textModelo);
			tela.getContentPane().add(buttonEntrar);
			tela.getContentPane().add(labelSaida);
			tela.getContentPane().add(labelBuscarPlaca);
			tela.getContentPane().add(textBuscarPlaca);
			tela.getContentPane().add(buttonBuscar);
			tela.getContentPane().add(labelModelo2);
			tela.getContentPane().add(textModelo2);
			tela.getContentPane().add(labelDataEntrada);
			tela.getContentPane().add(textDataEntrada);
			tela.getContentPane().add(labelHoraEntrada);
			tela.getContentPane().add(textHoraEntrada);
			tela.getContentPane().add(labelDataSaida);
			tela.getContentPane().add(textDataSaida);
			tela.getContentPane().add(labelHoraSaida);
			tela.getContentPane().add(textHoraSaida);
			tela.getContentPane().add(labelTempo);
			tela.getContentPane().add(textTempo);
			tela.getContentPane().add(labelValorPagar);
			tela.getContentPane().add(textValorPagar);
			tela.getContentPane().add(buttonSaida);
			tela.getContentPane().add(buttonFecharSistema);
			
					
			
			tela.setVisible(true);
			
		}
		
		
		
		
		
		public void criarTabela() {
			
			tabelaVeiculoModelo = new DefaultTableModel();
			
			tabelaVeiculoModelo.addColumn("CÓDIGO");
			tabelaVeiculoModelo.addColumn("PLACA");
			tabelaVeiculoModelo.addColumn("MODELO");
			tabelaVeiculoModelo.addColumn("DATA ENTRADA");
			
			
			
			//***Tabela
			tabelaVeiculo = new JTable(tabelaVeiculoModelo);
			
			tabelaVeiculo.getColumnModel().getColumn(0).setPreferredWidth(80);
			tabelaVeiculo.getColumnModel().getColumn(1).setPreferredWidth(80);
			tabelaVeiculo.getColumnModel().getColumn(2).setPreferredWidth(80);
			tabelaVeiculo.getColumnModel().getColumn(3).setPreferredWidth(80);
			
			//Impedir a reordenação das colunas(movimentação)- pós criar a tabela
			tabelaVeiculo.getTableHeader().setReorderingAllowed(false);
			
			//Impedir a redimencionamento das colunas
			tabelaVeiculo.getTableHeader().setResizingAllowed(false);
			
			
			scrollTable = new JScrollPane(tabelaVeiculo);
			scrollTable.setBounds(30, 130, 590, 165);
				
			
		}

		private boolean validarCampos(String placa, String modelo) {
			
			if (placa.isEmpty() & modelo.isEmpty()) {
			
				JOptionPane.showMessageDialog(null, "Informe a Placa e do Modelo veículo!", "AVISO", JOptionPane.WARNING_MESSAGE);
				textPlaca.requestFocus();
				labelPlaca.setForeground(Color.RED);
				labelModelo.setForeground(Color.RED);
				return false;
			} else if (placa.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe a Placa do veículo!", "AVISO", JOptionPane.WARNING_MESSAGE);
				textPlaca.requestFocus();
				labelPlaca.setForeground(Color.RED);
				return false;
			}else if (modelo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o Modelo do veículo!", "AVISO", JOptionPane.WARNING_MESSAGE);
				textModelo.requestFocus();
				labelModelo.setForeground(Color.RED);
				return false;
				
			}
			
			return true;
			
		}
		 
		private boolean validaCampo(String placa) {
			if (placa.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe a Placa do veículo!", "AVISO", JOptionPane.WARNING_MESSAGE);
				textBuscarPlaca.requestFocus();
				return false;
			}
				return true;
		 }
		
		
}
