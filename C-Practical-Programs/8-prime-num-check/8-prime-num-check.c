#include<stdio.h>

int primeCheck(int n){

    for (int  i = 2; i < n/2; i++)
    {
        if(n%i == 0){ return 0;}
    }

    return 1;
    
}

int main(int argc, char const *argv[])
{
    int num, isPrime;
    printf("Enter num: ");
    scanf("%d", &num);
    isPrime = primeCheck(num);

    if (isPrime){printf("%d is a prime number", num);}
    else{printf("%d is NOT a prime number", num);}
    
    return 0;
}
