package day3.FileHandling;

import java.io.*;

public class WriteFile {
    public static void main(String[] args) {
        String fileName="G:\\programming\\java\\basic_java\\src\\day3\\FileHandling\\testWrite.txt";

        File file = new File(fileName);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Ini saya yang nulis,hah");
            writer.newLine();
            writer.write("Iya saya yang nulis");
            writer.newLine();
            writer.write("Saya programmer jadi bisa");
            System.out.println("======================");
            //buat nampilin lokasi filenya
            System.out.println("File berhasil dibuat \n path : "+file.getAbsolutePath());
            System.out.println("======================");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        File file1 = new File("test.txt");
        System.out.println(file1.getAbsolutePath());
    }
}
