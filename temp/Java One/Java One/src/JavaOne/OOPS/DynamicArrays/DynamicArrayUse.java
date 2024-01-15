package JavaOne.OOPS.DynamicArrays;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();
        d.add(10);
        System.out.println(d.size());
        System.out.println(d.get(0));

        d.set(1, 11);
        System.out.println(d.size());
        System.out.println(d.get(10));
    }
}
