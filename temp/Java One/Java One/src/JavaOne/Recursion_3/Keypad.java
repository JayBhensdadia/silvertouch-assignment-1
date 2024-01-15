package JavaOne.Recursion_3;

import java.util.HashMap;

public class Keypad {
    
    public static HashMap<Integer,String> map;

    //hashmap that stores the string corresponding to 
    //every numbers in the dial pad
    public static void createMap(){
        map = new HashMap<>();
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        map.put(0,"");
    }

    public static String[] keypad(int n){
		
        //creating hashmap 
        createMap();
        
        //base case
        if(n==0){
            String[] ans = new String[1];
            ans[0] ="";
            return ans;
        }
        
        //getting hold on last digit
        int num = n%10;

        //getting output of n/10 (if n = 234 then output of 23)
        String[] temp = keypad(n/10);

        //creating output
        String[] output;

        //if num==0 or 1 then temp is our output also
        if(num==0 || num==1){
            return temp;
        }else{

            //if num!=0 && num!=1 then
            //ouput array size would be 
            //tempSize * stringSize(corresponding to num)
            String str = map.get(num);
            int length = temp.length * str.length();
        	output = new String[length];
            
        }
        
        int si = 0;
        int index = 0;
        while(si<map.get(num).length()){
            //in every iteration adding char to every elements of temp
            for(int i = 0; i < temp.length; i++){
                output[index] = temp[i] + map.get(num).charAt(si);
                index++;
            }
            si++;
        }
        
        return output;

	}

}
