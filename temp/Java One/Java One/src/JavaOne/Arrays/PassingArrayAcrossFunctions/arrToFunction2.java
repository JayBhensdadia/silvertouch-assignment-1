package JavaOne.Arrays.PassingArrayAcrossFunctions;

public class arrToFunction2 {

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void increment(int[] a){
        
        a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i]+=1;
        }
    }

    public static void main(String[] args) {
    
        int[] arr = {1,2,3,4,5};
       
        increment(arr);
        
        printArray(arr);

        

    }
    
}
