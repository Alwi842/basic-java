package day3.Enums;

public class EnumMethod {
    enum Role{
        ADMIN, GUEST
    }
    public static void getRole(Role role){
        System.out.println("Hi, "+role.toString().toLowerCase());
    }

    public static void main(String[] args) {
        getRole(Role.ADMIN);
    }
}
