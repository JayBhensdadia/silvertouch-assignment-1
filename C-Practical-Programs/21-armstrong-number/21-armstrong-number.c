#include<stdio.h>
#include<math.h>

/*
    9474

    SUM( digit ^ len) = original number
*/

int digitCount(int n){
    int count = 0;
    while (n>0)
    {
        count++;
        n = n/10;
    }

    return count;
    
}
int isArmstrong(int n){
    int original = n;
    int ans=0;
    int digits = digitCount(n);
    while (n>0)
    {
        ans += pow(n%10,digits);
        n=n/10;
    }
    
    return original==ans;
    
}

int main(int argc, char const *argv[])
{
    int n;
    printf("Enter number: ");
    scanf("%d",&n);

    if(isArmstrong(n)){ printf("given number is armstrong number");}
    else{printf("given number is NOT armstrong number");}
    return 0;
}
