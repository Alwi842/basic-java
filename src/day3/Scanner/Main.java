package day3.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //import scanner dari java buat bikin inputan ke terminal
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama : ");
        String nama = input.nextLine();
        System.out.print("Masukkan umur : ");
        int umur = input.nextInt();
        input.nextLine();//bikin karakter line break \n setelah membaca inputan angka
        System.out.print("Masukkan kelas : ");
        String kelas = input.nextLine();
        System.out.println("Hello, "+nama);
        System.out.println("Umur : "+umur);
        System.out.println("kelas : "+kelas);
        //buat nutup input
        input.close();
    }

}
