interface TrafficLightState{
    public void doAction(Context context);
}


class Context{
    private TrafficLightState state;

    public Context(){ state = null;}
    public Context(TrafficLightState state){ this.state = state;}

    public TrafficLightState getState(){return state;}

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void execute(){
        this.state.doAction(this);
    }
}

class Red implements TrafficLightState{
    @Override
    public void doAction(Context context) {
        System.out.println("stop.....");
        context.setState(this);
    }
}

class Yellow implements TrafficLightState{
    @Override
    public void doAction(Context context) {
        System.out.println("start your engines.....");
        context.setState(this);
    }
}

class Green implements TrafficLightState{
    @Override
    public void doAction(Context context) {
        System.out.println("go....");
        context.setState(this);
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context();

        TrafficLightState A = new Red();
        context.setState(A);
        context.execute();
        

        TrafficLightState B = new Yellow();
        context.setState(B);
        context.execute();

        TrafficLightState C = new Green();
        context.setState(C);
        context.execute();

        
    }
}