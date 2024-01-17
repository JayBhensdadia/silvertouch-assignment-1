package Geometric_Algorithms;

class Rectangle {
    int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean overlap(Rectangle other) {
        
        if (x1 >= other.x2 || other.x1 >= x2) {
            return false;
        }

        
        if (y1 >= other.y2 || other.y1 >= y2) {
            return false;
        }

       
        return true;
    }
}

public class RectangleOverlap {

    public static void main(String[] args) {
        
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 8, 8);

        boolean isOverlap = rect1.overlap(rect2);

        if (isOverlap) {
            System.out.println("Rectangles overlap");
        } else {
            System.out.println("Rectangles do not overlap");
        }
    }
}
