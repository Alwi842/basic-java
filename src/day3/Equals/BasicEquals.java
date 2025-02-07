package day3.Equals;

class Car{
    String model;
    int year;

    Car(String model, int year){
        this.model=model;
        this.year=year;
    }

}
/*EQUALS : parameter buat bandingin 2 objek apakah mereka punya atribut dan isi yang sama
* ini sama kaya operator ==*/
public class BasicEquals {
    public static void main(String[] args) {
        Car car1 = new Car("Hyundai ionic 5", 2023);
        Car car2 = new Car("Totoya Supra X", 2025);
        Car car3 = car1;
        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car3));

        if (car1.equals(car2)){
            System.out.println("Mobil sama");
        } else {
            System.out.println("Mobil beda");
        }
        boolean status =car1 == car3;
        System.out.println(status);
    }

}
