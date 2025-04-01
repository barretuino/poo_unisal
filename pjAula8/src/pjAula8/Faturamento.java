package pjAula8;

public class Faturamento {
	public static void main(String[] args) {
		NotaFiscal n1 = new NotaFiscal();
		NotaFiscal n2 = new NotaFiscal();
		NotaFiscal n3 = new NotaFiscal();
		
		System.out.println("Número de instâncias " + NotaFiscal.contador);
		System.out.println("Número de instâncias " + n1.contador);
		System.out.println("Número da Nota de n1 " + n1.idNota);
		
		System.out.println("Número de instâncias " + n2.contador);
		System.out.println("Número da Nota de n2 " + n2.idNota);
		
		System.out.println("Número de instâncias " + n3.contador);
		System.out.println("Número da Nota de n3 " + n3.idNota);
	}
}
