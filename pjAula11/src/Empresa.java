public class Empresa {

	@Description(nome = "Código")
    private int codigo;
	
	@Description(nome = "Razão Social")
    private String razaoSocial;
	
	@Description(nome = "Situação Cadastral")
    private boolean situacaoCadastral;
	
	@Description(nome = "Valor de Venda")
    private double valorVenda;

    public Empresa() {
    }

    public Empresa(int codigo, String razaoSocial, boolean situacaoCadastral, double valorVenda) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.situacaoCadastral = situacaoCadastral;
        this.valorVenda = valorVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean getSituacaoCadastral() {
        return situacaoCadastral;
    }

    public void setSituacaoCadastral(boolean situacaoCadastral) {
        this.situacaoCadastral = situacaoCadastral;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

}
