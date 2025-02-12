#include <stdio.h>
#include <stdlib.h>

/** Exemplo de Estrutura de Matrizes **/
typedef struct Cliente{
	int codigo;
	float faturamento;
};
main(){
	Cliente cadastro[5];
	//Inserção dos dados
	for(int i=0; i<5; i++){
		printf("Informe o codigo: ");
		scanf("%i", &cadastro[i].codigo);
		printf("Informe o faturamento: ");
		scanf("%f", &cadastro[i].faturamento);
	}
	//Leitura
	for(int i=0; i<5; i++){
		printf("Cliente %i faturamento de %2.f\n",
			cadastro[i].codigo, cadastro[i].faturamento);
	}
}
