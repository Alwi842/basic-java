package day3.Enums;

import java.util.EnumSet;
import java.util.Set;

/*ENUM TEST
* Buat class untuk mengelola hak akses user menggunakan role dengan spesifikasi berikut :
* 1. buat enum userAccess dengan nilai : CREATE, EDIT, DELETE, DISPLAY_DASHBOARD dan USER_MANAGEMENT
* 2. buat enum Role yang masing masing role punya akses berikut :
*    - ADMIN punya semua akses
*    - EDITOR punya akses CREATE, EDIT DAN DISPLAY_DASHBOARD
*    - GUEST cuma punya akses DISPLAY_DASHBOARD
* 3. buat kelas user dengan atribut nama dan roles
* 4. buat method untuk validasi dan menamilkan apakah user punya hak akses tertentu
* 5. buat main method untuk ekeskusinya didalam satu file ini*/
public class Test {
    private enum UserAccess {
        CREATE, EDIT, DELETE, DISPLAY_DASHBOARD, USER_MANAGEMENT
    }
    private enum Role{
        ADMIN(EnumSet.of(UserAccess.CREATE, UserAccess.EDIT, UserAccess.DELETE, UserAccess.USER_MANAGEMENT)),
        EDITOR(EnumSet.of(UserAccess.CREATE, UserAccess.EDIT, UserAccess.DISPLAY_DASHBOARD)),
        GUEST(EnumSet.of(UserAccess.DISPLAY_DASHBOARD));
        private EnumSet<UserAccess> access;

        Role(EnumSet<UserAccess> access){
            this.access=access;
        }
    }


    static class User{
        private String nama;
        private Role role;
        public User (String nama, Role role){
            this.nama=nama;
            this.role=role;
        }
        public void getUser(){
            System.out.println(nama);
            System.out.println(role);
            System.out.println(role.access);
        }
        public void checkAccess(UserAccess userAccess){
            if(role.access.contains(userAccess)){
                System.out.println("User "+ nama + " adalah "+role+" dan memiliki akses " + userAccess );
            } else {
                System.out.println("User "+ nama + " adalah "+role+" dan tidak memiliki akses " + userAccess );
            }
        }
    }

    public static void main(String[] args) {
        User user1= new User("alwi", Role.ADMIN);
        user1.checkAccess(UserAccess.CREATE);
        user1.getUser();
    }
}
