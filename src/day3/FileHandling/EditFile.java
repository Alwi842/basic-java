package day3.FileHandling;
import java.io.*;

public class EditFile {
    public static void main(String[] args) {
        String fileName="G:\\programming\\java\\basic_java\\src\\day3\\FileHandling\\testWrite.txt";
        File file = new File(fileName);

        //buat konten baru setelah pengeditan
        StringBuilder newContent = new StringBuilder();

        //cek
        if (file.exists()){
            try(BufferedReader reader = new BufferedReader((new FileReader(fileName)))){
                for (String line; (line=reader.readLine())!=null;){
                    //ganti kata menjadi kata lain
                    line=line.replace("programmer", "badut");
                    newContent.append(line).append(System.lineSeparator());
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                //ini buat overwrite
                writer.write(newContent.toString());
                //nambah kontent baru
                writer.append("surudududud surudududu");
                System.out.println("File berhasil diedit \n path : "+file.getAbsolutePath());
            } catch(IOException e){
                e.printStackTrace();
            }
        }else {
            System.out.println("File tidak ditemukan mamank : \n path : "+file.getAbsolutePath());
        }
    }

    }
