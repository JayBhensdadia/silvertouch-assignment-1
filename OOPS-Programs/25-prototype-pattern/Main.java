import java.util.HashMap;

abstract class Shape implements Cloneable{
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object clone(){
        Object clone = null;

        try{
            clone = super.clone();
        }catch(Exception e){
            System.out.println("Error");
        }

        return clone;
    }

    abstract void draw();

}


class Hexagon extends Shape{
    public Hexagon(){
        this.setType("Hexagon");
    }

    @Override
    void draw() {
        System.out.println("Hexagon drawn");
    }
}

class Octagon extends Shape{
    public Octagon(){
        this.setType("Octagon");
    }

    @Override
    void draw() {
        System.out.println("Octagon drawn");
    }
}

class Cache{
    private static HashMap<String,Shape> map = new HashMap<>();

    public static Shape getShape(String id){
        return (Shape)map.get(id).clone();
    }

    public static void loadCache(){
        Hexagon hex = new Hexagon();
        hex.setId("1");
        map.put(hex.getId(), hex);


        Octagon oct = new Octagon();
        oct.setId("2");
        map.put(oct.getId(), oct);
    }
}

/*
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Cache.loadCache();

        Shape clonedShape1 = (Shape) Cache.getShape("1");
        clonedShape1.draw();

        Shape clonedShape2 = (Shape) Cache.getShape("2");
        clonedShape2.draw();
        
    }
}
