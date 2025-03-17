package pjAula5;

/**
 * Conceito Polimorfismo
 * Técnica de Sobrecarga de Métodos
 * Prof. Ms. Paulo Barreto
 * Data 10/03/2025
 */

public class Calcular {
	public int somar(int a, int b) {
		return a + b;
	}
	public int somar(String a, String b) {
		return Integer.parseInt(a) + Integer.parseInt(b);
	}
	public int somar(double a, double b) {
		return (int)(a + b);
	}
	public int somar(String a, double b) {
		return Integer.parseInt(a) + (int)b;
	}
	public int somar(int a) {
		return a + a;
	}
	public int somar(double a, String b) {
		return (int)a + Integer.parseInt(b);
	}
}
