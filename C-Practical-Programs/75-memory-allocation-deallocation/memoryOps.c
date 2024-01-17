#include <stdio.h>
#include <stdlib.h>

int main() {
    int* dynamicArray;
    int arraySize;

    
    printf("Enter the size of the dynamic array: ");
    scanf("%d", &arraySize);

    dynamicArray = (int*)malloc(arraySize * sizeof(int));

    if (dynamicArray == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        return 1;  
    }

    
    printf("Enter %d integers for the dynamic array:\n", arraySize);
    for (int i = 0; i < arraySize; ++i) {
        scanf("%d", &dynamicArray[i]);
    }

    
    printf("Dynamic Array: ");
    for (int i = 0; i < arraySize; ++i) {
        printf("%d ", dynamicArray[i]);
    }
    printf("\n");

    
    free(dynamicArray);

    return 0;  
}
