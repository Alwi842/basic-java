package day2.AnonymousClass;

/*ANONYMOUS class : class sementara yang mewarisi class parentnya
* ini cara singkat/sekali pakai buat ngasih fungsi tambahan pada class dan inheritance yang udah ada
* daripada bikin class baru yang terpisah */
public class Main {
    public static void main(String[] args) {
        User user = new User("alwi",24);
        UserInterface userActions=new UserInterface() {
            @Override
            public void displayUser() {
                System.out.println("User name : "+user.getName());
                System.out.println("Age : "+user.getAge());
            }

            @Override
            public void updateUser() {
                System.out.println("User updated");
            }
        };

        userActions.displayUser();
        userActions.updateUser();

    }
}
