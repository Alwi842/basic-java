package day3.Equals;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<User> listUser = new ArrayList<>();
    public void registerUser(User user){listUser.add(user);}
    public void isUserRegistered(User user){
        if(listUser.contains(user)){
            System.out.println(user.getUsername()+" is registered!");
        } else {
            System.out.println(user.getData()+" is not registered!");
        }
    }
    public static void main(String[] args) {
        Main userController = new Main();//instancedari objek main

        //register user baru
        User user1 = new User("Alwi", "alwi.abdullah1221@gmail.com");
        User user2 = new User("Dimas", "dimas@gmail.com");
        User user3 = new User("Alwi", "alwi.abdullah1221@gmail.com");
        userController.registerUser(user1);
        userController.registerUser(user2);

        //simulasi user yang tidak terdaftar
        User userNotRegisterd = new User("Dani", "dani@gmail.com");
        userController.isUserRegistered(userNotRegisterd);
    }
}
