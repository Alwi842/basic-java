package day3.Enums;

import day3.Equals.User;

public class EnumConditional {
    enum userStatus{
        ACTIVE,INACTIVE,BANNED
    }
    static class User{
        private String nama;
        private userStatus status;
        public User(String nama, userStatus status){
            this.nama=nama;
            this.status=status;
        }
        public void setStatus(userStatus status){this.status=status;}

        public void checkStatus(){
            System.out.println("User "+nama+" is "+ status);
        }
    }

    public static void main(String[] args) {
        userStatus user1=userStatus.ACTIVE;
        if(user1==userStatus.ACTIVE){
            System.out.println("User is active");
        } else if(user1==userStatus.INACTIVE){
            System.out.println("User is inactive");
        } else if(user1==userStatus.BANNED){
            System.out.println("User is banned");
        }

        User alwi = new User("alwi", userStatus.INACTIVE);
        System.out.println("===CHECK USER STATUS===");
        alwi.checkStatus();

        System.out.println("===Update status===");
        alwi.setStatus(userStatus.ACTIVE);
        alwi.checkStatus();
    }
}
