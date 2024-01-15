#include<stdio.h>
#include<math.h>


/*

    1010 => 1*2^3 + 0 + 1*2^1 + 0 =  10

    
*/

int toDecimal(int n){
    int ans = 0;
    int i = 0;
    while (n>0)
    {
        ans+= (n%10) * pow(2,i);
        n=n/10;
        i++;
    }

    return ans;
    
}


int main(int argc, char const *argv[])
{
    int bin,decimal;
    printf("Enter the decimal number: ");
    scanf("%d", &bin);
    decimal = toDecimal(bin);
    printf("Decimal representation of %d is %d", bin, decimal);
    return 0;
}
