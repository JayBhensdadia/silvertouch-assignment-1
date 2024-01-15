import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOps {
    
    public static void createNewFile(String fileName){
        try {
            File Obj = new File(fileName);
            if (Obj.createNewFile()) {
                System.out.println("File created: "
                                   + Obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }


    public static void readFile(String fileName){
        try {
            File Obj = new File(fileName);
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }


    public static void writeToFile(String fileName, String content){
        try {
            FileWriter Writer
                = new FileWriter(fileName);
            Writer.write(content);
            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String fileName = "temp.txt";
        createNewFile(fileName);
        writeToFile(fileName, "my name is jay bhensdadia");
        readFile(fileName);
        
    }
}
