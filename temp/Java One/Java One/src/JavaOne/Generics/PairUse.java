package JavaOne.Generics;

public class PairUse {
    public static void main(String[] args) {
        Pairs<String,Integer> innerPair = new Pairs<>("jay", 108);
        Pairs<Pairs<String,Integer>,String> p = new Pairs<Pairs<String,Integer>,String>();
        p.setFirst(innerPair);
        System.out.println(p.getFirst());
        p.setSecond("abcd");
        System.out.println(p.getSecond());

        System.out.println("first : "+ p.getFirst().getFirst() +" , "+p.getFirst().getSecond());
        System.out.println("second : "+p.getSecond());

        //output:

        // JavaOne.Generics.Pairs@ee7d9f1
        // abcd
        // first : jay , 108
        // second : abcd
    }
}
