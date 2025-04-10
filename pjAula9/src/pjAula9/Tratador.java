package pjAula9;

public class Tratador {
	public static void main(String[] args) {
		int num = 5;
		String div = "1";
		
		try {
			int resultado = num / Integer.parseInt(div);
		
			System.out.println("Resultado é " + resultado);
		}catch(ArithmeticException e) {
			System.err.println("Erro de divisão por zero.");
		}catch(NumberFormatException e) {
			System.err.println("Verifique as entradas de dados."
					+ "\nConversão Inválida.");
		}finally {
			//TODO: Executado se tudo correr bem ou se houver algumas
			//exceção.
		}
	}
}
