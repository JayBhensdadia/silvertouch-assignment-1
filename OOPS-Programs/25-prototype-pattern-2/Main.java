import java.util.HashMap;

abstract class Animal implements Cloneable{
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Object clone = null;

        try {
            clone = super.clone();
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        return clone;
    }

    abstract void speak();
}

class Dog extends Animal{
    public Dog(){
        this.setType("dog");
    }

    @Override
    void speak() {
        System.out.println("Bhow Bhow");
    }
}

class Cat extends Animal{
    public Cat(){
        this.setType("cat");
    }

    @Override
    void speak() {
        System.out.println("Meow Meow");
    }
}

class Cache{
    private static HashMap<String,Animal> map = new HashMap<>();

    public static Animal getAnimal(String id){
        return (Animal)map.get(id).clone();
    }

    public static void loadCache(){

        Dog d = new Dog();
        d.setId("1");
        map.put(d.getId(), d);


        Cat c = new Cat();
        c.setId("2");
        map.put(c.getId(), c);

    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Cache.loadCache();

        Animal clonedAnimal = (Animal) Cache.getAnimal("1");
        clonedAnimal.speak();

        Animal clonedAnimal2 = (Animal) Cache.getAnimal("2");
        clonedAnimal2.speak();

    }
}