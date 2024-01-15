package JavaOne.Recursion.sumOfArray;

public class ArrSum {

    public static int sum(int[] a){

        //base case
        //if array length is 1 return the only element
        if(a.length == 1){
            return a[0];
        }

        //then recursively add smaller arays
        int[] smallArr = new int[a.length - 1];
        for(int i = 0; i < smallArr.length; i++){
            smallArr[i] = a[i];
        }
        int smallOutput = sum(smallArr);

        //if the hypothesis is true then it will sum from index
        // 0 to n-2 so the final output will be smallouput + a[n-1]
        int output = smallOutput + a[a.length-1];
        return output;
    }
    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,6};
        System.out.println(sum(arr));
    }
    
}
