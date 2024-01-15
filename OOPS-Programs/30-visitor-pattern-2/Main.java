import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface ComputerPart{
    public void accept(Visitor v);
}

interface Visitor{
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
}


class Mouse implements ComputerPart{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Keyboard implements ComputerPart{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Computer implements ComputerPart{
    List<ComputerPart> parts = new ArrayList<>();

    public void addPart(ComputerPart p){
        parts.add(p);
    }

    @Override
    public void accept(Visitor v) {
        for (ComputerPart p : parts) {
            p.accept(v);
        }

        v.visit(this);
    }
}

class ComputerPartVisitor implements Visitor{

    @Override
    public void visit(Computer computer) {
        System.out.println("displaying COMPUTER");
    }
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("displaying KEYBOARD");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("displaying MOUSE");
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Visitor v = new ComputerPartVisitor();

        ComputerPart p1 = new Keyboard();
        ComputerPart p2 = new Mouse();
        Computer c = new Computer();
        c.addPart(p1);
        c.addPart(p2);

        c.accept(v);

    }
}


