#include<stdio.h>
#include<stdlib.h>


void printReverseString(char str[], int len){
    fflush(stdin);
    char rStr[len];
    for (int i = 0; i < len; i++)
    {
        rStr[i] = str[len-1-i];
    }

    printf("Reversed: %s", rStr);

}

int main(int argc, char const *argv[])
{
    int len;
    char str[len];
    printf("Enter length of string: ");
    scanf("%d", &len);
    printf("Enter a string: ");
    scanf("%s", &str);
    printReverseString(str, len);
    return 0;
}
