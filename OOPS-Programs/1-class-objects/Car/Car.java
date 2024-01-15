
public class Car {
    private String maker;
    private String model;
    private int year;

    public Car(String maker, String model, int year){
        this.maker = maker;
        this.model = model;
        this.year = year;
    }


    private void displayDetails(){
        System.out.println("Maker: "+ this.maker);
        System.out.println("Model: "+this.model);
        System.out.println("Year: "+this.year);
    }


    public static void main(String[] args) {
        Car c = new Car("Suzuki", "Alto", 2009);
        c.displayDetails();
    }
    
}
