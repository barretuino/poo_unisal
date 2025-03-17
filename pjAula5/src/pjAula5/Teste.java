package pjAula5;

public class Teste {
	public static void main(String[] args) {
		Calcular calc = new Calcular();
		
		System.out.println(calc.somar(10));
		System.out.println(calc.somar(10, 10));
		System.out.println(calc.somar("10", 10));
		System.out.println(calc.somar("10", "10"));
		System.out.println(calc.somar(10, "10"));
		System.out.println(calc.somar(10d, 10d));
	}
}
