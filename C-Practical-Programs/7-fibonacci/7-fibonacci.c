#include<stdio.h>

int printArray(int a[], int size){
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", a[i]);
    }
}

int fibonacci(int n){
    int count = n;
    int fib[n];
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i < n; i++)
    {
        fib[i] = fib[i-1] + fib[i-2];
    }
    printArray(fib, n);
    
}

int main(int argc, char const *argv[])
{
    int num;
    printf("Enter num: ");
    scanf("%d", &num);

    fibonacci(num);
    return 0;
}
