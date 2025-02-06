package day2.OOP.Users;

/*INHERITANCE
* konsep untuk menurunkan sifat/perilaku parent class ke child class
* artinya class turunannya bisa menggunakan properti parent milik parent
* child class(inheritance) diditandai dengan kata kunci extends*/

public class User {
    private String username;
    public User(String uname){username=uname;}
    public String getUsername(){return username;}
    public void displayInfo(){
        System.out.println("Username : "+username);
    }
}
