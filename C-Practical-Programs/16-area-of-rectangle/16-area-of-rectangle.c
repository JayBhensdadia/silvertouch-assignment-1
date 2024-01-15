#include<stdio.h>


float areaOfRectangle(float l, float b){
    return l*b;
}

int main(int argc, char const *argv[])
{
    float l,b;
    printf("Enter length and breadth of the rectangle: ");
    scanf("%f %f", &l, &b);
    printf("Area = %1.2f square unit", areaOfRectangle(l,b));
    return 0;
}
