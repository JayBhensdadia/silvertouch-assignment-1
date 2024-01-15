class Engine{
    String type;
    public Engine(String type){
        this.type = type;
    }
}

class Car{
    String maker;
    String model;
    Engine engine;

    public Car(String maker, String model, Engine engine){
        this.maker = maker;
        this.model = model;
        this.engine = engine;
    }

    public void displayDetails(){
        System.out.println("Maker: " + this.maker);
        System.out.println("Model: " + this.model);
        System.out.println("Engine: " + this.engine.type);
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("v8");
        Car car = new Car("Suzuki", "Alto", engine);

        car.displayDetails();
    }
}
