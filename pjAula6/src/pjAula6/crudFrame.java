package pjAula6;

//Definição de um classe abstrata
public abstract class crudFrame {
	
	//Método abstrato
	public abstract void incluir(Object o);
	public abstract Object pesquisar(int codigo);
	public abstract void alterar(Object o);
}
