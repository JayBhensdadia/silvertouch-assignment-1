package JavaOne.Algorithms.QuickSort;

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

        int pivotElement = a[si];
        int count = 0;

        for(int i = si+1; i <= ei; i++){
            if(a[i]<pivotElement){
                count++;
            }
        }

        int pivot = si + count;

        int temp = a[pivot];
        a[pivot] = pivotElement;
        a[si] = temp;

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
