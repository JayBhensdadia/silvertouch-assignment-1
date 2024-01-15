#include<stdio.h>


int isVowel(char ch){
    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
        return 1;
    }
    return 0;
}

void printVowelAndConsonantCount(char str[], int len){
    int vCount = 0;
    int cCount = 0;
    for (int i = 0; i < len; i++)
    {
        char ch = str[i];
        if(isVowel(ch)){ vCount++; }
        else{ cCount++; }
    }

    printf("Vowels = %d and Consonants = %d", vCount, cCount);
    
}

int main(int argc, char const *argv[])
{
    int len;
    char str[len];
    printf("Enter length of string: ");
    scanf("%d", &len);
    printf("Enter a string: ");
    scanf("%s", &str);
    printVowelAndConsonantCount(str, len);
    return 0;
}
