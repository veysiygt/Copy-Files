import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
//You can copy all the files with the extension you want.
public class CopyFiles{

    private static ArrayList<Integer> content = new ArrayList<Integer>();

    public static void readFile(){
        try {
            FileInputStream file = new FileInputStream("file to be copied");//example test/file.txt
            
            int read;
            try {
                while((read = file.read()) != -1){
                    content.add(read);
                }
            } catch (IOException e) {
                System.out.println("Can't Read File!");
            }
        
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception!");
        } 
    }

    public static void copy(String fileName){

        try {
            try (FileOutputStream out = new FileOutputStream(fileName)) {
                for(int navigate : content){
                    try {
                        out.write(navigate);
                    } catch (IOException e) {
                        System.out.println("Can't navigate on file!");
                    }
                }
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                System.out.println("File Not Found Exception!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Exception!");
        } 

    }
    public static void main(String[] args) {
        
        readFile();
        copy("copied file");//the path of the place you want to copy example: test2/file2.txt

    }

}
