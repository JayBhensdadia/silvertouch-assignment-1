#include<stdio.h>

int factorial(int n){
    if(n<=0){ return 1;}
    return n * factorial(n-1);
}

int main(int argc, char const *argv[])
{
    int num, fact;
    printf("Enter num: ");
    scanf("%d", &num);

    fact = factorial(num);
    printf("factorial of %d is %d", num, fact);
    return 0;
}
