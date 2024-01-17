

interface Document{
    void print();
}

class PDFDocument implements Document{
    @Override
    public void print() {
        System.out.println("printing PDF document.....");
    }
}

class WordDocument implements Document{
    @Override
    public void print() {
        System.out.println("printing Word document.....");
    }
}

class DocumentFactory{
    public Document getDocument(String type){
        if(type==null){ return null;}
        else if (type.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        }else if (type.equalsIgnoreCase("word")) {
            return new WordDocument();
        }

        return null;
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        DocumentFactory fact = new DocumentFactory();

        Document doc1 = fact.getDocument("pdf");
        Document doc2 = fact.getDocument("word");

        doc1.print();
        doc2.print();
    }
}