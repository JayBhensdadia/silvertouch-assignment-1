interface State{
    public void doAction(Context context);
}

class Context{
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void execute(){
        this.state.doAction(this);
    }
}

class NoCoinState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Vending machine in NO-COIN-STATE");
    }
}

class HasCoinState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Vending machine in HAS-COIN-STATE");
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        State s1 = new HasCoinState();
        context.setState(s1);
        context.execute();

        System.out.println();
        System.out.println("after some vending actions.....");
        System.out.println();

        State s2 = new NoCoinState();
        context.setState(s2);
        context.execute();
    }
}

