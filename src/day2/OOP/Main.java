package day2.OOP;

import day2.OOP.Blogs.Blog;
import day2.OOP.Student.Student;
import day2.OOP.Users.Admin;
import day2.OOP.Users.User;

public class Main {
    public static void main(String[] args) {
        //class biasa
        System.out.println("===GET STUDENT===");
        Student s1 = new Student("Alwi", 70);
        s1.cekStatus();

        Student s2 = new Student("Abdullah", 80);
        s2.name="royyan";//update data
        s2.score=98;
        s2.cekStatus();
        //enkapsulasi
        System.out.println("===GET BLOG===");
        Blog myBlog = new Blog("Nasi goreng enak","Nasi goreng itu terbuat dari nasi enak");
        myBlog.displayInfo();
        //ngubah data dalam enkapsulasi harus pake setter/getter
        myBlog.setTitle("nasi oreng gk enak");
        myBlog.getTitle();
        myBlog.setContent("nasi goreng gk enak bro");
        myBlog.displayInfo();

        //comment
        myBlog.addComment("alwi", "bener");
        myBlog.addComment("Dimas", "B aja");
        myBlog.displayComments();

        System.out.println("===GET USER===");
        //class parent
        User userGuest = new User("Nanang");
        userGuest.displayInfo();
        //class child
        Admin userAdmin = new Admin("Alwi",true);
        userAdmin.displayInfo();


    }
}
