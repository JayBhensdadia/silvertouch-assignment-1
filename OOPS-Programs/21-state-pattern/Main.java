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

class StateA implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("in StateA");
        context.setState(this);
    }
}

class StateB implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("in StateB");
        context.setState(this);
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context();

        StateA stateA = new StateA();
        context.setState(stateA);
        context.execute();

        StateB stateB = new StateB();
        context.setState(stateB);
        context.execute();
    }
}