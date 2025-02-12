#include <stdio.h>
#include <stdlib.h>

typedef struct Data{
	int dia, mes, ano;
};

typedef struct Aluno{
	int ra;
	char nome[50];
	float nota;
	Data dataNascimento;
};

main(){
	/*Aluno voce;
	
	voce.nome = "Paulo";
	voce.ra = 20230876;
	voce.nota = 8.5;
	voce.dataNascimento.dia = 7;
	voce.dataNascimento.mes = 2;
	voce.dataNascimento.ano = 2005;*/
	int vetor[10]={1, 6, 7, -14, 134, 0, -2, 13, 22, -7};
	printf("Endereco do vetor %i \n", &vetor);
	for(int i=0; i<10; i++){
		printf("Indice %i Endereco %i conteudo %i\n", 
									i, &vetor[i], vetor[i]);
	}
}
