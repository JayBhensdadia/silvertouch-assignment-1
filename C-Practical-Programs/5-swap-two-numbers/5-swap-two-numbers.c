#include<stdio.h>

void swap(int *n1, int *n2){
    int temp;

    temp = *n2;
    *n2 = *n1;
    *n1 = temp;
}


int main(int argc, char const *argv[])
{
    int num1, num2;
    printf("Enter num1: ");
    scanf("%d",&num1);
    printf("Enter num2: ");
    scanf("%d",&num2);

    swap(&num1,&num2);
    printf("After swapping.....");
    printf("num1 is %d and num2 is %d", num1, num2);
    return 0;
}
