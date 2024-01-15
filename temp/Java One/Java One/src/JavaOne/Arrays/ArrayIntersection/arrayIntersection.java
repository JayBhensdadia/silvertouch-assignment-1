package JavaOne.Arrays.ArrayIntersection;
import java.util.Arrays;
public class arrayIntersection {

    public static void intersection(int[] a, int[] b){

        //O(n * m)
        //fails when duplicates are there

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i]==b[j])
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void intersectionBetter1(int[] arr1, int[] arr2) {
	    
        //(nlogn + mlogm)
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
       	int i = 0;
        int j = 0;
        
        while(i<arr1.length && j<arr2.length){
            
            if(arr1[i]>arr2[j]){
                j++;
            }else if(arr1[i]<arr2[j]){
                i++;
            }else if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            
        }
	}

    public static void intersectionBetter2(int[] arr1, int[] arr2){


        // O(nlogn + mlogn) 
        //fails when duplicates are there

        int n = arr1.length;
        int m = arr2.length;

        if(n<m){

            Arrays.sort(arr1);
            for(int i = 0; i < arr2.length; i++){
                if(Arrays.binarySearch(arr1, arr2[i])!=-1){
                    System.out.print(arr2[i]+" ");
                }
            }


        }else{

            Arrays.sort(arr2);
            for(int i = 0; i < arr1.length; i++){
                if(Arrays.binarySearch(arr2, arr1[i])!=-1){
                    System.out.print(arr1[i]+" ");
                }
            }

        }

    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,2,3,5};

        //intersection(arr1, arr2);
        intersectionBetter1(arr1, arr2);
        
    }
}
