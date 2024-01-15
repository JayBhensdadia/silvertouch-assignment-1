
interface Shape{
    public double calculateArea();
}

class Circle implements Shape{
    int radius;

    public Circle(int r){
        this.radius = r;
    }

    @Override
    public double calculateArea() {
        return 2*3.14*this.radius*this.radius;
    }
}


class Rectangle implements Shape{
    int length;
    int breadth;

    public Rectangle(int l, int b){
        this.length = l;
        this.breadth = b;
    }

    @Override
    public double calculateArea() {
        return this.length * this.breadth;
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Circle c = new Circle(10);
        System.out.println("Circle Area = " + c.calculateArea());

        Rectangle rect = new Rectangle(10, 12);
        System.out.println("Rectangle Area = " + rect.calculateArea());
    }
}