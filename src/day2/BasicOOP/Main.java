package day2.BasicOOP;

import day2.BasicOOP.Basic.Human;
public class Main {
    public static void main(String[] args) {
        //instance creation dari class human : prosses bikin sebuah objek baru dari sebuah class
        Human student = new Human("Alwi", 25);
        //instance method : method yang bisa diakses oleh objek yang menampung suatu class
        student.breath();
        student.fart();
    }
}
