package arquivos;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataHora {

	public static LocalDate getDataEntrada() {
		
		
		LocalDate dataEntrada = LocalDate.now();
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yy");
		
		
		
		
		return dataEntrada;
		
		}
		public static LocalDateTime getHoraEntrada() {
		
		
		LocalDateTime horaEntrada = LocalDateTime.now();
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
		
		
		return horaEntrada;
		
		}
		public static LocalDate getDataSaida() {
			
			
		LocalDate dataSaida = LocalDate.now();
			
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
		dataSaida.format(dtf);
		  

		
		return dataSaida;
			
			}
		
		public static LocalDateTime getHoraSaida() {
			
			
			LocalDateTime horaSaida = LocalDateTime.now();
			
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
			
			
			return horaSaida;
			
			}

}
