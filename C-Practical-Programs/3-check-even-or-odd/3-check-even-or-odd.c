#include<stdio.h>

int isEven(int n){
    return n%2==0;
}

int main(int argc, char const *argv[])
{
    int num;
    int isNumEven = 0;
    printf("Enter the number: ");
    scanf("%d", &num);
    isNumEven = isEven(num);
    if(isNumEven){ printf("Number is Even");}
    else{printf("Number is Odd");}
    return 0;
}
