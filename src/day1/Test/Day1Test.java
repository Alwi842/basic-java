package day1.Test;

import java.sql.SQLOutput;

public class Day1Test {
    public static void main(String[] args) {
        /* 1. buat logic untuk ngecek apakah sebuah bilangan adalah bilangan prima*/
        System.out.println("1. Apakah 10 adalah bilangan prima? " + isPrime(10));
        /*2. buat logic untuk nyari nilai terbesar dan terkecil dari sebuah array pake math method*/
        int[] angka = {1,2,3,4,5,6,7,8,9,10};
        int nilaiTerbesar=0;
        int nilaiTerkecil=999;
        for (int i = 0; i < angka.length; i++) {
            nilaiTerkecil=Math.min(nilaiTerkecil, angka[i]);
            nilaiTerbesar=Math.max(nilaiTerbesar,angka[i]);
        }
        System.out.println("2. Nilai terbesar : "+nilaiTerbesar);
        System.out.println("   Nilai terkecil : "+nilaiTerkecil);
        /*3. buat logic untuk nyari jumlah elemen yang nilainya genap dan jumlah elemen yang nilainya ganjil*/
        int ganjil=3;
        int genap=6;
        if ((ganjil%2)==1) System.out.println("3. Nilai 3 adalah ganjil");
        if ((genap%2)==0) System.out.println("   Nilai 6 adalah genap");
        /*4. buat logic untuk menghitung karakter dalam sebuah string*/
        String kata = "aku senang belajar java";
        System.out.println("4. Panjang kata adalah : " + kata.length());
        /*5. buat logic untuk menghtung jumlah huruf vokal dalam string 'kata'*/
        String character="";
        int total=0;
        for (int i = 0; i < kata.length(); i++) {
            character= String.valueOf(kata.charAt(i));
            if(character.equalsIgnoreCase("a") || character.equalsIgnoreCase("i")
                    || character.equalsIgnoreCase("u") || character.equalsIgnoreCase("e")
                    || character.equalsIgnoreCase("o")){
                total++;
            }
        }
        System.out.println("5. Total huruf fokal pada kata ada : " +total);
        /*6. buat array yang terdiri dari 5 mahasiswa, masing masing punya 3 nilai : ujian, absen, kuis
        * kalkulasi nilai mereka berdasarkan rata2 nilai dari 3 nilai tersebut
        * lalu tambahkan benda mereka berdasarkan nilai rata2 menggunakan logic if elsedan enum*/
        int[][] mahasiswa = {
                {5,6,7},
                {7,8,9},
                {10,9,8},
                {7,6,5},
                {10,10,10}
        };
        enum grade{
            A,B,C,D,E,F
        }
        System.out.println("6. nilai mahasiswa");
        for (int i = 0; i < mahasiswa.length; i++) {
            int avg = 0;
            for (int j = 0; j < mahasiswa[i].length; j++) {
                avg += mahasiswa[i][j];
            }
            double totalAvg = (double) avg / mahasiswa[i].length;
//            System.out.println("Average for mahasiswa " + i + ": " + totalAvg);
            if (totalAvg>=9){
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.A);
            } else if (totalAvg>=8){
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.B);
            } else if (totalAvg>=7){
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.C);
            } else if (totalAvg>=6){
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.D);
            } else if (totalAvg>=5){
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.E);
            } else {
                System.out.println("nilai mahasiswa "+(i+1)+" "+ grade.F);
            }
        }

    }
    public static Boolean isPrime(int num){
        if (num<=1) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
