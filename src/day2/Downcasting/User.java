package day2.Downcasting;

/*Superclass / parent class*/

public class User {
    void login(){
        System.out.println("login berhasil");
    }
}

//subclass
class Admin extends User{
    void adminStatus(){
        System.out.println("Hi, admin");
    }
}

//subclass
class Guest extends User{
    void adminStatus(){
        System.out.println("Hi, guest");
    }
}