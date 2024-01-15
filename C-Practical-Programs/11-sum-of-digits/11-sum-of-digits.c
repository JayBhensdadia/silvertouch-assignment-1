#include<stdio.h>

int digitSum(int n){
    int sum = 0;
    int digit;
    while (n>0)
    {
        digit = n%10;
        sum += digit;
        n = n/10;
    }

    return sum;
    
}

int main(int argc, char const *argv[])
{
    int num, sumOfDigits;
    printf("Enter the number: ");
    scanf("%d", &num);

    sumOfDigits = digitSum(num);
    printf("sum of digits is %d", sumOfDigits);
    return 0;
}
