package day3.Scanner;

import java.util.Scanner;

public class Siswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jumlah siswa : ");
        int jumlahSiswa = input.nextInt();
        input.nextLine();

        String[] namaSiswa = new String[jumlahSiswa];
        int[] umurSiswa = new int[jumlahSiswa];
        String[] kelas = new String[jumlahSiswa];
        double[] nilai = new double[jumlahSiswa];
        System.out.println("masukkan nama siswa :");
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Siswa "+(i+1)+" :");
            System.out.print("Nama :");
            namaSiswa[i]=input.nextLine();
            System.out.print("Umur :");
            umurSiswa[i]=input.nextInt();
            input.nextLine();
            System.out.print("Kelas :");
            kelas[i]=input.nextLine();
            System.out.print("Nilai :");
            nilai[i]=input.nextDouble();
            input.nextLine();
        }
        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Siswa "+(i+1));
            System.out.println("Nama : "+namaSiswa[i]);
            System.out.println("kelas : "+kelas[i]);
            System.out.println("umur : "+umurSiswa[i]);
            System.out.println("nilai : "+nilai[i]);
        }
        double total=0;
        for (int i = 0; i < jumlahSiswa; i++) {
            total+=nilai[i];
        }
        double rataRata=total/jumlahSiswa;
        System.out.println("rata-ratanya : "+rataRata);
    }
}
