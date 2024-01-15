#include <stdio.h>
#include <math.h>

float calculator(int choice, int n1, int n2)
{

    switch (choice)
    {
    case 1:
        return (n1 + n2);
        break;

    case 2:
        return n1 - n2;
        break;

    case 3:
        return n1 * n2;
        break;

    case 4:
        return (float)n1 / (float)n2;
        break;

    default:
        printf("enter valid inputs!!");
        break;
    }
}

int main(int argc, char const *argv[])
{
    int choice, num1, num2;
    printf("Enter \n1 for addition \n2 for subtraction \n3 for multiplication \n4 for division\nchoice: ");
    scanf("%d", &choice);

    printf("Enter number-1 and number-2: ");
    scanf("%d %d", &num1, &num2);

    printf("Result: %1.2f", calculator(choice, num1, num2));

    return 0;
}
