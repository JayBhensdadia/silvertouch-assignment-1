import java.util.ArrayList;
import java.util.List;

interface Command{
    void execute();
}

class TV{
    private boolean isOn = false;

    public void turnOn(){
        this.isOn = true;
        System.out.println("TV turned ON");
    }

    public void turnOff(){
        this.isOn = false;
        System.out.println("TV turned OFF");
    }
}

class onButton implements Command{
    private TV tv;

    public onButton(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        System.out.println("on-button pressed");
        this.tv.turnOn();
    }
}

class offButton implements Command{
    private TV tv;

    public offButton(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        System.out.println("off-button pressed");
        this.tv.turnOff();
    }
}


class Remote{
    private List<Command> cmds;

    public Remote(){ cmds = new ArrayList<>();}

    public void takeCommand(Command cmd){ cmds.add(cmd);}

    public void executeCommands(){
        for (Command cmd : cmds) {
            cmd.execute();
        }

        cmds.clear();
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        TV tv = new TV();
        Remote remote = new Remote();

        remote.takeCommand(new onButton(tv));
        remote.takeCommand(new offButton(tv));

        remote.executeCommands();
    }
}