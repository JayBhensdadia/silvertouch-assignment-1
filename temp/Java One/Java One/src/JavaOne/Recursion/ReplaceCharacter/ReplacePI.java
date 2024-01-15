package JavaOne.Recursion.ReplaceCharacter;

public class ReplacePI {
    
    public static String replacepi(String s){

        //base case
        if(s.length() <= 0){
            return s;
        }

        if(s.charAt(0)=='p' && s.charAt(1)=='i'){
            String smalloutput = replacepi(s.substring(2));
            return "3.14" + smalloutput;
        }else{
            String smalloutput = replacepi(s.substring(1));
            return s.charAt(0) + smalloutput;
        }

       
    }

    public static void main(String[] args) {

        System.out.println(replacepi("hellopiiampi"));
    }
}
