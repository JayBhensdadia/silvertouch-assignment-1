#include<stdio.h>



int isPerfect(int n){
    //get divisors
    int sum = 0;
    for (int i = 1; i < n; i++)
    {
        if(n%i == 0){ sum+=i; }
    }
    
    return sum==n;
}

int main(int argc, char const *argv[])
{
    int n;
    printf("Enter number: ");
    scanf("%d",&n);
    if(isPerfect(n)){ printf("Number is perfect");}
    else{printf("Number is NOT perfect");}
    return 0;
}
