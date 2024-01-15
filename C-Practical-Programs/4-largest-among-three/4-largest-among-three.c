#include<stdio.h>
#include<math.h>

int maxOfThree(int n1, int n2, int n3){
    if(n1>n2 && n1>n3){printf("Max: %d",n1);}
    else if(n2>n1 && n2>n3){printf("Max: %d",n2);}
    else{printf("Max: %d",n3);}
}


int main(int argc, char const *argv[])
{
    int num1, num2, num3;
    printf("Enter three Numbers: ");
    scanf("%d %d %d", &num1, &num2, &num3);
    maxOfThree(num1,num2,num3);
    return 0;
}
