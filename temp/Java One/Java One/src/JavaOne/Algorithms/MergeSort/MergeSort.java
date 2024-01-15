package JavaOne.Algorithms.MergeSort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] a){

        //base case
        if(a.length <= 1){
            return;
        }

        int mid = a.length/2;

        int[] smallArr1 = new int[mid];
        int[] smallArr2 = new int[a.length - mid];

        for(int i = 0; i < mid; i++){
            smallArr1[i] = a[i];
        }
        for(int j = mid,k=0; j < a.length; j++,k++){
            smallArr2[k] = a[j];
        }

        mergeSort(smallArr1);
        mergeSort(smallArr2);
        Merge(a,smallArr1,smallArr2);

    }

    public static void Merge(int[] ans,int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<n && j<m) {
            if (a[i]<b[j]) {
                ans[k] = a[i];
                i++;
            }else if (a[i]>=b[j]) {
                ans[k] = b[j];
                j++;
            }
            k++;
        }

        if (i>=n) {
            for (int l = j; l < m; l++) {
                ans[k] = b[l];
                
                k++;
            }
        }else if(j>=m){
            for (int l = i; l < n; l++) {
                ans[k] = a[l];
                
                k++;
            }

        }


    } 

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    
    public static void main(String[] args) {

        

        int[] arr = {1,22,4,5,17,8,21,31,-8,-5};
        mergeSort(arr);
        printArray(arr);
        
        //output : -8 -5 1 4 5 8 17 21 22 31
    }

}
