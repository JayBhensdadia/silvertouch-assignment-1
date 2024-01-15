#include<stdio.h>



int main(int argc, char const *argv[])
{
    float c,f;
    printf("Enter calsius: ");
    scanf("%f", &c);
    printf("Fahrenheit = %1.2f",(c*9.0/5.0)+(float)32);
    return 0;
}
