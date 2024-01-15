#include<stdio.h>



int main(int argc, char const *argv[])
{
    float c,f;
    printf("Enter Fahrenheit: ");
    scanf("%f", &f);
    printf("Fahrenheit = %1.2f",(float)(f-32)*5.0/9.0);
    return 0;
}
