package day3.FileHandling;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        String filePath="G:\\programming\\java\\basic_java\\src\\day3\\FileHandling\\test.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
//            String line;
//            while((line=reader.readLine())!=null){
//                System.out.println(line);
//            }
            //cara lain
            for(String line; (line=reader.readLine()) !=null;){
                System.out.println(line);
            }
        } catch (IOException e){
            e.getMessage();
            e.printStackTrace();
        }
    }
}
