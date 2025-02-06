package day2.Interfaces;

import java.util.HashSet;

//cara manggil interface di class UserController
public class UserController implements User, Role{
    private String username;
    private String password;
    private HashSet<String> users = new HashSet<>();
    public UserController(String username, String password){
        this.username=username;
        this.password=password;
    }
    @Override
    public String getUsername(){return username;}
    @Override
    public String getPassword(){return password;}

    @Override
    public void addUser(String username, String password){
        users.add(username);
        users.add(password);

        System.out.println(username+" dan "+password+" telah disimpan");
    }
    @Override
    public int getAllUser(){return users.size();}

}
