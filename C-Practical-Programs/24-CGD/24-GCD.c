#include<stdio.h>

int min(int n1, int n2){
    if(n1>n2){return n2;}
    else{ return n1;}
}



int gcd(int n1, int n2){
    int ans = 1;
    int num = min(n1,n2);
    for (int i = 2; i <= num; i++)
    {
        if(n1%i==0 && n2%i==0){ans = i;}
    }

    return ans;
    
}


int main(int argc, char const *argv[])
{
    int n1, n2;
    printf("Enter number1 and number2: ");
    scanf("%d %d", &n1, &n2);
    printf("GCD = %d", gcd(n1,n2));
    return 0;
}
