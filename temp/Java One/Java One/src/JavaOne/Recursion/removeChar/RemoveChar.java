package JavaOne.Recursion.removeChar;

public class RemoveChar {
    
    public static String removeX(String s){

        //base case
        if(s.length() == 0){
            return s;
        }

        String smallOutput = removeX(s.substring(1));

        //assuming we already have removed 'x' string starting from
        //index 1



        //so if the first char is 'x' in remaining string then 
        //remove it
        
        if(s.charAt(0)=='x'){
            return smallOutput;
        }else{
            return s.charAt(0) + smallOutput;
        }

    }

    public static void main(String[] args) {
        System.out.println(removeX("abxcxdxefghixyxhgxxx"));
    }
}
