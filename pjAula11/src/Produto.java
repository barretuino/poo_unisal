/**
 * Classe de Modelagem Conceitual
 * @autor Prof. Ms. Paulo Barreto
 * @data 26/04/2025
 */
public class Produto {
	@Description(nome = "Código")
	private int codigo;
	
	@Description(nome = "Descrição")
	private String descricao;
	
	@Description(nome = "Quantidade")
	private double quantidade;
	
	@Description(nome = "Situação")
	private boolean status;
	
	@Description(nome = "Localização")
	private String localizacao;
	
	@Description(nome = "Unidade de Medida")
	private UnidadeMedida unidadeMedida;

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
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}