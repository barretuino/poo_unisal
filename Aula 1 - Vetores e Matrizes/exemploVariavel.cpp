#include <stdio.h>
#include <stdlib.h>

//Declaracao de uma vari�vel global
float cotacaoDolar = 5.40;

main(){
	//Declara��o de uma vari�vel local
	float valorUnitario = 10;
	float *ponteiro = &valorUnitario;
	
	printf("Valor da variavel %.2f\n", cotacaoDolar);
	printf("Endereco da variavel cotacaoDoalar %i\n", 
											&cotacaoDolar);
	printf("Endereco da variavel valorUnitario %i\n", 
											&valorUnitario);
	printf("Valor indireto de valorUnitario %.2f\n",
											*ponteiro);
	printf("%i\n", ponteiro);
}
