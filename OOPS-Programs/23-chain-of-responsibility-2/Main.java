abstract class Logger{
    protected Logger next;

    public void setNextLogger(Logger lg){
        this.next = lg;
    }

    public abstract void log(String msg);
}

class SimpleLogger extends Logger{
    @Override
    public void log(String msg) {
        if(msg.length() < 30){
            System.out.println("Simple Logger: " + msg);
        }else{
            next.log(msg);
        }
    }
}


class AdvancedLogger extends Logger{
    @Override
    public void log(String msg) {
        System.out.println("Advanced Logger: " + msg);
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Logger logger1 = new SimpleLogger();
        Logger logger2 = new AdvancedLogger();

        logger1.setNextLogger(logger2);


        logger1.log("compilation successfull!!!!");
        logger1.log("compilation time is 321 micro seconds");
    }
}