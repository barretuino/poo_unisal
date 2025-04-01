package pjAula8;

/**
 * Demonstração de um exemplo de Sobreescrita de Métodos
 */
public class Teste {
	public static void main(String[] args) {
		Pai pai = new Pai();
		pai.acao(12.5f, "Veja a Sobreescrita");
		System.out.println(pai.getClass().getSimpleName());
		
		Filho filho = new Filho();
		filho.acao(12.5f, "Veja a Sobreescrita");
		System.out.println(filho.getClass().getSimpleName());
	}
}
