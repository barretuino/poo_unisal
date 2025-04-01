package pjAula8;

import java.util.Date;

public class Produto {
	int codigo;
	String descricao;
	Date dataCadastro;
	float quantidadeMinima;
	boolean situacao;
	
	public Produto() {
		//TODO: Vázio
	}

	public Produto(int codigo, String descricao, Date dataCadastro, float quantidadeMinima, boolean situacao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.quantidadeMinima = quantidadeMinima;
		this.situacao = situacao;
	}
}
