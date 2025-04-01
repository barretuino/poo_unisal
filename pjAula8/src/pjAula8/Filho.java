package pjAula8;

/**
 * Classe que irá realizar a herança e também demonstrar
 * a sobreescrita de métodos
 */
public class Filho extends Pai{
	public void acao(float valor, String texto) {
		super.acao(valor, texto);
		System.out.println("Faz outra coisa.");
	}
}
