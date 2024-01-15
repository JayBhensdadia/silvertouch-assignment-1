package JavaOne.Recursion.ReplaceCharacter;

public class ReplaceChar {
    
    public static String replace(String s, char org, char rep){

        //base case 
        if(s.length() == 0){
            return s;
        }

        //recurisvly calling function 
        String smallOutput = replace(s.substring(1), org, rep);
        
        if(s.charAt(0)==org){
            return rep + smallOutput;
        }else{
            return  s.charAt(0)+smallOutput;
        }


    }

    public static void main(String[] args) {
        System.out.println(replace("abxcxdx", 'x', 'z'));
    }

}
