package day2.OOP.Users;

/*ini adalah child class, implementasi dari inheritance
* child class Admin inherit from parent class user*/
public class Admin extends User {
    private boolean isAdmin;
    public Admin(String username,boolean role) {
        super(username);//menggambil variable kelas parent username
        isAdmin=role;
    }

    //override method si paretn
    @Override
    public void displayInfo(){
        System.out.println("Admin username : " + getUsername());
        System.out.println("Is admin : " + isAdmin);
    }
}
