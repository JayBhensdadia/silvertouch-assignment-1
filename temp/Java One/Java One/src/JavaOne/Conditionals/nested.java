package JavaOne.Conditionals;

public class nested {
    public static void main(String[] args) {
        int age = 19;
        boolean haveVoterID = false;

        if(age>=18){
            if(haveVoterID){
                System.out.println("you can vote");
            }else{
                System.out.println("get voter id first");
            }
        }else{
            System.out.println("you cant vote");
        }
    }
}
