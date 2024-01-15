#include<stdio.h>


/*

    10

    10/2 = 5 => 0
    5/2 = 2 => 1
    2/2 = 1 => 0
    1/2 = 0 => 1

    binary = 1010
*/


/*
    11/2 = 5 => 1
    5/2 = 2 => 1
    2/2 = 1 => 0
    1/2 = 0 => 1

*/



int toBinary(int n){
    int num = n;
    int bin = 0;
    int rem;

    while (n>0)
    {
        rem = n%2;
        bin = bin*10 + rem;
        n = n/2;
    }
    
    if(num%2==0){ return bin*10;}
    return bin;
}


int main(int argc, char const *argv[])
{
    int decimal,binary;
    printf("Enter the decimal number: ");
    scanf("%d", &decimal);

    binary = toBinary(decimal);
    printf("Binary representation of %d is %d", decimal, binary);


    return 0;
}

