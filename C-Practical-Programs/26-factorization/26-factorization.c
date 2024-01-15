#include<stdio.h>


void printFactors(int n){
    for (int i = 1; i <= n; i++)
    {
        if(n%i==0){ printf("%d, ", i);}
    }
    
}


int main(int argc, char const *argv[])
{
    int n;
    printf("Enter number: ");
    scanf("%d",&n);
    printFactors(n);
    return 0;
}
