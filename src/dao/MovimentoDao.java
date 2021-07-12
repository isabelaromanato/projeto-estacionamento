package dao;

import arquivos.DataHora;
import br.com.estacionamento.model.Movimento;
import javax.swing.table.*;
import java.time.format.*;
import java.nio.charset.*;
import java.nio.file.*;
import javax.swing.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.io.*;

public class MovimentoDao {
	private static Movimento movimento;
	private static final String LOCAL_ARQUIVO = "E:/Users/isaro/DS1M-SENAI/FPOO/movimentacao.txt";
	
	
	private static DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	//Gravar as informações no txt
	public static void gravarDadosTxt(String codigo, String placa, String modelo, LocalDate dataEntrada, LocalDateTime horaEntrada, JTable tabelaVeiculo) {
		
		//Variável de tipo File recebendo o caminho onde ficará salvo o arquivo txt
		File caminhoArquivo = new File(LOCAL_ARQUIVO);
		
		try {
			//Cria o arquivo txt
			FileWriter fw = new FileWriter(caminhoArquivo, true);
			
			//Escrita dos dados no arquivo
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Capturando as informações
			bw.write(codigo + ";" + placa + ";" + modelo + ";" + dataEntrada.format(formatterData) + ";" + horaEntrada.format(formatterHora) + ";" + "0" + ";" + "0" + ";" + "0" + ";" + "0" + ";");
			bw.newLine();
			
			//Add informações na tabela
			DefaultTableModel dtm = (DefaultTableModel) tabelaVeiculo.getModel();
			dtm.addRow(new Object[] {
				codigo,
				placa,
				modelo,
				dataEntrada.format(formatterData)
			});
			
			//Fechamos o arquivo (importante!!!)
			bw.close();
			fw.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Método que "procura" o veículo após a placa ser informada
	public static void getVeiculoEstacionado(String placa, JTextField textModelo, JTextField textDataEntrada, JTextField textHoraEntrada, JTextField textDataSaida, JTextField textHoraSaida, JTextField textTempo) {
		
		//Obtemos a lista de registros"
		List<Movimento> listaMovimentos = listarMovimentos();
		
		//Realizamos a varredura da lista para obtermos o modelo do veículo, a data e a hora de entrada no estacionamento!
		for (Movimento movimento : listaMovimentos) {
			if (movimento.getPlaca().equals(placa)) {
				textModelo.setText(movimento.getModelo());
				textDataEntrada.setText(movimento.getDataEntrada());
				textHoraEntrada.setText(movimento.getHoraEntrada());
			}
		}
		
		//Informei a data e a hora de saída
		textDataSaida.setText(String.valueOf(DataHora.getDataSaida().format(formatterData)));
		textHoraSaida.setText(String.valueOf(DataHora.getHoraSaida().format(formatterHora)));
		
		//Calcular o tempo e setar o valor no campo correto
		Date dt = new Date(calcularTempo());
		DateFormat df = new SimpleDateFormat("HH:mm");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		textTempo.setText(df.format(dt));
	}
	
	//Método para calcular o tempo que o véiculo ficou estacionado
	private static long calcularTempo() {
		long tempo = 0;
		try {
			Date horaEntrada = sdf.parse(movimento.getHoraEntrada());
			Date horaSaida = sdf.parse(DataHora.getHoraSaida().format(formatterHora));
			tempo = horaSaida.getTime() - horaEntrada.getTime();
		} catch(ParseException e) {
			System.out.println(e.getMessage());
		}
		return tempo;
	}
	
	//Método para listar todos os registros gravados no arquivo .txt!
	private static List<Movimento> listarMovimentos() {
		
		//Obtendo o arquivo para realização de sua leitura!
		Path arquivo = Paths.get(LOCAL_ARQUIVO);
		
		//Realizando a leitura...
		try {
			BufferedReader reader = Files.newBufferedReader(arquivo, Charset.forName("UTF-8"));
			String linha = reader.readLine();
			List<Movimento> listaMovimentos = new ArrayList<>();
			while (linha != null) {
				String[] vetorMovimento = linha.split(";");
				movimento = new Movimento();
				movimento.setCodigo(vetorMovimento[0]);
				movimento.setPlaca(vetorMovimento[1]);
				movimento.setModelo(vetorMovimento[2]);
				movimento.setDataEntrada(vetorMovimento[3]);
				movimento.setHoraEntrada(vetorMovimento[4]);
				movimento.setDataSaida(vetorMovimento[5]);
				movimento.setHoraSaida(vetorMovimento[6]);
				linha = reader.readLine();
				listaMovimentos.add(movimento);
			}
			
			reader.close();
			return listaMovimentos;
		} catch(Exception e) {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo. Exception: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public void salvar() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {
			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.WRITE,
					StandardOpenOption.APPEND);

			writer.write(movimento
					
					
					
					
					
					.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			// e.printStackTrace();
		}

	}
	
	public static void gravarDadosSaida (String codigo, String placa, String modelo, LocalDate dataEntrada, LocalDateTime horaEntrada,  LocalDate dataSaida, LocalDateTime horaSaida, double tempo, double valorPagar) {
	
		
		
		File caminhoArquivo = new File(LOCAL_ARQUIVO);
		
		try {
		
		FileWriter fw1 = new FileWriter(caminhoArquivo, true);
			
		BufferedWriter bw1 = new BufferedWriter(fw1);
		
		bw1.write(codigo + ";" + placa + ";" + modelo + ";" + dataEntrada.format(formatterData) + ";" + horaEntrada.format(formatterHora) + ";" + dataSaida.format(formatterData) + ";" + horaEntrada.format(formatterData) + ";" + tempo + ";" + "valorPagar" + ";");
		bw1.newLine();
			
		
	} catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	
	}
	
}


	

	

	
	


