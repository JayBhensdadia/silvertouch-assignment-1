import java.util.ArrayList;
import java.util.List;

class Momento{
    private String state;

    public Momento(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
}


class Originator{
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Momento saveStateToMomento(){
        return new Momento(state);
    }

    public void getStateFromMomento(Momento m){
        this.state = m.getState();
    }
}


class CareTaker{
    private List<Momento> momentoList = new ArrayList<>();

    public void add(Momento m){
        momentoList.add(m);
    }

    public Momento getMomento(int index){
        return momentoList.get(index);
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Originator originator = new Originator();
        CareTaker caretaker = new CareTaker();

        originator.setState("S1");
        caretaker.add(originator.saveStateToMomento());

        originator.setState("S2");
        caretaker.add(originator.saveStateToMomento());
        
        originator.setState("S3");
        System.out.println("Current state: " + originator.getState());

        //setting back to previous state
        originator.getStateFromMomento(caretaker.getMomento(0));
        System.out.println("First saved state: " + originator.getState());

        originator.getStateFromMomento(caretaker.getMomento(1));
        System.out.println("Second saved state: " + originator.getState());
    }
}