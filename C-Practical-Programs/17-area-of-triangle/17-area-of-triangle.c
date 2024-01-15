#include<stdio.h>

float areaOfTriangle(float b, float h){
    return ( b*h/2 );
}

int main(int argc, char const *argv[])
{
    float base,height;
    printf("Enter base-length and height of triangle: ");
    scanf("%f %f", &base, &height);
    printf("Area = %1.2f square-unit", areaOfTriangle(base,height));
    return 0;
}
