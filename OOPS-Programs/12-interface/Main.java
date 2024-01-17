

interface Drawable{
    public void draw();
}



class Circle implements Drawable{
    @Override
    public void draw() {
        System.out.println("Circle is drawn");
    }
}


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

