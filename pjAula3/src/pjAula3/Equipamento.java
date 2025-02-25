package pjAula3;

import java.util.Date;

/**
 * Classe de Modelagem Conceitual de um Equipamento
 * Prof. Ms. Paulo Barreto
 * Data 24/02/2025
 */
public class Equipamento {
	//Atributos
	private int codigo;
	private String descricao;
	private float valor;
	private Date dataAquisicao;
	private boolean ativo;
	
	//Método Construtor
	public Equipamento() {
	}
	
	public Equipamento(int codigo, String descricao, float valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.dataAquisicao = new Date();
		this.ativo = true;
	}
	
	//Métodos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
