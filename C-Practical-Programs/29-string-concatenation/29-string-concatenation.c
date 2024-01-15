#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int main(int argc, char const *argv[])
{
    int l1, l2;
    char s1[l1], s2[l2];

    
    printf("Enter length of string1: ");
    scanf("%d ",&l1);

    printf("Enter length of string2: ");
    scanf("%d ",&l2);

    fflush(stdin);

    printf("Enter string1: ");
    scanf("%s", &s1);

    printf("Enter string2: ");
    scanf("%s", &s2);

    printf("%s", strcat(s1,s2));

    return 0;
}
