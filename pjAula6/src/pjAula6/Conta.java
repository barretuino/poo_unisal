package pjAula6;

public class Conta {
	public static void mostrarCalculo(OperacaoMatematica op,
			double x, double y) {
		System.out.println(op.getClass().getSimpleName()
				+ " - " + op.calcular(x, y));
	}
	
	public static void main(String[] args) {
		mostrarCalculo(new Soma(), 10, 20);
		mostrarCalculo(new Subtracao(), 10, 20);
		mostrarCalculo(new Multiplicacao(), 10, 20);
		mostrarCalculo(new Divisao(), 10, 20);
	}
}
