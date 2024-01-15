interface Mediator{
    void sendMessage(String msg, User user);
}

abstract class User{
    protected Mediator mediator;
    String name;

    public User(String name, Mediator med){
        this.name = name;
        this.mediator = med;
    }

    abstract public void send(String msg, User user);

}


class Employee extends User{

    public Employee(String name, Mediator med){
        super(name, med);
    }

    @Override
    public void send(String msg, User user) {
        System.out.print(name + ": ");
        this.mediator.sendMessage(msg, user);
    }
}




class ChatMediator implements Mediator{
    @Override
    public void sendMessage(String msg, User user) {
        System.out.println(msg);
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediator();

        Employee emp1 = new Employee("jay", chatMediator);
        Employee emp2 = new Employee("vijay", chatMediator);

        emp1.send("hi, vijay how are you?", emp2);
        emp2.send("i am fine, what about you?", emp2);

    }
}