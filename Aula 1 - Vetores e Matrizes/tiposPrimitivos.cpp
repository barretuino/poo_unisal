#include <stdio.h>
#include <stdlib.h>

//Declaracao de variavel global
double cotacao = 1.44;

main(){
	//Declara�ao de vari�vel local
	int valor;
	float preco;
	char opcao;
	
	//Declara��o com inicializa��o
	float venda = 2 * cotacao;
	float *ponteiro = &venda;
	
	printf("Valor de venda %.2f\n", venda);
	printf("Endere�o da Variavel venda %d\n", &venda);
	printf("Utilizando o ponteiro %.2f\n", *ponteiro);
	printf("Endere�o da Variavel ponteiro %d\n", &ponteiro);
	printf("Valor da Variavel ponteiro %d\n", ponteiro);
	
	system("PAUSE");
}
