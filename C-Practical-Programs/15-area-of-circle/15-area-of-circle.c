#include<stdio.h>


float areaOfCircle(int n){
    return ( 2 * 3.14 * n * n);
}

int main(int argc, char const *argv[])
{
    int radius, area;

    printf("Enter the radius of circle: ");
    scanf("%d",&radius);

    printf("%1.2f square-unit",areaOfCircle(radius));
    return 0;
}
