package pjAula8;

public class NotaFiscal {
	//Atributo estático
	public static int contador = 0;
	public int idNota;
	
	public NotaFiscal() {
		contador++;
		idNota = contador;
	}
}
