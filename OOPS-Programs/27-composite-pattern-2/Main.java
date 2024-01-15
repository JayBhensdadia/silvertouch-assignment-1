import java.util.ArrayList;
import java.util.List;

interface StorageItem{
    void displayDetails();
}

class File implements StorageItem{
    String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println(this.name + ": " + "file content....");
    }
}

class Directory implements StorageItem{
    String name;
    List<StorageItem> list;

    public Directory(String name){ 
        this.name = name;
        list = new ArrayList<>();
    }

    public void addFile(File file){
        list.add(file);
    }

    public void removeFile(File file){
        list.remove(file);
    }

    public void addDirectory(Directory directory){
        list.add(directory);
    }

    public void removeDirectory(Directory dir){
        list.remove(dir);
    }

    @Override
    public void displayDetails() {
        System.out.println(name + ":- ");
        for (StorageItem item : list) {
            item.displayDetails();
        }
    }
}


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        File f1 = new File("data.txt");
        File f2 = new File("marks.txt");
        Directory d2 = new Directory("student-photos");

        Directory d1 = new Directory("student-data");

        d1.addDirectory(d2);
        d1.addFile(f1);
        d1.addFile(f2);

        d1.displayDetails();


    }
}