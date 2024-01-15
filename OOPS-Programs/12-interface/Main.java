
//drawable interface
interface Drawable{
    public void draw();
}


//Circle class that implements Drawable interface
class Circle implements Drawable{
    @Override
    public void draw() {
        System.out.println("Circle is drawn");
    }
}

//Rectangle class that implements Drawable interface
class Rectangle implements Drawable{
    @Override
    public void draw() {
        System.out.println("Rectangle is drawn");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rect = new Rectangle();

        circle.draw();
        rect.draw();
    }    
}

