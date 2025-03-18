package pjAula6;

public interface iCadastral {	
	public void inserir(Object o);
	public Object pesquisar(int codigo);
	public void alterar(Object o);
	public boolean excluir(int codigo);
	public Object clonar(Object origem);
}