package pjAula6;

public abstract class OperacaoMatematica {
	public abstract double calcular(double x, double y);
	
	public String imprimir(String texto) {
		return this.getClass().getSimpleName() + " " + texto;
	}
}
