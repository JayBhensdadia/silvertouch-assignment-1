package JavaOne.VariablesDataType;


public class Variables_DataTypes {
    public static void main(String[] args) {
        
        //    int        a      =     10;
        //  datatype   variable      data


        //storing integral data

        byte a1 = 10;
        short a2 = 123;
        int a3 = 12345;
        long a4 = 12345678;

        System.out.println("size of byte: "+ Byte.SIZE/8+" bytes");
        System.out.println("size of short: "+ Short.SIZE/8+" bytes");
        System.out.println("size of int: "+ Integer.SIZE/8+" bytes");
        System.out.println("size of long: "+ Long.SIZE/8+" bytes");


        //storing decimal data

        float f = 10.5f;
        double d = 10.234;

        System.out.println("size of float: "+ Float.SIZE/8+" bytes");
        System.out.println("size of double: "+ Double.SIZE/8+" bytes");
    
    
        // storing characters

        char ch = 'c';
        System.out.println("size of char: "+ Character.SIZE/8+" bytes");
    

        //storing strings

        String str = "jay";


        // storing booleans

        boolean b = true;
        boolean b2 = false;

    
    
    }
}
