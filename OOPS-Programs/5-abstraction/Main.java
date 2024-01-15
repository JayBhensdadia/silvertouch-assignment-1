abstract class Animal{
    abstract void eat();
    abstract void sound();
}


class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("dog is eating...");
    }

    @Override
    void sound() {
        System.out.println("dog is making sound.....");
    }
}

class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("cat is eating.....");
    }

    @Override
    void sound() {
        System.out.println("cat is making sound......");
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();

        d.eat();
        c.sound();
    }
}