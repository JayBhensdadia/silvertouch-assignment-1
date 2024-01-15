/*
 * LOGIC:
 * that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.
 */

public class QuickSort {


    public static void quickSort(int[] a, int si, int ei){

        //base case
        if(si >= ei){
            return;
        }
        

        int pivot = partition(a, si, ei);
        quickSort(a, si, pivot-1);
        quickSort(a, pivot+1, ei);
        

    }
    public static int partition(int[] a, int si, int ei){

        //assume first element to be pivot
        int pivotElement = a[si];

        //count elements smaller than pivot element
        int count = 0;
        for(int i = si+1; i <= ei; i++){
            if(a[i]<pivotElement){
                count++;
            }
        }


        //pivot index
        int pivot = si + count;

        //place pivot element at pivot index
        int temp = a[pivot];
        a[pivot] = pivotElement;
        a[si] = temp;



        //place all elements that are smaller than pivot on left side
        //and larger on right side
        int i = si;
        int j = ei;
        while(i<j){
            if(a[i] < pivotElement){
                i++;
            }
            else if(a[j]>=pivotElement){
                j--;
            }else{
                int temp2 = a[i];
                a[i] = a[j];
                a[j] = temp2;
                i++;
                j--; 
            }

        }
        return si+count;

    }

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        int[] arr = {1,22,4,5,17,8,21,31,-8,-5};
        quickSort(arr,0,arr.length-1);
        printArray(arr);

        //output: -8 -5 1 4 5 8 17 21 22 31  
        
    }
}
