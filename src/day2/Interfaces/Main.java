package day2.Interfaces;

public class Main {
    public static void main(String[] args) {
        UserController akun = new UserController("Alwi","123");
        System.out.println(akun.getUsername());
        System.out.println(akun.getPassword());
        akun.addUser("Dani","456");
        System.out.println("Total user : "+akun.getAllUser());
        //default method
        akun.getCompany();
        //ambil method tanpa menggunakan class

        User.setName("dimas tri sulaksono");

        //ambil metod di role
        akun.admin(true);
    }
}
