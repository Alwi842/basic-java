package day2.Upcasting;
/*upcasting : ngubah subclass jadi superclass*/
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        User user1=admin;//downcasting
        user1.login();

        Admin admin1=(Admin) user1;//upcasting
        admin1.adminStatus();
    }
}
