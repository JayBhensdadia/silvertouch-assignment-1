package JavaOne.HashMap;


import java.util.HashMap;
import java.util.Set;

public class inbuiltHMUse {
    public static void main(String[] args) {

        //creating hashmap
        HashMap<String,Integer> map = new HashMap<>();

        //setting value
        map.put("abc", 1);
        map.put("def", 3);
        map.put("dhoom", 4);

        //iterate
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("[ "+key+" , "+map.get(key)+" ]");
        }

        //getting value
        for (String key : map.keySet()) {
            System.out.println("[ "+key+" , "+map.get(key)+" ]");
        }

        //removal
        map.remove("dhoom");

        for (String key : map.keySet()) {
            System.out.println("[ "+key+" , "+map.get(key)+" ]");
        }

        System.out.println(map.size());


        
        
    }
}
