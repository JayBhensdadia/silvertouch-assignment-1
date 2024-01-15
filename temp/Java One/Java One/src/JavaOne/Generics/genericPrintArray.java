package JavaOne.Generics;

public class genericPrintArray {
    

    public static<T> void printArray(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        //System.out.println();
    }
    public static<T extends printInterface> void customPrint(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
    }

    public static void main(String[] args) {

        vehicle[] v = new vehicle[5];
        for (int i = 0; i < v.length; i++) {
            v[i] = new vehicle((i+1)*10, "JB");
        }

        
        customPrint(v);

        //output:
        // 10 JB
        // 20 JB
        // 30 JB
        // 40 JB
        // 50 JB
    }
}
