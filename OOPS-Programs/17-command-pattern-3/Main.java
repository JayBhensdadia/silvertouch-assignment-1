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

class AC{
    private boolean isOn = false;

    public void turnOn(){ 
        this.isOn = true;
        System.out.println("AC truned ON");
    }
    public void turnOff(){ 
        this.isOn = false; 
        System.out.println("AC turned OFF");
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

class ACOnCommand implements Command{
    private AC ac;

    public ACOnCommand(AC ac){
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.ac.turnOn();
    }
}


class ACOffCommand implements Command{
    private AC ac;

    public ACOffCommand(AC ac){
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.ac.turnOff();
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
        AC ac = new AC();

        LightOnCommand lightOnCmd = new LightOnCommand(light);
        LightOffCommand lightOffCmd = new LightOffCommand(light);
        ACOnCommand acOnCommand = new ACOnCommand(ac);
        ACOffCommand acOffCommand = new ACOffCommand(ac);

        Broker broker = new Broker();
        broker.takeCommand(lightOnCmd);
        broker.takeCommand(acOnCommand);
        broker.takeCommand(lightOffCmd);
        broker.takeCommand(acOffCommand);

        broker.executeCommands();
        
    }
}