package Geometric_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {

    public static List<Point> findConvexHull(Point[] points) {
        if (points.length < 3) {
            
            return new ArrayList<>();
        }

        
        Point startPoint = findStartPoint(points);

        
        Arrays.sort(points, (p1, p2) -> compareByPolarAngle(startPoint, p1, p2));

        
        Stack<Point> convexHull = new Stack<>();
        convexHull.push(startPoint);
        convexHull.push(points[0]);
        convexHull.push(points[1]);

        
        for (int i = 2; i < points.length; i++) {
            while (isClockwise(convexHull.elementAt(convexHull.size() - 2),
                    convexHull.peek(), points[i])) {
                convexHull.pop();
            }
            convexHull.push(points[i]);
        }

        return new ArrayList<>(convexHull);
    }

    private static Point findStartPoint(Point[] points) {
        Point startPoint = points[0];
        for (Point point : points) {
            if (point.y < startPoint.y || (point.y == startPoint.y && point.x < startPoint.x)) {
                startPoint = point;
            }
        }
        return startPoint;
    }

    private static int compareByPolarAngle(Point start, Point p1, Point p2) {
        int orientation = orientation(start, p1, p2);

        if (orientation == 0) {
            
            return distanceSquare(start, p1) - distanceSquare(start, p2);
        }

        return orientation;
    }

    private static boolean isClockwise(Point a, Point b, Point c) {
        return (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y) < 0;
    }

    private static int orientation(Point a, Point b, Point c) {
        int val = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
        if (val == 0) return 0;  
        return (val > 0) ? 1 : -1;
    }

    private static int distanceSquare(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(0, 3),
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 4),
                new Point(0, 0),
                new Point(1, 2),
                new Point(3, 1),
                new Point(3, 3)
        };

        List<Point> convexHull = findConvexHull(points);

        System.out.println("Convex Hull Points:");
        for (Point point : convexHull) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }
}
