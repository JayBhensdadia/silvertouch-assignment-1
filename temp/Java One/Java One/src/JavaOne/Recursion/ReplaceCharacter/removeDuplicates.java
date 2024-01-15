package JavaOne.Recursion.ReplaceCharacter;
/**
 * remove consicutive duplicates
 */

public class removeDuplicates {

    public static String removeDup(String s){

        //base case 
        if(s.length() <= 1){
            return s;
        }

        String smalloutput = removeDup(s.substring(1));
        if(s.charAt(0)==smalloutput.charAt(0)){
            return String.valueOf(s.charAt(0)) + smalloutput.substring(1);
        }else{
            return s.charAt(0) + smalloutput;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(removeDup("aaabiiciiiccdaaadsssss"));
    }
}
