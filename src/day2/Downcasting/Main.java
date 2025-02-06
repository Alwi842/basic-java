package day2.Downcasting;

/* Downcastinglne : ngubah superclass/parent jadi subclass/child class
* biar bisa make metod/attribut yang spesifik dari subclass.*/

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();//bikin objek admin
        Guest guest = new Guest();
        User user1=admin;// bikin objek user
        User user2=guest;
        Admin admin1=(Admin) user1; // douncasting biar keadmin
        admin1.adminStatus(); //metod yang ingin dipake di superclass
        admin1.login();//metod yang masih bisa dipake superclas walawpun sudah di downcast

        Guest guest1 =(Guest) user2;
        guest1.adminStatus();
    }

}
