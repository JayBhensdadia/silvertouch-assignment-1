
/* Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java Virtual Machine. */

class Logger{
    private static Logger logger = new Logger();
    
    private Logger(){}

    public static Logger getLogger(){
        return logger;
    }

    public void doSomething(){
        System.out.println("inside logger class");
    }
}


public class Main {

    public static void main(String[] args) {
        Logger lg = Logger.getLogger();
        lg.doSomething();

        Logger lg2 = Logger.getLogger();
        lg2.doSomething();

        System.out.println(lg==lg2);
    }
    
}
