import java.util.ArrayList;
import java.util.List;

interface Command{
    void execute();
}

class Light{
    private boolean isOn = false;

    public void turnOn(){ 
        this.isOn = true;
        System.out.println("Light truned ON");
    }
    public void turnOff(){ 
        this.isOn = false; 
        System.out.println("Light turned OFF");
    }

}


class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOn();
    }
}


class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.turnOff();
    }
}

class Broker{
    private List<Command> commandList = new ArrayList<>();

    public void takeCommand(Command cmd){
        commandList.add(cmd);
    }

    public void executeCommands(){
        for (Command cmd : commandList) {
            cmd.execute();
        }

        commandList.clear();
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Light light = new Light();

        LightOnCommand onCmd = new LightOnCommand(light);
        LightOffCommand offCmd = new LightOffCommand(light);

        Broker broker = new Broker();
        broker.takeCommand(onCmd);
        broker.takeCommand(offCmd);

        broker.executeCommands();
        
    }
}