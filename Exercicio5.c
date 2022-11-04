/*Nome: Bernardo Lancelot Martinez Barbosa
Turma: 3AINFO*/
#include<stdio.h>
 
int main() 
{
    int numero;
    int i = 2;
    int fim = 0;
    int a=1;
//Aqui declarei as variáveis.
 
    printf("Digite um número: ");
    scanf("%d", &numero);
//Aqui nessas 2 linhas pedi para que o usuário digitasse um número.
 
    if (numero == 0 || numero == 1){
        printf("Não é primo\n");
    }
    else{
        while (i*i <= numero){
            if (numero % i == 0) {
                fim++;
                break;
            }
        i++;
        }
        if (fim == 0)
            printf("É primo\n");
        else
            printf("Não é primo\n");
    }
//Esse 'if' e esse 'else' serve basicamente para checar se o número é primo ou não, vendo se a variável auxiliar é menor ou igual ao numero digitado.
    return 0;
}
