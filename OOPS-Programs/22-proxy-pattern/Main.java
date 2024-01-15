interface Image{
    public void display();
}


class RealImage implements Image{
    private String file;

    public RealImage(String file){
        this.file = file;
        loadFromDisk(file);
    }

    private void loadFromDisk(String file){
        System.out.println("Loading " + file + "....");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + file + "....");
    }
}


class ProxyImage implements Image{
    private RealImage realImage;
    private String file;

    public ProxyImage(String file){
        this.file = file;
    }

    @Override
    public void display() {
        if(realImage==null){ realImage = new RealImage(file);}
        realImage.display();
    }
}

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        
        Image img = new ProxyImage("jay-profile.hevc");
        img.display();

        System.out.println();

        //it will not load from disk as it is already present
        img.display();

    }
}