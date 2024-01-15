#include<stdio.h>


int main(int argc, char const *argv[])
{
    float p,n,r,i;

    printf("Enter principle amount: ");
    scanf("%f", &p);

    
    printf("Enter rate of interest: ");
    scanf("%f", &r);

    
    printf("Enter time period in years: ");
    scanf("%f", &n);

    i = ((p*r*n)/(float)100);
    printf("Interest: %1.3f",i );

    return 0;
}
