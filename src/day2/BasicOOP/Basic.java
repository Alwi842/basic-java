package day2.BasicOOP;
/*Basic OOP
* Class : konsep dasar untuk bikin objek atau kerangka kerja yang mendefinisikan karakteristik dan perilaku
* suatu objek atau bisa dibikin class yang berisi fungsionalitas untuk program*/
public class Basic { //class permanen
    public static class Human { //classstatic yang bisa dipanggil oleh class lainnya sebagai objek
        //class attribut : data yang dimiliki objek
        String name;
        int age;
        //constructor : method khusus yang menginisiasikan objek/mengatur nilai awal dari variabel class
        public Human (String name, int age){
            this.name=name;
            this.age=age;
        }
        //method :fungsi khusus yang dimiliki objek
        public void breath(){
            System.out.println(name + " is breathing and he's age " +age+" years old");
        }
        public void fart(){
            System.out.println(name+" is farting");
        }

    }
}
