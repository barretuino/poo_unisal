package pjAula8;

/**
 * Classe que será a ancestral que iremos Sobreescrever
 */
public class Pai {
	public void acao(float valor, String texto) {
		System.out.println(texto);
		System.out.println("Valor é " + valor);
	}
	
	public int somar(int a, int b) {
		return a + b;
	}
}