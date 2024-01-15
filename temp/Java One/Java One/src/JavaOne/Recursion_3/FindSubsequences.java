package JavaOne.Recursion_3;

public class FindSubsequences {

    public static String[] subsequences(String str){
        //base case
        if(str.length()==0){
            String[] ans = new String[1];
            ans[0] = "";
            return ans;
        }

        //ans of substring(1)
        String[] temp = subsequences(str.substring(1));
        
        //creating double size array
        String[] output = new String[2*temp.length];

        int i = 0;

        //copying elements of temp in ouput
        for(int j = 0; j<temp.length; j++){
            output[i] = temp[j];
            i++;
        }

        //copying + adding str.charAt(0) elements of temp in output
        for(int j = 0; j<temp.length; j++){
            output[i] = str.charAt(0)+temp[j];
            i++;
        }
        return output;
        
    }
    public static void printArray(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        String[] ans = new String[(int)Math.pow(2, str.length())];
        ans = subsequences(str);
        printArray(ans);
    }
}
