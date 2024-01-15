package JavaOne.Recursion_3;

public class KeypadUse {
    public static void main(String[] args) {
        Keypad k = new Keypad();
        String[] ans = k.keypad(23);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
