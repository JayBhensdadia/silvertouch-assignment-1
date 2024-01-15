package JavaOne.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// step 1 : create file object
// step 2 : pass file object to scanner class constructor
// step 3 : use scanner methods to read file

public class inputFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File("/Users/jaybhensdadia/Documents/Java One/src/JavaOne/Input/input.txt");
        Scanner sc = new Scanner(file);

        ArrayList<Integer> arr = new ArrayList<>();
        
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            arr.add(Integer.parseInt(sc.next()));
        }

        System.out.println(arr);

    }
}
