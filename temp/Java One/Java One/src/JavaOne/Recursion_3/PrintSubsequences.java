package JavaOne.Recursion_3;

public class PrintSubsequences {
    public static void printSubSeq(String str, String sofar){
        if(str.length()==0){
            System.out.println(sofar);
            return;
        }
        printSubSeq(str.substring(1), sofar+str.charAt(0));
        printSubSeq(str.substring(1), sofar);
    }
    public static void main(String[] args) {
        String str = "abc";
        printSubSeq(str,"");
    }
}
