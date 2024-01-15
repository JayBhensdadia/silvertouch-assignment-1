interface RenderingEngine{
    void render();
}

class SimpleRE implements RenderingEngine{
    @Override
    public void render() {
        System.out.println("Rendered by Simple Rendering Engine");
    }
}

class AdvancedRE implements RenderingEngine{
    @Override
    public void render() {
        System.out.println("Rendered by Advanced Rendering Engine");
    }
}

abstract class Shape{
    protected RenderingEngine engine;

    public Shape(RenderingEngine engine){
        this.engine = engine;
    }

    abstract void draw();
}


class Circle extends Shape{
    public Circle(RenderingEngine engine){
        super(engine);
    }

    @Override
    void draw() {
        System.out.println("Circle is drawn");
        this.engine.render();
    }
}

class Rectangle extends Shape{
    public Rectangle(RenderingEngine engine){
        super(engine);
    }

    @Override
    void draw() {
        System.out.println("Rectangle is drawn");
        this.engine.render();
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(new SimpleRE());
        circle.draw();

        System.out.println();

        Rectangle rect = new Rectangle(new AdvancedRE());
        rect.draw();
    }
}