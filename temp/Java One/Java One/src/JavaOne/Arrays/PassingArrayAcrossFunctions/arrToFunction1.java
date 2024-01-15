package JavaOne.Arrays.PassingArrayAcrossFunctions;

public class arrToFunction1 {

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void increment(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i]+=1;
        }
    }

    public static void increment(int a){
        a++;
    }

    

    public static void main(String[] args) {
    
        int[] arr = {1,2,3,4,5};
        int i = 10;
        increment(arr);
        increment(i);

        System.out.println(i);
        printArray(arr);

        

    }
}
