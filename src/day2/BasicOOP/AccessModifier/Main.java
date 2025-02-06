package day2.BasicOOP.AccessModifier;
import day2.BasicOOP.AccessModifier.Person;
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Alwi", 24,"Indonesia");
        Person person2 = new Person("Danu", 25,"Indonesia");
        Person person3 = new Person("Dimas", 26,"Indonesia");

        person2.displayInfo();
        person1.displayInfo();
        person3.displayInfo();

        Person.displayTotalPerson();

        //akses data

        System.out.println("Public access : "+ person1.name);
        System.out.println("Protected access : "+person1.address);
//        System.out.println("private access : "+person1.age); //error karena aksessnya private
        System.out.println("final access : "+person1.NATIONALITY);

        /*Kapan harus mengimplementasi access modifier?
        * 1. Public : bisa dipake untuk class atau method yang biasanya bisa dipanggil dimana aja
        * 2. Private : biasanya dipake untuk mendeklarasikan variable classdimana gk bisa sembarangan diubah
        * 3. final : ketika kita mau mendefinisikan nilai default yang konstant untuk suatu variabel*/
    }
}
