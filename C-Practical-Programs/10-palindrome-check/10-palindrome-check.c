#include<stdio.h>

int palindromeCheck(char str[], int len){
    int i = 0;
    int j = len-1;

    while (i <= j)
    {
        if(str[i]!=str[j]){return 0;}
        i++;
        j--;
    }

    return 1;
    
}

int main(int argc, char const *argv[])
{
    int len, isPalindrome;
    char str[len];

    printf("Enter length of the string: ");
    scanf("%d", &len);

    printf("Enter the string: ");
    scanf("%s", &str);

    isPalindrome = palindromeCheck(str, len);
    if(isPalindrome){ printf("string is palindrome");}
    else{ printf("string is NOT palindrome");}
    
    return 0;
}
