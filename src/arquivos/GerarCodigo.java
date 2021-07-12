package arquivos;

import java.util.UUID;

public class GerarCodigo {
	
	public static String getCodigo() {
		
		String codigo = "";
		
		codigo = UUID.randomUUID().toString().toUpperCase();
		
		codigo = codigo.substring(0, 8);
		
		return codigo;
		
	}
	
		
		public static String gerarCodigo() {
			return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		}
	

}
