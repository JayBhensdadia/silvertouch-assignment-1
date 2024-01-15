package JavaOne.VariablesDataType;

public class LocalVariable {

    public LocalVariable(){

        // example of local variable
        int var1 = 10;
    }

    static void hello(){
        //example of local variable
        String var2 = "hello";
    }
    public static void main(String[] args) {
        
        /**
          Variables which are defined within a block, 
          method or constructor.

          Scope is limited to that block or 
          method or constructor

         */


         {
            //example of local variable
            int var3 = 33;

         }

         // i cant access var3 here
    }
}
