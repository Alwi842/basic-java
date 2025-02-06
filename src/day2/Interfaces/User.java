package day2.Interfaces;
/* Interface : kumpulan metod yang harus dipake oleh class yang mengemplementasikannya*/
public interface User {
    //metod biasa yang wajib dipake oleh class yang mengimplementasikannya
    String getUsername();
    String getPassword();

    void addUser(String username, String password);
    int getAllUser();

    //default method =method ini gak perlu di override(optional)
    default void getCompany(){
        System.out.println("Company : PT Aigen Global Teknologi");
    }

    //static method : method yang bisa dipanggil langsung tanpa memerlukan class(method inibisa di gkbisa di override)
    static void setName(String name){
        System.out.println("Name : "+name);
    }
}
