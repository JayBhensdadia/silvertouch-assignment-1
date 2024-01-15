
class Shape {

    

    int area(){
        return 0;
    }
    
    int perimeter(){
        return 0;
    }
}

class Rectangle extends Shape{
    int length;
    int breadth;

    public Rectangle(int l, int b){
        this.length = l;
        this.breadth = b;
    }

    @Override
    int area() {
        return this.length * this.breadth;
    }

    @Override
    int perimeter() {
        return 2*(this.length + this.breadth);
    }
    
}


public class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 12);
        System.out.println("Area = " + rect.area());
        System.out.println("Perimeter = " + rect.perimeter());
    }
}