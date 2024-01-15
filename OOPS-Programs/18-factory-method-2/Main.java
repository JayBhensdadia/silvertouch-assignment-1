interface Vehicle{
    void drive();
}

class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("driving bike.....");
    }
}

class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("driving car...");
    }
}

class VehicleFactory{
    public Vehicle getVehicle(String type){
        if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }else if (type.equalsIgnoreCase("car")) {
            return new Car();
        }

        return null;
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle v1 = factory.getVehicle("bike");
        Vehicle v2 = factory.getVehicle("car");

        v1.drive();
        v2.drive();
    }
}