#include<stdio.h>


int sum(int a, int b){
    return a+b;
}

int main(int argc, char const *argv[])
{
    int num1;
    int num2;
    printf("Enter number 1: ");
    scanf("%d",&num1);

    printf("Enter number 2: ");
    scanf("%d",&num2);

    printf("sum is %d", sum(num1,num2));
    return 0;
}
