package Spatial_Data_Structures;

import java.util.ArrayList;
import java.util.List;

class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    double x, y, width, height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(double px, double py) {
        return px >= x && px <= x + width && py >= y && py <= y + height;
    }

    public boolean intersects(Rectangle other) {
        return x < other.x + other.width && x + width > other.x && y < other.y + other.height && y + height > other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}


class QuadTreeNode {
    Rectangle bounds;
    List<Point> points;
    QuadTreeNode[] children;

    public QuadTreeNode(Rectangle bounds) {
        this.bounds = bounds;
        this.points = new ArrayList<>();
        this.children = new QuadTreeNode[4];
    }
}

public class Quadtree {
    private static final int MAX_POINTS_PER_NODE = 4;
    private QuadTreeNode root;

    public Quadtree(Rectangle bounds) {
        this.root = new QuadTreeNode(bounds);
    }

    public void insert(Point point) {
        insert(root, point);
    }

    private void insert(QuadTreeNode node, Point point) {
        if (!node.bounds.contains(point.x, point.y)) {
            return;
        }

        if (node.points.size() < MAX_POINTS_PER_NODE && node.children[0] == null) {
            node.points.add(point);
        } else {
            if (node.children[0] == null) {
                splitNode(node);
            }

            for (int i = 0; i < 4; i++) {
                insert(node.children[i], point);
            }
        }
    }

    private void splitNode(QuadTreeNode node) {
        double x = node.bounds.getX();
        double y = node.bounds.getY();
        double w = node.bounds.getWidth() / 2;
        double h = node.bounds.getHeight() / 2;

        node.children[0] = new QuadTreeNode(new Rectangle(x, y, w, h));
        node.children[1] = new QuadTreeNode(new Rectangle(x + w, y, w, h));
        node.children[2] = new QuadTreeNode(new Rectangle(x, y + h, w, h));
        node.children[3] = new QuadTreeNode(new Rectangle(x + w, y + h, w, h));

        for (Point p : node.points) {
            insert(node, p);
        }
        node.points.clear();
    }

    public List<Point> queryRange(Rectangle range) {
        List<Point> result = new ArrayList<>();
        queryRange(root, range, result);
        return result;
    }

    private void queryRange(QuadTreeNode node, Rectangle range, List<Point> result) {
        if (!node.bounds.intersects(range)) {
            return;
        }

        for (Point p : node.points) {
            if (range.contains(p.x, p.y)) {
                result.add(p);
            }
        }

        if (node.children[0] != null) {
            for (int i = 0; i < 4; i++) {
                queryRange(node.children[i], range, result);
            }
        }
    }

    public static void main(String[] args) {
        Quadtree quadtree = new Quadtree(new Rectangle(0, 0, 100, 100));

        quadtree.insert(new Point(10, 10));
        quadtree.insert(new Point(30, 30));
        quadtree.insert(new Point(70, 70));
        quadtree.insert(new Point(90, 90));

        Rectangle queryRange = new Rectangle(20, 20, 50, 50);
        List<Point> pointsInRange = quadtree.queryRange(queryRange);

        System.out.println("Points in the range:");
        for (Point point : pointsInRange) {
            System.out.println("(" + point.x + ", " + point.y + ")");
        }
    }
}

