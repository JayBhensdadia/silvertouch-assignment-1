#include<stdio.h>
#include<string.h>

int countWords(char str[]){
    int spaceCount = 0;
    for (int i = 0; i < strlen(str); i++)
    {
        if((int)str[i]==32){spaceCount++;}
    }
    return spaceCount+1;
}

int main(int argc, char const *argv[])
{
    char str[100] = "this is a program to count words in sentence";
    printf("No. of words = %d", countWords(str));
    return 0;
}
