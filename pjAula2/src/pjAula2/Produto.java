package pjAula2;

import java.util.Date;

/**
 * Classe de Modelagem Conceitual
 * Autor: Prof. Ms. Paulo Barreto
 * Data: 17/02/2025
 */
public class Produto {
	//Atributos
	private int codigo;
	private String modelo;
	private float valorBase;
	private Date dataCadastro;
	private boolean situacaoCadastral;

	//Métodos
	public void incluir(int codigo, String modelo, float valorBase,
			Date dataCadastro, boolean situacaoCadastral) {
		if(codigo > 0) {
			this.codigo = codigo;
		}else { 
			System.err.println("Código é inválido!");
		}
		this.modelo = modelo;
		this.valorBase = valorBase;
		this.dataCadastro = dataCadastro;
		this.situacaoCadastral = situacaoCadastral;
	}
}
