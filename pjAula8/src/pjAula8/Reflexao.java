package pjAula8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflexao {
	public static void main(String[] args) {
		Class<Produto> classe = Produto.class; 
		
		//Reflection de Atributos
		for (Field atributo : classe.getDeclaredFields()) { 
			System.out.println(atributo.getName()); 
		}
		
		//Reflection de Métodos Construtores
		for(Constructor metodo : classe.getConstructors()) {
			System.out.println(metodo.getName());
		}
		
		//Reflection de Métodos Comuns
		for(Method metodo : classe.getMethods()) {
			System.out.println(metodo.getName());
		}
	}
}
