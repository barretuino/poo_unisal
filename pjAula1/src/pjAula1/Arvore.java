package pjAula1;

import java.util.Date;

/**
 * Classe de Modelagem conceitual para uma árvore
 * @author Prof. Paulo Barreto
 * @date 10/02/2025
 */
public class Arvore {
	//Atributos
	int codigo;
	String especie;
	float altura;
	int idade;
	String origemNacionalidade;
	
	//Métodos
	int obterIdade(Date dataPlantio) {
		int idade = (int) (new Date().getTime() - dataPlantio.getTime());
		return idade;
	}
}
