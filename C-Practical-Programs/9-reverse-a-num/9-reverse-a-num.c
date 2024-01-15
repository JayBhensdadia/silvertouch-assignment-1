#include<stdio.h>


/*

    123

    3 = 3
    3*10 + 2 = 32
    32*10 + 1 = 321


*/
int reverse(int n){
    
    int rev = 0;
    int digit;

    while (n>0){
        digit = n % 10;
        rev = (rev*10) + digit;
        
        n = n/10;
    }

    return rev;
    

}

int main(int argc, char const *argv[])
{
    int num, reversed;
    printf("Enter num: ");
    scanf("%d", &num);

    reversed = reverse(num);
    printf("reversed number: %d",reversed);
    return 0;
}
