package day1.Method;

//cara import method instance

import static day1.Method.MultipleMethod.multiple;
import static day1.Method.Animal.sound;

public class Method {
    //Metod : fungsi untuk ngejalanin suatu perintah/perilaku tertentu (fungsi)

    /*Public static int add(int num1, int num2){} cara buat method
    * public static : access modifier agar method ini bisa digunakan secara global
    * int add(params) : method/fungsi dengan return integer
    * return : buat ngembaliin nilai*/
    public static int add(int num1, int num2){return num1+num2;}
    public static Object cekNilai(int nilai){
        if (nilai >=80) {
            return "Lulus";
        } else {
            return "Gk lulus";
        }
    }
    public static void main(String[] args) {
        //cara jalanin method
        int result = add(5,2);
        System.out.println("5 + 2 = "+result);

        System.out.println(cekNilai(90));
        System.out.println("===Method overload===");
        System.out.println("Multiple : "+multiple(5,5));
        System.out.println("Multiple 3param : "+multiple(5,5,5));
        System.out.println("Multiple double : "+multiple(3.5,3.3,5.0));

        System.out.println("===Method override===");
        System.out.println("Method parent " + sound());
        System.out.println("Method override Kucing " + kucing.sound());

        //cara manggil
        System.out.println("===Instance Method===");
        Animal hewan = new Animal();
        System.out.println(hewan.sound());

        kucing nyan = new kucing();
        System.out.println(nyan.sound());
    }

}
