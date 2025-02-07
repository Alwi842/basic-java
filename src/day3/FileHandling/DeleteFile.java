package day3.FileHandling;
import java.io.*;
public class DeleteFile {
    public static void main(String[] args) {
        String fileName="G:\\programming\\java\\basic_java\\src\\day3\\FileHandling\\test.txt";
        File file = new File(fileName);

        if(file.exists()){
           if (file.delete()){
               System.out.println("file berhasil dihapus!");
           }
        } else {
            System.out.println("File tidak ditemukan bro");
        }
    }
}
