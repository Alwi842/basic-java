package day2.BasicOOP.AccessModifier;

public class Person {
    //AccessModifier: kata kunci mengatur aksebilitas, visibilitas dari sebuah class, variable atau method

    //public
    public String name; //bisa diakses dimana aja

    //private
    private int age; //cuma bisa diakses didalam kelas sendiri (person)

    //protected
    protected String address; // cuma bisa di akses oleh class sendiri (person) dan subclassnya

    //non-accross modifier :
    //static
    public static int totalPerson = 6; // variable statis untuk ngasih nilai awal terhadap variabel

    //final
    public final String NATIONALITY = "indonesia"; // untuk bikin nilai constant

    public Person (String name, int age, String address){
        this.name=name;
        this.age=age;
        this.address=address;
        totalPerson++;
    };

    //method
    public void displayInfo(){
        System.out.println("My name : "+name);
        System.out.println("My age : "+age);
        System.out.println("My address : " + address);
    }

    //method static untuk nampilin total objek setiap kali objek person bertambah
    public static void displayTotalPerson(){
        System.out.println("Total person : "+ totalPerson);
    }
}
