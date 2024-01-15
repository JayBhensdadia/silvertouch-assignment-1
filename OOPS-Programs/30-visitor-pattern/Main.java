import java.util.ArrayList;
import java.util.List;

interface Visitor {
    void visit(ImageElement img);
    void visit(TextElement txt);
}

abstract class Element{

    private String name;

    public Element(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public void accept(Visitor v);
}

class Document extends Element{

    public List<Element> list = new ArrayList<>();

    public Document(String name){
        super(name);
    }

    @Override
    public void accept(Visitor v) {
        for (Element element : list) {
            element.accept(v);
        }
    }
}

class ImageElement extends Element{
    public ImageElement(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class TextElement extends Element{
    public TextElement(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ElementVisitor implements Visitor{
    @Override
    public void visit(TextElement txt) {
        System.out.println("Text Element: " + txt.getName());
    }

    @Override
    public void visit(ImageElement img) {
        System.out.println("Image Element: " + img.getName());
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Visitor v = new ElementVisitor();

        Document doc = new Document("doc-1");

        doc.list.add(new TextElement("text-1"));
        doc.list.add(new ImageElement("image-1"));

        doc.accept(v);
        
    }
}