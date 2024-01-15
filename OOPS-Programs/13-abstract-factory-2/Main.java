interface Chair{}
interface Table{}


class SimpleChair implements Chair{
    public SimpleChair(){
        System.out.println("Simple chair is created!");
    }
}

class FancyChair implements Chair{
    public FancyChair(){
        System.out.println("fancy chair is created!");
    }
}

class SimpleTable implements Table{
    public SimpleTable(){
        System.out.println("simple table is created!");
    }
}

class FancyTable implements Table{
    public FancyTable(){
        System.out.println("fancy table is created!");
    }
}

abstract class AbstractFactory{
    abstract public Chair getChair();
    abstract public Table getTable();
}

class Factory1 extends AbstractFactory{
    @Override
    public Chair getChair() {
        return new SimpleChair();
    }

    @Override
    public Table getTable() {
        return new SimpleTable();
    }
}


class Factory2 extends AbstractFactory{
    @Override
    public Chair getChair() {
        return new FancyChair();
    }

    @Override
    public Table getTable() {
        return new FancyTable();
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory fact1 = new Factory1();
        AbstractFactory fact2 = new Factory2();

        fact1.getChair();
        fact2.getTable();
    }
}