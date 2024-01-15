#include<stdio.h>

int printArray(int a[], int size){
    for (int i = 0; i < size; i++)
    {
        printf("%d, ", a[i]);
    }
}

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(int arr[], int n){
    
    for (int i = 0; i < n-1; i++)
    {
        for (int  j = 0; j < n-i-1; j++)
        {
            if(arr[j] > arr[j+1]){
                swap(&arr[j], &arr[j+1]);
            }
        }
        
    }
    
}


int main(int argc, char const *argv[])
{
    int arr[] = {11,2,34,4,1};
    printf("before sorting:");
    printArray(arr,5);
    printf("\nafter sorting:");
    bubbleSort(arr,5);
    printArray(arr,5);
    return 0;
}
