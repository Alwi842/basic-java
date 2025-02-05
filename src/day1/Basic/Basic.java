package day1.Basic;

import java.lang.reflect.Array;

/*Java : bahasa programming OOP (object oriented programming)
* setiap class yang dibuat didalam file java mewakili suatu objek
* */
public class Basic {
//    Metod main : blok yang akan mengeksekusi suatu perintah
    public static void main(String[] args) {
        //variable menyimpan data
        //tipe data : jenis data yang disimpan dalam variabel
        //rumus beda sama javascript <tipe data> <nama variable> = isi data
        print();
    }
    public static void print(){
        int age=25;//integer
        String name="Alwi";//string
        boolean isStudent=true;//boolean

        System.out.println("Nama saya "+ name);
        System.out.println("Umur saya "+ age);
        if (isStudent){
            System.out.println("Saya adalah seornag pelajar");
        } else{
            System.out.println("Saya adalah seornag guru");
        }

        //array di java punya ukuran data yang statis. gabisa sembarangan tambah datanya dan cuma bisa nyimpen 1 tipe
        //data
        System.out.println("===Array bro===");
        int[] numbers={1,2,3,4,5};
        System.out.println("Array length : " +numbers.length);
        numbers[4] =7;
        //looping tradisional
        for (int i = 0; i < numbers.length ; i++) {
            System.out.println("Array "+i+" : "+ numbers[i]);
        }
        //Integer : tipe data yang bisa dimanipulasi pake metod metod array.

        Integer integerNumber=25;
        System.out.println("Integer : "+integerNumber.byteValue());
        //objek : tipe data campuran
        Object[] dataCampur = {"alwi", 25, false};
        //enhanced looping
        for (Object i : dataCampur) {
            System.out.println("data campur : " + i);
        }
        //tipedata int yang ukurannya lebih panjang dibandikan int
        long longNumber=123456789;
        System.out.println(longNumber);

        double doubleNumber=3.1415926535;
        float floatNumber=3;

        //concatenation : metod untuk menggabungkan 2 string
        String firstName = "alwi";
        String lastName = "Royyan";
        System.out.println("Baisc : "+ firstName+" "+lastName);
        System.out.println("concat : " + firstName.concat(lastName));

        //enum:buat nyimpen nilai-nilai konstan yang gk bisa diubah
        enum grade{
            LULUS,
            TIDAK_LULUS
        }
        System.out.println("Status kelulusan anda : " +grade.LULUS);
    }
}
