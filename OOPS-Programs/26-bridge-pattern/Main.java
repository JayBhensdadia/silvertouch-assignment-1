interface Color{
    void fill();
}

class Red implements Color{
    @Override
    public void fill() {
        System.out.println("filled color RED");
    }
}

class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("filled color Blue");
    }
}

abstract class Shape{
    protected Color color;

    public Shape(Color color){
        this.color = color;
    }

    abstract void draw();
}

class Circle extends Shape{

    public Circle(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.println("circle is drawn");
        this.color.fill();
    }
}

class Rectangle extends Shape{
    public Rectangle(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.println("rectangle is drawn");
        this.color.fill();
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(new Red());
        circle.draw();

        System.out.println();
        
        Rectangle rect = new Rectangle(new Blue());
        rect.draw();
    }
}