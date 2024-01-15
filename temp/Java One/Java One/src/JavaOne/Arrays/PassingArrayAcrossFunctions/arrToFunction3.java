package JavaOne.Arrays.PassingArrayAcrossFunctions;

public class arrToFunction3 {
    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static int[] increment(int[] a){

        a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i]+=1;
        }
        return a;
    }

  
    

    public static void main(String[] args) {
    
        int[] arr = {1,2,3,4,5};
        
        arr = increment(arr);
        
        
        printArray(arr);

        

    }
}
