#include<stdio.h>
#include<string.h>

int isAllZero(int arr[]){
    for (int i = 0; i < 256; i++)
    {
        if(arr[i]!=0){return 0;}
    }
    return 1;
}

int isAnagram(char s1[], char s2[]){
    int l1 = strlen(s1);
    int l2 = strlen(s2);
    int arr[256] = {0};
    if(l1!=l2){ return 0; }

    for (int i = 0; i < l1; i++)
    {
        char ch = s1[i];
        arr[(int)ch]++;
    }



    for (int i = 0; i < l1; i++)
    {
        char ch = s2[i];
        arr[(int)ch]--;
    }
    
    if(isAllZero(arr)){ return 1;}
    else{ return 0;}

}


int main(int argc, char const *argv[])
{
    char str1[100] = "listen";
    char str2[100] = "silent";

    if(isAnagram(str1,str2)){printf("Yes, they are each-other's anagram!");}
    else{ printf("No, they are not anagram");}
    return 0;
}
